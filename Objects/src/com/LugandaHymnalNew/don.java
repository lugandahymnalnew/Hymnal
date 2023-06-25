package com.LugandaHymnalNew;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class don extends Activity implements B4AActivity{
	public static don mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "com.LugandaHymnalNew", "com.LugandaHymnalNew.don");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (don).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.LugandaHymnalNew", "com.LugandaHymnalNew.don");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.LugandaHymnalNew.don", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (don) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (don) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return don.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (don) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (don) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            don mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (don) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public uk.co.martinpearman.b4a.webkit.WebViewExtras _vvvvvvvvvvv3 = null;
public uk.co.martinpearman.b4a.webkit.DefaultWebViewClient _vvvvvvvvvvvvvv1 = null;
public anywheresoftware.b4a.objects.WebViewWrapper _webview1 = null;
public anywheresoftware.b4a.objects.RuntimePermissions _vvvvvvvvvvvvv1 = null;
public uk.co.martinpearman.b4a.webkit.DefaultJavascriptInterface _vvvvvvvvvvvvv0 = null;
public com.LugandaHymnalNew.main _vvvv6 = null;
public com.LugandaHymnalNew.codes _vvvv7 = null;
public com.LugandaHymnalNew.starter _vvvv0 = null;
public com.LugandaHymnalNew.songs _vvvvv1 = null;
public com.LugandaHymnalNew.customwebviewerror _vvvvv3 = null;
public com.LugandaHymnalNew.err _vvvvv4 = null;
public com.LugandaHymnalNew.abaana _vvvvv5 = null;
public com.LugandaHymnalNew.ebil _vvvvv6 = null;
public com.LugandaHymnalNew.emisi _vvvvv7 = null;
public com.LugandaHymnalNew.httputils2service _vvvvv0 = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"dom\")";
mostCurrent._activity.LoadLayout("dom",mostCurrent.activityBA);
 //BA.debugLineNum = 26;BA.debugLine="JI1.Initialize";
mostCurrent._vvvvvvvvvvvvv0.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 27;BA.debugLine="DWVC.Initialize(\"WebViewClient\")";
mostCurrent._vvvvvvvvvvvvvv1.Initialize(mostCurrent.activityBA,"WebViewClient");
 //BA.debugLineNum = 28;BA.debugLine="WVE.Initialize(WebView1)";
mostCurrent._vvvvvvvvvvv3.Initialize((android.webkit.WebView)(mostCurrent._webview1.getObject()));
 //BA.debugLineNum = 29;BA.debugLine="WVE.SetWebViewClient(DWVC)";
mostCurrent._vvvvvvvvvvv3.SetWebViewClient((android.webkit.WebViewClient)(mostCurrent._vvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 30;BA.debugLine="WVE.AddJavascriptInterface(JI1, \"B4A\")";
mostCurrent._vvvvvvvvvvv3.AddJavascriptInterface((Object)(mostCurrent._vvvvvvvvvvvvv0),"B4A");
 //BA.debugLineNum = 31;BA.debugLine="ProgressDialogShow(\"GUMIKIRIZA\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("GUMIKIRIZA"));
 //BA.debugLineNum = 32;BA.debugLine="WVE.LoadUrl(\"file:///android_asset/src%5Cpages%5C";
mostCurrent._vvvvvvvvvvv3.LoadUrl("file:///android_asset/src%5Cpages%5Cmpagila.html");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static void  _vvvvvvvvvvvvvv2(String _command) throws Exception{
ResumableSub_Call rsub = new ResumableSub_Call(null,_command);
rsub.resume(processBA, null);
}
public static class ResumableSub_Call extends BA.ResumableSub {
public ResumableSub_Call(com.LugandaHymnalNew.don parent,String _command) {
this.parent = parent;
this._command = _command;
}
com.LugandaHymnalNew.don parent;
String _command;
String _permission = "";
boolean _result = false;
anywheresoftware.b4a.phone.Phone.PhoneCalls _p = null;
String _k = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 50;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CALL_PHONE)";
parent.mostCurrent._vvvvvvvvvvvvv1.CheckAndRequest(processBA,parent.mostCurrent._vvvvvvvvvvvvv1.PERMISSION_CALL_PHONE);
 //BA.debugLineNum = 51;BA.debugLine="Wait For Activity_PermissionResult(Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 52;BA.debugLine="If Result = False Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (_result==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 54;BA.debugLine="Dim p As PhoneCalls";
_p = new anywheresoftware.b4a.phone.Phone.PhoneCalls();
 //BA.debugLineNum = 55;BA.debugLine="Dim k = Command.Replace(\"#\",\"%23\")";
_k = _command.replace("#","%23");
 //BA.debugLineNum = 57;BA.debugLine="StartActivity(p.Call(Command.Replace(\"#\",\"%23\")))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.Call(_command.replace("#","%23"))));
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_permissionresult(String _permission,boolean _result) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private WVE As WebViewExtras";
mostCurrent._vvvvvvvvvvv3 = new uk.co.martinpearman.b4a.webkit.WebViewExtras();
 //BA.debugLineNum = 16;BA.debugLine="Private DWVC As DefaultWebViewClient";
mostCurrent._vvvvvvvvvvvvvv1 = new uk.co.martinpearman.b4a.webkit.DefaultWebViewClient();
 //BA.debugLineNum = 17;BA.debugLine="Private WebView1 As WebView";
mostCurrent._webview1 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private rp As RuntimePermissions";
mostCurrent._vvvvvvvvvvvvv1 = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 19;BA.debugLine="Private JI1 As DefaultJavascriptInterface";
mostCurrent._vvvvvvvvvvvvv0 = new uk.co.martinpearman.b4a.webkit.DefaultJavascriptInterface();
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _open_web(String _link) throws Exception{
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
 //BA.debugLineNum = 59;BA.debugLine="Sub Open_web(Link As String)";
 //BA.debugLineNum = 60;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 61;BA.debugLine="StartActivity(p.OpenBrowser(Link))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.OpenBrowser(_link)));
 //BA.debugLineNum = 62;BA.debugLine="Log(\"true\")";
anywheresoftware.b4a.keywords.Common.LogImpl("04784131","true",0);
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvv3(String _sj,String _ms) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub SendError(Sj As String, Ms As String)";
 //BA.debugLineNum = 65;BA.debugLine="codes.SendEmail(Sj,Ms)";
mostCurrent._vvvv7._vvv4 /*String*/ (mostCurrent.activityBA,_sj,_ms);
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _webview1_receivedsslerror(uk.co.martinpearman.b4a.webkit.SslErrorHandler _sslerrorhandler1,uk.co.martinpearman.b4a.net.http.SslError _sslerror1) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub  WebView1_ReceivedSslError(SslErrorHandler1 As";
 //BA.debugLineNum = 41;BA.debugLine="SslErrorHandler1.Cancel";
_sslerrorhandler1.Cancel();
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _webviewclient_pagefinished(String _url) throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub WebViewClient_PageFinished (Url As String)";
 //BA.debugLineNum = 44;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _webviewclient_receivederror(int _errorcode,String _description,String _failingurl) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub WebViewClient_ReceivedError(ErrorCode As Int,";
 //BA.debugLineNum = 38;BA.debugLine="WVE.LoadHtml(customwebviewerror.GetErrorPageHtml(";
mostCurrent._vvvvvvvvvvv3.LoadHtml(mostCurrent._vvvvv3._vvvv4 /*String*/ (mostCurrent.activityBA,_description));
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
}