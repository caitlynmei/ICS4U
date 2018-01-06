// notes: 
// context.strokeText("hi", 300, 100); <-- border of text 


var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

title();
adjList();
indegreeList(); 
drawGraph();

// draw title 
function title() {
	context.font = "30px apercu mono";
	context.fillStyle = "purple";
	context.textAlign = "center";
	context.fillText("Hello World", myCanvas.width/2, 50);
}

// draw adjacency list of each vertex 
function adjList() {
	context.font = "18px Palatino Linotype";
	context.fillStyle = "black";
	context.textAlign = "left";
	context.fillText("Adjacency List of each vertex (outgoing vertices)", 50, 100);
	context.fillText("0: 1, 4, 6", 60, 130);
	context.fillText("1: ", 60, 150);
	context.fillText("2: 6", 60, 170);
	context.fillText("3: 1, 5, 6", 60, 190);
	context.fillText("4: 3, 6", 60, 210);	
	context.fillText("5: ", 60, 230);	
	context.fillText("6: ", 60, 250);
}

// draw list for indegrees of each vertex
function indegreeList() {
	context.font = "18px Palatino Linotype";
	context.fillStyle = "black";
	context.textAlign = "left";
	context.fillText("In-degrees of each vertex", 50, 300);
	context.fillText("0: 0", 60, 330);
	context.fillText("1: 2", 60, 350);
	context.fillText("2: 0", 60, 370);
	context.fillText("3: 1", 60, 390);
	context.fillText("4: 1", 60, 410);	
	context.fillText("5: 1", 60, 430);	
	context.fillText("6: 4", 60, 450);
}

// draw graph 
function drawGraph() {
	// top row of vertices
	context.beginPath();
	context.arc(500, 120, 25, 0, 2*Math.PI, false);
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(640, 120, 25, 0, 2*Math.PI, false);
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(780, 120, 25, 0, 2*Math.PI, false);
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(920, 120, 25, 0, 2*Math.PI, false);
	context.stroke();
	context.closePath();
	context.beginPath();

	// bottom row of vertices 
	context.beginPath();
	context.arc(570, 300, 25, 0, 2*Math.PI, false);
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(710, 300, 25, 0, 2*Math.PI, false);
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(850, 300, 25, 0, 2*Math.PI, false);
	context.stroke();
	context.closePath();
}

 

/*
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
*/


