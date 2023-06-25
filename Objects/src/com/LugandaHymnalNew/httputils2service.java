package com.LugandaHymnalNew;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class httputils2service extends android.app.Service{
	public static class httputils2service_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (httputils2service) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, httputils2service.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, BA.class);
		}

	}
    static httputils2service mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return httputils2service.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.LugandaHymnalNew", "com.LugandaHymnalNew.httputils2service");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "com.LugandaHymnalNew.httputils2service", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (httputils2service) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
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
                    BA.LogInfo("** Service (httputils2service) Create **");
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
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (httputils2service) Start **");
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
        if (false) {
            BA.LogInfo("** Service (httputils2service) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (httputils2service) Destroy **");
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
public static anywheresoftware.b4h.okhttp.OkHttpClientWrapper _vvvvvvvvvvvvvvv1 = null;
public static anywheresoftware.b4a.objects.collections.Map _vvvvvvvvvvvvvv0 = null;
public static String _vvvv5 = "";
public static int _vvvvvvvvvvvvvvv2 = 0;
public com.LugandaHymnalNew.main _vvvv6 = null;
public com.LugandaHymnalNew.codes _vvvv7 = null;
public com.LugandaHymnalNew.starter _vvvv0 = null;
public com.LugandaHymnalNew.songs _vvvvv1 = null;
public com.LugandaHymnalNew.don _vvvvv2 = null;
public com.LugandaHymnalNew.customwebviewerror _vvvvv3 = null;
public com.LugandaHymnalNew.err _vvvvv4 = null;
public com.LugandaHymnalNew.abaana _vvvvv5 = null;
public com.LugandaHymnalNew.ebil _vvvvv6 = null;
public com.LugandaHymnalNew.emisi _vvvvv7 = null;
public static String  _vvvvvvvvvvvvvv7(int _taskid,boolean _success,String _errormessage) throws Exception{
com.LugandaHymnalNew.httpjob _job = null;
 //BA.debugLineNum = 146;BA.debugLine="Sub CompleteJob(TaskId As Int, success As Boolean,";
 //BA.debugLineNum = 150;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (com.LugandaHymnalNew.httpjob)(_vvvvvvvvvvvvvv0.Get((Object)(_taskid)));
 //BA.debugLineNum = 151;BA.debugLine="If job = Null Then";
if (_job== null) { 
 //BA.debugLineNum = 152;BA.debugLine="Log(\"HttpUtils2Service: job completed multiple t";
anywheresoftware.b4a.keywords.Common.LogImpl("07798790","HttpUtils2Service: job completed multiple times - "+BA.NumberToString(_taskid),0);
 //BA.debugLineNum = 153;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 155;BA.debugLine="TaskIdToJob.Remove(TaskId)";
_vvvvvvvvvvvvvv0.Remove((Object)(_taskid));
 //BA.debugLineNum = 156;BA.debugLine="job.success = success";
_job._vvvvvvvvv2 /*boolean*/  = _success;
 //BA.debugLineNum = 157;BA.debugLine="job.errorMessage = errorMessage";
_job._vvvvvvvvv5 /*String*/  = _errormessage;
 //BA.debugLineNum = 159;BA.debugLine="job.Complete(TaskId)";
_job._complete /*String*/ (_taskid);
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responseerror(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,String _reason,int _statuscode,int _taskid) throws Exception{
com.LugandaHymnalNew.httpjob _job = null;
 //BA.debugLineNum = 109;BA.debugLine="Sub hc_ResponseError (Response As OkHttpResponse,";
 //BA.debugLineNum = 111;BA.debugLine="Log($\"ResponseError. Reason: ${Reason}, Response:";
anywheresoftware.b4a.keywords.Common.LogImpl("07733250",("ResponseError. Reason: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_reason))+", Response: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_response.getErrorResponse()))+""),0);
 //BA.debugLineNum = 113;BA.debugLine="Response.Release";
_response.Release();
 //BA.debugLineNum = 114;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (com.LugandaHymnalNew.httpjob)(_vvvvvvvvvvvvvv0.Get((Object)(_taskid)));
 //BA.debugLineNum = 115;BA.debugLine="If job = Null Then";
if (_job== null) { 
 //BA.debugLineNum = 116;BA.debugLine="Log(\"HttpUtils2Service (hc_ResponseError): job c";
anywheresoftware.b4a.keywords.Common.LogImpl("07733255","HttpUtils2Service (hc_ResponseError): job completed multiple times - "+BA.NumberToString(_taskid),0);
 //BA.debugLineNum = 117;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 119;BA.debugLine="job.Response = Response";
_job._vvvvvvvvvv1 /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse*/  = _response;
 //BA.debugLineNum = 120;BA.debugLine="If Response.ErrorResponse <> \"\" Then";
if ((_response.getErrorResponse()).equals("") == false) { 
 //BA.debugLineNum = 121;BA.debugLine="CompleteJob(TaskId, False, Response.ErrorRespons";
_vvvvvvvvvvvvvv7(_taskid,anywheresoftware.b4a.keywords.Common.False,_response.getErrorResponse());
 }else {
 //BA.debugLineNum = 123;BA.debugLine="CompleteJob(TaskId, False, Reason)";
_vvvvvvvvvvvvvv7(_taskid,anywheresoftware.b4a.keywords.Common.False,_reason);
 };
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responsesuccess(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,int _taskid) throws Exception{
com.LugandaHymnalNew.httpjob _job = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 86;BA.debugLine="Sub hc_ResponseSuccess (Response As OkHttpResponse";
 //BA.debugLineNum = 87;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (com.LugandaHymnalNew.httpjob)(_vvvvvvvvvvvvvv0.Get((Object)(_taskid)));
 //BA.debugLineNum = 88;BA.debugLine="If job = Null Then";
if (_job== null) { 
 //BA.debugLineNum = 89;BA.debugLine="Log(\"HttpUtils2Service (hc_ResponseSuccess): job";
anywheresoftware.b4a.keywords.Common.LogImpl("07602179","HttpUtils2Service (hc_ResponseSuccess): job completed multiple times - "+BA.NumberToString(_taskid),0);
 //BA.debugLineNum = 90;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 92;BA.debugLine="job.Response = Response";
_job._vvvvvvvvvv1 /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse*/  = _response;
 //BA.debugLineNum = 93;BA.debugLine="Dim out As OutputStream = File.OpenOutput(TempFol";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(_vvvv5,BA.NumberToString(_taskid),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 97;BA.debugLine="Response.GetAsynchronously(\"response\", out , _";
_response.GetAsynchronously(processBA,"response",(java.io.OutputStream)(_out.getObject()),anywheresoftware.b4a.keywords.Common.True,_taskid);
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private hc As OkHttpClient";
_vvvvvvvvvvvvvvv1 = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private TaskIdToJob As Map";
_vvvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 19;BA.debugLine="Public TempFolder As String";
_vvvv5 = "";
 //BA.debugLineNum = 23;BA.debugLine="Private taskCounter As Int";
_vvvvvvvvvvvvvvv2 = 0;
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _response_streamfinish(boolean _success,int _taskid) throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Private Sub Response_StreamFinish (Success As Bool";
 //BA.debugLineNum = 102;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 103;BA.debugLine="CompleteJob(TaskId, Success, \"\")";
_vvvvvvvvvvvvvv7(_taskid,_success,"");
 }else {
 //BA.debugLineNum = 105;BA.debugLine="CompleteJob(TaskId, Success, LastException.Messa";
_vvvvvvvvvvvvvv7(_taskid,_success,anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 29;BA.debugLine="TempFolder = File.DirInternalCache";
_vvvv5 = anywheresoftware.b4a.keywords.Common.File.getDirInternalCache();
 //BA.debugLineNum = 30;BA.debugLine="Try";
try { //BA.debugLineNum = 31;BA.debugLine="File.WriteString(TempFolder, \"~test.test\", \"test";
anywheresoftware.b4a.keywords.Common.File.WriteString(_vvvv5,"~test.test","test");
 //BA.debugLineNum = 32;BA.debugLine="File.Delete(TempFolder, \"~test.test\")";
anywheresoftware.b4a.keywords.Common.File.Delete(_vvvv5,"~test.test");
 } 
       catch (Exception e6) {
			processBA.setLastException(e6); //BA.debugLineNum = 34;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("07340039",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
 //BA.debugLineNum = 35;BA.debugLine="Log(\"Switching to File.DirInternal\")";
anywheresoftware.b4a.keywords.Common.LogImpl("07340040","Switching to File.DirInternal",0);
 //BA.debugLineNum = 36;BA.debugLine="TempFolder = File.DirInternal";
_vvvv5 = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 };
 //BA.debugLineNum = 41;BA.debugLine="If hc.IsInitialized = False Then";
if (_vvvvvvvvvvvvvvv1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 46;BA.debugLine="hc.Initialize(\"hc\")";
_vvvvvvvvvvvvvvv1.Initialize("hc");
 };
 //BA.debugLineNum = 54;BA.debugLine="TaskIdToJob.Initialize";
_vvvvvvvvvvvvvv0.Initialize();
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 59;BA.debugLine="Service.StopAutomaticForeground";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public static String  _submitjob(com.LugandaHymnalNew.httpjob _job) throws Exception{
int _taskid = 0;
 //BA.debugLineNum = 68;BA.debugLine="Public Sub SubmitJob(job As HttpJob)";
 //BA.debugLineNum = 69;BA.debugLine="If TaskIdToJob.IsInitialized = False Then Service";
if (_vvvvvvvvvvvvvv0.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_service_create();};
 //BA.debugLineNum = 73;BA.debugLine="taskCounter = taskCounter + 1";
_vvvvvvvvvvvvvvv2 = (int) (_vvvvvvvvvvvvvvv2+1);
 //BA.debugLineNum = 74;BA.debugLine="Dim TaskId As Int = taskCounter";
_taskid = _vvvvvvvvvvvvvvv2;
 //BA.debugLineNum = 76;BA.debugLine="TaskIdToJob.Put(TaskId, job)";
_vvvvvvvvvvvvvv0.Put((Object)(_taskid),(Object)(_job));
 //BA.debugLineNum = 77;BA.debugLine="If job.Username <> \"\" And job.Password <> \"\" Then";
if ((_job._vvvvvvvvv3 /*String*/ ).equals("") == false && (_job._vvvvvvvvv4 /*String*/ ).equals("") == false) { 
 //BA.debugLineNum = 78;BA.debugLine="hc.ExecuteCredentials(job.GetRequest, TaskId, jo";
_vvvvvvvvvvvvvvv1.ExecuteCredentials(processBA,_job._vvvvvvv3 /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (),_taskid,_job._vvvvvvvvv3 /*String*/ ,_job._vvvvvvvvv4 /*String*/ );
 }else {
 //BA.debugLineNum = 80;BA.debugLine="hc.Execute(job.GetRequest, TaskId)";
_vvvvvvvvvvvvvvv1.Execute(processBA,_job._vvvvvvv3 /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (),_taskid);
 };
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
}
