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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private WVE As WebViewExtras
	Private J1 As DefaultJavascriptInterface
	Private DWVC As DefaultWebChromeClient
	Private DWVC1 As DefaultWebViewClient
	Private WebView1 As WebView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("dom")
	J1.Initialize
	WVE.Initialize(WebView1)
	DWVC.Initialize("WebView1")
	DWVC1.Initialize("WebView1")
	WVE.AddJavascriptInterface(J1,"B4A")
	WVE.SetWebChromeClient(DWVC)
	WVE.SetWebViewClient(DWVC1)
	WebView1.LoadUrl("file:///android_asset/src%5Cpages%5Cabaana.html")
End Sub

Sub WebView1_ReceivedError(ErrorCode As Int, Description As String, FailingUrl As String)
	WebView1.LoadHtml(customwebviewerror.GetErrorPageHtml(Description))
End Sub

Sub openMenu
	StartActivity("songs")
	Activity.Finish
End Sub

Sub WebView1_PageFinished (Url As String)
	ProgressDialogHide
End Sub
Sub ShareMessage(sMes As String)
	Dim in As Intent
	in.Initialize(in.ACTION_SEND, "")
	in.PutExtra("android.intent.extra.TEXT", sMes)
	in.SetType("text/plain")
	in.WrapAsIntentChooser("Share Via")
	StartActivity(in)
End Sub

Sub Activity_Resume
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
