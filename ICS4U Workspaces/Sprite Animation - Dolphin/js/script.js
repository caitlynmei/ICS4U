
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");
 
var myImage = new Image();
<<<<<<< HEAD
myImage.src = "images/Dolphin.png";
=======
myImage.src = "images/Dolphin_Sprite4New.png";
>>>>>>> 72e269c0cf167053281d51d40f03a60971d3cadb
myImage.addEventListener("load", loadImage, false);
 
function loadImage(e) {
  animate();
}

// variables 
var shift = 0; // onto the next sprite image
var frameWidth = 196.57;//148.5;
var frameHeight = 198;//161;
var totalFrames = 4;
var currentFrame = 0; // counter 

// animation
function animate() {
  context.clearRect(120, 25, 196.57, 198);
  //context.clearRect(120, 25, 300, 300);
 
  //draw each frame + place them in the 4iddle
  context.drawImage(myImage, shift, 0, frameWidth, frameHeight,
                    120, 25, frameWidth, frameHeight);
 
  shift += frameWidth + 1;
 
  /*
    Start at the beginning once you've reached the
    end of your sprite!
  */
  if (currentFrame == (totalFrames-1)) {
    shift = 0;
    currentFrame = 0;
  }
 
  currentFrame++;
}

setInterval(animate, 600);