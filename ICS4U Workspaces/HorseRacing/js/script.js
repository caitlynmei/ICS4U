
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
  
  if (currentFrame == (totalFrames - 1)) {
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
function alreadyInRace(currentIndex, dolphin, dolphinsInRace) { // *******sketch param
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
var shiftFrame = 0; // shifts onto the next dolphin image in sprite
var sWidth = 196.57; // width of source dolphin image
var sHeight = 198; // height of source dolphin image

var dx = 0; // dolphin destination x coordinate
var dy = 0; // dolphin destination y coordinate
var dWidth = sWidth / (dolphinsInRace.length / 2); // ******* fix sizing // width ofdestination dolphin image
var dHeight = sHeight / (dolphinsInRace.length / 2); // width of destination dolphin image
var stepsInRace = []; // array holds the number of "steps" each dolphin takes *************

var totalFrames = 4;
var currentFrame = 0; // counter

myImage.addEventListener("load", loadImage, false);
 
function loadImage(e) {
  animate();
}
 
// animation
function animate() {
  context.clearRect(0, dy, (dWidth + dx), dHeight);
 
  //draw each frame and place them in the middle
  context.drawImage(myImage, shiftFrame, 0, sWidth, sHeight, dx, dy, dWidth, dHeight);
  shiftFrame += sWidth;
  dx += dWidth; // dolphin travels
 
  /*
  var j;
  for (j = 0; j < dolphinsInRace.length; j++) {
    stepsInRace[j] = stepsInRace[j] + Math.floor((Math.random() * 4) + 1);
  }*/

  /*
    Start at the beginning once you've reached the
    end of your sprite!
  */
  if (currentFrame == (totalFrames - 1)) {
    shiftFrame = 0;
    currentFrame = 0;
  }

  /*
  if (dx === (myCanvas.width - dWidth) ) {
    gameOver = true;
  }*/
 
  currentFrame++;
}

setInterval(animate, 500);


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
  });
 
} )