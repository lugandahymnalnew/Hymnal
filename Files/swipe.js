
// Making pages variable
var pages = [1,2,3,4,5,6,7,8,9,10,11,12,'12a',13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250];
// Getting number of current song
	var page = $('.No b').text().trim();
	// console.log(typeof page);// path.split("/").pop().split('%5C').pop().split(".").slice(0, -1).join('.');
	var Npg;
	var song_midi='midi/'; 
	
	var next;
	var prev;
//getting index of current page
	if(pages.indexOf(page) != -1){
		Npg = pages.indexOf(page);
		// console.log(Npg);
	}
	else{
		Npg = pages.indexOf(eval(page));
		// console.log(Npg)
	}
		song_midi = song_midi+pages[Npg]+'.mid';
		//console.log(song_midi)
//Checking wether on the first song and setting Url
	if(!pages[Npg - 1]){
		next = pages[Npg + 1];
		prev = pages[pages.length - 1];
		//console.log("yes");
	}
//Checking wether on the last song and setting Url
	else if(!pages[Npg + 1]){
		next = pages[0];
		prev = pages[Npg - 1];
		//console.log("yes high");
	}
//Setting Url for other songs
	else{
		next = pages[Npg + 1];
		prev = pages[Npg - 1];
		//console.log("not 3")
	}

// Fixing link for B4A New file system
var nextR, prevL;
nextR = next
prevL = prev
nextR = "pages%5C"+next
prevL = "pages%5C"+prev

//console.log("midi: "+song_midi)
var startingX , startingY , movingX , movingY, startTime, endTime, timeTaken;
$(document).on('touchstart', function(evt) {
	startingX = evt.touches[0].clientX ;
	startingY = evt.touches[0].clientY ;
	startTime = Date.now() 
});
$(document).on('touchmove', function(evt) {
	movingX = evt.touches[0].clientX ;
	movingY = evt.touches[0].clientY ;

});
$(document).on('touchend', function(evt) { 
	endTime = Date.now();
var tT = endTime - startTime
tT /= 1000
// Getting number of current song
var page = $('.No b').text().trim();
// console.log(typeof page);// path.split("/").pop().split('%5C').pop().split(".").slice(0, -1).join('.');
var Npg;
var song_midi='midi/'; 

var next;
var prev;
//getting index of current page
if(pages.indexOf(page) != -1){
	Npg = pages.indexOf(page);
	// console.log(Npg);
}
else{
	Npg = pages.indexOf(eval(page));
	// console.log(Npg)
}
	song_midi = song_midi+pages[Npg]+'.mid';
	//console.log(song_midi)
//Checking wether on the first song and setting Url
if(!pages[Npg - 1]){
	next = pages[Npg + 1];
	prev = pages[pages.length - 1];
	//console.log("yes");
}
//Checking wether on the last song and setting Url
else if(!pages[Npg + 1]){
	next = pages[0];
	prev = pages[Npg - 1];
	//console.log("yes high");
}
//Setting Url for other songs
else{
	next = pages[Npg + 1];
	prev = pages[Npg - 1];
	//console.log("not 3")
}
	if (tT > 0.3){
		// console.log(tT)
	}
	else{
		if(startingX+250 < movingX){
			// console.log('right');
			B4A.CallSub('swipe', true, ""+prev);
		} 
		else if(startingX-250 > movingX){
			// console.log('left');
			B4A.CallSub('swipe', true, ""+next)
		}
		// if(startingY+200 < movingY){
		//	console.log('down');
		// } 
		// else if(startingY-200 > movingY){
		//		console.log('up');
		// }
	}
});
function trying(func) {
	try {
		eval(func)
	} catch (error) {
		if(func.includes('swipeLeft')){
			window.location.href = nextR
		}
		else if(func.includes('swipeRight')){
			window.location.href = prevL
		}
		console.log(error.message)
	}
}
// function touchStart(evt){
// }
// function touchMove(evt){
// }
// function touchEnd(){
// }