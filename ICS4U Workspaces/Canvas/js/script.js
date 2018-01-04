
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

context.font = "30px apercu mono";
context.fillStle = "purple";
context.textAlign = "left";
context.fillText("Hello World", 300, 50);

context.font = "20px apercu mono";
context.strokeText("Hello, again", 300, 100);

context.fillStyle = "#3EF3D7";
context.fillRect(0, 0, 150, 75);

// Create Gradient 
var grd = context.createRadialGradient(95, 50, 5, 90, 60, 100);
grd.addColorStop(0, "red");
grd.addColorStop(1, "white");

// Fill with Gradient
context.fillStyle = grd;
context.fillRect(95, 50, 150, 100);

//var canvas =  document.getElementById("myCanvas");
//var context = canvas.getContext("2d");
context.beginPath();
context.arc(95, 50, 40, 0, 2*Math.PI);
context.stroke();

var img = document.getElementById("dog");
context.drawImage(img, 0, 200);


