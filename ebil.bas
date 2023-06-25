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
	'Private MainWebView As WebView
	Private WVE As WebViewExtras
	Private DWVC As DefaultWebViewClient
	Private WebView1 As WebView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("dom")
 
	DWVC.Initialize("WebViewClient")
	WVE.Initialize(WebView1)
	WVE.SetWebViewClient(DWVC)
	ProgressDialogShow2("GUMIKIRIZA",False)
	WVE.LoadUrl("https://www.adventist.org")
End Sub
Sub WebViewClient_ReceivedError(ErrorCode As Int, Description As String, FailingUrl As String)
	WVE.LoadHtml(customwebviewerror.GetErrorPageHtml(Description))
End Sub
Sub WebViewClient_ReceivedSslError(SslErrorHandler1 As SslErrorHandler, SslError1 As SslError)
	SslErrorHandler1.Cancel
End Sub
Sub WebViewClient_PageFinished (Url As String)
	ProgressDialogHide
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
