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
End Sub

Sub Activity_Create(FirstTime As Boolean)
'	Do Not forget To load the layout File created with the visual designer. For example:,
'	Activity.LoadLayout("Layout1")
	Activity.LoadLayout("song")
	JI.Initialize
'	WebView1.Initialize("WebView1")
	WVE.Initialize(WebView1)
	DWV.Initialize("WebView1")
	DWV1.Initialize("WebView1")
	WVE.AddJavascriptInterface(JI,"B4A")
	WVE.SetWebChromeClient(DWV)
	WVE.SetWebViewClient(DWV1)
	WebView1.ZoomEnabled = False
	Panel1.Visible = True
'	Panel1.AddView(WebView1, 0, 0, 100%x, 100%y)
'	WebView1.LoadHtml("www.google.com")
	'WebView1.LoadUrl("file:///android_asset/src%5Cmenu.html")
	
	'WebView1.LoadUrl("about:blank") ' Load a blank page initially
	'Wait For (WebView1) WebView1_PageFinished (Url As String)
	WVE.GetSettings.SetAllowFileAccess(True) ' Enable file access
	Dim internalPath As String = File.Combine(File.DirInternal, "src%5Cmenu.html")
	Dim Url As String = "file://" & internalPath
	WebView1.LoadUrl(Url)

	ProgressDialogShow2("Gumikiriza",False)
	WebView1.SendToBack
	load = True
	count = 0
End Sub

Sub Activity_Resume
	If playing1 Then
		If MP.IsPlaying = True Then 
			'MP.Looping = True
			If pos < MP.Position + 6000 Then
				pos = MP.Position + 6000
			Else
				pos = ((pos-6000)/(MP.Duration))*MP.Duration + MP.Position + 6000
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
		Return
	End If
End Sub

Private Sub WebView1_OverrideUrl (Url As String) As Boolean
	load = True
	If Url.Contains("#") Then
		Log("Me am try")
	Else If Url.Contains("baana.html") Then
		StartActivity("abaana")
		Activity.Finish
	Else
		WebView1.LoadUrl(codes.FixUrl("src",Url))
		'ProgressDialogShow2("Gumikiriza",False)
		Log(Url)
	End If
End Sub


Private Sub WebView1_PageFinished (Url As String)
	Log(Url)
	ProgressDialogHide
	btnUp_Click
	load = False
	Try
		If MP.IsPlaying Then
			Dim js As String
			js = "$('.play').css('display','none');$('.stop').css('display','');"
			WVE.ExecuteJavascript(js)
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
		Panel1.Visible=False
	End If
End Sub

Sub btn_cancle_Click
	err_txt.Text = ""
	Panel1.Visible=False
End Sub

Private Sub swipeRight
	Dim Javascript As String
	Javascript="P_prev()"
	WVE.ExecuteJavascript(Javascript)
End Sub
Private Sub swipeLeft
	Dim Javascript As String
	Javascript="N_next()"
	WVE.ExecuteJavascript(Javascript)
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then                           ' Hardware-Zurück Taste gedrückt
		If WebView1.Url.Contains("menu.html") Then
			Activity.Finish
			StartActivity(Main)
		Else
			'Stop
			'Song_Menu.Visible = False
			WebView1.LoadUrl("file:///data/user/0/com.LugandaHymnalNew/files/src%5Cmenu.html")
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
		leng = MP.Duration * loops + 6000
		MP.Position = MP.Duration - 6000
		pos = 0
		loos = loops + 1
		If MP.Duration > 90000 Then
			loos = 1
			MP.Position = 0
			loopable = True
		End If
		'Log("volume: "&codes.m.Get("'Volume'"))
		'MP.SetVolume(codes.m.Get("'Volume'")/100, codes.m.Get("'Volume'")/100)
		Log("test me "&codes.vol)
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
	Log(count)
	MP.Play
End Sub

Sub SendError(SongN As String, E_err As String)
	Log("kiai")
	Panel2.Visible = True
	Panel2.BringToFront
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
			Log((Value / 100 *leng))
			count = 0
		Else
			MP.Position = ((Value / 100 * leng) - 6000) Mod MP.Duration
			Log("get count: "&MP.Position&":"&MP.Duration)
			pos = Value / 100 * leng
			ckcount = ((Value / 100 * leng) - 6000) / MP.Duration
			count = ckcount + 1
	'		Log("get count: "&count)
		End If
	End If
	'Log("get count loopabble: "&MP.Position&" : "&MP.Duration&" : "&count)
	Log("get count: "&count&" : "&loos)
	timer1_Tick 'immediately update the progress label
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
