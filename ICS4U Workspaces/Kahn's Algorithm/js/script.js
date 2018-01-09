// notes: 
// context.strokeText("hi", 300, 100); <-- border of text 
 
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

// for graph diagram 
var rightPressed = false; // initially not pressed, thus false
document.addEventListener("keydown", keyDownHandler, false); // when pressed, function will be executed 
document.addEventListener("keyup", keyUpHandler, false);
var count = 0; // counts which step topOrder is on

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

// x and y coordinates of the left side of topOrder table
var topOrderX = vTopX - 20;
var topOrderY = vBottomY + 110;


// --- functions --- 

// --- changing steps --- 
// 39 is > key
// 37 is < key
function keyDownHandler(e) { // "e" is an event, parameter 
	if (e.keyCode == 39) {
		rightPressed = true;
	}
}

function keyUpHandler(e) {
	if (e.keyCode == 39) {
		rightPressed = false;
	}
}

title();
adjList();
indegreeList(); 
drawGraph();

// draw title 
function title() {
	context.beginPath();
	context.font = "27px apercu mono";
	context.fillStyle = "purple";
	context.textAlign = "center";
	context.fillText("Kahn\'s Algorithm", myCanvas.width / 2, 50);
	context.closePath();
}

// draw adjacency list of each vertex 
function adjList() {
	context.beginPath()
	context.font = "18px Menlo";
	context.fillStyle = "black";
	context.textAlign = "left";
	context.fillText("adj[] (Outgoing Vertices for Each Vertex)", 50, adjY);
	context.fillText("0:   1,   4,   6", 60, adjY + 20);
	context.fillText("1:   ", 60, adjY + 40);
	context.fillText("2:   6", 60, adjY + 60);
	context.fillText("3:   1,   5,   6", 60, adjY + 80);
	context.fillText("4:   3,   6", 60, adjY + 100);	
	context.fillText("5: ", 60, adjY + 120);	
	context.fillText("6: ", 60, adjY + 140);
	context.closePath();
}

// draw list for indegrees of each vertex
function indegreeList() {
	context.beginPath();
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
	context.closePath();
}

// draw graph 
function drawGraph() {
	drawVertices();
	drawNumbers();
	drawArrows();
	drawTopOrder();
}

// draw vertices
function drawVertices() {
	context.fillStyle = "#CCFFFF";
	context.strokeStyle = "black";
	//context.strokeStyle = "#e2e2da"; ** for after added 

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
	context.beginPath();
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
	context.closePath();
}

// draw arrows
function drawArrows() {
	context.beginPath();
	context.strokeStyle = "#ff0000";
	context.fillStyle = "#ff0000"; 
	// top arrows (following vertex labels are for its outgoing vertices)
	// vertex 0:
	context.moveTo(arrowTopX, arrowTopY);
	context.lineTo(arrowTopX + 70, arrowTopY);
	context.stroke();
	context.fillText(">", arrowTipX, arrowTipY);

	context.moveTo(arrowTopX - 30, arrowTopY + 35);
	context.lineTo(arrowTopX + 28, arrowBottomY - 32);
	context.stroke();

	// arrow tips (different angles) for edges 
	var arrowTip04 = new Image(); 
	arrowTip04.src = "images/arrow_tip_04.PNG"; // vertex 0 - 4 edge 
	context.drawImage(arrowTip04, arrowTopX, arrowBottomY - 32);
	// ***********

	context.moveTo(arrowTopX - 10, arrowTopY + 25);
	context.lineTo(arrowBottomX + 215, arrowBottomY - 20);
	context.stroke();

	// vertex 2:
	context.moveTo(arrowTopX + 252, arrowTopY + 35);
	context.lineTo(arrowBottomX + 235, arrowBottomY - 35);
	context.stroke();
	//context.fillText(">", arrowTipX, arrowTipY); // fix 

	// vertex 3:
	context.moveTo(arrowTopX + 355, arrowTopY + 22);
	context.lineTo(arrowBottomX + 120, arrowBottomY - 30);
	context.stroke();
	// arrow head!!
	context.moveTo(arrowTopX + 375, arrowTopY + 33);
	context.lineTo(arrowBottomX + 255, arrowBottomY - 35);
	context.stroke();
	
	// bottom arrows  
	// vertex 4:
	context.moveTo(arrowTopX + 52, arrowBottomY - 30);
	context.lineTo(arrowTopX + 349, arrowTopY);
	context.stroke();
	context.closePath();
}

// draw vertices in queue
function queue() {

}

// illustrates vertices added to topOrder (topological order) list 
// after it has an indegree of 0
function drawTopOrder() {
	drawTable();
	topOrderText();
	// indexes in topOrder (top row of table)
	context.beginPath();
	context.font = "22px Menlo";
	context.fillStyle = "black";
	context.fillText("0", topOrderX + 28, topOrderY - 8);
	context.fillText("1", topOrderX + 94, topOrderY - 8);
	context.fillText("2", topOrderX + 160, topOrderY - 8);
	context.fillText("3", topOrderX + 226, topOrderY - 8);
	context.fillText("4", topOrderX + 292, topOrderY - 8);
	context.fillText("5", topOrderX + 358, topOrderY - 8);
	context.fillText("6", topOrderX + 424, topOrderY - 8);
	context.closePath();
	topOrderVertices();
}

// text for topOrder
function topOrderText() {
	context.beginPath();
	context.font = "18px Menlo";
	context.fillText("topOrder (holds vertices with indegree 0): ", topOrderX, topOrderY - 40);
	context.fillText("index: ", topOrderX - 70, topOrderY - 8);
	context.fillText("vertices: ", topOrderX - 70, topOrderY + 30);
	context.closePath();
}

// draws the table for the topolocial order list 
function drawTable() {
	context.beginPath();
	// horizontal lines for table
	context.strokeStyle = "black";
	context.moveTo(topOrderX, topOrderY);
	context.lineTo(topOrderX + 462, topOrderY);
	context.stroke();

	context.moveTo(topOrderX, topOrderY - 30);
	context.lineTo(topOrderX + 462, topOrderY - 30);
	context.stroke();

	context.moveTo(topOrderX, topOrderY + 50);
	context.lineTo(topOrderX + 462, topOrderY + 50);
	context.stroke();

	// vertical lines for table
	context.moveTo(topOrderX, topOrderY - 30);
	context.lineTo(topOrderX, topOrderY + 50);
	context.stroke();

	context.moveTo(topOrderX + 66, topOrderY - 30);
	context.lineTo(topOrderX + 66, topOrderY + 50);
	context.stroke();

	context.moveTo(topOrderX + 132, topOrderY - 30);
	context.lineTo(topOrderX + 132, topOrderY + 50);
	context.stroke();

	context.moveTo(topOrderX + 198, topOrderY - 30);
	context.lineTo(topOrderX + 198, topOrderY + 50);
	context.stroke();

	context.moveTo(topOrderX + 264, topOrderY - 30);
	context.lineTo(topOrderX + 264, topOrderY + 50);
	context.stroke();

	context.moveTo(topOrderX + 330, topOrderY - 30);
	context.lineTo(topOrderX + 330, topOrderY + 50);
	context.stroke();

	context.moveTo(topOrderX + 396, topOrderY - 30);
	context.lineTo(topOrderX + 396, topOrderY + 50);
	context.stroke();

	context.moveTo(topOrderX + 462, topOrderY - 30);
	context.lineTo(topOrderX + 462, topOrderY + 50);
	context.stroke();

	context.closePath();
}

// vertices in topOrder with indegree 0
function topOrderVertices() {
	if (rightPressed && count === 0) {
		// indegree list
		context.strokeStyle = "blue";
		context.fillText("0:   0", 60, inY + 20);
		context.fillText("2:   0", 60, inY + 60);
		// topOrder table
		context.fillText("0", topOrderX + 28, topOrderY + 20);
		context.fillText("2", topOrderX + 94, topOrderY + 20);
	}
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


