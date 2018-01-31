
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");
document.getElementById("dolphinsInRace").style.visibility = "hidden"; 
document.getElementById("signUp").style.visibility = "hidden";
document.getElementById("myCanvas").style.visibility = "hidden";

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
 
  /*
    Start at the beginning once you've reached the
    end of your sprite!
  */
  if (currentFrame == (totalFrames - 1)) {
    shift = 0;
    currentFrame = 0;
  }
 
  currentFrame++;
}

setInterval(animate, 500);



// initializing variables
var players = [];
var playerNames = [];
var playerWallets = [];
var playerBets = [];

var minWalletAmount = 2; // minimum amount of money from a player's wallet to bet with $2
var horses = getHorses();
var horsesLength = horses.length; // length of master horse list, 86 dolphins 
var horsesInRace = generateRaceHorses();

// --- gets master list of horses --- 
function getHorses() {
  horseList = ["Kincsem", "Black Caviar", "Peppers Pride", "Eclipse", "Karayel", "Ormonde", "Prestige", "Ribot", "Colin", "Macon", "Frankel", "Highflyer", "Nearco", "Barcaldine",
    "Personal Ensign", "Tremont", "Asteroid", "Braque", "Crucifix", "Goldfinder", "Kurifuji (Toshifuji)", "Nereide", "Tokino Minoru", "Handsomechamp", "Bahram", "Combat",
    "Grand Flaneur", "Patience", "Regulus", "St. Simon", "Alipes", "American Eclipse", "Caracalla", "Maruzensky", "Sweetbriar", "Tiffin", "El Rio Rey", "Heliskier", "Kitano Dai O",
    "Malt Queen", "Mannamead", "Perdita II", "The Tetrarch", "Zarkava", "Bay Middleton", "Bustin Stones", "Candy Ride", "Cavaliere d\'Arpino", "Claude", "Hurry On", "Quintessence",
    "Tolgus", "Ajax", "Dice", "Emerson", "Flying Childers", "Husson", "Kneller", "Landaluce", "Landgraf", "Melair", "Norfolk", "Precocious", "Reset", "Fasliyev", "Teofilo",
    "Treve", "Queen\'s Logic", "Agnes Tachyon", "Blood Royal", "Certify", "Fuji Kiseki", "Golden Fleece", "Lammtarra", "Madelia", "Raise a Native", "Snap", "Vindication", 
    "White Moonstone", "Blue Train", "Boniform", "Cobweb", "Danzig", "Kantharos", "Footstepsinthesand", "Pharis"]; 

  return horseList;
}

// --- generates list of horses in current race --- 
// returns 4 - 8 horses
function generateRaceHorses() {
  var numHorsesInRace = 0;
  var minHorses = 4;
  var maxHorses = 8;

  numHorsesInRace = Math.floor((Math.random() * (maxHorses - minHorses) + minHorses));

  var horsesInRace = []; // holds chosen horses in horse array
  //boolean isUniqueHorse = false; // to check if the index generated from randomizer is not repeated

  var currentHorseIndex = 0;

  var i;
  for (i = 0; i < numHorsesInRace; i++) {
    currentHorseIndex = Math.floor((Math.random() * horsesLength));
    horsesInRace[i] = currentHorseIndex;

    if (alreadyInRace(i, currentHorseIndex, horsesInRace) === true) {
      i--;
    }
  }

  return horsesInRace;
}

// ---------- checks if horse is already in the race ---------
// ---> sequential search
function alreadyInRace(currentIndex, horse, horsesInRace) {
  var i;
  for (i = 0; i < horsesInRace.length - 1; i++) {
    if (horsesInRace[i] === horse && i !== currentIndex) {
      return true;
    }
  }

  return false;
}

function printHorses() {
  var i;
  for (i = 0; i < horsesInRace.length; i++) {
    $("#dolphinsInRace tbody").append( "<tr>" +
        "<td>" + (i+1) + "</td>" + "<td>" + horses[horsesInRace[i]] + "</td>" + "</tr>" );
  }
}

// ----- checks if player has entered a valid number for betting horse -----
/*
function getValidHorseNumberInput(int minHorseChoice, int maxHorseChoice, Scanner keyboard) {
  boolean isValid = false;

  var userBettingHorseNumber = 0;
  while (!isValid) {
      try {
       
        if (userBettingHorseNumber >= minHorseChoice && userBettingHorseNumber <= maxHorseChoice) {
          isValid = true;
        } else {
          System.out.print("Please enter a number for one of the horses shown in the table (1 - " + maxHorseChoice + "): ");
        }
      } catch (Exception ex) {
        System.out.print("Please enter a valid horse number: ");
      }
    }

    return userBettingHorseNumber;
}

// ----- checks if player has entered a valid number for betting horse -----
  public static int getValidHorseNumberInput(int minHorseChoice, int maxHorseChoice, Scanner keyboard) {
    boolean isValid = false;

    int userBettingHorseNumber = 0;
    while (!isValid) {
      try {
        userBettingHorseNumber = Integer.parseInt(keyboard.nextLine());
        if (userBettingHorseNumber >= minHorseChoice && userBettingHorseNumber <= maxHorseChoice) {
          isValid = true;
        } else {
          System.out.print("Please enter a number for one of the horses shown in the table (1 - " + maxHorseChoice + "): ");
        }
      } catch (Exception ex) {
        System.out.print("Please enter a valid horse number: ");
      }
    }

    return userBettingHorseNumber;
  }

*/ 

/*
boolean gameOver = false;
while (!gameOver) {
  doRace(minWalletAmount, horses, playerNames, playerWallets, keyboard);
  gameOver = promptForGameOver(keyboard);
}*/

/*
$(document).ready(function(){
  alert("Welcome to Horse Racing!!")
})
*/

$(document).ready(function(){
   
  var dialog, form,

    //emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
    name = $( "#name" ),
    wallet = $( "#wallet" ),
    betting = $( "#betting" ),
    allFields = $( [] ).add( name ).add( wallet ).add( betting ),//.add( password ),
    tips = $( ".validateTips" );
 
  function updateTips( t ) {
    tips
      .text( t )
      .addClass( "ui-state-highlight" );
    setTimeout(function() {
      tips.removeClass( "ui-state-highlight", 1500 );
    }, 500 );
  }
 
  function checkLength( o, n, min, max ) {
    if ( o.val().length > max || o.val().length < min ) {
      o.addClass( "ui-state-error" );
      updateTips( "Length of " + n + " must be between " +
        min + " and " + max + "." );
      return false;
    } else {
      return true;
    }
  }

  // --- checks if player has entered a valid amount of betting money ---
  function checkNum (o, n, min, max) { // fix the check amount for wallet 
    if ( o.val().length > max || o.val().length < min ) {
      o.addClass( "ui-state-error" );
      updateTips( "You can only bet with numeric money. Your betting power also cannot exceed the amount in your wallet, nor be negative." );
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
 
    valid = valid && checkLength( name, "username", 3, 16 );
    valid = valid && checkNum( betting, "betting", 1, 6 );
    //valid = valid && checkLength( wallet, "wallet", 1, 6); 
 
    valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
    valid = valid && checkRegexp( betting, /^([0-9_\d])+$/i, "You can only bet with numeric money. Please enter a number." ); // fix 
    // valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
    // i from regexp makes it case-insensitive

    if ( valid ) {
      playerNames.push(name.val()); // add names
      playerBets.push(parseInt(betting.val()));
      playerWallets.push(parseInt(wallet.val() - betting.val()));

      $( "#users tbody" ).append( "<tr>" +
        "<td>" + name.val() + "</td>" +
        "<td>" + wallet.val() + "</td>" +
        "<td>" + betting.val() + "</td>" +
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
    printHorses();
    document.getElementById("dolphinsInRace").style.visibility = "visible"; 
    document.getElementById("myCanvas").style.visibility = "visible";
  });

  // Continue Button One
  $( "#continueOneBtn" ).button().on( "click", function() {
    document.getElementById("signUp").style.visibility = "visible";
  });
 
} )