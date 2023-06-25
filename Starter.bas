B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.9
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Starter service can start in the foreground state in some edge cases.
End Sub

Sub Service_Music(FName As String)
	If songs.MP.IsInitialized = True Then
		'If songs.MP.IsPlaying = True Then songs.MP.Stop
		songs.MP.Initialize2("MP")
		songs.MP.Load(File.DirAssets, FName)
		Log("starter: "&songs.MP.IsInitialized)
		Return
	End If
	songs.MP.Initialize()
	Service_Music(FName)
	Return
End Sub
Sub MP_Complete
	songs.counter = songs.counter + 1
	songs.MP.Play
	Log("in sev: "&songs.counter)
End Sub
Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
	If songs.MP.IsInitialized = True Then
		If songs.MP.IsPlaying = True Then songs.MP.Stop
	End If
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	ToastMessageShow(Error.Message,True)
	ToastMessageShow(StackTrace,True)
	Return True
End Sub

Sub Service_Destroy

End Sub
