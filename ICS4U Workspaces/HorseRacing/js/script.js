
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");
//document.getElementById("myCanvas").style.visibility = "visible"; // change to hidden after done testing
document.getElementById("dolphinsInRace").style.visibility = "hidden"; 
document.getElementById("signUp").style.visibility = "hidden";
document.getElementById("raceDolphins").style.visibility = "hidden";
document.getElementById("results").style.visibility = "hidden";

/* back-up version
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
var dolphinsInRace = generateRaceDolphins(); // generates a list of random dolphins to participate in race

var minDolphinChoice = 1; // minimum choice for dolphin number in race, #1 dolphin in list (on chart)
var maxDolphinChoice = dolphinsInRace.length; // maximum choice for dolphin number in race

// --- dolphin methods ---
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
  for (i = 0; i <= numDolphinsInRace; i++) {
    currentHorseIndex = Math.floor((Math.random() * dolphinsLength));
    dolphinsInRace[i] = currentHorseIndex;

    if (alreadyInRace(i, currentDolphinIndex, dolphinsInRace) === true) {
      i--;
    }
  }

  return dolphinsInRace;
}

// checks if dolphin is already in the race
function alreadyInRace(currentIndex, dolphin, dolphinsInRace) { // ***sketchy parameters
  var i;
  for (i = 0; i < dolphinsInRace.length - 1; i++) {
    if (dolphinsInRace[i] === dolphin && i !== currentIndex) {
      return true;
    }
  }

  return false;
}

// shows list of dolphins in race
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
var myImage = new Image();
myImage.src = "images/Dolphin_Sprite_Use.PNG";

// Notes: how to draw image
// ctx.drawImage(image, sx, sy, sWidth, sHeight, dx, dy, dWidth, dHeight); 
// s --> source
// d --> destination

var sWidth = 196.57; // width of source dolphin image
var sHeight = 198; // height of source dolphin image
var dWidth = sWidth / 3; // ******* fix sizing // width ofdestination dolphin image
var dHeight = sHeight / 3; // width of destination dolphin image

var finishLine = myCanvas.width - dWidth; // amount of px it takes to reach finish line of race
var dolphinRaceOver = false; // checks for when race is finished ***
var distances = []; // holds total amount of steps each dolphin takes in race
var winningDolphins = []; // holds winning dolphins in this race (if there was a tie, multiple winners)
var winningDolphinNames = []; // holds winning dolphin string names
var numWinningDolphins = 0;

// dolphin 1 - 8 destination x, y coordinates 
var dx1 = 0; // dolphin 1 destination x coordinate
var dy1 = 8; // dolphin 1 destination y coordinate; 8 px is just for padding at top
var dx2 = 0; 
var dy2 = dHeight + dy1; 
var dx3 = 0; 
var dy3 = dHeight + dy2; 
var dx4 = 0; 
var dy4 = dHeight + dy3; 
var dx5 = 0; 
var dy5 = dHeight + dy4; 
var dx6 = 0; 
var dy6 = dHeight + dy5; 
var dx7 = 0; 
var dy7 = dHeight + dy6; 
var dx8 = 0; 
var dy8 = dHeight + dy7;

var totalFrames = 4;
// dolphin 1 - 8 currentFrame counter 
var currentFrame1 = 0; 
var currentFrame2 = 0; 
var currentFrame3 = 0; 
var currentFrame4 = 0; 
var currentFrame5 = 0; 
var currentFrame6 = 0; 
var currentFrame7 = 0; 
var currentFrame8 = 0; 

// dolphin 1 - 8 shiftFrame variable shifts currentFrame onto the next dolphin image in sprite
var shiftFrame1 = 0; 
var shiftFrame2 = 0;
var shiftFrame3 = 0;
var shiftFrame4 = 0;
var shiftFrame5 = 0;
var shiftFrame6 = 0;
var shiftFrame7 = 0;
var shiftFrame8 = 0;
 
function loadImage(e) {
  animate();
}

function doRace () {
  // each dixtance"x" holds the number of "steps" each dolphin takes
  var distance1 = Math.floor((Math.random() * 20) + 5);
  var distance2 = Math.floor((Math.random() * 20) + 5);
  var distance3 = Math.floor((Math.random() * 20) + 5);
  var distance4 = Math.floor((Math.random() * 20) + 5);
  var distance5 = Math.floor((Math.random() * 20) + 5);
  var distance6 = Math.floor((Math.random() * 20) + 5);
  var distance7 = Math.floor((Math.random() * 20) + 5);
  var distance8 = Math.floor((Math.random() * 20) + 5);

  myImage.addEventListener("load", loadImage, false);
  setInterval(animate(distance1, distance2, distance3, distance4, distance5, distance6, distance7, distance8), 350);
}
 
// --- animation ---
function animate(distance1, distance2, distance3, distance4, distance5, distance6, distance7, distance8) {    
  while (!dolphinRaceOver) {
    // --- dolphin 1 ---
    context.clearRect(0, dy1, (dWidth + dx1), dHeight);
   
    // draw dolphin
    context.drawImage(myImage, shiftFrame1, 0, sWidth, sHeight, dx1, dy1, dWidth, dHeight);
    shiftFrame1 += sWidth;
    dx1 += distance1; // dolphin travels
        
    // loops currentFrame back to first frame once it reaches the end of sprite
    if (currentFrame1 === (totalFrames - 1)) {
      shiftFrame1 = 0;
      currentFrame1 = 0;
    }
    currentFrame1++;

    // --- dolphin 2 ---
    context.clearRect(0, dy2, (dWidth + dx2), dHeight);
    context.drawImage(myImage, shiftFrame2, 0, sWidth, sHeight, dx2, dy2, dWidth, dHeight);
    shiftFrame2 += sWidth;
    dx2 += distance2; 
       
    if (currentFrame2 === (totalFrames - 1)) {
      shiftFrame2 = 0;
      currentFrame2 = 0;
    }
    currentFrame2++;

    // --- dolphin 3 ---
    context.clearRect(0, dy3, (dWidth + dx3), dHeight);
    context.drawImage(myImage, shiftFrame3, 0, sWidth, sHeight, dx3, dy3, dWidth, dHeight);
    shiftFrame3 += sWidth;
    dx3 += distance3; 
     
    if (currentFrame3 === (totalFrames - 1)) {
      shiftFrame3 = 0;
      currentFrame3 = 0;
    }
    currentFrame3++;

    // --- dolphin 4 ---
    context.clearRect(0, dy4, (dWidth + dx4), dHeight);
    context.drawImage(myImage, shiftFrame4, 0, sWidth, sHeight, dx4, dy4, dWidth, dHeight);
    shiftFrame4 += sWidth;
    dx4 += distance4; 
      
    if (currentFrame4 === (totalFrames - 1)) {
      shiftFrame4 = 0;
      currentFrame4 = 0;
    }
    currentFrame4++;

    // --- dolphin 5 ---
    if (dolphinsInRace.length >= 5) {
      context.clearRect(0, dy5, (dWidth + dx5), dHeight);
      context.drawImage(myImage, shiftFrame5, 0, sWidth, sHeight, dx5, dy5, dWidth, dHeight);
      shiftFrame5 += sWidth;
      dx5 += distance5; 
    
      if (currentFrame5 === (totalFrames - 1)) {
        shiftFrame5 = 0;
        currentFrame5 = 0;
      }
      currentFrame5++;
    }

    // --- dolphin 6 ---
    if (dolphinsInRace.length >= 6) {
      context.clearRect(0, dy6, (dWidth + dx6), dHeight);
      context.drawImage(myImage, shiftFrame6, 0, sWidth, sHeight, dx6, dy6, dWidth, dHeight);
      shiftFrame6 += sWidth;
      dx6 += distance6; 
         
      if (currentFrame6 === (totalFrames - 1)) {
        shiftFrame6 = 0;
        currentFrame6 = 0;
      }
      currentFrame6++;
    }

    // --- dolphin 7 ---
    if (dolphinsInRace.length >= 7) {
      context.clearRect(0, dy7, (dWidth + dx7), dHeight);
      context.drawImage(myImage, shiftFrame7, 0, sWidth, sHeight, dx7, dy7, dWidth, dHeight);
      shiftFrame7 += sWidth;
      dx7 += distance7; 
         
      if (currentFrame7 === (totalFrames - 1)) {
        shiftFrame7 = 0;
        currentFrame7 = 0;
      }
      currentFrame7++;
    }

    // --- dolphin 8 ---
    if (dolphinsInRace.length === 8) {
      context.clearRect(0, dy8, (dWidth + dx8), dHeight);
      context.drawImage(myImage, shiftFrame8, 0, sWidth, sHeight, dx8, dy8, dWidth, dHeight);
      shiftFrame8 += sWidth;
      dx8 += distance8; 
         
      if (currentFrame8 === (totalFrames - 1)) {
        shiftFrame8 = 0;
        currentFrame8 = 0;
      }
      currentFrame8++;
    }

    // assigning total distances each dolphin travelled to distances[] 
    distances[0] = dx1;
    distances[1] = dx2;
    distances[2] = dx3;
    distances[3] = dx4;
    distances[4] = dx5;
    distances[5] = dx6;
    distances[6] = dx7;
    distances[7] = dx8;

    if (checkFinishLine(distances) === true) {
      winningDolphins = getWinningDolphins(distances); // get the winning dolphin(s) in the race
      dolphinRaceOver = true;
      //break;
    }
  }
}

function printDolphinWinners() {
  winningDolphinNames = getDolphinNames();
  for (var j = 0; j < numWinningDolphins; j++) {
    if (winningDolphins[j] != 0) {
      $("#dolphinWinners tbody").append( "<tr>" + 
        "<td>" + dolphins[dolphinsInRace[winningDolphins[j] - 1]] + "</td>" + "</tr>" );
    }
  }
}

function getDolphinNames() {
  var i;
  for (i = 0; i < winningDolphins.length; i++) {
    if (winningDolphins[i] != 0) {
      winningDolphinNames[i] = dolphins[dolphinsInRace[winningDolphins[i] - 1]];
      numWinningDolphins++;
    }
  }

  return winningDolphinNames;
}

function checkFinishLine(distances) {
  var valid = false;
  for (var i = 0; i < dolphinsInRace.length; i++) {
    if (distances[i] >= finishLine) {
      valid = true;
      break;
    }
  }
  return valid;
}

function getWinningDolphins(distances) {
  var i;
  var temp = 0;
  for (i = 0; i < dolphinsInRace.length; i++) {
    if (distances[i] >= finishLine) {
      winningDolphins[temp++] = i + 1;
    }
  } 
  return winningDolphins;
}

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
    doRace();
    if (dolphinRaceOver === true) {
      document.getElementById("winningDolphinListBtn").style.visibility = "visible";
    }
  });

  // Winning Dolphin List Button
  $( "#winningDolphinListBtn" ).button().on( "click", function() {
    printDolphinWinners();
    document.getElementById("winningDolphins").style.visibility = "visible";
  });
 
} )