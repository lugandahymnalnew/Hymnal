B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=9.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private WVE As WebViewExtras
	Private DWVC As DefaultWebViewClient
	Private WebView1 As WebView
	Private rp As RuntimePermissions
	Private JI1 As DefaultJavascriptInterface
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("dom")
 	JI1.Initialize
	DWVC.Initialize("WebViewClient")
	WVE.Initialize(WebView1)
	WVE.SetWebViewClient(DWVC)
	WVE.AddJavascriptInterface(JI1, "B4A")
	ProgressDialogShow("GUMIKIRIZA")
	WVE.LoadUrl("https://newlugandahymnal.onrender.com/adverts")
End Sub

Sub Activity_Resume
End Sub
Sub WebViewClient_ReceivedError(ErrorCode As Int, Description As String, FailingUrl As String)
	WVE.LoadHtml(customwebviewerror.GetErrorPageHtml(Description))
End Sub
Sub  WebView1_ReceivedSslError(SslErrorHandler1 As SslErrorHandler, SslError1 As SslError)
	SslErrorHandler1.Cancel
End Sub
Sub WebViewClient_PageFinished (Url As String)
	ProgressDialogHide
End Sub
Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub Call(Command As String)
	rp.CheckAndRequest(rp.PERMISSION_CALL_PHONE)
	Wait For Activity_PermissionResult(Permission As String, Result As Boolean)
	If Result = False Then Return
	' PERMISSION_CALL_PHONE includes phone state
	Dim p As PhoneCalls
	Dim k = Command.Replace("#","%23")
	'Log(k)
	StartActivity(p.Call(Command.Replace("#","%23")))
End Sub
Sub Open_web(Link As String)
	Dim p As PhoneIntents
	StartActivity(p.OpenBrowser(Link))
	Log("true")
End Sub
Sub SendError(Sj As String, Ms As String)
	codes.SendEmail(Sj,Ms)
End Sub
