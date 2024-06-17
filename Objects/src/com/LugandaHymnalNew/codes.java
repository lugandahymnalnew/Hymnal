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
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static String _usercode = "";
public static String _vercode = "";
public static String _veridcode = "";
public static String _vers = "";
public static String _vol = "";
public static String _hide = "";
public static anywheresoftware.b4a.objects.collections.Map _m = null;
public static int _counterror = 0;
public com.LugandaHymnalNew.main _main = null;
public com.LugandaHymnalNew.songs _songs = null;
public com.LugandaHymnalNew.starter _starter = null;
public com.LugandaHymnalNew.sqldb _sqldb = null;
public com.LugandaHymnalNew.err _err = null;
public com.LugandaHymnalNew.adv _adv = null;
public com.LugandaHymnalNew.don _don = null;
public com.LugandaHymnalNew.customwebviewerror _customwebviewerror = null;
public com.LugandaHymnalNew.ems _ems = null;
public com.LugandaHymnalNew.abaana _abaana = null;
public com.LugandaHymnalNew.ebil _ebil = null;
public com.LugandaHymnalNew.emisi _emisi = null;
public com.LugandaHymnalNew.httputils2service _httputils2service = null;
public static String  _adddatatodb(anywheresoftware.b4a.BA _ba,String _col,String _val,String _table,String _db) throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Sub addDataToDb(col As String, val As String, tabl";
 //BA.debugLineNum = 204;BA.debugLine="sql.Initialize(File.DirInternal, db, True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_db,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 205;BA.debugLine="Try";
try { //BA.debugLineNum = 206;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO '\"&table&\"' VALUE";
_sql.ExecNonQuery2("INSERT INTO '"+_table+"' VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_col),(Object)(_val)}));
 } 
       catch (Exception e5) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e5); //BA.debugLineNum = 208;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52949125",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 209;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 211;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public static String  _addsetting(anywheresoftware.b4a.BA _ba,String _para,String _val) throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Sub AddSetting(para As String, val As String)";
 //BA.debugLineNum = 140;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 141;BA.debugLine="Try";
try { //BA.debugLineNum = 142;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO settings VALUES (";
_sql.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_para),(Object)(_val)}));
 } 
       catch (Exception e5) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e5); //BA.debugLineNum = 144;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52621445",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 145;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 147;BA.debugLine="m.Put(para,val)";
_m.Put((Object)(_para),(Object)(_val));
 //BA.debugLineNum = 148;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static boolean  _checkvalue(anywheresoftware.b4a.BA _ba,String _col,String _db,String _table) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
 //BA.debugLineNum = 180;BA.debugLine="Sub checkValue(col As String, db As String, table";
 //BA.debugLineNum = 181;BA.debugLine="Try";
try { //BA.debugLineNum = 183;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 184;BA.debugLine="sql.Initialize(File.DirInternal, db, True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_db,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 185;BA.debugLine="cursor = sql.ExecQuery2(\"SELECT * FROM '\"&table&";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery2("SELECT * FROM '"+_table+"' WHERE chapter = ?",new String[]{_col})));
 //BA.debugLineNum = 186;BA.debugLine="cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 187;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e8) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e8); //BA.debugLineNum = 190;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
return false;
}
public static String  _consentf(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Sub ConsentF";
 //BA.debugLineNum = 121;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 122;BA.debugLine="Log(\"consented\")";
anywheresoftware.b4a.keywords.Common.LogImpl("52490370","consented",0);
 //BA.debugLineNum = 123;BA.debugLine="sql.ExecNonQuery2(\"UPDATE table1 SET col1 = ?, co";
_sql.ExecNonQuery2("UPDATE table1 SET col1 = ?, col2 = ?, col3 = ? WHERE col1 = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_usercode),(Object)(_vercode),(Object)(_vercode),(Object)(_usercode)}));
 //BA.debugLineNum = 125;BA.debugLine="Log(\"success\")";
anywheresoftware.b4a.keywords.Common.LogImpl("52490373","success",0);
 //BA.debugLineNum = 126;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _createcode(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor1 = null;
int _i = 0;
 //BA.debugLineNum = 43;BA.debugLine="Sub CreateCode";
 //BA.debugLineNum = 44;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Dim Cursor1 As Cursor";
_cursor1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 46;BA.debugLine="createTables";
_createtables(_ba);
 //BA.debugLineNum = 47;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 54;BA.debugLine="Try";
try { //BA.debugLineNum = 55;BA.debugLine="Cursor = sql.ExecQuery(\"SELECT * FROM table1\")";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM table1")));
 //BA.debugLineNum = 56;BA.debugLine="Cursor1 = sql.ExecQuery(\"SELECT * FROM settings";
_cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM settings")));
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 58;BA.debugLine="If countError > 3 Then";
if (_counterror>3) { 
 //BA.debugLineNum = 59;BA.debugLine="ToastMessageShow(\"Please Uninstall and re inst";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please Uninstall and re install from play store"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 60;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 62;BA.debugLine="File.Delete(File.DirInternal, \"MyDb.db\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db");
 //BA.debugLineNum = 63;BA.debugLine="countError = countError + 1";
_counterror = (int) (_counterror+1);
 //BA.debugLineNum = 64;BA.debugLine="CreateCode";
_createcode(_ba);
 //BA.debugLineNum = 65;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 67;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 68;BA.debugLine="Log(Cursor.GetString(\"col1\"))";
anywheresoftware.b4a.keywords.Common.LogImpl("52293785",_cursor.GetString("col1"),0);
 //BA.debugLineNum = 70;BA.debugLine="UserCode = Cursor.GetString(\"col1\")";
_usercode = _cursor.GetString("col1");
 //BA.debugLineNum = 71;BA.debugLine="VerCode = Cursor.GetString(\"col2\")";
_vercode = _cursor.GetString("col2");
 //BA.debugLineNum = 72;BA.debugLine="VeridCode = Cursor.GetString(\"col3\")";
_veridcode = _cursor.GetString("col3");
 //BA.debugLineNum = 73;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 74;BA.debugLine="For i = 0 To Cursor1.RowCount - 1";
{
final int step24 = 1;
final int limit24 = (int) (_cursor1.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit24 ;_i = _i + step24 ) {
 //BA.debugLineNum = 75;BA.debugLine="Cursor1.Position = i";
_cursor1.setPosition(_i);
 //BA.debugLineNum = 76;BA.debugLine="m.Put(Cursor1.GetString(\"col1\"),Cursor1.GetStri";
_m.Put((Object)(_cursor1.GetString("col1")),(Object)(_cursor1.GetString("col2")));
 //BA.debugLineNum = 78;BA.debugLine="Log(Cursor1.GetString(\"col1\")&\": \"&Cursor1.GetSt";
anywheresoftware.b4a.keywords.Common.LogImpl("52293795",_cursor1.GetString("col1")+": "+_cursor1.GetString("col2"),0);
 }
};
 //BA.debugLineNum = 80;BA.debugLine="Vers = m.Get(\"Version\")";
_vers = BA.ObjectToString(_m.Get((Object)("Version")));
 //BA.debugLineNum = 81;BA.debugLine="vol = m.Get(\"Volume\")";
_vol = BA.ObjectToString(_m.Get((Object)("Volume")));
 //BA.debugLineNum = 82;BA.debugLine="hide = m.Get(\"Hide\")";
_hide = BA.ObjectToString(_m.Get((Object)("Hide")));
 //BA.debugLineNum = 84;BA.debugLine="Log(\"Load: \"&vol)";
anywheresoftware.b4a.keywords.Common.LogImpl("52293801","Load: "+_vol,0);
 //BA.debugLineNum = 87;BA.debugLine="sql.close";
_sql.Close();
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _createtable(anywheresoftware.b4a.BA _ba,String _table,String _db) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Sub createTable(table As String, db As String)";
 //BA.debugLineNum = 195;BA.debugLine="Try";
try { //BA.debugLineNum = 196;BA.debugLine="sql.Initialize(File.DirInternal, db, True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_db,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 197;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS '\"&";
_sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS '"+_table+"' (chapter TEXT PRIMARY KEY , verses TEXT)");
 } 
       catch (Exception e5) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e5); //BA.debugLineNum = 199;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("52883589",anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 };
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public static String  _createtables(anywheresoftware.b4a.BA _ba) throws Exception{
String _code = "";
int _ver = 0;
int _i = 0;
 //BA.debugLineNum = 89;BA.debugLine="Sub createTables";
 //BA.debugLineNum = 90;BA.debugLine="If File.Exists(File.DirInternal,\"MyDb.db\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db")) { 
 //BA.debugLineNum = 91;BA.debugLine="Log(\"yes\")";
anywheresoftware.b4a.keywords.Common.LogImpl("52359298","yes",0);
 }else {
 //BA.debugLineNum = 93;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 94;BA.debugLine="Dim code As String";
_code = "";
 //BA.debugLineNum = 95;BA.debugLine="Dim Ver As Int";
_ver = 0;
 //BA.debugLineNum = 96;BA.debugLine="For i = 0 To 3";
{
final int step7 = 1;
final int limit7 = (int) (3);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 97;BA.debugLine="code = code&Rnd(0,9)";
_code = _code+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (9)));
 }
};
 //BA.debugLineNum = 99;BA.debugLine="Ver = code * 43 + 1844";
_ver = (int) ((double)(Double.parseDouble(_code))*43+1844);
 //BA.debugLineNum = 100;BA.debugLine="Try";
try { //BA.debugLineNum = 101;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS ta";
_sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS table1 (col1 TEXT , col2 TEXT, col3 TEXT)");
 //BA.debugLineNum = 102;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS se";
_sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS settings (col1 TEXT , col2 TEXT)");
 //BA.debugLineNum = 103;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO table1 VALUES (?";
_sql.ExecNonQuery2("INSERT INTO table1 VALUES (?, ?, Null)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_code),(Object)(_ver)}));
 //BA.debugLineNum = 104;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO settings VALUES";
_sql.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("Version"),(Object)("1.0.2")}));
 //BA.debugLineNum = 105;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO settings VALUES";
_sql.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("Volume"),(Object)(50)}));
 //BA.debugLineNum = 106;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO settings VALUES";
_sql.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("Hide"),(Object)("False")}));
 //BA.debugLineNum = 107;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 108;BA.debugLine="Log(\"true\")";
anywheresoftware.b4a.keywords.Common.LogImpl("52359315","true",0);
 } 
       catch (Exception e21) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e21); //BA.debugLineNum = 110;BA.debugLine="ToastMessageShow(\"sorry error in database\", Tru";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("sorry error in database"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 111;BA.debugLine="Log(\"failed\")";
anywheresoftware.b4a.keywords.Common.LogImpl("52359318","failed",0);
 };
 };
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public static String  _currentsong(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
 //BA.debugLineNum = 129;BA.debugLine="Sub currentSong As String";
 //BA.debugLineNum = 130;BA.debugLine="Try";
try { //BA.debugLineNum = 131;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 } 
       catch (Exception e4) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e4); //BA.debugLineNum = 134;BA.debugLine="Return LastException.Message";
if (true) return anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage();
 };
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public static String  _failure(anywheresoftware.b4a.BA _ba,String _msg) throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Sub failure(msg As String)";
 //BA.debugLineNum = 232;BA.debugLine="MsgboxAsync(msg, \"Operation failed\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence("Operation failed"),(_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public static String  _getandroidversion(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
 //BA.debugLineNum = 115;BA.debugLine="Sub getAndroidVersion As String";
 //BA.debugLineNum = 116;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 117;BA.debugLine="Return p.SdkVersion";
if (true) return BA.NumberToString(_p.getSdkVersion());
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public static Object  _getsetting(anywheresoftware.b4a.BA _ba,String _setting) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
 //BA.debugLineNum = 162;BA.debugLine="Sub GetSetting(setting As String) As Object";
 //BA.debugLineNum = 163;BA.debugLine="Try";
try { //BA.debugLineNum = 165;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 166;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 167;BA.debugLine="cursor = sql.ExecQuery2(\"SELECT * FROM settings";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery2("SELECT * FROM settings WHERE col1 = ?",new String[]{_setting})));
 //BA.debugLineNum = 168;BA.debugLine="If cursor.RowCount > -1 Then";
if (_cursor.getRowCount()>-1) { 
 //BA.debugLineNum = 169;BA.debugLine="cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 170;BA.debugLine="Return cursor.GetString(\"col2\")";
if (true) return (Object)(_cursor.GetString("col2"));
 }else {
 //BA.debugLineNum = 172;BA.debugLine="Return \"404\"";
if (true) return (Object)("404");
 };
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 175;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52752525",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 176;BA.debugLine="Return  \"0\"";
if (true) return (Object)("0");
 };
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return null;
}
public static String  _globals(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _open_web(anywheresoftware.b4a.BA _ba,String _link) throws Exception{
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
 //BA.debugLineNum = 235;BA.debugLine="Sub Open_web(Link As String)";
 //BA.debugLineNum = 236;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 237;BA.debugLine="StartActivity(p.OpenBrowser(Link))";
anywheresoftware.b4a.keywords.Common.StartActivity((_ba.processBA == null ? _ba : _ba.processBA),(Object)(_p.OpenBrowser(_link)));
 //BA.debugLineNum = 238;BA.debugLine="Log(\"true\")";
anywheresoftware.b4a.keywords.Common.LogImpl("512845059","true",0);
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Dim sql As SQL";
_sql = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 7;BA.debugLine="Dim UserCode As String";
_usercode = "";
 //BA.debugLineNum = 8;BA.debugLine="Dim VerCode As String";
_vercode = "";
 //BA.debugLineNum = 9;BA.debugLine="Dim VeridCode As String";
_veridcode = "";
 //BA.debugLineNum = 10;BA.debugLine="Dim Vers As String";
_vers = "";
 //BA.debugLineNum = 11;BA.debugLine="Dim vol As String";
_vol = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim hide As String";
_hide = "";
 //BA.debugLineNum = 13;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 14;BA.debugLine="Dim countError As Int";
_counterror = 0;
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _sendemail(anywheresoftware.b4a.BA _ba,String _songno,String _errmsg) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _in = null;
 //BA.debugLineNum = 25;BA.debugLine="Sub SendEmail(SongNo As String, ErrMsg As String)";
 //BA.debugLineNum = 26;BA.debugLine="Try";
try { //BA.debugLineNum = 27;BA.debugLine="If ErrMsg=\"\" Then";
if ((_errmsg).equals("")) { 
 //BA.debugLineNum = 28;BA.debugLine="ToastMessageShow(\"You can't send empty feedback";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("You can't send empty feedback"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 29;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 31;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 32;BA.debugLine="in.Initialize(\"android.intent.action.SENDTO\", \"m";
_in.Initialize("android.intent.action.SENDTO","mailto:");
 //BA.debugLineNum = 33;BA.debugLine="in.PutExtra(\"android.intent.extra.EMAIL\", Array";
_in.PutExtra("android.intent.extra.EMAIL",(Object)(new String[]{"kitarogz@gmail.com"}));
 //BA.debugLineNum = 34;BA.debugLine="in.PutExtra(\"android.intent.extra.SUBJECT\", \"New";
_in.PutExtra("android.intent.extra.SUBJECT",(Object)("New Luganda Hymnal: "+_songno));
 //BA.debugLineNum = 35;BA.debugLine="in.PutExtra(\"android.intent.extra.TEXT\", \"You ca";
_in.PutExtra("android.intent.extra.TEXT",(Object)("You can Edit your Error: "+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+_errmsg));
 //BA.debugLineNum = 36;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity((_ba.processBA == null ? _ba : _ba.processBA),(Object)(_in.getObject()));
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 38;BA.debugLine="ToastMessageShow(\"No mail apps\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No mail apps"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 39;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _success(anywheresoftware.b4a.BA _ba,String _msg) throws Exception{
 //BA.debugLineNum = 227;BA.debugLine="Sub success(msg As String)";
 //BA.debugLineNum = 228;BA.debugLine="MsgboxAsync(msg, \"Operation Successfull\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence("Operation Successfull"),(_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 229;BA.debugLine="End Sub";
return "";
}
public static String  _update_setting(anywheresoftware.b4a.BA _ba,String _para,String _val) throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Sub update_Setting(para As String, val As String)";
 //BA.debugLineNum = 152;BA.debugLine="sql.Initialize(File.DirInternal, \"MyDb.db\", True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyDb.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 153;BA.debugLine="Try";
try { //BA.debugLineNum = 154;BA.debugLine="Log(val)";
anywheresoftware.b4a.keywords.Common.LogImpl("52686979",_val,0);
 //BA.debugLineNum = 155;BA.debugLine="sql.ExecNonQuery2(\"UPDATE settings SET col2 = ?";
_sql.ExecNonQuery2("UPDATE settings SET col2 = ? WHERE col1 = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_val),(Object)(_para)}));
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 157;BA.debugLine="Log(\"THis: \"&LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("52686982","THis: "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 };
 //BA.debugLineNum = 159;BA.debugLine="sql.close";
_sql.Close();
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public static String  _updatenotes(anywheresoftware.b4a.BA _ba) throws Exception{
String _s = "";
 //BA.debugLineNum = 214;BA.debugLine="Sub updateNotes As String";
 //BA.debugLineNum = 215;BA.debugLine="Dim s As String";
_s = "";
 //BA.debugLineNum = 216;BA.debugLine="s = \"1. Some songs have been corrected. The ## ##";
_s = "1. Some songs have been corrected. The ## ## has been fixed"+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 217;BA.debugLine="s = s & \"2. You can join the New Luganda hymnal c";
_s = _s+"2. You can join the New Luganda hymnal community on telegram."+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 218;BA.debugLine="s = s & \"3. Have a nice worship experience.\"&CRLF";
_s = _s+"3. Have a nice worship experience."+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 219;BA.debugLine="s = s & \"4. Swipe left Or right To open Next Or p";
_s = _s+"4. Swipe left Or right To open Next Or previous song."+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 220;BA.debugLine="s = s & \"5. You can now tilt to get a wider view.";
_s = _s+"5. You can now tilt to get a wider view."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 221;BA.debugLine="s = s & \"Thank you For choosing our app.\"&CRLF";
_s = _s+"Thank you For choosing our app."+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 222;BA.debugLine="s = s & \"Tell us what you want in the Next update";
_s = _s+"Tell us what you want in the Next update using the Feedback section. You can also directly update the app from there.";
 //BA.debugLineNum = 224;BA.debugLine="Return s";
if (true) return _s;
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
}
