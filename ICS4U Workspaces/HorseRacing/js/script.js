
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");
document.getElementById("dolphinsInRace").style.visibility = "hidden"; 
document.getElementById("signUp").style.visibility = "hidden";
document.getElementById("raceDolphins").style.visibility = "hidden";
document.getElementById("myCanvas").style.visibility = "visible";

/* back-up
// --- dolphin sprite animation ---
// variables 
var shift = 0; // onto the next sprite image
var frameWidth = 196.57;
var frameHeight = 198;
var totalFrames = 4;
var currentFrame = 0; // counter  

var myImage = new Image();
myImage.src = "images/Dolphin_Sprite_Use.PNG";
myImage.addEventListener("load", loadImage, false);
 
function loadImage(e) {
  animate();
}
 
// animation
function animate() {
  context.clearRect(120, 25, 196.57, 198);
 
  //draw each frame + place them in the middle
  context.drawImage(myImage, shift, 0, frameWidth, frameHeight,
                    120, 25, frameWidth, frameHeight);
 
  shift += frameWidth + 1;
 
   // Start at the beginning once you've reached the
   // end of your sprite!
  
  if (currentFrame === (totalFrames - 1)) {
    shift = 0;
    currentFrame = 0;
  }
 
  currentFrame++;
}

setInterval(animate, 500);
*/

// --- initializing player variables ---
// var players = []; 
var playerNames = []; // array holds each player's name
var playerWallets = []; // array holds the amount of money in each player's wallet
var playerBets = []; // array holds the amount of money each player bets
var minWalletAmount = 0; // minimum amount of money from a player's wallet to bet with; $0
var maxWalletAmount = 1000; // maximum (initial) amount of money from a player's wallet to bet with; $1000

// --- initializing horse variables ---
var dolphins = ["Kincsem", "Black Caviar", "Peppers Pride", "Eclipse", "Karayel", "Ormonde", "Prestige", "Ribot", "Colin", "Macon", "Frankel", "Highflyer", "Nearco", "Barcaldine",
    "Personal Ensign", "Tremont", "Asteroid", "Braque", "Crucifix", "Goldfinder", "Kurifuji (Toshifuji)", "Nereide", "Tokino Minoru", "Handsomechamp", "Bahram", "Combat",
    "Grand Flaneur", "Patience", "Regulus", "St. Simon", "Alipes", "American Eclipse", "Caracalla", "Maruzensky", "Sweetbriar", "Tiffin", "El Rio Rey", "Heliskier", "Kitano Dai O",
    "Malt Queen", "Mannamead", "Perdita II", "The Tetrarch", "Zarkava", "Bay Middleton", "Bustin Stones", "Candy Ride", "Cavaliere d\'Arpino", "Claude", "Hurry On", "Quintessence",
    "Tolgus", "Ajax", "Dice", "Emerson", "Flying Childers", "Husson", "Kneller", "Landaluce", "Landgraf", "Melair", "Norfolk", "Precocious", "Reset", "Fasliyev", "Teofilo",
    "Treve", "Queen\'s Logic", "Agnes Tachyon", "Blood Royal", "Certify", "Fuji Kiseki", "Golden Fleece", "Lammtarra", "Madelia", "Raise a Native", "Snap", "Vindication", 
    "White Moonstone", "Blue Train", "Boniform", "Cobweb", "Danzig", "Kantharos", "Footstepsinthesand", "Pharis"]; // master list of dolphins
var dolphinsLength = dolphins.length; // length of master dolphin list; 86 dolphins in array
var chosenDolphins = []; // array holds the dolphin each player choses to bet on
var dolphinsInRace = generateRaceDolphins();

var minDolphinChoice = 1; // minimum choice for dolphin number in race, #1 dolphin in list (on chart)
var maxDolphinChoice = dolphinsInRace.length; // maximum choice for dolphin number in race

/*
var winningDolphins = startDolphinRace(); // holds the winning dolphin(s) -- if there is a tie then there's more than 1 winner

function startDolphinRace() {
  var numSpacesInRace = 80;
  var stepsInRace = []; // array holds the number of "steps" each dolphin takes
  // print initial starting position

  // printing race visualization
  var dolphinRaceOver = false;

  while (!dolphinRaceOver) {
    var j;
    for (j = 0; j < dolphinsInRace.length; j++) {
      stepsInRace[j] = stepsInRace[j] + Math.floor((Math.random() * 4) + 1);
    }

    // to check if the dolphin race is over
    dolphinRaceOver = checkRaceOver(stepsInRace, numSpacesInRace); 

    if (dolphinRaceOver === true) {
       break;
    }
  }
    
  // get the winning dolphins (if tie) in the race
  int[] winningDolphins = getWinningHorse(stepsInRace, numSpacesInRace); 
    
  return winningDolphins;
}*/

/*
var gameOver = false;
while (!gameOver) {
  // doRace(minWalletAmount, dolphins, playerNames, playerWallets, keyboard);
  // gameOver = promptForGameOver(keyboard);
  gameOver = true;
}*/

/*
function doRace(){

  
}
*/
// ---  horse methods ---
// generates list of dolphins in current race
// returns 4 - 8 dolphins
function generateRaceDolphins() {
  var numDolphinsInRace = 0;
  var minDolphins = 4;
  var maxDolphins = 8;

  numDolphinsInRace = Math.floor((Math.random() * (maxDolphins - minDolphins) + minDolphins));

  var dolphinsInRace = []; // holds generated dolphins 
  var currentDolphinIndex = 0;

  var i;
  for (i = 0; i < numDolphinsInRace; i++) {
    currentHorseIndex = Math.floor((Math.random() * dolphinsLength));
    dolphinsInRace[i] = currentHorseIndex;

    if (alreadyInRace(i, currentDolphinIndex, dolphinsInRace) === true) {
      i--;
    }
  }

  return dolphinsInRace;
}

// checks if horse is already in the race
function alreadyInRace(currentIndex, dolphin, dolphinsInRace) { // ***sketchy parameters
  var i;
  for (i = 0; i < dolphinsInRace.length - 1; i++) {
    if (dolphinsInRace[i] === dolphin && i !== currentIndex) {
      return true;
    }
  }

  return false;
}

function printDolphinList() {
  var i;
  for (i = 0; i < dolphinsInRace.length; i++) {
    $("#dolphinsInRace tbody").append( "<tr>" +
        "<td>" + (i+1) + "</td>" + "<td>" + dolphins[dolphinsInRace[i]] + "</td>" + "</tr>" );
  }
}

/*
boolean gameOver = false;
while (!gameOver) {
  doRace(minWalletAmount, horses, playerNames, playerWallets, keyboard);
  gameOver = promptForGameOver(keyboard);
}*/

/*
$(document).ready(function(){
  alert("Welcome to today's Dolphin Race!!")
})
*/

// --- dolphin sprite animation ---

// Notes: how to draw image
// ctx.drawImage(image, sx, sy, sWidth, sHeight, dx, dy, dWidth, dHeight); 
// s --> source
// d --> destination

var myImage = new Image();
myImage.src = "images/Dolphin_Sprite_Use.PNG";

// variables 
var sWidth = 196.57; // width of source dolphin image
var sHeight = 198; // height of source dolphin image

var dWidth = sWidth / 3; // ******* fix sizing // width ofdestination dolphin image
var dHeight = sHeight / 3; // width of destination dolphin image

//var stepsInRace = []; // array holds the number of "steps" each dolphin takes *************
var finishLine = myCanvas.width - dWidth; 
var dolphinRaceOver = false;

  var dx1 = Math.floor((Math.random() * 20) + 5); // dolphin destination x coordinate
  var dy1 = 8; // dolphin destination y coordinates; plus 8 px is just for padding at top
  var dx2 = Math.floor((Math.random() * 20) + 5); // dolphin destination x coordinate
  var dy2 = dHeight + dy1; // dolphin destination y coordinates
  var dx3 = Math.floor((Math.random() * 20) + 5); // dolphin destination x coordinate
  var dy3 = dHeight + dy2; // dolphin destination y coordinates
  var dx4 = Math.floor((Math.random() * 20) + 5); // dolphin destination x coordinate
  var dy4 = dHeight + dy3; // dolphin destination y coordinates
  var dx5 = Math.floor((Math.random() * 20) + 5); // dolphin destination x coordinate
  var dy5 = dHeight + dy4; // dolphin destination y coordinates
  var dx6 = Math.floor((Math.random() * 20) + 5); // dolphin destination x coordinate
  var dy6 = dHeight + dy5; // dolphin destination y coordinates
  var dx7 = Math.floor((Math.random() * 20) + 5); // dolphin destination x coordinate
  var dy7 = dHeight + dy6; // dolphin destination y coordinates
  var dx8 = Math.floor((Math.random() * 20) + 5); // dolphin destination x coordinate
  var dy8 = dHeight + dy7; // dolphin destination y coordinates

  var distance1 = 0;
  var distance2 = 0;
  var distance3 = 0;
  var distance4 = 0;
  var distance5 = 0;
  var distance6 = 0;
  var distance7 = 0;
  var distance8 = 0;

  var totalFrames = 4;
  var currentFrame1 = 0; // counter
  var currentFrame2 = 0; // counter
  var currentFrame3 = 0; // counter
  var currentFrame4 = 0; // counter
  var currentFrame5 = 0; // counter
  var currentFrame6 = 0; // counter
  var currentFrame7 = 0; // counter
  var currentFrame8 = 0; // counter

  var shiftFrame1 = 0; // shifts onto the next dolphin image in sprite
  var shiftFrame2 = 0;
  var shiftFrame3 = 0;
  var shiftFrame4 = 0;
  var shiftFrame5 = 0;
  var shiftFrame6 = 0;
  var shiftFrame7 = 0;
  var shiftFrame8 = 0;

myImage.addEventListener("load", loadImage, false);
 
function loadImage(e) {
  animate();
}
 
// animation
function animate() {    
    //while (!dolphinRaceOver) {
      // --- dolphin 1 ---
      context.clearRect(0, dy1, (dWidth + distance1), dHeight);
 
      //draw each frame and place them in the middle
      context.drawImage(myImage, shiftFrame1, 0, sWidth, sHeight, distance1, dy1, dWidth, dHeight);
      shiftFrame1 += sWidth;
      distance1 += dx1; // dolphin travels
     
      /*
        Start at the beginning once you've reached the
        end of your sprite!
      */
      if (currentFrame1 === (totalFrames - 1)) {
        shiftFrame1 = 0;
        currentFrame1 = 0;
      }
      currentFrame1++;

      // --- dolphin 2 ---
      context.clearRect(0, dy2, (dWidth + distance2), dHeight);
 
      //draw each frame and place them in the middle
      context.drawImage(myImage, shiftFrame2, 0, sWidth, sHeight, distance2, dy2, dWidth, dHeight);
      shiftFrame2 += sWidth;
      distance2 += dx2; // dolphin travels
     
      if (currentFrame2 === (totalFrames - 1)) {
        shiftFrame2 = 0;
        currentFrame2 = 0;
      }
      currentFrame2++;

      // --- dolphin 3 ---
      context.clearRect(0, dy3, (dWidth + distance3), dHeight);
 
      //draw each frame and place them in the middle
      context.drawImage(myImage, shiftFrame3, 0, sWidth, sHeight, distance3, dy3, dWidth, dHeight);
      shiftFrame3 += sWidth;
      distance3 += dx3; // dolphin travels
     
      if (currentFrame3 === (totalFrames - 1)) {
        shiftFrame3 = 0;
        currentFrame3 = 0;
      }
      currentFrame3++;

      // --- dolphin 4 ---
      context.clearRect(0, dy4, (dWidth + distance4), dHeight);
 
      //draw each frame and place them in the middle
      context.drawImage(myImage, shiftFrame4, 0, sWidth, sHeight, distance4, dy4, dWidth, dHeight);
      shiftFrame4 += sWidth;
      distance4 += dx4; // dolphin travels
     
      if (currentFrame4 === (totalFrames - 1)) {
        shiftFrame4 = 0;
        currentFrame4 = 0;
      }
      currentFrame4++;

      // --- dolphin 5 ---
      if (dolphinsInRace.length >= 5) {
        context.clearRect(0, dy5, (dWidth + distnace5), dHeight);
 
        //draw each frame and place them in the middle
        context.drawImage(myImage, shiftFrame5, 0, sWidth, sHeight, distance5, dy5, dWidth, dHeight);
        shiftFrame5 += sWidth;
        distance5 += dx5; // dolphin travels
       
        if (currentFrame5 === (totalFrames - 1)) {
          shiftFrame5 = 0;
          currentFrame5 = 0;
        }
        currentFrame5++;
      }

      // --- dolphin 6 ---
      if (dolphinsInRace.length >= 6) {
        context.clearRect(0, dy6, (dWidth + distance6), dHeight);
 
        //draw each frame and place them in the middle
        context.drawImage(myImage, shiftFrame6, 0, sWidth, sHeight, distance6, dy6, dWidth, dHeight);
        shiftFrame6 += sWidth;
        distance6 += dx6; // dolphin travels
       
        if (currentFrame6 === (totalFrames - 1)) {
          shiftFrame6 = 0;
          currentFrame6 = 0;
        }
        currentFrame6++;
      }

      // --- dolphin 7 ---
      if (dolphinsInRace.length >= 7) {
        context.clearRect(0, dy7, (dWidth + distance7), dHeight);
 
        //draw each frame and place them in the middle
        context.drawImage(myImage, shiftFrame7, 0, sWidth, sHeight, distance7, dy7, dWidth, dHeight);
        shiftFrame7 += sWidth;
        distance7 += dx7; // dolphin travels
       
        if (currentFrame7 === (totalFrames - 1)) {
          shiftFrame7 = 0;
          currentFrame7 = 0;
        }
        currentFrame7++;
      }

      // --- dolphin 8 ---
      if (dolphinsInRace.length === 8) {
        context.clearRect(0, dy8, (dWidth + distance8), dHeight);
 
        //draw each frame and place them in the middle
        context.drawImage(myImage, shiftFrame8, 0, sWidth, sHeight, distance8, dy8, dWidth, dHeight);
        shiftFrame8 += sWidth;
        distance8 += dx8; // dolphin travels
       
        if (currentFrame8 === (totalFrames - 1)) {
          shiftFrame8 = 0;
          currentFrame8 = 0;
        }
        currentFrame8++;
      }


      if (distance1 >= finishLine) {
        dolphinRaceOver = true;
        alert("End my suffering... *cries*");
      }
  /*
  if (dx === (myCanvas.width - dWidth) ) {
    gameOver = true;
  }*/
}

//setInterval(animate, 350);

$(document).ready(function(){
   
  var dialog, form,

    name = $( "#name" ),
    wallet = $( "#wallet" ),
    betting = $( "#betting" ),
    chosenDolphin = $( "#chosenDolphin" ),
    allFields = $( [] ).add( name ).add( wallet ).add( betting ).add( chosenDolphin ),
    tips = $( ".validateTips" );
 
  function updateTips( t ) {
    tips
      .text( t )
      .addClass( "ui-state-highlight" );
    setTimeout(function() {
      tips.removeClass( "ui-state-highlight", 1500 );
    }, 500 );
  }
 
  function checkName( o, n, min, max ) {
    if ( o.val().length > max || o.val().length < min ) {
      o.addClass( "ui-state-error" );
      updateTips( "Length of " + n + " must be between " +
        min + " and " + max + "." );
      return false;
    } else {
      return true;
    }
  }

  // checks if player has entered a valid amount of betting money 
  function checkBet (o, n, min, max) { 
    if ( o.val() > max || o.val() < min ) {
      o.addClass( "ui-state-error" );
      updateTips( "You can only bet with numeric money. Your betting power also cannot exceed the amount in your wallet, nor be negative." );
      return false;
    } else {
      return true;
    }
  }

  // checks if player has entered a valid dolphin number 
  function checkDolphin (o, n, min, max) { 
    if ( o.val() > max || o.val() < min ) {
      o.addClass( "ui-state-error" );
      updateTips( "You can only bet on an assigned racing number for a dolphin in today's race. Please enter a valid number." );
      return false;
    } else {
      return true;
    }
  }

  function checkRegexp( o, regexp, n ) { // regexp -- regular expression
    if ( !( regexp.test( o.val() ) ) ) {
      o.addClass( "ui-state-error" );
      updateTips( n );
      return false;
    } else {
      return true;
    }
  }
 
  function addUser() {
    var valid = true;
    allFields.removeClass( "ui-state-error" );
 
    valid = valid && checkName( name, "username", 1, 16 );
    valid = valid && checkBet( betting, "betting", minWalletAmount, maxWalletAmount );
    valid = valid && checkDolphin( chosenDolphin, "chosenDolphin", minDolphinChoice, maxDolphinChoice );

    //valid = valid && checkLength( wallet, "wallet", 1, 6); 
 
    valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Your player name may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
    valid = valid && checkRegexp( betting, /^([0-9_\d])+$/i, "You can only bet with numeric money. Please enter a number." ); 
    valid = valid && checkRegexp( chosenDolphin, /^([0-9_\d])+$/i, "You can only enter an assigned racing number for a dolphin in today's race. Please enter a valid number." ); 
    // i from regexp makes it case-insensitive

    if ( valid ) {
      playerNames.push(name.val()); // add names
      playerBets.push(parseInt(betting.val()));
      playerWallets.push(parseInt(wallet.val() - betting.val()));
      chosenDolphins.push(parseInt(chosenDolphin.val()));

      $( "#users tbody" ).append( "<tr>" +
        "<td>" + name.val() + "</td>" +
        "<td>" + wallet.val() + "</td>" +
        "<td>" + betting.val() + "</td>" +
        "<td>" + chosenDolphin.val() + "</td>" + 
      "</tr>" );
      dialog.dialog( "close" );
    }
    return valid;
  }
     
  dialog = $( "#dialog-form" ).dialog({
    autoOpen: false,
    height: 400,
    width: 350,
    modal: true,
    buttons: {
      "Create an account": addUser,
      Cancel: function() {
        dialog.dialog( "close" );
      }
    },
    close: function() {
      form[ 0 ].reset();
      allFields.removeClass( "ui-state-error" );
    }
  });
 
  form = dialog.find( "form" ).on( "submit", function( event ) {
    event.preventDefault();
    addUser();
  });
 
  // Create New User Button in Sign Up List 
  $( "#create-user" ).button().on( "click", function() {
    dialog.dialog( "open" );
  });

  // Generate Dolphin List Button 
  $( "#dolphinList" ).button().on( "click", function() {
    //alert("here");
    printDolphinList();
    document.getElementById("dolphinsInRace").style.visibility = "visible"; 
  });

  // Continue Button One
  $( "#continueOneBtn" ).button().on( "click", function() {
    document.getElementById("signUp").style.visibility = "visible";
  });

  // Start Race Button
  $( "#startRaceBtn" ).button().on( "click", function() {
    document.getElementById("raceDolphins").style.visibility = "visible";
    setInterval(animate, 300);
  });
 
} )