B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=11.8
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	
End Sub

Sub FixUrl(Folder As String, Url As String) As String
	Dim TempUrl As String
	TempUrl = Url.Replace("/","\")
	If TempUrl.Contains("file:\\\android_asset\") Then
		'If the index or main file is in the assets folder
		If Folder = "" Then
			TempUrl = TempUrl.Replace("file:\\\android_asset\","file:///android_asset/")
			Log("In assets: "&TempUrl)
		Else
			TempUrl = TempUrl.Replace("file:\\\android_asset\","file:///android_asset/"&Folder&"\")
			Log("Folder In assets: "&TempUrl)
		End If
	Else
		If Folder = "" Then
			TempUrl = TempUrl.Replace("file:\\\","file:///android_asset/")
			Log("In assets: "&TempUrl)
		Else
			TempUrl = TempUrl.Replace("file:\\\","file:///android_asset/"&Folder&"\")
			Log("Folder In assets: "&TempUrl)
		End If
	End If
	Return TempUrl
	'File:\\\android_asset\
End Sub