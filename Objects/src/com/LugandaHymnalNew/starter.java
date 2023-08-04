package com.LugandaHymnalNew;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.LugandaHymnalNew", "com.LugandaHymnalNew.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.LugandaHymnalNew.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public com.LugandaHymnalNew.main _main = null;
public com.LugandaHymnalNew.codes _codes = null;
public com.LugandaHymnalNew.songs _songs = null;
public com.LugandaHymnalNew.don _don = null;
public com.LugandaHymnalNew.customwebviewerror _customwebviewerror = null;
public com.LugandaHymnalNew.err _err = null;
public com.LugandaHymnalNew.abaana _abaana = null;
public com.LugandaHymnalNew.ebil _ebil = null;
public com.LugandaHymnalNew.emisi _emisi = null;
public com.LugandaHymnalNew.httputils2service _httputils2service = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 48;BA.debugLine="ToastMessageShow(Error.Message,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_error.getMessage()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 49;BA.debugLine="ToastMessageShow(StackTrace,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_stacktrace),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 50;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return false;
}
public static String  _mp_complete() throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub MP_Complete";
 //BA.debugLineNum = 35;BA.debugLine="songs.counter = songs.counter + 1";
mostCurrent._songs._counter /*int*/  = (int) (mostCurrent._songs._counter /*int*/ +1);
 //BA.debugLineNum = 36;BA.debugLine="songs.MP.Play";
mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .Play();
 //BA.debugLineNum = 37;BA.debugLine="Log(\"in sev: \"&songs.counter)";
anywheresoftware.b4a.keywords.Common.LogImpl("81245187","in sev: "+BA.NumberToString(mostCurrent._songs._counter /*int*/ ),0);
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _service_music(String _fname) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Service_Music(FName As String)";
 //BA.debugLineNum = 23;BA.debugLine="If songs.MP.IsInitialized = True Then";
if (mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 25;BA.debugLine="songs.MP.Initialize2(\"MP\")";
mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .Initialize2(processBA,"MP");
 //BA.debugLineNum = 26;BA.debugLine="songs.MP.Load(File.DirAssets, FName)";
mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_fname);
 //BA.debugLineNum = 27;BA.debugLine="Log(\"starter: \"&songs.MP.IsInitialized)";
anywheresoftware.b4a.keywords.Common.LogImpl("81179653","starter: "+BA.ObjectToString(mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .IsInitialized()),0);
 //BA.debugLineNum = 28;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 30;BA.debugLine="songs.MP.Initialize()";
mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .Initialize();
 //BA.debugLineNum = 31;BA.debugLine="Service_Music(FName)";
_service_music(_fname);
 //BA.debugLineNum = 32;BA.debugLine="Return";
if (true) return "";
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 19;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 41;BA.debugLine="If songs.MP.IsInitialized = True Then";
if (mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 42;BA.debugLine="If songs.MP.IsPlaying = True Then songs.MP.Stop";
if (mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .IsPlaying()==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._songs._mp /*anywheresoftware.b4a.objects.MediaPlayerWrapper*/ .Stop();};
 };
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
}
