package com.LugandaHymnalNew;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class sqldb {
private static sqldb mostCurrent = new sqldb();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _db = null;
public static anywheresoftware.b4a.objects.collections.Map _menu = null;
public static anywheresoftware.b4a.objects.collections.List _son = null;
public static anywheresoftware.b4a.objects.collections.Map _menuloaded = null;
public static anywheresoftware.b4a.objects.collections.JSONParser _jsonparser = null;
public com.LugandaHymnalNew.main _main = null;
public com.LugandaHymnalNew.songs _songs = null;
public com.LugandaHymnalNew.codes _codes = null;
public com.LugandaHymnalNew.starter _starter = null;
public com.LugandaHymnalNew.err _err = null;
public com.LugandaHymnalNew.adv _adv = null;
public com.LugandaHymnalNew.don _don = null;
public com.LugandaHymnalNew.customwebviewerror _customwebviewerror = null;
public com.LugandaHymnalNew.ems _ems = null;
public com.LugandaHymnalNew.abaana _abaana = null;
public com.LugandaHymnalNew.ebil _ebil = null;
public com.LugandaHymnalNew.emisi _emisi = null;
public com.LugandaHymnalNew.httputils2service _httputils2service = null;
public static String  _checkdb(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Public Sub checkDB()";
 //BA.debugLineNum = 14;BA.debugLine="If File.Exists(File.DirInternal,\"songs.db\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"songs.db")) { 
 //BA.debugLineNum = 15;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 17;BA.debugLine="File.Copy(File.DirAssets, \"songs.db\", File.DirIn";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"songs.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"songs.db");
 //BA.debugLineNum = 18;BA.debugLine="checkDB";
_checkdb(_ba);
 };
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _createtable(anywheresoftware.b4a.BA _ba,String _dbn,String _tn,String _schema) throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Public Sub createTable(dbN As String, tN As String";
 //BA.debugLineNum = 141;BA.debugLine="Try";
try { //BA.debugLineNum = 142;BA.debugLine="db.Initialize(File.DirInternal, dbN, False)";
_db.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_dbn,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 143;BA.debugLine="db.ExecNonQuery(\"CREATE TABLE \"&tN&\"(\"&schema&\")";
_db.ExecNonQuery("CREATE TABLE "+_tn+"("+_schema+")");
 //BA.debugLineNum = 144;BA.debugLine="MsgboxAsync(\"Table \"&tN&\" was created successful";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Table "+_tn+" was created successfully in db "+_dbn),BA.ObjectToCharSequence("Success"),(_ba.processBA == null ? _ba : _ba.processBA));
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 146;BA.debugLine="MsgboxAsync(LastException.Message ,\"Sorry, there";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage()),BA.ObjectToCharSequence("Sorry, there was an error."),(_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 147;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("54063239",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _cursortolistluganda(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor) throws Exception{
anywheresoftware.b4a.objects.collections.List _resultlist = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _rowmap = null;
 //BA.debugLineNum = 23;BA.debugLine="Sub CursorToListLuganda(cursor As Cursor) As List";
 //BA.debugLineNum = 24;BA.debugLine="Dim resultList As List";
_resultlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 25;BA.debugLine="resultList.Initialize";
_resultlist.Initialize();
 //BA.debugLineNum = 28;BA.debugLine="If cursor <> Null Then";
if (_cursor!= null) { 
 //BA.debugLineNum = 30;BA.debugLine="For i = 0 To cursor.RowCount - 1";
{
final int step4 = 1;
final int limit4 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 32;BA.debugLine="cursor.Position = i";
_cursor.setPosition(_i);
 //BA.debugLineNum = 35;BA.debugLine="Dim rowMap As Map";
_rowmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 36;BA.debugLine="rowMap.Initialize";
_rowmap.Initialize();
 //BA.debugLineNum = 41;BA.debugLine="rowMap.Put(\"number\", cursor.GetString(\"number\")";
_rowmap.Put((Object)("number"),(Object)(_cursor.GetString("number")));
 //BA.debugLineNum = 42;BA.debugLine="rowMap.Put(\"An\", cursor.GetString(\"An\"))";
_rowmap.Put((Object)("An"),(Object)(_cursor.GetString("An")));
 //BA.debugLineNum = 43;BA.debugLine="rowMap.Put(\"EngNo\", cursor.GetString(\"EngNo\"))";
_rowmap.Put((Object)("EngNo"),(Object)(_cursor.GetString("EngNo")));
 //BA.debugLineNum = 44;BA.debugLine="rowMap.Put(\"EngTit\", cursor.GetString(\"EngTit\")";
_rowmap.Put((Object)("EngTit"),(Object)(_cursor.GetString("EngTit")));
 //BA.debugLineNum = 45;BA.debugLine="rowMap.Put(\"composer\", cursor.GetString(\"compos";
_rowmap.Put((Object)("composer"),(Object)(_cursor.GetString("composer")));
 //BA.debugLineNum = 46;BA.debugLine="rowMap.Put(\"doh\", cursor.GetString(\"doh\"))";
_rowmap.Put((Object)("doh"),(Object)(_cursor.GetString("doh")));
 //BA.debugLineNum = 47;BA.debugLine="rowMap.Put(\"signDown\", cursor.GetString(\"signDo";
_rowmap.Put((Object)("signDown"),(Object)(_cursor.GetString("signDown")));
 //BA.debugLineNum = 48;BA.debugLine="rowMap.Put(\"signUp\", cursor.GetString(\"signUp\")";
_rowmap.Put((Object)("signUp"),(Object)(_cursor.GetString("signUp")));
 //BA.debugLineNum = 49;BA.debugLine="rowMap.Put(\"song\", cursor.GetString(\"song\"))";
_rowmap.Put((Object)("song"),(Object)(_cursor.GetString("song")));
 //BA.debugLineNum = 52;BA.debugLine="resultList.Add(rowMap)";
_resultlist.Add((Object)(_rowmap.getObject()));
 }
};
 };
 //BA.debugLineNum = 57;BA.debugLine="cursor.Close";
_cursor.Close();
 //BA.debugLineNum = 60;BA.debugLine="Return resultList";
if (true) return _resultlist;
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getmenu(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
 //BA.debugLineNum = 64;BA.debugLine="Public Sub getMenu() As List";
 //BA.debugLineNum = 65;BA.debugLine="Try";
try { //BA.debugLineNum = 66;BA.debugLine="db.Initialize(File.DirInternal,\"songs.db\", False";
_db.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"songs.db",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 67;BA.debugLine="Dim cursor As Cursor =  db.ExecQuery(\"SELECT num";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_db.ExecQuery("SELECT number, An, EngNo, EngTit, composer, doh, signDown, signUp, song FROM luganda")));
 //BA.debugLineNum = 68;BA.debugLine="Return CursorToListLuganda(cursor)";
if (true) return _cursortolistluganda(_ba,_cursor);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 70;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("53801094",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.Map  _getsongwithnumber(anywheresoftware.b4a.BA _ba,String _num) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
anywheresoftware.b4a.objects.collections.Map _ms = null;
anywheresoftware.b4a.objects.collections.Map _error = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 74;BA.debugLine="Public Sub getSongWithNumber(num As String) As Map";
 //BA.debugLineNum = 75;BA.debugLine="Try";
try { //BA.debugLineNum = 77;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Dim ms As Map";
_ms = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 79;BA.debugLine="Dim error As Map";
_error = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 80;BA.debugLine="error.Initialize";
_error.Initialize();
 //BA.debugLineNum = 81;BA.debugLine="error.Put(\"err\",\"Not found\")";
_error.Put((Object)("err"),(Object)("Not found"));
 //BA.debugLineNum = 82;BA.debugLine="ms.Initialize";
_ms.Initialize();
 //BA.debugLineNum = 83;BA.debugLine="db.Initialize(File.DirInternal,\"songs.db\", False";
_db.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"songs.db",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 84;BA.debugLine="cursor = db.ExecQuery2(\"SELECT * FROM luganda WH";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_db.ExecQuery2("SELECT * FROM luganda WHERE number = ?",new String[]{_num})));
 //BA.debugLineNum = 85;BA.debugLine="If cursor.RowCount < 1 Then";
if (_cursor.getRowCount()<1) { 
 //BA.debugLineNum = 86;BA.debugLine="ms.Put(\"No\",\"<b>#</b><br>#\")";
_ms.Put((Object)("No"),(Object)("<b>#</b><br>#"));
 //BA.debugLineNum = 87;BA.debugLine="ms.Put(\"Title\",\"<b>#</b><br>#\")";
_ms.Put((Object)("Title"),(Object)("<b>#</b><br>#"));
 //BA.debugLineNum = 88;BA.debugLine="ms.Put(\"An\",\"#\")";
_ms.Put((Object)("An"),(Object)("#"));
 //BA.debugLineNum = 89;BA.debugLine="ms.Put(\"Sign\",\"#\")";
_ms.Put((Object)("Sign"),(Object)("#"));
 //BA.debugLineNum = 90;BA.debugLine="ms.Put(\"Comp\",\"#\")";
_ms.Put((Object)("Comp"),(Object)("#"));
 //BA.debugLineNum = 91;BA.debugLine="ms.Put(\"Lyrics\",error)";
_ms.Put((Object)("Lyrics"),(Object)(_error.getObject()));
 //BA.debugLineNum = 92;BA.debugLine="Return ms";
if (true) return _ms;
 }else {
 //BA.debugLineNum = 95;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 97;BA.debugLine="cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 98;BA.debugLine="jsonParser.Initialize(cursor.GetString(\"lyrics\"";
_jsonparser.Initialize(_cursor.GetString("lyrics"));
 //BA.debugLineNum = 99;BA.debugLine="m = jsonParser.NextObject";
_m = _jsonparser.NextObject();
 //BA.debugLineNum = 100;BA.debugLine="ms.Put(\"No\",\"<b>\"&cursor.GetString(\"number\")&\"<";
_ms.Put((Object)("No"),(Object)("<b>"+_cursor.GetString("number")+"</b><br>"+_cursor.GetString("EngNo")));
 //BA.debugLineNum = 101;BA.debugLine="ms.Put(\"Title\",\"<b>\"&cursor.GetString(\"song\")&\"";
_ms.Put((Object)("Title"),(Object)("<b>"+_cursor.GetString("song")+"</b><br>"+_cursor.GetString("EngTit")));
 //BA.debugLineNum = 102;BA.debugLine="ms.Put(\"An\",cursor.GetString(\"An\"))";
_ms.Put((Object)("An"),(Object)(_cursor.GetString("An")));
 //BA.debugLineNum = 103;BA.debugLine="ms.Put(\"Sign\",cursor.GetString(\"signUp\")&\"<br>\"";
_ms.Put((Object)("Sign"),(Object)(_cursor.GetString("signUp")+"<br>"+_cursor.GetString("signDown")));
 //BA.debugLineNum = 104;BA.debugLine="ms.Put(\"Comp\",cursor.GetString(\"composer\")&\"<br";
_ms.Put((Object)("Comp"),(Object)(_cursor.GetString("composer")+"<br><b>"+_cursor.GetString("doh")+"</b>"));
 //BA.debugLineNum = 105;BA.debugLine="ms.Put(\"Lyrics\",m)";
_ms.Put((Object)("Lyrics"),(Object)(_m.getObject()));
 //BA.debugLineNum = 106;BA.debugLine="Return ms";
if (true) return _ms;
 };
 } 
       catch (Exception e32) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e32); //BA.debugLineNum = 109;BA.debugLine="ms.Put(\"No\",\"<b>#</b><br>#\")";
_ms.Put((Object)("No"),(Object)("<b>#</b><br>#"));
 //BA.debugLineNum = 110;BA.debugLine="ms.Put(\"Title\",\"<b>#</b><br>#\")";
_ms.Put((Object)("Title"),(Object)("<b>#</b><br>#"));
 //BA.debugLineNum = 111;BA.debugLine="ms.Put(\"An\",\"#\")";
_ms.Put((Object)("An"),(Object)("#"));
 //BA.debugLineNum = 112;BA.debugLine="ms.Put(\"Sign\",\"#\")";
_ms.Put((Object)("Sign"),(Object)("#"));
 //BA.debugLineNum = 113;BA.debugLine="ms.Put(\"Comp\",\"#\")";
_ms.Put((Object)("Comp"),(Object)("#"));
 //BA.debugLineNum = 114;BA.debugLine="ms.Put(\"Lyrics\",error)";
_ms.Put((Object)("Lyrics"),(Object)(_error.getObject()));
 //BA.debugLineNum = 115;BA.debugLine="Return ms";
if (true) return _ms;
 };
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return null;
}
public static String  _multicolumnupdate(anywheresoftware.b4a.BA _ba,String _dbn,String _tn,String _setphrase,String _selectcol,String _selectvalue) throws Exception{
 //BA.debugLineNum = 130;BA.debugLine="Public Sub multiColumnUpdate(dbN As String, tN As";
 //BA.debugLineNum = 131;BA.debugLine="Try";
try { //BA.debugLineNum = 132;BA.debugLine="db.Initialize(File.DirInternal, dbN, False)";
_db.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_dbn,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 133;BA.debugLine="db.ExecNonQuery2(\"UPDATE \"&tN&\" SET \"&setPhrase&";
_db.ExecNonQuery2("UPDATE "+_tn+" SET "+_setphrase+" WHERE "+_selectcol+" = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_selectvalue)}));
 } 
       catch (Exception e5) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e5); //BA.debugLineNum = 135;BA.debugLine="MsgboxAsync(LastException.Message ,\"Sorry, there";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage()),BA.ObjectToCharSequence("Sorry, there was an error."),(_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 136;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("53997702",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public db As SQL";
_db = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 7;BA.debugLine="Public menu As Map";
_menu = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 8;BA.debugLine="Public son As List";
_son = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 9;BA.debugLine="Public menuLoaded As Map";
_menuloaded = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 10;BA.debugLine="Public jsonParser As JSONParser";
_jsonparser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _readbook(anywheresoftware.b4a.BA _ba,String _tn,String _dbn,String _selectcol,String _selectvalue) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
anywheresoftware.b4a.objects.collections.List _l = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i = 0;
int _j = 0;
 //BA.debugLineNum = 151;BA.debugLine="Public Sub readBook(tN As String, dbN As String ,";
 //BA.debugLineNum = 152;BA.debugLine="Try";
try { //BA.debugLineNum = 153;BA.debugLine="db.Initialize(File.DirInternal, dbN, False)";
_db.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_dbn,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 154;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 155;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 156;BA.debugLine="l.Initialize";
_l.Initialize();
 //BA.debugLineNum = 157;BA.debugLine="cursor = db.ExecQuery2(\"SELECT * FROM \"&tN&\" WHE";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_db.ExecQuery2("SELECT * FROM "+_tn+" WHERE "+_selectcol+" = ?",new String[]{_selectvalue})));
 //BA.debugLineNum = 158;BA.debugLine="If cursor.RowCount < 1 Then";
if (_cursor.getRowCount()<1) { 
 //BA.debugLineNum = 159;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 160;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 161;BA.debugLine="m.Put(\"chapter\", \"#####\")";
_m.Put((Object)("chapter"),(Object)("#####"));
 //BA.debugLineNum = 162;BA.debugLine="m.Put(\"verses\",\"###\")";
_m.Put((Object)("verses"),(Object)("###"));
 //BA.debugLineNum = 163;BA.debugLine="l.Add(m)";
_l.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 164;BA.debugLine="Return l";
if (true) return _l;
 }else {
 //BA.debugLineNum = 166;BA.debugLine="For i = 0 To cursor.RowCount - 1";
{
final int step15 = 1;
final int limit15 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
 //BA.debugLineNum = 167;BA.debugLine="cursor.Position = i";
_cursor.setPosition(_i);
 //BA.debugLineNum = 168;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 169;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 170;BA.debugLine="For j = 0 To cursor.ColumnCount -1";
{
final int step19 = 1;
final int limit19 = (int) (_cursor.getColumnCount()-1);
_j = (int) (0) ;
for (;_j <= limit19 ;_j = _j + step19 ) {
 //BA.debugLineNum = 171;BA.debugLine="m.Put(cursor.GetColumnName(j), cursor.GetStri";
_m.Put((Object)(_cursor.GetColumnName(_j)),(Object)(_cursor.GetString2(_j)));
 }
};
 //BA.debugLineNum = 173;BA.debugLine="l.Add(m)";
_l.Add((Object)(_m.getObject()));
 }
};
 //BA.debugLineNum = 175;BA.debugLine="Return l";
if (true) return _l;
 };
 } 
       catch (Exception e27) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e27); //BA.debugLineNum = 178;BA.debugLine="MsgboxAsync(LastException.Message ,\"Sorry, there";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage()),BA.ObjectToCharSequence("Sorry, there was an error."),(_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 179;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("54128796",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 180;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 181;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 182;BA.debugLine="m.Put(\"chapter\", \"#####\")";
_m.Put((Object)("chapter"),(Object)("#####"));
 //BA.debugLineNum = 183;BA.debugLine="m.Put(\"verses\",\"###\")";
_m.Put((Object)("verses"),(Object)("###"));
 //BA.debugLineNum = 184;BA.debugLine="l.Add(m)";
_l.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 185;BA.debugLine="Return l";
if (true) return _l;
 };
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return null;
}
public static String  _singlecolumnupdate(anywheresoftware.b4a.BA _ba,String _dbn,String _tn,String _setcol,String _selectcol,String _selectvalue,String _newvalue) throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Public Sub singleColumnUpdate(dbN As String, tN As";
 //BA.debugLineNum = 121;BA.debugLine="Try";
try { //BA.debugLineNum = 122;BA.debugLine="db.Initialize(File.DirInternal, dbN, False)";
_db.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_dbn,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 123;BA.debugLine="db.ExecNonQuery2(\"UPDATE \"&tN&\" SET \"&setCol&\" =";
_db.ExecNonQuery2("UPDATE "+_tn+" SET "+_setcol+" = ? WHERE "+_selectcol+" = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_newvalue),(Object)(_selectvalue)}));
 } 
       catch (Exception e5) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e5); //BA.debugLineNum = 125;BA.debugLine="MsgboxAsync(LastException.Message ,\"Sorry, there";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage()),BA.ObjectToCharSequence("Sorry, there was an error."),(_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 126;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("53932166",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
}
