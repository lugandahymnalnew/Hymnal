B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
	
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim p As Phone
	Dim SN As String
	Dim SB As String
	Dim MP As MediaPlayer
	Dim timer1 As Timer
	Dim counter As Int
	Dim sw As Boolean = False
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
'	Private WebView1 As FlingableWebView
'	Private FWV As WebView
	'Private Seq As MidiSequence
	'Private Seqr As MidiSequencer
	Private JI As DefaultJavascriptInterface
	Private WVE As WebViewExtras
	Private DWV As DefaultWebChromeClient
	Private DWV1 As DefaultWebViewClient
	Private s_start  As Long
	Private err_txt As EditText
	Private Panel1 As Panel
	Private barPosition As SeekBar
	Private lblPosition As Label
	Private barVolume As SeekBar
	Private Panel3 As Panel
	Private btnUp As Button
	Private btnDown As Button
	Dim load As Boolean
	Dim leng As Long
	Dim pos As Long
	Dim Inpos As Long
	Dim count As Int
	Dim loos As Int
	Private WebView1 As WebView
	Dim playing1 As Boolean = False
	Dim loopable As Boolean = False
	Private Panel2 As Panel
	Dim rp As RuntimePermissions
	Dim songNumber As String
	Dim menu As Boolean
End Sub

Sub Activity_Create(FirstTime As Boolean)
'	Do Not forget To load the layout File created with the visual designer. For example:,
'	Activity.LoadLayout("Layout1")
Try	
		
		Activity.LoadLayout("song")
		JI.Initialize
'	WebView1.Initialize("WebView1")
		WVE.Initialize(WebView1)
		DWV.Initialize("WebView12")
		DWV1.Initialize("WebView11")
		WVE.SetWebChromeClient(DWV)
		WVE.AddJavascriptInterface(JI,"B4A")
		WebView1.ZoomEnabled = False
		Panel1.Visible = True
		If codes.GetSetting("Song") = "" Then
			WebView1.LoadUrl("file:///android_asset/menu.html")
		Else
			Try
				Log(codes.GetSetting("Song"))
				leng = codes.GetSetting("Seeker")
				swipe(codes.GetSetting("Song"))
			Catch
				SendError("Error",LastException.Message)
				MsgboxAsync("Please, uninstall the app and re-install from playstore or xender","Instructions")
			End Try
		End If
			ProgressDialogShow2("Gumikiriza",False)
			WebView1.SendToBack
			load = True
			count = 0
			songNumber = ""
			menu = False
			
		'SendError("Error","This is an error")
Catch
	codes.SendEmail("Error", LastException.Message)
	Log(LastException.Message)
End Try
		
End Sub

Sub Activity_Resume
	'Log("Song Number: "&songNumber)
	Try
		leng = codes.GetSetting("Seeker")
		pos = codes.GetSetting("Pos")
		loos = codes.GetSetting("Loops")
		count = codes.GetSetting("Count")
	Catch
		SendError("Error",LastException.Message)
		MsgboxAsync("Please, uninstall the app and re-install from playstore or xender","Instructions")
	End Try
	If playing1 Then
		If MP.IsPlaying = True Then 
			'MP.Looping = True
			If pos < MP.Position + 6000 Then
				pos = MP.Position + 6000
			Else
				Dim kia As Int
				kia = (pos-6000)/(MP.Duration)
				Log("Division: "&kia)
				pos = kia*MP.Duration + MP.Position + 6000
			End If
		Else
			stop1
			Log("me")
		End If
	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	If UserClosed = True Then
		If playing1 Then MP.Stop
		codes.update_Setting("Song","")
		Return
	End If
		codes.update_Setting("Pos",pos)
End Sub



Private Sub WebView1_OverrideUrl (Url As String) As Boolean
	load = True
	Log(Url)
	If Url.Contains("menu") Or Url.Contains("index") Then
		WebView1.LoadUrl(Url)
	Else
		swipe(Url.SubString(22))
	End If
End Sub


Private Sub WebView1_PageFinished (Url As String)
'	Log(Url)
	ProgressDialogHide
	btnUp_Click
	load = False
	Try
		If MP.IsPlaying Then
			Dim js As String
			js = "$('.play').css('display','none');$('.stop').css('display','');"
			WVE.ExecuteJavascript(js)
			
			Panel3.SetVisibleAnimated(100, True)
			btnUp.Visible = False
			btnDown.Visible = True
		End If
	Catch
		Log("Not play")
	End Try
	load = False
End Sub

Sub btn_ok_Click
	If err_txt.Text = "" Then
		ToastMessageShow("You can't send empty feedback", True)
	Else
		Try
			codes.SendEmail(SN, err_txt.Text)
		Catch
			ToastMessageShow(LastException.Message, True)
		End Try
		err_txt.Text = ""
		Panel2.Visible=False
	End If
End Sub

Sub btn_cancle_Click
	err_txt.Text = ""
	Panel2.Visible=False
End Sub

Sub loadIndex()
	
End Sub

Private Sub swipe(h As String)
	Dim s As Map
	'Log(h)
	songNumber = h
	menu = True
	s = sqlDb.getSongWithNumber(h)
	
	codes.update_Setting("Song",songNumber)
	' Extract values from the 's' map
	Dim no As String = s.Get("No")
	Dim title As String = s.Get("Title")
	Dim an As String = s.Get("An")
	Dim sign As String = s.Get("Sign")
	Dim comp As String = s.Get("Comp")
	Dim sl As Map
	Dim l As List
	l.Initialize
	sl.Initialize
	sl = s.Get("Lyrics")

	' Construct the HTML string in jsCode
	Dim jsCode As String
	jsCode = "<!DOCTYPE html>" & CRLF
	jsCode = jsCode & "<html lang=""en"">" & CRLF
	jsCode = jsCode & "<head>" & CRLF
	jsCode = jsCode & "    <meta charset=""UTF-8"">" & CRLF
	jsCode = jsCode & "    <meta name=""viewport"" content=""width=device-width, initial-scale=1.0"">" & CRLF
	jsCode = jsCode & "    <meta http-equiv=""X-UA-Compatible"" content=""ie=edge"">" & CRLF
	jsCode = jsCode & "    <title></title>" & CRLF
	jsCode = jsCode & "    <link rel=""stylesheet"" href=""file:///android_asset/style.css"">" & CRLF
	jsCode = jsCode & "    <script src=""file:///android_asset/jquery.js"" defer></script>" & CRLF
	jsCode = jsCode & "    <script src=""file:///android_asset/all-1.js"" defer></script>" & CRLF
	jsCode = jsCode & "    <script src=""file:///android_asset/swipe.js"" defer></script>" & CRLF
	jsCode = jsCode & "    <script src=""file:///android_asset/share.js"" defer></script>" & CRLF
	jsCode = jsCode & "</head>" & CRLF
	jsCode = jsCode & "<body>" & CRLF
	jsCode = jsCode & "<div class=""tittle-1"">" & CRLF
	jsCode = jsCode & "    <div class=""No"">" & no & "</div>" & CRLF
	jsCode = jsCode & "    <div class=""song"">" & title & "</div>" & CRLF
	jsCode = jsCode & "    <div class=""an"">" & an & "</div>" & CRLF
	jsCode = jsCode & "    <div class=""sign"">" & sign & "</div>" & CRLF
	jsCode = jsCode & "    <div class=""comp"">" & comp & "</div>" & CRLF
	jsCode = jsCode & "</div>" & CRLF
	jsCode = jsCode & "<div class=""hymn"">" & CRLF
	jsCode = jsCode & "        <pre id=""txt"">" & CRLF
	
	For Each key As String In sl.Keys
		If key.Contains("tanza") Then
			jsCode = jsCode & key.SubString(7) &". "
		End If
		'jsCode = jsCode & "<b>"&key&"</b>" & CRLF
		If GetType(sl.Get(key)) = "java.util.ArrayList" Then
			l = sl.Get(key)
			For Each line As String In l
				jsCode = jsCode & line & CRLF
			Next
		Else
			jsCode = jsCode & sl.Get(key) & CRLF
		End If
		jsCode = jsCode & CRLF
	Next
	jsCode = jsCode & CRLF
	jsCode = jsCode & "        </pre>" & CRLF
	jsCode = jsCode & "    </div>" & CRLF
	jsCode = jsCode & "    <a href=""file:///android_asset/menu.html"">" & CRLF
	jsCode = jsCode & "        <div class=""btn"">Back to Menu<br>" & CRLF
	jsCode = jsCode & "            <small>&copy;Philippians 4:13</small>" & CRLF
	jsCode = jsCode & "        </div>" & CRLF
	jsCode = jsCode & "    </a>" & CRLF
	jsCode = jsCode & " <div class=""slid""><input type=""range"" min=""0.5"" max=""5"" id=""siz"" value=""2"" step=""0.1"" onmousemove=""onc()"" onchange=""onc()""></div>" & CRLF
	jsCode = jsCode & "</body>" & CRLF
	jsCode = jsCode & "</html>"

	' Load the HTML string into the WebView
	WebView1.LoadHtml(jsCode)
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then                 
		If WebView1.Url.Contains("menu.html") Then
			Activity.Finish
			StartActivity(Main)
		Else
			codes.update_Setting("Song","")
			WebView1.LoadUrl("file:///android_asset/menu.html")
			Return True
		End If
	Else
		Return False
	End If
End Sub

Sub ShareMessage(sMes As String)
	Dim in As Intent
	in.Initialize(in.ACTION_SEND, "")
	in.PutExtra("android.intent.extra.TEXT", sMes)
	in.SetType("text/plain")
	in.WrapAsIntentChooser("Share Via")
	StartActivity(in)
End Sub

Sub openAbaana
	StartActivity("abaana")
End Sub

Sub DoLoad(FileName As String, loops As String)
	FileName = FileName.Replace("/","\")
	'FileName = codes.FixUrl("",FileName)
	If playing1 Then
		If MP.IsPlaying Then MP.Stop
		Try
			MP.Initialize2("MP")
			Try
				MP.Load(File.DirInternal, FileName)
			Catch
				Try
					If File.Exists(File.DirInternal,FileName) Then
						MP.Load(File.DirInternal, FileName)
						Return
					Else
						Msgbox2Async("Do you want to download, the song?","Try downloading","Yes","Cancle","No",Null,False)
						Wait For MsgBox_Result(Result As Int)
						If Result = DialogResponse.POSITIVE Then
							DownloadAndSaveFile("https://newlugandahymnal.onrender.com/midi/"&FileName.Replace("midi\",""),FileName)
							stop1
							Return
						Else
							stop1
							Return
						End If
						'DownloadAndSaveFile("https://library.timelesstruths.org/library/music/J/Jesus_Loves_Me/Jesus_Loves_Me.mid",FileName)
						'DownloadAndSaveFile("https://lugandahymnalnew.infinityfreeapp.com/midi/"&FileName.Replace("midi\",""),FileName)
					End If
				Catch
					Log(LastException)
					ToastMessageShow("Sorry, song is missing wait for the next update",True)
					ProgressDialogHide
					stop1
					Return
				End Try
				Return
			End Try
		Catch
			ToastMessageShow("Sorry Your phone doesn't support this feature", True)
			stop1
			Return
		End Try
		timer1.Initialize("timer1", 1000)
		timer1_Tick
		MP.Looping = False
		Panel3.SetVisibleAnimated(100, True)
		btnUp.Visible = False
		btnDown.Visible = True
		MP.Position = MP.Duration - 6000
		pos = 0
		loos = loops + 1
		If MP.Duration > 90000 Then
			loos = 1
			MP.Position = 0
			loopable = True
		End If
		leng = MP.Duration * loos + 6000
		codes.update_Setting("Seeker",leng)
		codes.update_Setting("Loops",loos)
		barVolume.Value = codes.vol
		MP.Play
		timer1.Enabled = True
		Return
	End If
	Try
		MP.Initialize2("MP")
		playing1 = True
		DoLoad(FileName, loops)
	Catch
		Log(LastException.Message)
	End Try
End Sub

Sub MP_Complete
	count = count + 1
	codes.update_Setting("Count",count)
	'Log(count)
	MP.Play
End Sub

Sub SendError(SongN As String, E_err As String)
	'Log("kiai")
	Panel2.Visible = True
	err_txt.Text = E_err
	'Panel2.BringToFront
	SN = SongN
	SB = E_err
End Sub
Sub stop1
	Dim Javascript As String
	Javascript = "stop()"
	WVE.ExecuteJavascript(Javascript)
End Sub
Sub Stop
	Try
		MP.Stop
		count = 0
		loopable = False
	Catch
		Log(LastException.Message)
	End Try
	Panel3.SetLayoutAnimated(200dip, 5dip,-160dip,100%x - 10dip,Panel3.Height)
	Panel3.SetVisibleAnimated(200, False)
End Sub

Sub timer1_Tick
	If MP.IsPlaying Then
		barPosition.Value = pos / leng * 100
		'barPosition.Value = leng / MP.Position * 100
		lblPosition.Text = "Position: " & ConvertToTimeFormat(pos) & _
			" (" & ConvertToTimeFormat(leng) & ")"
			'Log("kiki: "&MP.Position)
			pos = pos + 1000
		If count >= loos And count >= 2 Then
			stop1
			count = 0
			timer1.Enabled = False
			pos = 0
		End If
	Else
	End If
End Sub
'converts milliseconds to m:ss format.
Sub ConvertToTimeFormat(ms As Int) As String
	Dim seconds, minutes As Int
	seconds = Round(ms / 1000)
	minutes = Floor(seconds / 60)
	seconds = seconds Mod 60
	Return NumberFormat(minutes, 1, 0) & ":" & NumberFormat(seconds, 2, 0) 'ex: 3:05
End Sub

Sub barVolume_ValueChanged (Value As Int, UserChanged As Boolean)
	MP.SetVolume(barVolume.Value / 100, barVolume.Value / 100)
	Log("Value: "&barVolume.Value)
	'codes.m.Put("'Volume'",barVolume.Value)
	codes.update_Setting("Volume",barVolume.Value)
End Sub

Sub barPosition_ValueChanged (Value As Int, UserChanged As Boolean)
	Dim ckcount As Int
	If UserChanged = False Then Return 'the value was changed programmatically
	If loopable Then
		pos = Value / 100 * MP.Duration
		MP.Position = pos
	Else
		If (Value / 100 * leng) < 6000 Then
			MP.Position = MP.Duration - (6000-(Value / 100 * leng))
			pos = Value / 100 * leng
'			Log((Value / 100 *leng))
			count = 0
		Else
			MP.Position = ((Value / 100 * leng) - 6000) Mod MP.Duration
'			Log("get count: "&MP.Position&":"&MP.Duration)
			pos = Value / 100 * leng
			ckcount = ((Value / 100 * leng) - 6000) / MP.Duration
			count = ckcount + 1
	'		Log("get count: "&count)
		End If
	End If
	'Log("get count loopabble: "&MP.Position&" : "&MP.Duration&" : "&count)
	'Log("get count: "&count&" : "&loos)
	codes.update_Setting("Pos",pos)
End Sub

Sub Looping_CheckedChange(Checked As Boolean)
	MP.Looping = Checked
End Sub

Private Sub btnUp_Click
	Panel3.SetLayoutAnimated(500dip,5dip,-160dip,100%x - 10dip,Panel3.Height)
	btnUp.SetVisibleAnimated(200,False)
	btnDown.SetVisibleAnimated(200,True)
End Sub

Private Sub btnDown_Click
	Panel3.SetLayoutAnimated(500dip,5dip,5dip,100%x - 10dip,Panel3.Height)
	btnUp.SetVisibleAnimated(200,True)
	btnDown.SetVisibleAnimated(200,False)
End Sub

Sub DownloadAndSaveFile(link As String, fileName As String)
	'MsgboxAsync(link, "this is link")
	If File.Exists(File.DirInternal, fileName) Then
		Msgbox2Async("Do you want to overwrite?", "File exists", "Yes", "Cancel", "No", Null, "false")
		Wait For MsgBox_Result(Result As Int)
		If Result = DialogResponse.POSITIVE Then
			File.Delete(File.DirInternal, fileName)
		Else
			Return
		End If
	End If
	ProgressDialogShow2("please wait, while song is beng downloaded",False)
	Dim j As HttpJob
	j.Initialize("", Me)
	j.Download(link)
	Wait For (j) JobDone(j As HttpJob)
	If j.Success Then
		Dim out As OutputStream = File.OpenOutput(File.DirInternal, fileName, False)
		File.Copy2(j.GetInputStream, out)
		out.Close
		MsgboxAsync("Song added successfully", "Success")
		'WebView1.LoadUrl("file://" & File.Combine(File.DirInternal, "src%5Cmenu.html"))
	Else 
		Select j.Response.StatusCode
			Case -1:
				MsgboxAsync("Error: try again with a good data connection", "Connection error")
			Case 404:
				MsgboxAsync("Error: Song has not yet been added, but please keep on trying. or report this error", "Sorry for inconvinience")
			Case Else
				MsgboxAsync("Error: the error is unknown", "There was an error")
		End Select
	End If
	ProgressDialogHide
	j.Release
End Sub
