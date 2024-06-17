function serFunction(){
    var input = document.getElementById('ser');
    var filter = input.value.toUpperCase();
    var div = document.getElementById('ind');
    var a = div.getElementsByTagName('a');
    if(!null){
        for(i = 0; i < a.length; i++){
            if(a[i].innerHTML.toUpperCase().indexOf(filter)>-1){
                a[i].style.display="";   
            }
            else{
                a[i].style.display="none";
            }
        }
    }
}

var oldT = [
    "Genesis",
    "Exodus",
    "Leviticus",
    "Numbers",
    "Deuteronomy",
    "Joshua",
    "Judges",
    "Ruth",
    "1 Samuel",
    "2 Samuel",
    "1 Kings",
    "2 Kings",
    "1 Chronicles",
    "2 Chronicles",
    "Ezra",
    "Nehemiah",
    "Esther",
    "Job",
    "Psalms",
    "Proverbs",
    "Ecclesiastes",
    "Song of Solomon",
    "Isaiah",
    "Jeremiah",
    "Lamentations",
    "Ezekiel",
    "Daniel",
    "Hosea",
    "Joel",
    "Amos",
    "Obadiah",
    "Jonah",
    "Micah",
    "Nahum",
    "Habakkuk",
    "Zephaniah",
    "Haggai",
    "Zechariah",
    "Malachi"
]

var newT = [
    "Matthew",
    "Mark",
    "Luke",
    "John",
    "Acts",
    "Romans",
    "1 Corinthians",
    "2 Corinthians",
    "Galatians",
    "Ephesians",
    "Philippians",
    "Colossians",
    "1 Thessalonians",
    "2 Thessalonians",
    "1 Timothy",
    "2 Timothy",
    "Titus",
    "Philemon",
    "Hebrews",
    "James",
    "1 Peter",
    "2 Peter",
    "1 John",
    "2 John",
    "3 John",
    "Jude",
    "Revelation"
];

var newTL = [
    "Matayo",
    "Makko",
    "Lukka",
    "Yokaana",
    "Ebikolwa",
    "Abaruumi",
    "1 Abakkolinso",
    "2 Abakkolinso",
    "Abaggalatiya",
    "Abaefeeso",
    "Abafiripi",
    "Abakkolosaayi",
    "1 Abasessaloniika",
    "2 Abasessaloniika",
    "1 Timoseewo",
    "2 Timoseewo",
    "Tito - Titus",
    "Firemooni",
    "Abaebbulaniya",
    "Yakobo",
    "1 Peetero",
    "2 Peetero",
    "1 Yokaana",
    "2 Yokaana",
    "3 Yokaana",
    "Yuda",
    "Okubikkulirwa"
]; 

var oldTL = [
    "Olubereberye",
    "Okuva",
    "Ebyabaleevi",
    "Okubala",
    "Ekyamateeka",
    "Yoswa",
    "Ekyabalamuzi",
    "Luusi",
    "1 Samwiri",
    "2 Samwiri",
    "1 Bassekabaka",
    "2 Bassekabaka",
    "1 Ebyomumirembe",
    "2 Ebyomumirembe",
    "Ezera",
    "Nekkemiya",
    "Eseza",
    "Yobu",
    "Zabbuli",
    "Engero",
    "Omubuulizi",
    "Oluyimba lwa Sulemaani",
    "Isaaya",
    "Yeremiya",
    "Okukungubaga",
    "Ezekyeri",
    "Danyeri",
    "Koseya",
    "Yoweeri",
    "Amosi",
    "Obadiya",
    "Yona",
    "Mikka",
    "Nakumu",
    "Kaabakuuku",
    "Zeffaniya",
    "Kaggayi",
    "Zekkaliya",
    "Malaki"
]