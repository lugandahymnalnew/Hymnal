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

public class songs extends Activity implements B4AActivity{
	public static songs mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.LugandaHymnalNew", "com.LugandaHymnalNew.songs");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (songs).");
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
		activityBA = new BA(this, layout, processBA, "com.LugandaHymnalNew", "com.LugandaHymnalNew.songs");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.LugandaHymnalNew.songs", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (songs) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (songs) Resume **");
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
		return songs.class;
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
            BA.LogInfo("** Activity (songs) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (songs) Pause event (activity is not paused). **");
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
            songs mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (songs) Resume **");
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
public static anywheresoftware.b4a.phone.Phone _p = null;
public static String _sn = "";
public static String _sb = "";
public static anywheresoftware.b4a.objects.MediaPlayerWrapper _mp = null;
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public static int _counter = 0;
public static boolean _sw = false;
public uk.co.martinpearman.b4a.webkit.DefaultJavascriptInterface _ji = null;
public uk.co.martinpearman.b4a.webkit.WebViewExtras _wve = null;
public uk.co.martinpearman.b4a.webkit.DefaultWebChromeClient _dwv = null;
public uk.co.martinpearman.b4a.webkit.DefaultWebViewClient _dwv1 = null;
public static long _s_start = 0L;
public anywheresoftware.b4a.objects.EditTextWrapper _err_txt = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _barposition = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblposition = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _barvolume = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnup = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndown = null;
public static boolean _load = false;
public static long _leng = 0L;
public static long _pos = 0L;
public static long _inpos = 0L;
public static int _count = 0;
public static int _loos = 0;
public anywheresoftware.b4a.objects.WebViewWrapper _webview1 = null;
public static boolean _playing1 = false;
public static boolean _loopable = false;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public com.LugandaHymnalNew.main _main = null;
public com.LugandaHymnalNew.codes _codes = null;
public com.LugandaHymnalNew.starter _starter = null;
public com.LugandaHymnalNew.don _don = null;
public com.LugandaHymnalNew.customwebviewerror _customwebviewerror = null;
public com.LugandaHymnalNew.err _err = null;
public com.LugandaHymnalNew.abaana _abaana = null;
public com.LugandaHymnalNew.ebil _ebil = null;
public com.LugandaHymnalNew.emisi _emisi = null;
public com.LugandaHymnalNew.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
String _internalpath = "";
String _url = "";
 //BA.debugLineNum = 52;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 55;BA.debugLine="Activity.LoadLayout(\"song\")";
mostCurrent._activity.LoadLayout("song",mostCurrent.activityBA);
 //BA.debugLineNum = 56;BA.debugLine="JI.Initialize";
mostCurrent._ji.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 58;BA.debugLine="WVE.Initialize(WebView1)";
mostCurrent._wve.Initialize((android.webkit.WebView)(mostCurrent._webview1.getObject()));
 //BA.debugLineNum = 59;BA.debugLine="DWV.Initialize(\"WebView1\")";
mostCurrent._dwv.Initialize(mostCurrent.activityBA,"WebView1");
 //BA.debugLineNum = 60;BA.debugLine="DWV1.Initialize(\"WebView1\")";
mostCurrent._dwv1.Initialize(mostCurrent.activityBA,"WebView1");
 //BA.debugLineNum = 61;BA.debugLine="WVE.AddJavascriptInterface(JI,\"B4A\")";
mostCurrent._wve.AddJavascriptInterface((Object)(mostCurrent._ji),"B4A");
 //BA.debugLineNum = 62;BA.debugLine="WVE.SetWebChromeClient(DWV)";
mostCurrent._wve.SetWebChromeClient((android.webkit.WebChromeClient)(mostCurrent._dwv.getObject()));
 //BA.debugLineNum = 63;BA.debugLine="WVE.SetWebViewClient(DWV1)";
mostCurrent._wve.SetWebViewClient((android.webkit.WebViewClient)(mostCurrent._dwv1.getObject()));
 //BA.debugLineNum = 64;BA.debugLine="WebView1.ZoomEnabled = False";
mostCurrent._webview1.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 65;BA.debugLine="Panel1.Visible = True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 72;BA.debugLine="WVE.GetSettings.SetAllowFileAccess(True) ' Enable";
mostCurrent._wve.GetSettings().SetAllowFileAccess(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 73;BA.debugLine="Dim internalPath As String = File.Combine(File.Di";
_internalpath = anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"src%5Cmenu.html");
 //BA.debugLineNum = 74;BA.debugLine="Dim Url As String = \"file://\" & internalPath";
_url = "file://"+_internalpath;
 //BA.debugLineNum = 75;BA.debugLine="WebView1.LoadUrl(Url)";
mostCurrent._webview1.LoadUrl(_url);
 //BA.debugLineNum = 77;BA.debugLine="ProgressDialogShow2(\"Gumikiriza\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("Gumikiriza"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 78;BA.debugLine="WebView1.SendToBack";
mostCurrent._webview1.SendToBack();
 //BA.debugLineNum = 79;BA.debugLine="load = True";
_load = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 80;BA.debugLine="count = 0";
_count = (int) (0);
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 169;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 170;BA.debugLine="If WebView1.Url.Contains(\"menu.html\") Then";
if (mostCurrent._webview1.getUrl().contains("menu.html")) { 
 //BA.debugLineNum = 171;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 172;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 }else {
 //BA.debugLineNum = 176;BA.debugLine="WebView1.LoadUrl(\"file:///data/user/0/com.Lugan";
mostCurrent._webview1.LoadUrl("file:///data/user/0/com.LugandaHymnalNew/files/src%5Cmenu.html");
 //BA.debugLineNum = 177;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 180;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 100;BA.debugLine="If UserClosed = True Then";
if (_userclosed==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 101;BA.debugLine="If playing1 Then MP.Stop";
if (_playing1) { 
_mp.Stop();};
 //BA.debugLineNum = 102;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 84;BA.debugLine="If playing1 Then";
if (_playing1) { 
 //BA.debugLineNum = 85;BA.debugLine="If MP.IsPlaying = True Then";
if (_mp.IsPlaying()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 87;BA.debugLine="If pos < MP.Position + 6000 Then";
if (_pos<_mp.getPosition()+6000) { 
 //BA.debugLineNum = 88;BA.debugLine="pos = MP.Position + 6000";
_pos = (long) (_mp.getPosition()+6000);
 }else {
 //BA.debugLineNum = 90;BA.debugLine="pos = ((pos-6000)/(MP.Duration))*MP.Duration +";
_pos = (long) (((_pos-6000)/(double)(_mp.getDuration()))*_mp.getDuration()+_mp.getPosition()+6000);
 };
 }else {
 //BA.debugLineNum = 93;BA.debugLine="stop1";
_stop1();
 //BA.debugLineNum = 94;BA.debugLine="Log(\"me\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22621451","me",0);
 };
 };
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public static String  _barposition_valuechanged(int _value,boolean _userchanged) throws Exception{
int _ckcount = 0;
 //BA.debugLineNum = 334;BA.debugLine="Sub barPosition_ValueChanged (Value As Int, UserCh";
 //BA.debugLineNum = 335;BA.debugLine="Dim ckcount As Int";
_ckcount = 0;
 //BA.debugLineNum = 336;BA.debugLine="If UserChanged = False Then Return 'the value was";
if (_userchanged==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 337;BA.debugLine="If loopable Then";
if (_loopable) { 
 //BA.debugLineNum = 338;BA.debugLine="pos = Value / 100 * MP.Duration";
_pos = (long) (_value/(double)100*_mp.getDuration());
 //BA.debugLineNum = 339;BA.debugLine="MP.Position = pos";
_mp.setPosition((int) (_pos));
 }else {
 //BA.debugLineNum = 341;BA.debugLine="If (Value / 100 * leng) < 6000 Then";
if ((_value/(double)100*_leng)<6000) { 
 //BA.debugLineNum = 342;BA.debugLine="MP.Position = MP.Duration - (6000-(Value / 100";
_mp.setPosition((int) (_mp.getDuration()-(6000-(_value/(double)100*_leng))));
 //BA.debugLineNum = 343;BA.debugLine="pos = Value / 100 * leng";
_pos = (long) (_value/(double)100*_leng);
 //BA.debugLineNum = 344;BA.debugLine="Log((Value / 100 *leng))";
anywheresoftware.b4a.keywords.Common.LogImpl("23866634",BA.NumberToString((_value/(double)100*_leng)),0);
 //BA.debugLineNum = 345;BA.debugLine="count = 0";
_count = (int) (0);
 }else {
 //BA.debugLineNum = 347;BA.debugLine="MP.Position = ((Value / 100 * leng) - 6000) Mod";
_mp.setPosition((int) (((_value/(double)100*_leng)-6000)%_mp.getDuration()));
 //BA.debugLineNum = 348;BA.debugLine="Log(\"get count: \"&MP.Position&\":\"&MP.Duration)";
anywheresoftware.b4a.keywords.Common.LogImpl("23866638","get count: "+BA.NumberToString(_mp.getPosition())+":"+BA.NumberToString(_mp.getDuration()),0);
 //BA.debugLineNum = 349;BA.debugLine="pos = Value / 100 * leng";
_pos = (long) (_value/(double)100*_leng);
 //BA.debugLineNum = 350;BA.debugLine="ckcount = ((Value / 100 * leng) - 6000) / MP.Du";
_ckcount = (int) (((_value/(double)100*_leng)-6000)/(double)_mp.getDuration());
 //BA.debugLineNum = 351;BA.debugLine="count = ckcount + 1";
_count = (int) (_ckcount+1);
 };
 };
 //BA.debugLineNum = 356;BA.debugLine="Log(\"get count: \"&count&\" : \"&loos)";
anywheresoftware.b4a.keywords.Common.LogImpl("23866646","get count: "+BA.NumberToString(_count)+" : "+BA.NumberToString(_loos),0);
 //BA.debugLineNum = 357;BA.debugLine="timer1_Tick 'immediately update the progress labe";
_timer1_tick();
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return "";
}
public static String  _barvolume_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 327;BA.debugLine="Sub barVolume_ValueChanged (Value As Int, UserChan";
 //BA.debugLineNum = 328;BA.debugLine="MP.SetVolume(barVolume.Value / 100, barVolume.Val";
_mp.SetVolume((float) (mostCurrent._barvolume.getValue()/(double)100),(float) (mostCurrent._barvolume.getValue()/(double)100));
 //BA.debugLineNum = 329;BA.debugLine="Log(\"Value: \"&barVolume.Value)";
anywheresoftware.b4a.keywords.Common.LogImpl("23801090","Value: "+BA.NumberToString(mostCurrent._barvolume.getValue()),0);
 //BA.debugLineNum = 331;BA.debugLine="codes.update_Setting(\"Volume\",barVolume.Value)";
mostCurrent._codes._update_setting /*String*/ (mostCurrent.activityBA,"Volume",BA.NumberToString(mostCurrent._barvolume.getValue()));
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public static String  _btn_cancle_click() throws Exception{
 //BA.debugLineNum = 152;BA.debugLine="Sub btn_cancle_Click";
 //BA.debugLineNum = 153;BA.debugLine="err_txt.Text = \"\"";
mostCurrent._err_txt.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 154;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public static String  _btn_ok_click() throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Sub btn_ok_Click";
 //BA.debugLineNum = 139;BA.debugLine="If err_txt.Text = \"\" Then";
if ((mostCurrent._err_txt.getText()).equals("")) { 
 //BA.debugLineNum = 140;BA.debugLine="ToastMessageShow(\"You can't send empty feedback\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("You can't send empty feedback"),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 142;BA.debugLine="Try";
try { //BA.debugLineNum = 143;BA.debugLine="codes.SendEmail(SN, err_txt.Text)";
mostCurrent._codes._sendemail /*String*/ (mostCurrent.activityBA,_sn,mostCurrent._err_txt.getText());
 } 
       catch (Exception e7) {
			processBA.setLastException(e7); //BA.debugLineNum = 145;BA.debugLine="ToastMessageShow(LastException.Message, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 147;BA.debugLine="err_txt.Text = \"\"";
mostCurrent._err_txt.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 148;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public static String  _btndown_click() throws Exception{
 //BA.debugLineNum = 370;BA.debugLine="Private Sub btnDown_Click";
 //BA.debugLineNum = 371;BA.debugLine="Panel3.SetLayoutAnimated(500dip,5dip,5dip,100%x -";
mostCurrent._panel3.SetLayoutAnimated(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),mostCurrent._panel3.getHeight());
 //BA.debugLineNum = 372;BA.debugLine="btnUp.SetVisibleAnimated(200,True)";
mostCurrent._btnup.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 373;BA.debugLine="btnDown.SetVisibleAnimated(200,False)";
mostCurrent._btndown.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 374;BA.debugLine="End Sub";
return "";
}
public static String  _btnup_click() throws Exception{
 //BA.debugLineNum = 364;BA.debugLine="Private Sub btnUp_Click";
 //BA.debugLineNum = 365;BA.debugLine="Panel3.SetLayoutAnimated(500dip,5dip,-160dip,100%";
mostCurrent._panel3.SetLayoutAnimated(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),mostCurrent._panel3.getHeight());
 //BA.debugLineNum = 366;BA.debugLine="btnUp.SetVisibleAnimated(200,False)";
mostCurrent._btnup.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 367;BA.debugLine="btnDown.SetVisibleAnimated(200,True)";
mostCurrent._btndown.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 368;BA.debugLine="End Sub";
return "";
}
public static String  _converttotimeformat(int _ms) throws Exception{
int _seconds = 0;
int _minutes = 0;
 //BA.debugLineNum = 319;BA.debugLine="Sub ConvertToTimeFormat(ms As Int) As String";
 //BA.debugLineNum = 320;BA.debugLine="Dim seconds, minutes As Int";
_seconds = 0;
_minutes = 0;
 //BA.debugLineNum = 321;BA.debugLine="seconds = Round(ms / 1000)";
_seconds = (int) (anywheresoftware.b4a.keywords.Common.Round(_ms/(double)1000));
 //BA.debugLineNum = 322;BA.debugLine="minutes = Floor(seconds / 60)";
_minutes = (int) (anywheresoftware.b4a.keywords.Common.Floor(_seconds/(double)60));
 //BA.debugLineNum = 323;BA.debugLine="seconds = seconds Mod 60";
_seconds = (int) (_seconds%60);
 //BA.debugLineNum = 324;BA.debugLine="Return NumberFormat(minutes, 1, 0) & \":\" & Number";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_minutes,(int) (1),(int) (0))+":"+anywheresoftware.b4a.keywords.Common.NumberFormat(_seconds,(int) (2),(int) (0));
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
return "";
}
public static void  _doload(String _filename,String _loops) throws Exception{
ResumableSub_DoLoad rsub = new ResumableSub_DoLoad(null,_filename,_loops);
rsub.resume(processBA, null);
}
public static class ResumableSub_DoLoad extends BA.ResumableSub {
public ResumableSub_DoLoad(com.LugandaHymnalNew.songs parent,String _filename,String _loops) {
this.parent = parent;
this._filename = _filename;
this._loops = _loops;
}
com.LugandaHymnalNew.songs parent;
String _filename;
String _loops;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 198;BA.debugLine="FileName = FileName.Replace(\"/\",\"\\\")";
_filename = _filename.replace("/","\\");
 //BA.debugLineNum = 200;BA.debugLine="If playing1 Then";
if (true) break;

case 1:
//if
this.state = 44;
if (parent._playing1) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 201;BA.debugLine="If MP.IsPlaying Then MP.Stop";
if (true) break;

case 4:
//if
this.state = 9;
if (parent._mp.IsPlaying()) { 
this.state = 6;
;}if (true) break;

case 6:
//C
this.state = 9;
parent._mp.Stop();
if (true) break;

case 9:
//C
this.state = 10;
;
 //BA.debugLineNum = 202;BA.debugLine="Try";
if (true) break;

case 10:
//try
this.state = 39;
this.catchState = 38;
this.state = 12;
if (true) break;

case 12:
//C
this.state = 13;
this.catchState = 38;
 //BA.debugLineNum = 203;BA.debugLine="MP.Initialize2(\"MP\")";
parent._mp.Initialize2(processBA,"MP");
 //BA.debugLineNum = 204;BA.debugLine="Try";
if (true) break;

case 13:
//try
this.state = 36;
this.catchState = 17;
this.state = 15;
if (true) break;

case 15:
//C
this.state = 36;
this.catchState = 17;
 //BA.debugLineNum = 205;BA.debugLine="MP.Load(File.DirInternal, FileName)";
parent._mp.Load(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename);
 if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 38;
 //BA.debugLineNum = 207;BA.debugLine="Try";
if (true) break;

case 18:
//try
this.state = 35;
this.catchState = 34;
this.state = 20;
if (true) break;

case 20:
//C
this.state = 21;
this.catchState = 34;
 //BA.debugLineNum = 208;BA.debugLine="If File.Exists(File.DirInternal,FileName) The";
if (true) break;

case 21:
//if
this.state = 32;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename)) { 
this.state = 23;
}else {
this.state = 25;
}if (true) break;

case 23:
//C
this.state = 32;
 //BA.debugLineNum = 209;BA.debugLine="MP.Load(File.DirInternal, FileName)";
parent._mp.Load(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename);
 //BA.debugLineNum = 210;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 25:
//C
this.state = 26;
 //BA.debugLineNum = 212;BA.debugLine="Msgbox2Async(\"Do you want to download, the s";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Do you want to download, the song?"),BA.ObjectToCharSequence("Try downloading"),"Yes","Cancle","No",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 213;BA.debugLine="Wait For MsgBox_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 50;
return;
case 50:
//C
this.state = 26;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 214;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 26:
//if
this.state = 31;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 28;
}else {
this.state = 30;
}if (true) break;

case 28:
//C
this.state = 31;
 //BA.debugLineNum = 215;BA.debugLine="DownloadAndSaveFile(\"https://newlugandahymn";
_downloadandsavefile("https://newlugandahymnal.onrender.com/midi/"+_filename.replace("midi\\",""),_filename);
 //BA.debugLineNum = 216;BA.debugLine="stop1";
_stop1();
 //BA.debugLineNum = 217;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 30:
//C
this.state = 31;
 //BA.debugLineNum = 219;BA.debugLine="stop1";
_stop1();
 //BA.debugLineNum = 220;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 31:
//C
this.state = 32;
;
 if (true) break;

case 32:
//C
this.state = 35;
;
 if (true) break;

case 34:
//C
this.state = 35;
this.catchState = 38;
 //BA.debugLineNum = 226;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("23342365",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 227;BA.debugLine="ToastMessageShow(\"Sorry, song is missing wait";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Sorry, song is missing wait for the next update"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 228;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 229;BA.debugLine="stop1";
_stop1();
 //BA.debugLineNum = 230;BA.debugLine="Return";
if (true) return ;
 if (true) break;
if (true) break;

case 35:
//C
this.state = 36;
this.catchState = 38;
;
 //BA.debugLineNum = 232;BA.debugLine="Return";
if (true) return ;
 if (true) break;
if (true) break;

case 36:
//C
this.state = 39;
this.catchState = 38;
;
 if (true) break;

case 38:
//C
this.state = 39;
this.catchState = 0;
 //BA.debugLineNum = 235;BA.debugLine="ToastMessageShow(\"Sorry Your phone doesn't supp";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Sorry Your phone doesn't support this feature"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 236;BA.debugLine="stop1";
_stop1();
 //BA.debugLineNum = 237;BA.debugLine="Return";
if (true) return ;
 if (true) break;
if (true) break;

case 39:
//C
this.state = 40;
this.catchState = 0;
;
 //BA.debugLineNum = 239;BA.debugLine="timer1.Initialize(\"timer1\", 1000)";
parent._timer1.Initialize(processBA,"timer1",(long) (1000));
 //BA.debugLineNum = 240;BA.debugLine="timer1_Tick";
_timer1_tick();
 //BA.debugLineNum = 241;BA.debugLine="MP.Looping = False";
parent._mp.setLooping(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 242;BA.debugLine="Panel3.SetVisibleAnimated(100, True)";
parent.mostCurrent._panel3.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 243;BA.debugLine="btnUp.Visible = False";
parent.mostCurrent._btnup.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 244;BA.debugLine="btnDown.Visible = True";
parent.mostCurrent._btndown.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 245;BA.debugLine="leng = MP.Duration * loops + 6000";
parent._leng = (long) (parent._mp.getDuration()*(double)(Double.parseDouble(_loops))+6000);
 //BA.debugLineNum = 246;BA.debugLine="MP.Position = MP.Duration - 6000";
parent._mp.setPosition((int) (parent._mp.getDuration()-6000));
 //BA.debugLineNum = 247;BA.debugLine="pos = 0";
parent._pos = (long) (0);
 //BA.debugLineNum = 248;BA.debugLine="loos = loops + 1";
parent._loos = (int) ((double)(Double.parseDouble(_loops))+1);
 //BA.debugLineNum = 249;BA.debugLine="If MP.Duration > 90000 Then";
if (true) break;

case 40:
//if
this.state = 43;
if (parent._mp.getDuration()>90000) { 
this.state = 42;
}if (true) break;

case 42:
//C
this.state = 43;
 //BA.debugLineNum = 250;BA.debugLine="loos = 1";
parent._loos = (int) (1);
 //BA.debugLineNum = 251;BA.debugLine="MP.Position = 0";
parent._mp.setPosition((int) (0));
 //BA.debugLineNum = 252;BA.debugLine="loopable = True";
parent._loopable = anywheresoftware.b4a.keywords.Common.True;
 if (true) break;

case 43:
//C
this.state = 44;
;
 //BA.debugLineNum = 256;BA.debugLine="Log(\"test me \"&codes.vol)";
anywheresoftware.b4a.keywords.Common.LogImpl("23342395","test me "+parent.mostCurrent._codes._vol /*String*/ ,0);
 //BA.debugLineNum = 257;BA.debugLine="barVolume.Value = codes.vol";
parent.mostCurrent._barvolume.setValue((int)(Double.parseDouble(parent.mostCurrent._codes._vol /*String*/ )));
 //BA.debugLineNum = 258;BA.debugLine="MP.Play";
parent._mp.Play();
 //BA.debugLineNum = 259;BA.debugLine="timer1.Enabled = True";
parent._timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 260;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 262;BA.debugLine="Try";

case 44:
//try
this.state = 49;
this.catchState = 48;
this.state = 46;
if (true) break;

case 46:
//C
this.state = 49;
this.catchState = 48;
 //BA.debugLineNum = 263;BA.debugLine="MP.Initialize2(\"MP\")";
parent._mp.Initialize2(processBA,"MP");
 //BA.debugLineNum = 264;BA.debugLine="playing1 = True";
parent._playing1 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 265;BA.debugLine="DoLoad(FileName, loops)";
_doload(_filename,_loops);
 if (true) break;

case 48:
//C
this.state = 49;
this.catchState = 0;
 //BA.debugLineNum = 267;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("23342406",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 if (true) break;
if (true) break;

case 49:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static void  _downloadandsavefile(String _link,String _filename) throws Exception{
ResumableSub_DownloadAndSaveFile rsub = new ResumableSub_DownloadAndSaveFile(null,_link,_filename);
rsub.resume(processBA, null);
}
public static class ResumableSub_DownloadAndSaveFile extends BA.ResumableSub {
public ResumableSub_DownloadAndSaveFile(com.LugandaHymnalNew.songs parent,String _link,String _filename) {
this.parent = parent;
this._link = _link;
this._filename = _filename;
}
com.LugandaHymnalNew.songs parent;
String _link;
String _filename;
int _result = 0;
com.LugandaHymnalNew.httpjob _j = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 377;BA.debugLine="If File.Exists(File.DirInternal, fileName) Then";
if (true) break;

case 1:
//if
this.state = 10;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename)) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 378;BA.debugLine="Msgbox2Async(\"Do you want to overwrite?\", \"File";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Do you want to overwrite?"),BA.ObjectToCharSequence("File exists"),"Yes","Cancel","No",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,BA.ObjectToBoolean("false"));
 //BA.debugLineNum = 379;BA.debugLine="Wait For MsgBox_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 25;
return;
case 25:
//C
this.state = 4;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 380;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 4:
//if
this.state = 9;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 //BA.debugLineNum = 381;BA.debugLine="File.Delete(File.DirInternal, fileName)";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename);
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 383;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 9:
//C
this.state = 10;
;
 if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 386;BA.debugLine="ProgressDialogShow2(\"please wait, while song is b";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("please wait, while song is beng downloaded"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 387;BA.debugLine="Dim j As HttpJob";
_j = new com.LugandaHymnalNew.httpjob();
 //BA.debugLineNum = 388;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (processBA,"",songs.getObject());
 //BA.debugLineNum = 389;BA.debugLine="j.Download(link)";
_j._download /*String*/ (_link);
 //BA.debugLineNum = 390;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_j));
this.state = 26;
return;
case 26:
//C
this.state = 11;
_j = (com.LugandaHymnalNew.httpjob) result[0];
;
 //BA.debugLineNum = 391;BA.debugLine="If j.Success Then";
if (true) break;

case 11:
//if
this.state = 24;
if (_j._success /*boolean*/ ) { 
this.state = 13;
}else {
this.state = 15;
}if (true) break;

case 13:
//C
this.state = 24;
 //BA.debugLineNum = 392;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File.D";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 393;BA.debugLine="File.Copy2(j.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_j._getinputstream /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ ().getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 394;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 395;BA.debugLine="WebView1.LoadUrl(\"file://\" & File.Combine(File.D";
parent.mostCurrent._webview1.LoadUrl("file://"+anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"src%5Cmenu.html"));
 if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 397;BA.debugLine="Select j.Response.StatusCode";
if (true) break;

case 16:
//select
this.state = 23;
switch (BA.switchObjectToInt(_j._response /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse*/ .getStatusCode(),(int) (-1),(int) (404))) {
case 0: {
this.state = 18;
if (true) break;
}
case 1: {
this.state = 20;
if (true) break;
}
default: {
this.state = 22;
if (true) break;
}
}
if (true) break;

case 18:
//C
this.state = 23;
 //BA.debugLineNum = 399;BA.debugLine="MsgboxAsync(\"Error: try\", \"Connection error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Error: try"),BA.ObjectToCharSequence("Connection error"),processBA);
 if (true) break;

case 20:
//C
this.state = 23;
 //BA.debugLineNum = 401;BA.debugLine="MsgboxAsync(\"Error: Song has not yet been adde";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Error: Song has not yet been added, but please keep on trying. or report this error"),BA.ObjectToCharSequence("Sorry for inconvinience"),processBA);
 if (true) break;

case 22:
//C
this.state = 23;
 //BA.debugLineNum = 403;BA.debugLine="MsgboxAsync(\"Error: the error is unknown\", \"Th";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Error: the error is unknown"),BA.ObjectToCharSequence("There was an error"),processBA);
 if (true) break;

case 23:
//C
this.state = 24;
;
 if (true) break;

case 24:
//C
this.state = -1;
;
 //BA.debugLineNum = 406;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 407;BA.debugLine="j.Release";
_j._release /*String*/ ();
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _jobdone(com.LugandaHymnalNew.httpjob _j) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private JI As DefaultJavascriptInterface";
mostCurrent._ji = new uk.co.martinpearman.b4a.webkit.DefaultJavascriptInterface();
 //BA.debugLineNum = 27;BA.debugLine="Private WVE As WebViewExtras";
mostCurrent._wve = new uk.co.martinpearman.b4a.webkit.WebViewExtras();
 //BA.debugLineNum = 28;BA.debugLine="Private DWV As DefaultWebChromeClient";
mostCurrent._dwv = new uk.co.martinpearman.b4a.webkit.DefaultWebChromeClient();
 //BA.debugLineNum = 29;BA.debugLine="Private DWV1 As DefaultWebViewClient";
mostCurrent._dwv1 = new uk.co.martinpearman.b4a.webkit.DefaultWebViewClient();
 //BA.debugLineNum = 30;BA.debugLine="Private s_start  As Long";
_s_start = 0L;
 //BA.debugLineNum = 31;BA.debugLine="Private err_txt As EditText";
mostCurrent._err_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private barPosition As SeekBar";
mostCurrent._barposition = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private lblPosition As Label";
mostCurrent._lblposition = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private barVolume As SeekBar";
mostCurrent._barvolume = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private Panel3 As Panel";
mostCurrent._panel3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private btnUp As Button";
mostCurrent._btnup = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private btnDown As Button";
mostCurrent._btndown = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Dim load As Boolean";
_load = false;
 //BA.debugLineNum = 40;BA.debugLine="Dim leng As Long";
_leng = 0L;
 //BA.debugLineNum = 41;BA.debugLine="Dim pos As Long";
_pos = 0L;
 //BA.debugLineNum = 42;BA.debugLine="Dim Inpos As Long";
_inpos = 0L;
 //BA.debugLineNum = 43;BA.debugLine="Dim count As Int";
_count = 0;
 //BA.debugLineNum = 44;BA.debugLine="Dim loos As Int";
_loos = 0;
 //BA.debugLineNum = 45;BA.debugLine="Private WebView1 As WebView";
mostCurrent._webview1 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim playing1 As Boolean = False";
_playing1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 47;BA.debugLine="Dim loopable As Boolean = False";
_loopable = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 48;BA.debugLine="Private Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Dim rp As RuntimePermissions";
mostCurrent._rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _looping_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 360;BA.debugLine="Sub Looping_CheckedChange(Checked As Boolean)";
 //BA.debugLineNum = 361;BA.debugLine="MP.Looping = Checked";
_mp.setLooping(_checked);
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public static String  _mp_complete() throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Sub MP_Complete";
 //BA.debugLineNum = 272;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 //BA.debugLineNum = 273;BA.debugLine="Log(count)";
anywheresoftware.b4a.keywords.Common.LogImpl("23407874",BA.NumberToString(_count),0);
 //BA.debugLineNum = 274;BA.debugLine="MP.Play";
_mp.Play();
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
public static String  _openabaana() throws Exception{
 //BA.debugLineNum = 193;BA.debugLine="Sub openAbaana";
 //BA.debugLineNum = 194;BA.debugLine="StartActivity(\"abaana\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("abaana"));
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 11;BA.debugLine="Dim SN As String";
_sn = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim SB As String";
_sb = "";
 //BA.debugLineNum = 13;BA.debugLine="Dim MP As MediaPlayer";
_mp = new anywheresoftware.b4a.objects.MediaPlayerWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Dim timer1 As Timer";
_timer1 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 15;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 16;BA.debugLine="Dim sw As Boolean = False";
_sw = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public static String  _senderror(String _songn,String _e_err) throws Exception{
 //BA.debugLineNum = 277;BA.debugLine="Sub SendError(SongN As String, E_err As String)";
 //BA.debugLineNum = 278;BA.debugLine="Log(\"kiai\")";
anywheresoftware.b4a.keywords.Common.LogImpl("23473409","kiai",0);
 //BA.debugLineNum = 279;BA.debugLine="Panel2.Visible = True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 280;BA.debugLine="Panel2.BringToFront";
mostCurrent._panel2.BringToFront();
 //BA.debugLineNum = 281;BA.debugLine="SN = SongN";
_sn = _songn;
 //BA.debugLineNum = 282;BA.debugLine="SB = E_err";
_sb = _e_err;
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
return "";
}
public static String  _sharemessage(String _smes) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _in = null;
 //BA.debugLineNum = 184;BA.debugLine="Sub ShareMessage(sMes As String)";
 //BA.debugLineNum = 185;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 186;BA.debugLine="in.Initialize(in.ACTION_SEND, \"\")";
_in.Initialize(_in.ACTION_SEND,"");
 //BA.debugLineNum = 187;BA.debugLine="in.PutExtra(\"android.intent.extra.TEXT\", sMes)";
_in.PutExtra("android.intent.extra.TEXT",(Object)(_smes));
 //BA.debugLineNum = 188;BA.debugLine="in.SetType(\"text/plain\")";
_in.SetType("text/plain");
 //BA.debugLineNum = 189;BA.debugLine="in.WrapAsIntentChooser(\"Share Via\")";
_in.WrapAsIntentChooser("Share Via");
 //BA.debugLineNum = 190;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public static String  _stop() throws Exception{
 //BA.debugLineNum = 289;BA.debugLine="Sub Stop";
 //BA.debugLineNum = 290;BA.debugLine="Try";
try { //BA.debugLineNum = 291;BA.debugLine="MP.Stop";
_mp.Stop();
 //BA.debugLineNum = 292;BA.debugLine="count = 0";
_count = (int) (0);
 //BA.debugLineNum = 293;BA.debugLine="loopable = False";
_loopable = anywheresoftware.b4a.keywords.Common.False;
 } 
       catch (Exception e6) {
			processBA.setLastException(e6); //BA.debugLineNum = 295;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("23604486",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
 //BA.debugLineNum = 297;BA.debugLine="Panel3.SetLayoutAnimated(200dip, 5dip,-160dip,100";
mostCurrent._panel3.SetLayoutAnimated(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),mostCurrent._panel3.getHeight());
 //BA.debugLineNum = 298;BA.debugLine="Panel3.SetVisibleAnimated(200, False)";
mostCurrent._panel3.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 299;BA.debugLine="End Sub";
return "";
}
public static String  _stop1() throws Exception{
String _javascript = "";
 //BA.debugLineNum = 284;BA.debugLine="Sub stop1";
 //BA.debugLineNum = 285;BA.debugLine="Dim Javascript As String";
_javascript = "";
 //BA.debugLineNum = 286;BA.debugLine="Javascript = \"stop()\"";
_javascript = "stop()";
 //BA.debugLineNum = 287;BA.debugLine="WVE.ExecuteJavascript(Javascript)";
mostCurrent._wve.ExecuteJavascript(_javascript);
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return "";
}
public static String  _swipeleft() throws Exception{
String _javascript = "";
 //BA.debugLineNum = 162;BA.debugLine="Private Sub swipeLeft";
 //BA.debugLineNum = 163;BA.debugLine="Dim Javascript As String";
_javascript = "";
 //BA.debugLineNum = 164;BA.debugLine="Javascript=\"N_next()\"";
_javascript = "N_next()";
 //BA.debugLineNum = 165;BA.debugLine="WVE.ExecuteJavascript(Javascript)";
mostCurrent._wve.ExecuteJavascript(_javascript);
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _swiperight() throws Exception{
String _javascript = "";
 //BA.debugLineNum = 157;BA.debugLine="Private Sub swipeRight";
 //BA.debugLineNum = 158;BA.debugLine="Dim Javascript As String";
_javascript = "";
 //BA.debugLineNum = 159;BA.debugLine="Javascript=\"P_prev()\"";
_javascript = "P_prev()";
 //BA.debugLineNum = 160;BA.debugLine="WVE.ExecuteJavascript(Javascript)";
mostCurrent._wve.ExecuteJavascript(_javascript);
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
 //BA.debugLineNum = 301;BA.debugLine="Sub timer1_Tick";
 //BA.debugLineNum = 302;BA.debugLine="If MP.IsPlaying Then";
if (_mp.IsPlaying()) { 
 //BA.debugLineNum = 303;BA.debugLine="barPosition.Value = pos / leng * 100";
mostCurrent._barposition.setValue((int) (_pos/(double)_leng*100));
 //BA.debugLineNum = 305;BA.debugLine="lblPosition.Text = \"Position: \" & ConvertToTimeF";
mostCurrent._lblposition.setText(BA.ObjectToCharSequence("Position: "+_converttotimeformat((int) (_pos))+" ("+_converttotimeformat((int) (_leng))+")"));
 //BA.debugLineNum = 308;BA.debugLine="pos = pos + 1000";
_pos = (long) (_pos+1000);
 //BA.debugLineNum = 309;BA.debugLine="If count >= loos And count >= 2 Then";
if (_count>=_loos && _count>=2) { 
 //BA.debugLineNum = 310;BA.debugLine="stop1";
_stop1();
 //BA.debugLineNum = 311;BA.debugLine="count = 0";
_count = (int) (0);
 //BA.debugLineNum = 312;BA.debugLine="timer1.Enabled = False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 313;BA.debugLine="pos = 0";
_pos = (long) (0);
 };
 }else {
 };
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public static boolean  _webview1_overrideurl(String _url) throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="Private Sub WebView1_OverrideUrl (Url As String) A";
 //BA.debugLineNum = 107;BA.debugLine="load = True";
_load = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 108;BA.debugLine="If Url.Contains(\"#\") Then";
if (_url.contains("#")) { 
 //BA.debugLineNum = 109;BA.debugLine="Log(\"Me am try\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22752515","Me am try",0);
 }else if(_url.contains("baana.html")) { 
 //BA.debugLineNum = 111;BA.debugLine="StartActivity(\"abaana\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("abaana"));
 //BA.debugLineNum = 112;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
 //BA.debugLineNum = 114;BA.debugLine="WebView1.LoadUrl(codes.FixUrl(\"src\",Url))";
mostCurrent._webview1.LoadUrl(mostCurrent._codes._fixurl /*String*/ (mostCurrent.activityBA,"src",_url));
 //BA.debugLineNum = 116;BA.debugLine="Log(Url)";
anywheresoftware.b4a.keywords.Common.LogImpl("22752522",_url,0);
 };
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return false;
}
public static String  _webview1_pagefinished(String _url) throws Exception{
String _js = "";
 //BA.debugLineNum = 121;BA.debugLine="Private Sub WebView1_PageFinished (Url As String)";
 //BA.debugLineNum = 122;BA.debugLine="Log(Url)";
anywheresoftware.b4a.keywords.Common.LogImpl("22818049",_url,0);
 //BA.debugLineNum = 123;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 124;BA.debugLine="btnUp_Click";
_btnup_click();
 //BA.debugLineNum = 125;BA.debugLine="load = False";
_load = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 126;BA.debugLine="Try";
try { //BA.debugLineNum = 127;BA.debugLine="If MP.IsPlaying Then";
if (_mp.IsPlaying()) { 
 //BA.debugLineNum = 128;BA.debugLine="Dim js As String";
_js = "";
 //BA.debugLineNum = 129;BA.debugLine="js = \"$('.play').css('display','none');$('.stop";
_js = "$('.play').css('display','none');$('.stop').css('display','');";
 //BA.debugLineNum = 130;BA.debugLine="WVE.ExecuteJavascript(js)";
mostCurrent._wve.ExecuteJavascript(_js);
 };
 } 
       catch (Exception e12) {
			processBA.setLastException(e12); //BA.debugLineNum = 133;BA.debugLine="Log(\"Not play\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22818060","Not play",0);
 };
 //BA.debugLineNum = 135;BA.debugLine="load = False";
_load = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
}
