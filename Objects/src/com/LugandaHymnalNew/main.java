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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.LugandaHymnalNew", "com.LugandaHymnalNew.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "com.LugandaHymnalNew", "com.LugandaHymnalNew.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.LugandaHymnalNew.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
public anywheresoftware.b4a.objects.WebViewWrapper _vvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.PanelWrapper _vvvvvvvvvv0 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label8 = null;
public com.LugandaHymnalNew.codes _vvvv7 = null;
public com.LugandaHymnalNew.starter _vvvv0 = null;
public com.LugandaHymnalNew.songs _vvvvv1 = null;
public com.LugandaHymnalNew.don _vvvvv2 = null;
public com.LugandaHymnalNew.customwebviewerror _vvvvv3 = null;
public com.LugandaHymnalNew.err _vvvvv4 = null;
public com.LugandaHymnalNew.abaana _vvvvv5 = null;
public com.LugandaHymnalNew.ebil _vvvvv6 = null;
public com.LugandaHymnalNew.emisi _vvvvv7 = null;
public com.LugandaHymnalNew.httputils2service _vvvvv0 = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (songs.mostCurrent != null);
vis = vis | (don.mostCurrent != null);
vis = vis | (err.mostCurrent != null);
vis = vis | (abaana.mostCurrent != null);
vis = vis | (ebil.mostCurrent != null);
vis = vis | (emisi.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 30;BA.debugLine="codes.CreateCode";
mostCurrent._vvvv7._vv0 /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 31;BA.debugLine="If codes.VerCode = codes.VeridCode Then";
if ((mostCurrent._vvvv7._v7 /*String*/ ).equals(mostCurrent._vvvv7._v0 /*String*/ )) { 
 //BA.debugLineNum = 32;BA.debugLine="Try";
try { //BA.debugLineNum = 33;BA.debugLine="If codes.m.ContainsKey(\"copied\") Then";
if (mostCurrent._vvvv7._vv4 /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)("copied"))) { 
 //BA.debugLineNum = 34;BA.debugLine="Log(\"yeah: \"&codes.m.Get(\"copied\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("0131078","yeah: "+BA.ObjectToString(mostCurrent._vvvv7._vv4 /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("copied"))),0);
 //BA.debugLineNum = 35;BA.debugLine="If codes.m.ContainsKey(\"copied\") Then";
if (mostCurrent._vvvv7._vv4 /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)("copied"))) { 
 //BA.debugLineNum = 36;BA.debugLine="If codes.m.Get(\"app\") <> LogAppVersion Then";
if ((mostCurrent._vvvv7._vv4 /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("app"))).equals((Object)(_vvvvvvvvvv5())) == false) { 
 //BA.debugLineNum = 37;BA.debugLine="moveFiles";
_vvvvvvvvvv6();
 //BA.debugLineNum = 38;BA.debugLine="codes.update_Setting(\"app\",LogAppVersion)";
mostCurrent._vvvv7._update_setting /*String*/ (mostCurrent.activityBA,"app",_vvvvvvvvvv5());
 };
 }else {
 //BA.debugLineNum = 41;BA.debugLine="codes.AddSetting(\"app\",LogAppVersion)";
mostCurrent._vvvv7._vv6 /*String*/ (mostCurrent.activityBA,"app",_vvvvvvvvvv5());
 };
 }else {
 //BA.debugLineNum = 44;BA.debugLine="moveFiles";
_vvvvvvvvvv6();
 //BA.debugLineNum = 45;BA.debugLine="codes.AddSetting(\"app\",LogAppVersion)";
mostCurrent._vvvv7._vv6 /*String*/ (mostCurrent.activityBA,"app",_vvvvvvvvvv5());
 //BA.debugLineNum = 46;BA.debugLine="codes.AddSetting(\"copied\",\"true\")";
mostCurrent._vvvv7._vv6 /*String*/ (mostCurrent.activityBA,"copied","true");
 //BA.debugLineNum = 47;BA.debugLine="Log(\"Error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("0131091","Error",0);
 };
 } 
       catch (Exception e21) {
			processBA.setLastException(e21); //BA.debugLineNum = 50;BA.debugLine="File.Delete(File.DirInternal, \"MyDb.db\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db");
 //BA.debugLineNum = 51;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 52;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 54;BA.debugLine="Try";
try { //BA.debugLineNum = 55;BA.debugLine="Activity.LoadLayout(\"menu\")";
mostCurrent._activity.LoadLayout("menu",mostCurrent.activityBA);
 //BA.debugLineNum = 56;BA.debugLine="Label8.Text = \"Version: \"&LogAppVersion&CRLF&\"B";
mostCurrent._label8.setText(BA.ObjectToCharSequence("Version: "+_vvvvvvvvvv5()+anywheresoftware.b4a.keywords.Common.CRLF+"By Rogers Kitamirike"+anywheresoftware.b4a.keywords.Common.CRLF+"+256 757 035774"));
 } 
       catch (Exception e29) {
			processBA.setLastException(e29); //BA.debugLineNum = 58;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("0131102",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 //BA.debugLineNum = 59;BA.debugLine="File.Delete(File.DirInternal, \"MyDb.db\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db");
 //BA.debugLineNum = 60;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 61;BA.debugLine="Return";
if (true) return "";
 };
 }else {
 //BA.debugLineNum = 66;BA.debugLine="Log(\"see: \"&codes.VerCode)";
anywheresoftware.b4a.keywords.Common.LogImpl("0131110","see: "+mostCurrent._vvvv7._v7 /*String*/ ,0);
 //BA.debugLineNum = 67;BA.debugLine="Log(\"see1: \"&codes.VeridCode)";
anywheresoftware.b4a.keywords.Common.LogImpl("0131111","see1: "+mostCurrent._vvvv7._v0 /*String*/ ,0);
 //BA.debugLineNum = 68;BA.debugLine="Log(codes.Vers)";
anywheresoftware.b4a.keywords.Common.LogImpl("0131112",mostCurrent._vvvv7._vv1 /*String*/ ,0);
 //BA.debugLineNum = 69;BA.debugLine="Activity.LoadLayout(\"concent\")";
mostCurrent._activity.LoadLayout("concent",mostCurrent.activityBA);
 //BA.debugLineNum = 70;BA.debugLine="WV.Initialize(\"WV\")";
mostCurrent._vvvvvvvvvv7.Initialize(mostCurrent.activityBA,"WV");
 //BA.debugLineNum = 71;BA.debugLine="ScrollView1.Initialize(\"ScrollView1\")";
mostCurrent._vvvvvvvvvv0.Initialize(mostCurrent.activityBA,"ScrollView1");
 //BA.debugLineNum = 72;BA.debugLine="Activity.AddView(ScrollView1,10dip, 10dip, 100%x";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._vvvvvvvvvv0.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110))));
 //BA.debugLineNum = 73;BA.debugLine="ScrollView1.Color = Colors.White";
mostCurrent._vvvvvvvvvv0.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 75;BA.debugLine="ScrollView1.AddView(WV,5,5,ScrollView1.Width-10,";
mostCurrent._vvvvvvvvvv0.AddView((android.view.View)(mostCurrent._vvvvvvvvvv7.getObject()),(int) (5),(int) (5),(int) (mostCurrent._vvvvvvvvvv0.getWidth()-10),(int) (mostCurrent._vvvvvvvvvv0.getHeight()-10));
 //BA.debugLineNum = 76;BA.debugLine="WV.LoadUrl(\"file:///android_asset/src%5Cpages%5C";
mostCurrent._vvvvvvvvvv7.LoadUrl("file:///android_asset/src%5Cpages%5Cagree.html");
 //BA.debugLineNum = 77;BA.debugLine="ProgressDialogShow2(\"Welcome\", False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("Welcome"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 78;BA.debugLine="WV.ZoomEnabled = False";
mostCurrent._vvvvvvvvvv7.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 79;BA.debugLine="WV.JavaScriptEnabled = True";
mostCurrent._vvvvvvvvvv7.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _allow_click() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Private Sub allow_Click";
 //BA.debugLineNum = 130;BA.debugLine="codes.ConsentF";
mostCurrent._vvvv7._vv7 /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 131;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _baana_but_click() throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Private Sub baana_but_Click";
 //BA.debugLineNum = 108;BA.debugLine="StartActivity(abaana)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvv5.getObject()));
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static String  _deny_click() throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Private Sub deny_Click";
 //BA.debugLineNum = 135;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public static String  _don_but_click() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Private Sub don_but_Click";
 //BA.debugLineNum = 120;BA.debugLine="StartActivity(don)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvv2.getObject()));
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public static void  _vvvvvvvvvvv1(String _link,String _filename) throws Exception{
ResumableSub_DownloadAndSaveFile rsub = new ResumableSub_DownloadAndSaveFile(null,_link,_filename);
rsub.resume(processBA, null);
}
public static class ResumableSub_DownloadAndSaveFile extends BA.ResumableSub {
public ResumableSub_DownloadAndSaveFile(com.LugandaHymnalNew.main parent,String _link,String _filename) {
this.parent = parent;
this._link = _link;
this._filename = _filename;
}
com.LugandaHymnalNew.main parent;
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
 //BA.debugLineNum = 174;BA.debugLine="If File.Exists(File.DirInternal, fileName) Then";
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
 //BA.debugLineNum = 175;BA.debugLine="Msgbox2Async(\"Do you want to overwrite?\", \"File";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Do you want to overwrite?"),BA.ObjectToCharSequence("File exists"),"Yes","Cancel","No",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,BA.ObjectToBoolean("false"));
 //BA.debugLineNum = 176;BA.debugLine="Wait For MsgBox_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 25;
return;
case 25:
//C
this.state = 4;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 177;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
 //BA.debugLineNum = 178;BA.debugLine="File.Delete(File.DirInternal, fileName)";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename);
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 180;BA.debugLine="Return";
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
 //BA.debugLineNum = 183;BA.debugLine="ProgressDialogShow2(\"please wait, while song is b";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("please wait, while song is beng downloaded"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 184;BA.debugLine="Dim j As HttpJob";
_j = new com.LugandaHymnalNew.httpjob();
 //BA.debugLineNum = 185;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (processBA,"",main.getObject());
 //BA.debugLineNum = 186;BA.debugLine="j.Download(link)";
_j._vvvvvv4 /*String*/ (_link);
 //BA.debugLineNum = 187;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_j));
this.state = 26;
return;
case 26:
//C
this.state = 11;
_j = (com.LugandaHymnalNew.httpjob) result[0];
;
 //BA.debugLineNum = 188;BA.debugLine="If j.Success Then";
if (true) break;

case 11:
//if
this.state = 24;
if (_j._vvvvvvvvv2 /*boolean*/ ) { 
this.state = 13;
}else {
this.state = 15;
}if (true) break;

case 13:
//C
this.state = 24;
 //BA.debugLineNum = 189;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File.D";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 190;BA.debugLine="File.Copy2(j.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_j._vvvvvvv2 /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ ().getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 191;BA.debugLine="out.Close";
_out.Close();
 if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 193;BA.debugLine="Select j.Response.StatusCode";
if (true) break;

case 16:
//select
this.state = 23;
switch (BA.switchObjectToInt(_j._vvvvvvvvvv1 /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse*/ .getStatusCode(),(int) (-1),(int) (404))) {
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
 //BA.debugLineNum = 195;BA.debugLine="MsgboxAsync(\"Error: try\", \"Connection error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Error: try"),BA.ObjectToCharSequence("Connection error"),processBA);
 if (true) break;

case 20:
//C
this.state = 23;
 //BA.debugLineNum = 197;BA.debugLine="MsgboxAsync(\"Error: Song has not yet been adde";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Error: Song has not yet been added, but please keep on trying. or report this error"),BA.ObjectToCharSequence("Sorry for inconvinience"),processBA);
 if (true) break;

case 22:
//C
this.state = 23;
 //BA.debugLineNum = 199;BA.debugLine="MsgboxAsync(\"Error: the error is unknown\", \"Th";
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
 //BA.debugLineNum = 202;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 203;BA.debugLine="j.Release";
_j._vvvvvvvv0 /*String*/ ();
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static void  _jobdone(com.LugandaHymnalNew.httpjob _j) throws Exception{
}
public static String  _ebil_but_click() throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Private Sub ebil_but_Click";
 //BA.debugLineNum = 116;BA.debugLine="StartActivity(ebil)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvv6.getObject()));
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public static String  _emisi_but_click() throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Private Sub Emisi_but_Click";
 //BA.debugLineNum = 112;BA.debugLine="StartActivity(emisi)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvv7.getObject()));
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static String  _endag_but_click() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Private Sub Endag_but_Click";
 //BA.debugLineNum = 99;BA.debugLine="ToastMessageShow(\"Please, Wait for the next updat";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please, Wait for the next update"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 100;BA.debugLine="Open_web(\"https://ictgoldenstar.blogspot.com/2022";
_open_web("https://ictgoldenstar.blogspot.com/2022/08/ennyimba-za-kristo-2-privacy-policy.html");
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _err_but_click() throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Private Sub err_but_Click";
 //BA.debugLineNum = 124;BA.debugLine="StartActivity(err)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvv4.getObject()));
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private WV As WebView";
mostCurrent._vvvvvvvvvv7 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private ScrollView1 As Panel";
mostCurrent._vvvvvvvvvv0 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private Label8 As Label";
mostCurrent._label8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvv5() throws Exception{
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
String _info = "";
 //BA.debugLineNum = 138;BA.debugLine="Sub LogAppVersion As String";
 //BA.debugLineNum = 139;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
 //BA.debugLineNum = 140;BA.debugLine="Dim info As String";
_info = "";
 //BA.debugLineNum = 141;BA.debugLine="info = pm.GetVersionName(\"com.LugandaHymnalNew\")";
_info = _pm.GetVersionName("com.LugandaHymnalNew");
 //BA.debugLineNum = 142;BA.debugLine="Return info";
if (true) return _info;
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _menu_but_click() throws Exception{
 //BA.debugLineNum = 94;BA.debugLine="Private Sub menu_but_Click";
 //BA.debugLineNum = 95;BA.debugLine="StartActivity(songs)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvv1.getObject()));
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public static void  _vvvvvvvvvv6() throws Exception{
ResumableSub_moveFiles rsub = new ResumableSub_moveFiles(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_moveFiles extends BA.ResumableSub {
public ResumableSub_moveFiles(com.LugandaHymnalNew.main parent) {
this.parent = parent;
}
com.LugandaHymnalNew.main parent;
anywheresoftware.b4a.objects.collections.List _kit = null;
String _ki = "";
boolean _success = false;
anywheresoftware.b4a.BA.IterableList group3;
int index3;
int groupLen3;

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
 //BA.debugLineNum = 146;BA.debugLine="Dim kit As List = File.ListFiles(File.DirAssets)";
_kit = new anywheresoftware.b4a.objects.collections.List();
_kit = anywheresoftware.b4a.keywords.Common.File.ListFiles(anywheresoftware.b4a.keywords.Common.File.getDirAssets());
 //BA.debugLineNum = 147;BA.debugLine="ProgressDialogShow2(\"files initialising, please w";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("files initialising, please wait"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 148;BA.debugLine="For Each ki As String In kit";
if (true) break;

case 1:
//for
this.state = 22;
group3 = _kit;
index3 = 0;
groupLen3 = group3.getSize();
this.state = 23;
if (true) break;

case 23:
//C
this.state = 22;
if (index3 < groupLen3) {
this.state = 3;
_ki = BA.ObjectToString(group3.Get(index3));}
if (true) break;

case 24:
//C
this.state = 23;
index3++;
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 149;BA.debugLine="Log(ki)";
anywheresoftware.b4a.keywords.Common.LogImpl("01114116",_ki,0);
 //BA.debugLineNum = 150;BA.debugLine="Select Case ki";
if (true) break;

case 4:
//select
this.state = 21;
switch (BA.switchObjectToInt(_ki,"webkit","webapk_dex_version.txt","webapk8.dex","stored-locales","resources.pak","src\\pages\\1 - Copy (244) - Copy.html","song.bal","layout.bal","menu.bal","images","icudtl.dat","app logo.png","b4x_fontawesome.otf","b4x_materialicons.ttf","chrome_100_percent.pak")) {
case 0: 
case 1: 
case 2: 
case 3: 
case 4: 
case 5: 
case 6: 
case 7: 
case 8: 
case 9: 
case 10: 
case 11: 
case 12: 
case 13: 
case 14: {
this.state = 6;
if (true) break;
}
default: {
this.state = 8;
if (true) break;
}
}
if (true) break;

case 6:
//C
this.state = 21;
 //BA.debugLineNum = 154;BA.debugLine="Log(\"Skipped\")";
anywheresoftware.b4a.keywords.Common.LogImpl("01114121","Skipped",0);
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 156;BA.debugLine="If File.Exists(File.DirInternal, ki) Then";
if (true) break;

case 9:
//if
this.state = 20;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_ki)) { 
this.state = 11;
}else {
this.state = 19;
}if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 157;BA.debugLine="Try";
if (true) break;

case 12:
//try
this.state = 17;
this.catchState = 16;
this.state = 14;
if (true) break;

case 14:
//C
this.state = 17;
this.catchState = 16;
 //BA.debugLineNum = 158;BA.debugLine="File.Delete(File.DirInternal, ki)";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_ki);
 //BA.debugLineNum = 159;BA.debugLine="Wait For (File.CopyAsync(File.DirAssets, ki,";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, anywheresoftware.b4a.keywords.Common.File.CopyAsync(processBA,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_ki,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_ki));
this.state = 25;
return;
case 25:
//C
this.state = 17;
_success = (Boolean) result[0];
;
 //BA.debugLineNum = 160;BA.debugLine="Log(\"Success: \" & Success)";
anywheresoftware.b4a.keywords.Common.LogImpl("01114127","Success: "+BA.ObjectToString(_success),0);
 if (true) break;

case 16:
//C
this.state = 17;
this.catchState = 0;
 //BA.debugLineNum = 162;BA.debugLine="ToastMessageShow(\"simple error\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("simple error"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 163;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("01114130",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 if (true) break;
if (true) break;

case 17:
//C
this.state = 20;
this.catchState = 0;
;
 if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 166;BA.debugLine="Wait For (File.CopyAsync(File.DirAssets, ki,";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, anywheresoftware.b4a.keywords.Common.File.CopyAsync(processBA,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_ki,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_ki));
this.state = 26;
return;
case 26:
//C
this.state = 20;
_success = (Boolean) result[0];
;
 //BA.debugLineNum = 167;BA.debugLine="Log(\"Success: \" & Success)";
anywheresoftware.b4a.keywords.Common.LogImpl("01114134","Success: "+BA.ObjectToString(_success),0);
 if (true) break;

case 20:
//C
this.state = 21;
;
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;
if (true) break;

case 22:
//C
this.state = -1;
;
 //BA.debugLineNum = 171;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
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
public static void  _complete(boolean _success) throws Exception{
}
public static String  _open_web(String _link) throws Exception{
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
 //BA.debugLineNum = 102;BA.debugLine="Sub Open_web(Link As String)";
 //BA.debugLineNum = 103;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 104;BA.debugLine="StartActivity(p.OpenBrowser(Link))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.OpenBrowser(_link)));
 //BA.debugLineNum = 105;BA.debugLine="Log(\"true\")";
anywheresoftware.b4a.keywords.Common.LogImpl("0524291","true",0);
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
codes._process_globals();
starter._process_globals();
songs._process_globals();
don._process_globals();
customwebviewerror._process_globals();
err._process_globals();
abaana._process_globals();
ebil._process_globals();
emisi._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}

private static byte[][] bb;

public static String vvv13(final byte[] _b, final int i) throws Exception {
Runnable r = new Runnable() {
{

int value = i / 9 + 304522;
if (bb == null) {
		
                bb = new byte[4][];
				bb[0] = BA.packageName.getBytes("UTF8");
                bb[1] = BA.applicationContext.getPackageManager().getPackageInfo(BA.packageName, 0).versionName.getBytes("UTF8");
                if (bb[1].length == 0)
                    bb[1] = "jsdkfh".getBytes("UTF8");
                bb[2] = new byte[] { (byte)BA.applicationContext.getPackageManager().getPackageInfo(BA.packageName, 0).versionCode };			
        }
        bb[3] = new byte[] {
                    (byte) (value >>> 24),
						(byte) (value >>> 16),
						(byte) (value >>> 8),
						(byte) value};
				try {
					for (int __b = 0;__b < (3 + 1);__b ++) {
						for (int b = 0;b<_b.length;b++) {
							_b[b] ^= bb[__b][b % bb[__b].length];
						}
					}

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
                

            
}
public void run() {
}
};
return new String(_b, "UTF8");
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _wv_pagefinished(String _url) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub WV_PageFinished (Url As String)";
 //BA.debugLineNum = 83;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
}
