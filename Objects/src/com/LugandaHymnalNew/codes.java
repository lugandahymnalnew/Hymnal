package com.LugandaHymnalNew;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class codes {
private static codes mostCurrent = new codes();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _v5 = null;
public static String _v6 = "";
public static String _v7 = "";
public static String _v0 = "";
public static String _vv1 = "";
public static String _vv2 = "";
public static String _vv3 = "";
public static anywheresoftware.b4a.objects.collections.Map _vv4 = null;
public static int _vv5 = 0;
public com.LugandaHymnalNew.main _vvvv6 = null;
public com.LugandaHymnalNew.starter _vvvv0 = null;
public com.LugandaHymnalNew.songs _vvvvv1 = null;
public com.LugandaHymnalNew.don _vvvvv2 = null;
public com.LugandaHymnalNew.customwebviewerror _vvvvv3 = null;
public com.LugandaHymnalNew.err _vvvvv4 = null;
public com.LugandaHymnalNew.abaana _vvvvv5 = null;
public com.LugandaHymnalNew.ebil _vvvvv6 = null;
public com.LugandaHymnalNew.emisi _vvvvv7 = null;
public com.LugandaHymnalNew.httputils2service _vvvvv0 = null;
public static String  _vv6(anywheresoftware.b4a.BA _ba,String _para,String _val) throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Sub AddSetting(para As String, val As String)";
 //BA.debugLineNum = 158;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True)";
_v5.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 159;BA.debugLine="Try";
try { //BA.debugLineNum = 160;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO settings VALUES (";
_v5.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_para),(Object)(_val)}));
 } 
       catch (Exception e5) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e5); //BA.debugLineNum = 162;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("01769477",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 163;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 165;BA.debugLine="m.Put(para,val)";
_vv4.Put((Object)(_para),(Object)(_val));
 //BA.debugLineNum = 166;BA.debugLine="sql.Close";
_v5.Close();
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public static String  _vv7(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Sub ConsentF";
 //BA.debugLineNum = 150;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True)";
_v5.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 151;BA.debugLine="sql.ExecNonQuery2(\"UPDATE table1 SET col1 = ?, co";
_v5.ExecNonQuery2("UPDATE table1 SET col1 = ?, col2 = ?, col3 = ? WHERE col1 = "+_v6,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_v6),(Object)(_v7),(Object)(_v7)}));
 //BA.debugLineNum = 153;BA.debugLine="Log(\"success\")";
anywheresoftware.b4a.keywords.Common.LogImpl("01703940","success",0);
 //BA.debugLineNum = 154;BA.debugLine="sql.Close";
_v5.Close();
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public static String  _vv0(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor1 = null;
int _i = 0;
 //BA.debugLineNum = 64;BA.debugLine="Sub CreateCode";
 //BA.debugLineNum = 65;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Dim Cursor1 As Cursor";
_cursor1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 67;BA.debugLine="createTables";
_vvv1(_ba);
 //BA.debugLineNum = 68;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True)";
_v5.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 75;BA.debugLine="Try";
try { //BA.debugLineNum = 76;BA.debugLine="Cursor = sql.ExecQuery(\"SELECT * FROM table1\")";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_v5.ExecQuery("SELECT * FROM table1")));
 //BA.debugLineNum = 77;BA.debugLine="Cursor1 = sql.ExecQuery(\"SELECT * FROM settings";
_cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_v5.ExecQuery("SELECT * FROM settings")));
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 79;BA.debugLine="If countError > 3 Then";
if (_vv5>3) { 
 //BA.debugLineNum = 80;BA.debugLine="ToastMessageShow(\"Please Uninstall and re inst";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please Uninstall and re install from play store"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 81;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 83;BA.debugLine="File.Delete(File.DirInternal, \"MyDb.db\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db");
 //BA.debugLineNum = 84;BA.debugLine="countError = countError + 1";
_vv5 = (int) (_vv5+1);
 //BA.debugLineNum = 85;BA.debugLine="CreateCode";
_vv0(_ba);
 //BA.debugLineNum = 86;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 88;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 89;BA.debugLine="Log(Cursor.GetString(\"col1\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("01507353",_cursor.GetString("col1"),0);
 //BA.debugLineNum = 91;BA.debugLine="UserCode = Cursor.GetString(\"col1\")";
_v6 = _cursor.GetString("col1");
 //BA.debugLineNum = 92;BA.debugLine="VerCode = Cursor.GetString(\"col2\")";
_v7 = _cursor.GetString("col2");
 //BA.debugLineNum = 93;BA.debugLine="VeridCode = Cursor.GetString(\"col3\")";
_v0 = _cursor.GetString("col3");
 //BA.debugLineNum = 94;BA.debugLine="m.Initialize";
_vv4.Initialize();
 //BA.debugLineNum = 95;BA.debugLine="For i = 0 To Cursor1.RowCount - 1";
{
final int step24 = 1;
final int limit24 = (int) (_cursor1.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit24 ;_i = _i + step24 ) {
 //BA.debugLineNum = 96;BA.debugLine="Cursor1.Position = i";
_cursor1.setPosition(_i);
 //BA.debugLineNum = 97;BA.debugLine="m.Put(Cursor1.GetString(\"col1\"),Cursor1.GetStri";
_vv4.Put((Object)(_cursor1.GetString("col1")),(Object)(_cursor1.GetString("col2")));
 //BA.debugLineNum = 98;BA.debugLine="Log(\"load 1: \"&Cursor1.GetString(\"col2\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("01507362","load 1: "+_cursor1.GetString("col2"),0);
 }
};
 //BA.debugLineNum = 100;BA.debugLine="Vers = m.Get(\"Version\")";
_vv1 = BA.ObjectToString(_vv4.Get((Object)("Version")));
 //BA.debugLineNum = 101;BA.debugLine="vol = m.Get(\"Volume\")";
_vv2 = BA.ObjectToString(_vv4.Get((Object)("Volume")));
 //BA.debugLineNum = 102;BA.debugLine="hide = m.Get(\"Hide\")";
_vv3 = BA.ObjectToString(_vv4.Get((Object)("Hide")));
 //BA.debugLineNum = 103;BA.debugLine="Log(\"Load: \"&vol)";
anywheresoftware.b4a.keywords.Common.LogImpl("01507367","Load: "+_vv2,0);
 //BA.debugLineNum = 106;BA.debugLine="sql.close";
_v5.Close();
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public static String  _vvv1(anywheresoftware.b4a.BA _ba) throws Exception{
String _code = "";
int _ver = 0;
int _i = 0;
 //BA.debugLineNum = 118;BA.debugLine="Sub createTables";
 //BA.debugLineNum = 119;BA.debugLine="If File.Exists(File.DirInternal,\"MyDb.db\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db")) { 
 //BA.debugLineNum = 120;BA.debugLine="Log(\"yes\")";
anywheresoftware.b4a.keywords.Common.LogImpl("01572866","yes",0);
 }else {
 //BA.debugLineNum = 122;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True";
_v5.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 123;BA.debugLine="Dim code As String";
_code = "";
 //BA.debugLineNum = 124;BA.debugLine="Dim Ver As Int";
_ver = 0;
 //BA.debugLineNum = 125;BA.debugLine="For i = 0 To 3";
{
final int step7 = 1;
final int limit7 = (int) (3);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 126;BA.debugLine="code = code&Rnd(0,9)";
_code = _code+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (9)));
 }
};
 //BA.debugLineNum = 128;BA.debugLine="Ver = code * 43 + 1844";
_ver = (int) ((double)(Double.parseDouble(_code))*43+1844);
 //BA.debugLineNum = 129;BA.debugLine="Try";
try { //BA.debugLineNum = 130;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS ta";
_v5.ExecNonQuery("CREATE TABLE IF NOT EXISTS table1 (col1 TEXT , col2 TEXT, col3 TEXT)");
 //BA.debugLineNum = 131;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS se";
_v5.ExecNonQuery("CREATE TABLE IF NOT EXISTS settings (col1 TEXT , col2 TEXT)");
 //BA.debugLineNum = 132;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO table1 VALUES (?";
_v5.ExecNonQuery2("INSERT INTO table1 VALUES (?, ?, Null)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_code),(Object)(_ver)}));
 //BA.debugLineNum = 133;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO settings VALUES";
_v5.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("Version"),(Object)("1.0.2")}));
 //BA.debugLineNum = 134;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO settings VALUES";
_v5.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("Volume"),(Object)(50)}));
 //BA.debugLineNum = 135;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO settings VALUES";
_v5.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("Hide"),(Object)("False")}));
 //BA.debugLineNum = 136;BA.debugLine="sql.Close";
_v5.Close();
 //BA.debugLineNum = 137;BA.debugLine="Log(\"true\")";
anywheresoftware.b4a.keywords.Common.LogImpl("01572883","true",0);
 } 
       catch (Exception e21) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e21); //BA.debugLineNum = 139;BA.debugLine="ToastMessageShow(\"sorry error in database\", Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("sorry error in database"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 140;BA.debugLine="Log(\"failed\")";
anywheresoftware.b4a.keywords.Common.LogImpl("01572886","failed",0);
 };
 };
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _vvv2(anywheresoftware.b4a.BA _ba,String _folder,String _url) throws Exception{
String _tempurl = "";
String _fil = "";
String _fil1 = "";
String _t = "";
String _t1 = "";
 //BA.debugLineNum = 24;BA.debugLine="Sub FixUrl(Folder As String, Url As String) As Str";
 //BA.debugLineNum = 26;BA.debugLine="Dim TempUrl As String";
_tempurl = "";
 //BA.debugLineNum = 27;BA.debugLine="Dim fil,fil1 As String";
_fil = "";
_fil1 = "";
 //BA.debugLineNum = 28;BA.debugLine="fil = Url.SubString(Url.IndexOf2(\"files/\",0)+6)";
_fil = _url.substring((int) (_url.indexOf("files/",(int) (0))+6));
 //BA.debugLineNum = 29;BA.debugLine="fil1 = fil";
_fil1 = _fil;
 //BA.debugLineNum = 30;BA.debugLine="Log(\"file path: \"&fil)";
anywheresoftware.b4a.keywords.Common.LogImpl("01376262","file path: "+_fil,0);
 //BA.debugLineNum = 31;BA.debugLine="If Url.Contains(\"files/\") Then";
if (_url.contains("files/")) { 
 //BA.debugLineNum = 32;BA.debugLine="fil = Folder&\"%5C\"&fil.Replace(\"/\",\"%5C\")";
_fil = _folder+"%5C"+_fil.replace("/","%5C");
 //BA.debugLineNum = 33;BA.debugLine="TempUrl = Url.Replace(fil1,fil)";
_tempurl = _url.replace(_fil1,_fil);
 //BA.debugLineNum = 34;BA.debugLine="Log(\"if: \"&TempUrl)";
anywheresoftware.b4a.keywords.Common.LogImpl("01376266","if: "+_tempurl,0);
 //BA.debugLineNum = 35;BA.debugLine="Return TempUrl";
if (true) return _tempurl;
 }else {
 //BA.debugLineNum = 37;BA.debugLine="Dim t, t1 As String";
_t = "";
_t1 = "";
 //BA.debugLineNum = 38;BA.debugLine="t = Url.SubString(Url.IndexOf2(\"lNew/\",0)+5)";
_t = _url.substring((int) (_url.indexOf("lNew/",(int) (0))+5));
 //BA.debugLineNum = 39;BA.debugLine="t1 = t";
_t1 = _t;
 //BA.debugLineNum = 40;BA.debugLine="t = \"files/\"&Folder&\"%5C\"&t.Replace(\"/\",\"%5C\")";
_t = "files/"+_folder+"%5C"+_t.replace("/","%5C");
 //BA.debugLineNum = 41;BA.debugLine="TempUrl = Url.Replace(t1,t)";
_tempurl = _url.replace(_t1,_t);
 //BA.debugLineNum = 42;BA.debugLine="Return TempUrl";
if (true) return _tempurl;
 };
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _vvv3(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
 //BA.debugLineNum = 144;BA.debugLine="Sub getAndroidVersion As String";
 //BA.debugLineNum = 145;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 146;BA.debugLine="Return p.SdkVersion";
if (true) return BA.NumberToString(_p.getSdkVersion());
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _globals(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Dim sql As SQL";
_v5 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 7;BA.debugLine="Dim UserCode As String";
_v6 = "";
 //BA.debugLineNum = 8;BA.debugLine="Dim VerCode As String";
_v7 = "";
 //BA.debugLineNum = 9;BA.debugLine="Dim VeridCode As String";
_v0 = "";
 //BA.debugLineNum = 10;BA.debugLine="Dim Vers As String";
_vv1 = "";
 //BA.debugLineNum = 11;BA.debugLine="Dim vol As String";
_vv2 = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim hide As String";
_vv3 = "";
 //BA.debugLineNum = 13;BA.debugLine="Dim m As Map";
_vv4 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 14;BA.debugLine="Dim countError As Int";
_vv5 = 0;
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _vvv4(anywheresoftware.b4a.BA _ba,String _songno,String _errmsg) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _in = null;
 //BA.debugLineNum = 46;BA.debugLine="Sub SendEmail(SongNo As String, ErrMsg As String)";
 //BA.debugLineNum = 47;BA.debugLine="Try";
try { //BA.debugLineNum = 48;BA.debugLine="If ErrMsg=\"\" Then";
if ((_errmsg).equals("")) { 
 //BA.debugLineNum = 49;BA.debugLine="ToastMessageShow(\"You can't send empty feedback";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("You can't send empty feedback"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 50;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 52;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 53;BA.debugLine="in.Initialize(\"android.intent.action.SENDTO\", \"m";
_in.Initialize("android.intent.action.SENDTO","mailto:");
 //BA.debugLineNum = 54;BA.debugLine="in.PutExtra(\"android.intent.extra.EMAIL\", Array";
_in.PutExtra("android.intent.extra.EMAIL",(Object)(new String[]{"kitarogz@gmail.com"}));
 //BA.debugLineNum = 55;BA.debugLine="in.PutExtra(\"android.intent.extra.SUBJECT\", \"New";
_in.PutExtra("android.intent.extra.SUBJECT",(Object)("New Luganda Hymnal: "+_songno));
 //BA.debugLineNum = 56;BA.debugLine="in.PutExtra(\"android.intent.extra.TEXT\", \"You ca";
_in.PutExtra("android.intent.extra.TEXT",(Object)("You can Edit your Error: "+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+_errmsg));
 //BA.debugLineNum = 57;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity((_ba.processBA == null ? _ba : _ba.processBA),(Object)(_in.getObject()));
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 59;BA.debugLine="ToastMessageShow(\"No mail apps\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No mail apps"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 60;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _update_setting(anywheresoftware.b4a.BA _ba,String _para,String _val) throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Sub update_Setting(para As String, val As String)";
 //BA.debugLineNum = 170;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True)";
_v5.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 171;BA.debugLine="Try";
try { //BA.debugLineNum = 172;BA.debugLine="Log(val)";
anywheresoftware.b4a.keywords.Common.LogImpl("01835011",_val,0);
 //BA.debugLineNum = 173;BA.debugLine="sql.ExecNonQuery2(\"UPDATE settings SET col2 = ?";
_v5.ExecNonQuery2("UPDATE settings SET col2 = ? WHERE col1 = '"+_para+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_val)}));
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 175;BA.debugLine="Log(\"THis: \"&LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("01835014","THis: "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 };
 //BA.debugLineNum = 177;BA.debugLine="sql.close";
_v5.Close();
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
}
