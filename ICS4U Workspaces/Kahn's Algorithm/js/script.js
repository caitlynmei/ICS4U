// notes: 
// context.strokeText("hi", 300, 100); <-- border of text 
 
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

// first y coordinate for adj list
var adjY = 150;

// first y coordinate for indegree list
var inY = 350;

// x and y coordinates of first vertex on top row
var vTopX = 500; // x coordinate
var vTopY = 150; // y coordinate 

// x and y coordinates of first vertex on bottom row
var vBottomX = 570; // x coordinate
var vBottomY = 350; // y coordinate 

// x coordinates for first label number of vertices 
var numTopX = vTopX - 7; // top x coordinate
var numBottomX = vBottomX - 7; // bottom x coordinate

// y coordinates for first label number of vertices 
var numTopY = vTopY + 9; // top y coordinate
var numBottomY = vBottomY + 9; // bottom y coordinate

// x and y coordinates for first arrow line on top row
var arrowTopX = vTopX + 35; // top x coordinate
var arrowTopY = vTopY; // top y coordinate

// x and y coordinates for first arrow line on bottom row
var arrowBottomX = vBottomX + 36; // bottom x coordinate
var arrowBottomY = vBottomY; // bottom y coordinate

// x and y coordinate for first arrow tip
var arrowTipX = arrowTopX + 55;
var arrowTipY = vTopY + 10;


title();
adjList();
indegreeList(); 
drawGraph();

// draw title 
function title() {
	context.font = "27px apercu mono";
	context.fillStyle = "purple";
	context.textAlign = "center";
	context.fillText("Kahn\'s Algorithm", myCanvas.width / 2, 50);
}

// draw adjacency list of each vertex 
function adjList() {
	context.font = "18px Menlo";
	context.fillStyle = "black";
	context.textAlign = "left";
	context.fillText("Adjacency List of Each Vertex (Outgoing Vertices)", 50, adjY);
	context.fillText("0:   1,   4,   6", 60, adjY + 20);
	context.fillText("1:   ", 60, adjY + 40);
	context.fillText("2:   6", 60, adjY + 60);
	context.fillText("3:   1,   5,   6", 60, adjY + 80);
	context.fillText("4:   3,   6", 60, adjY + 100);	
	context.fillText("5: ", 60, adjY + 120);	
	context.fillText("6: ", 60, adjY + 140);
}

// draw list for indegrees of each vertex
function indegreeList() {
	context.font = "18px Menlo";
	context.fillStyle = "black";
	context.textAlign = "left";
	context.fillText("In-degrees of Each Vertex", 50, inY);
	context.fillText("0:   0", 60, inY + 20);
	context.fillText("1:   2", 60, inY + 40);
	context.fillText("2:   0", 60, inY + 60);
	context.fillText("3:   1", 60, inY + 80);
	context.fillText("4:   1", 60, inY + 100);	
	context.fillText("5:   1", 60, inY + 120);	
	context.fillText("6:   4", 60, inY + 140);
}

// draw graph 
function drawGraph() {
	drawVertices();
	drawNumbers();
	drawArrows();	
}

// draw vertices
function drawVertices() {
	context.fillStyle = "#CCFFFF"; 

	// top row of vertices
	context.beginPath();
	context.arc(vTopX, vTopY, 25, 0, 2*Math.PI, false);
	context.fill();
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(vTopX + 140, vTopY, 25, 0, 2*Math.PI, false);
	context.fill();
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(vTopX + 280, vTopY, 25, 0, 2*Math.PI, false);
	context.fill();
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(vTopX + 420, vTopY, 25, 0, 2*Math.PI, false);
	context.fill();
	context.stroke();
	context.closePath();

	// bottom row of vertices 
	context.beginPath();
	context.arc(vBottomX, vBottomY, 25, 0, 2*Math.PI, false);
	context.fill();
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(vBottomX + 140, vBottomY, 25, 0, 2*Math.PI, false);
	context.fill();
	context.stroke();
	context.closePath();
	context.beginPath();
	context.arc(vBottomX + 280, vBottomY, 25, 0, 2*Math.PI, false);
	context.fill();
	context.stroke();
	context.closePath();
}

// label numbers of each vertex 
function drawNumbers() {
	context.font = "30px Menlo";
	context.fillStyle = "black";
	context.textAlign = "left";

	// top vertices
	context.fillText("0", numTopX, numTopY);
	context.fillText("1", numTopX + 140, numTopY);
	context.fillText("2", numTopX + 280, numTopY);
	context.fillText("3", numTopX + 420, numTopY);

	// bottom vertices 
	context.fillText("4", numBottomX, numBottomY);
	context.fillText("5", numBottomX + 140, numBottomY);
	context.fillText("6", numBottomX + 280, numBottomY);
}

// draw arrows
function drawArrows() {
	// top arrows (following vertex labels are for its outgoing vertices)
	// vertex 0:
	context.moveTo(arrowTopX, arrowTopY);
	context.lineTo(arrowTopX + 70, arrowTopY);
	context.strokeStyle = "#ff0000";
	context.stroke();
	context.fillStyle = "#ff0000"; 
	context.fillText(">", arrowTipX, arrowTipY);

	// vertex 2:
	context.moveTo(arrowTopX + 252, arrowTopY + 35);
	context.lineTo(arrowBottomX + 235, arrowBottomY - 35);
	context.stroke();
	//context.fillText(">", arrowTipX, arrowTipY); // fix 

	// vertex 3:
	context.moveTo(arrowTopX + 355, arrowTopY + 22);
	context.lineTo(arrowBottomX + 120, arrowBottomY - 35);
	context.stroke();
	// arrow head!!
	context.moveTo(arrowTopX + 375, arrowTopY + 33);
	context.lineTo(arrowBottomX + 255, arrowBottomY - 35);
	context.stroke();
	
	// bottom arrows  
	// vertex 4:
	

	// vertex 5: 
	// vertex 6:
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


