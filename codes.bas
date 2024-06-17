B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=11.8
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim sql As SQL
	Dim UserCode As String
	Dim VerCode As String
	Dim VeridCode As String
	Dim Vers As String
	Dim vol As String
	Dim hide As String
	Dim m As Map
	Dim countError As Int
End Sub
countError = 0
Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	'Dim Seq As MidiSequence
	'Dim Seqr As MidiSequencer
End Sub


Sub SendEmail(SongNo As String, ErrMsg As String)
	Try
		If ErrMsg="" Then
			ToastMessageShow("You can't send empty feedback", True)
			Return
		End If
		Dim in As Intent
		in.Initialize("android.intent.action.SENDTO", "mailto:")
		in.PutExtra("android.intent.extra.EMAIL", Array As String("kitarogz@gmail.com"))
		in.PutExtra("android.intent.extra.SUBJECT", "New Luganda Hymnal: "&SongNo)
		in.PutExtra("android.intent.extra.TEXT", "You can Edit your Error: "&CRLF&CRLF&ErrMsg)
		StartActivity(in)
	Catch
		ToastMessageShow("No mail apps", True)
		Return
	End Try
End Sub

Sub CreateCode
	Dim Cursor As Cursor
	Dim Cursor1 As Cursor
	createTables
	sql.Initialize(File.DirInternal, "MyDb.db", True)
	'Checking if the table was already created
	'Try
	'	sql.ExecNonQuery("CREATE TABLE table1 (col1 TEXT , col2 TEXT, col3 TEXT)")
	'	sql.ExecNonQuery("CREATE TABLE settings (col1 TEXT , col2 TEXT)")
		'If the code is in the table, Loading payment page
	'Catch
		Try
			Cursor = sql.ExecQuery("SELECT * FROM table1")
			Cursor1 = sql.ExecQuery("SELECT * FROM settings")
		Catch
			If countError > 3 Then
				ToastMessageShow("Please Uninstall and re install from play store", True)
				Return
			End If
			File.Delete(File.DirInternal, "MyDb.db")
			countError = countError + 1
			CreateCode
			Return
		End Try
		Cursor.Position = 0
		Log(Cursor.GetString("col1"))
		'Getting codes to other Activities
		UserCode = Cursor.GetString("col1")
		VerCode = Cursor.GetString("col2")
		VeridCode = Cursor.GetString("col3")
		m.Initialize
		For i = 0 To Cursor1.RowCount - 1
			Cursor1.Position = i
			m.Put(Cursor1.GetString("col1"),Cursor1.GetString("col2"))
			
		Log(Cursor1.GetString("col1")&": "&Cursor1.GetString("col2"))
		Next
			Vers = m.Get("Version")
			vol = m.Get("Volume")
			hide = m.Get("Hide")
			'm.Put("Song","")
			Log("Load: "&vol)
			'Log("load 1: "&)
			'Log(m.Get("Version"))
		sql.close
End Sub
Sub createTables
	If File.Exists(File.DirInternal,"MyDb.db") Then
		Log("yes")
	Else
		sql.Initialize(File.DirInternal, "MyDb.db", True)
		Dim code As String
		Dim Ver As Int
		For i = 0 To 3
			code = code&Rnd(0,9)
		Next
		Ver = code * 43 + 1844
		Try
			sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS table1 (col1 TEXT , col2 TEXT, col3 TEXT)")
			sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS settings (col1 TEXT , col2 TEXT)")
			sql.ExecNonQuery2("INSERT INTO table1 VALUES (?, ?, Null)", Array As Object(code, Ver))
			sql.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)", Array As Object("Version","1.0.2"))
			sql.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)", Array As Object("Volume",50))
			sql.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)", Array As Object("Hide","False"))
			sql.Close
			Log("true")
		Catch
			ToastMessageShow("sorry error in database", True)
			Log("failed")
		End Try
	End If
End Sub
Sub getAndroidVersion As String
	Dim p As Phone
	Return p.SdkVersion
End Sub

Sub ConsentF
	sql.Initialize(File.DirInternal, "MyDb.db", True)
	Log("consented")
	sql.ExecNonQuery2("UPDATE table1 SET col1 = ?, col2 = ?, col3 = ? WHERE col1 = ?", Array As Object(UserCode, VerCode, VerCode, UserCode))
	'sql.ExecNonQuery2("INSERT INTO table1 VALUES (?, ?, ?)", Array As Object("Version","Null", 1.0.1))
	Log("success")
	sql.Close
End Sub

Sub currentSong As String
	Try
		Dim cursor As Cursor
		
	Catch
		Return LastException.Message
		'Log(LastException)
	End Try
End Sub

Sub AddSetting(para As String, val As String)
	sql.Initialize(File.DirInternal, "MyDb.db", True)
	Try
		sql.ExecNonQuery2("INSERT INTO settings VALUES (?, ?)", Array As Object(para,val))
	Catch
		Log(LastException)
		Return
	End Try
	m.Put(para,val)
	sql.Close
End Sub

Sub update_Setting(para As String, val As String)
	sql.Initialize(File.DirInternal, "MyDb.db", True)
	Try
		Log(val)
		sql.ExecNonQuery2("UPDATE settings SET col2 = ? WHERE col1 = ?", Array As Object(val, para))
	Catch
		Log("THis: "&LastException.Message)
	End Try
	sql.close
End Sub

Sub GetSetting(setting As String) As Object
	Try
'		Log("Seting: "&setting)
		Dim cursor As Cursor
		sql.Initialize(File.DirInternal, "MyDb.db", True)
		cursor = sql.ExecQuery2("SELECT * FROM settings WHERE col1 = ?",Array As String(setting))
		If cursor.RowCount > -1 Then
			cursor.Position = 0
			Return cursor.GetString("col2")
		Else
			Return "404"
		End If
	Catch
		Log(LastException)
		Return  "0"
	End Try
End Sub

Sub checkValue(col As String, db As String, table As String) As Boolean
	Try
'		Log("Seting: "&setting)
		Dim cursor As Cursor
		sql.Initialize(File.DirInternal, db, True)
		cursor = sql.ExecQuery2("SELECT * FROM '"&table&"' WHERE chapter = ?",Array As String(col))
		cursor.Position = 0
		Return True
	Catch
		'Log(LastException)
		Return False
	End Try
End Sub

Sub createTable(table As String, db As String)
	Try
		sql.Initialize(File.DirInternal, db, True)
		sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS '"&table&"' (chapter TEXT PRIMARY KEY , verses TEXT)")
	Catch
		Log(LastException.Message)
	End Try
End Sub

Sub addDataToDb(col As String, val As String, table As String, db As String)
	sql.Initialize(File.DirInternal, db, True)
	Try
		sql.ExecNonQuery2("INSERT INTO '"&table&"' VALUES (?, ?)", Array As Object(col,val))
	Catch
		Log(LastException)
		Return
	End Try
	sql.Close
End Sub

Sub updateNotes As String
	Dim s As String
	s = "1. Some songs have been corrected. The ## ## has been fixed"&CRLF
	s = s & "2. You can join the New Luganda hymnal community on telegram."&CRLF
	s = s & "3. Have a nice worship experience."&CRLF
	s = s & "4. Swipe left Or right To open Next Or previous song."&CRLF
	s = s & "5. You can now tilt to get a wider view."&CRLF&CRLF
	s = s & "Thank you For choosing our app."&CRLF
	s = s & "Tell us what you want in the Next update using the Feedback section. You can also directly update the app from there."
	
	Return s
End Sub

Sub success(msg As String)
	MsgboxAsync(msg, "Operation Successfull")
End Sub

Sub failure(msg As String)
	MsgboxAsync(msg, "Operation failed")
End Sub

Sub Open_web(Link As String)
	Dim p As PhoneIntents
	StartActivity(p.OpenBrowser(Link))
	Log("true")
End Sub