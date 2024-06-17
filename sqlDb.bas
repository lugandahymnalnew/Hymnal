B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=12.5
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Public db As SQL
	Public menu As Map
	Public son As List
	Public menuLoaded As Map
	Public jsonParser As JSONParser
End Sub

Public Sub checkDB()
	If File.Exists(File.DirInternal,"songs.db") Then
		Return
	Else
		File.Copy(File.DirAssets, "songs.db", File.DirInternal, "songs.db")
		checkDB
	End If
End Sub

' Custom function to convert Cursor to List of Maps for luganda table
Sub CursorToListLuganda(cursor As Cursor) As List
	Dim resultList As List
	resultList.Initialize

	' Check if the cursor is not null
	If cursor <> Null Then
		' Iterate through the cursor rows
		For i = 0 To cursor.RowCount - 1
			' Move to the next row
			cursor.Position = i

			' Create a map to store column values
			Dim rowMap As Map
			rowMap.Initialize

			' Explicitly select columns in the query

			' Put values in the map
			rowMap.Put("number", cursor.GetString("number"))
			rowMap.Put("An", cursor.GetString("An"))
			rowMap.Put("EngNo", cursor.GetString("EngNo"))
			rowMap.Put("EngTit", cursor.GetString("EngTit"))
			rowMap.Put("composer", cursor.GetString("composer"))
			rowMap.Put("doh", cursor.GetString("doh"))
			rowMap.Put("signDown", cursor.GetString("signDown"))
			rowMap.Put("signUp", cursor.GetString("signUp"))
			rowMap.Put("song", cursor.GetString("song"))

			' Add the map to the result list
			resultList.Add(rowMap)
		Next
	End If

	' Close the cursor
	cursor.Close

	' Return the list of maps
	Return resultList
End Sub


Public Sub getMenu() As List
	Try
		db.Initialize(File.DirInternal,"songs.db", False)
		Dim cursor As Cursor =  db.ExecQuery("SELECT number, An, EngNo, EngTit, composer, doh, signDown, signUp, song FROM luganda")
		Return CursorToListLuganda(cursor)
	Catch
		Log(LastException)
	End Try
End Sub

Public Sub getSongWithNumber(num As String) As Map
	Try
		
		Dim cursor As Cursor
			Dim ms As Map
			Dim error As Map
			error.Initialize
			error.Put("err","Not found")
			ms.Initialize
		db.Initialize(File.DirInternal,"songs.db", False)
		cursor = db.ExecQuery2("SELECT * FROM luganda WHERE number = ?", Array As String(num))
		If cursor.RowCount < 1 Then
			ms.Put("No","<b>#</b><br>#")
			ms.Put("Title","<b>#</b><br>#")
			ms.Put("An","#")
			ms.Put("Sign","#")
			ms.Put("Comp","#")
			ms.Put("Lyrics",error)
			Return ms
		Else
			'Dim s As String
			Dim m As Map
			'Dim l As List
			cursor.Position = 0
			jsonParser.Initialize(cursor.GetString("lyrics"))
			m = jsonParser.NextObject
			ms.Put("No","<b>"&cursor.GetString("number")&"</b><br>"&cursor.GetString("EngNo"))
			ms.Put("Title","<b>"&cursor.GetString("song")&"</b><br>"&cursor.GetString("EngTit"))
			ms.Put("An",cursor.GetString("An"))
			ms.Put("Sign",cursor.GetString("signUp")&"<br>"&cursor.GetString("signDown"))
			ms.Put("Comp",cursor.GetString("composer")&"<br><b>"&cursor.GetString("doh")&"</b>")
			ms.Put("Lyrics",m)
			Return ms
		End If
	Catch
		ms.Put("No","<b>#</b><br>#")
		ms.Put("Title","<b>#</b><br>#")
		ms.Put("An","#")
		ms.Put("Sign","#")
		ms.Put("Comp","#")
		ms.Put("Lyrics",error)
		Return ms
	End Try
End Sub

'tN is Table_name, dbN is Database, Set is Select_phrase, where is Where_clause, 
Public Sub singleColumnUpdate(dbN As String, tN As String, setCol As String, selectCol As String, selectValue As String, newValue As String)
	Try
		db.Initialize(File.DirInternal, dbN, False)
		db.ExecNonQuery2("UPDATE "&tN&" SET "&setCol&" = ? WHERE "&selectCol&" = ?", Array As Object(newValue, selectValue))
	Catch
		MsgboxAsync(LastException.Message ,"Sorry, there was an error.")
		Log(LastException)
	End Try
End Sub

Public Sub multiColumnUpdate(dbN As String, tN As String, setPhrase As String, selectCol As String, selectValue As String)
	Try
		db.Initialize(File.DirInternal, dbN, False)
		db.ExecNonQuery2("UPDATE "&tN&" SET "&setPhrase&" WHERE "&selectCol&" = ?", Array As Object(selectValue))
	Catch
		MsgboxAsync(LastException.Message ,"Sorry, there was an error.")
		Log(LastException)
	End Try
End Sub

Public Sub createTable(dbN As String, tN As String, schema As String)
	Try
		db.Initialize(File.DirInternal, dbN, False)
		db.ExecNonQuery("CREATE TABLE "&tN&"("&schema&")")
		MsgboxAsync("Table "&tN&" was created successfully in db "&dbN ,"Success")
	Catch
		MsgboxAsync(LastException.Message ,"Sorry, there was an error.")
		Log(LastException)
	End Try
End Sub

Public Sub readBook(tN As String, dbN As String , selectCol As String, selectValue As String) As List
	Try
		db.Initialize(File.DirInternal, dbN, False)
		Dim cursor As Cursor
		Dim l As List
		l.Initialize
		cursor = db.ExecQuery2("SELECT * FROM "&tN&" WHERE "&selectCol&" = ?", Array As String(selectValue))
		If cursor.RowCount < 1 Then
			Dim m As Map
			m.Initialize
			m.Put("chapter", "#####")
			m.Put("verses","###")
			l.Add(m)
			Return l
		Else
			For i = 0 To cursor.RowCount - 1
				cursor.Position = i
				Dim m As Map
				m.Initialize
				For j = 0 To cursor.ColumnCount -1
					m.Put(cursor.GetColumnName(j), cursor.GetString2(j))
				Next
				l.Add(m)
			Next
			Return l
		End If
	Catch
		MsgboxAsync(LastException.Message ,"Sorry, there was an error.")
		Log(LastException)
		Dim m As Map
		m.Initialize
		m.Put("chapter", "#####")
		m.Put("verses","###")
		l.Add(m)
		Return l
	End Try
End Sub