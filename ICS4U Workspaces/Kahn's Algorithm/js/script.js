// notes: 
// context.strokeText("hi", 300, 100); <-- border of text 
 
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");

// for graph diagram 
var count = 0; // counts which step topOrder is on
document.getElementById("beginBtn").addEventListener("click", startButton); // start button
document.getElementById("btnOne").addEventListener("click", buttonOne); // step 1 button
document.getElementById("btnTwo").addEventListener("click", buttonTwo); // step 2 button
document.getElementById("btnThree").addEventListener("click", buttonThree); // step 2 button
document.getElementById("btnFour").addEventListener("click", buttonFour); // step 2 button
document.getElementById("btnFive").addEventListener("click", buttonFive); // step 2 button
document.getElementById("sortedBtn").addEventListener("click", sortedButton); // step 2 button


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
var topOrderY = vBottomY + 160;


// --- functions --- 

// --- go --- 
title();
function drawBackground() {
	title();
	adjList();
	indegreeList(); 
	drawGraph();
}

// start button for diagram steps 
function startButton() {
	alert ("Hi! Please click on the following buttons beside me for the next steps to see how Kahn's Algorithm works!\n\nCheck out Step 1!");
	drawBackground();
}

function buttonOne() {
	count = 1;
	alert ("Step 1:\nVertices 0 and 2 have an in-degree of 0. Add them to topOrder list.");
	context.clearRect(0, 0, myCanvas.width, myCanvas.height);
	drawBackground();
	context.beginPath()
	context.font = "18px Menlo";
	context.fillStyle = "#6593F5";
	// indegree list
	context.fillText("0:   0", 60, inY + 20);
	context.fillText("2:   0", 60, inY + 60);
	// topOrder table
	context.font = "22px Menlo";
	context.fillText("0", topOrderX + 28, topOrderY + 30);
	context.fillText("2", topOrderX + 94, topOrderY + 30);
	context.closePath();
}

function buttonTwo() {
	count = 2;
	alert ("Step 2:\nLet\'s take a look at vertex 0. For its adjacent vertices 1, 4, and 6, decrement in-degrees by one. If in-degrees for adjacent vertices (like 3) become 0, add them to topOrder.");
	context.clearRect(0, 0, myCanvas.width, myCanvas.height);
	drawBackground();

	context.beginPath()
	context.font = "18px Menlo";
	context.fillStyle = "#6593F5";
	// adj list
	context.fillText("0:   1,   4,   6", 60, adjY + 20);
	// indegree list
	context.fillText("1:   1", 60, inY + 40);
	context.fillText("4:   0", 60, inY + 100);	
	context.fillText("6:   3", 60, inY + 140);
	context.fillStyle = "black";
	context.fillText("0:   0", 60, inY + 20);
	context.fillText("2:   0", 60, inY + 60);
	// topOrder table
	context.font = "22px Menlo";
	context.fillStyle = "#6593F5";
	context.fillText("4", topOrderX + 160, topOrderY + 30);
	context.fillStyle = "black";
	context.fillText("0", topOrderX + 28, topOrderY + 30);
	context.fillText("2", topOrderX + 94, topOrderY + 30);
}

function buttonThree() {
	count = 3;
	alert ("Step 3:\nLet\'s take a look at vertex 2. For its adjacent vertex 6, decrement its in-degree by one to 2.");
	context.clearRect(0, 0, myCanvas.width, myCanvas.height);
	drawBackground();
	context.beginPath()
	context.font = "18px Menlo";
	context.fillStyle = "#6593F5";
	// adj list
	context.fillText("2:   6", 60, adjY + 60);
	// indegree list
	context.fillText("6:   2", 60, inY + 140);
	// topOrder table
	context.font = "22px Menlo";
	context.fillStyle = "black";
	context.fillText("0", topOrderX + 28, topOrderY + 30);
	context.fillText("2", topOrderX + 94, topOrderY + 30);
	context.fillText("4", topOrderX + 160, topOrderY + 30);
	context.closePath();
}

function buttonFour() {
	count = 4;
	alert ("Step 4:\nLet\'s take a look at vertex 4. For its adjacent vertices 3 and 6, decrement in-degrees by one. In-degree for adjacent vertex 3 becomes 0, add it to topOrder.");
	context.clearRect(0, 0, myCanvas.width, myCanvas.height);
	drawBackground();
	context.beginPath()
	context.font = "18px Menlo";
	context.fillStyle = "#6593F5";
	// adj list
	context.fillText("4:   3,   6", 60, adjY + 100);
	// indegree list
	context.fillText("3:   0", 60, inY + 80);
	context.fillText("6:   1", 60, inY + 140);
	// topOrder table
	context.font = "22px Menlo";
	context.fillText("3", topOrderX + 226, topOrderY + 30);
	context.fillStyle = "black";
	context.fillText("0", topOrderX + 28, topOrderY + 30);
	context.fillText("2", topOrderX + 94, topOrderY + 30);
	context.fillText("4", topOrderX + 160, topOrderY + 30);
	context.closePath();
}

function buttonFive() {
	count = 5;
	alert ("Step 5:\nLet\'s take a look at vertex 3. For its adjacent vertex 6, decrement its in-degree by one. In-degree for adjacent vertex 6 becomes 0, add it to topOrder.\n\nThere are no outgoing adjacent vertices for the remaining vertices 1, 5, and 6 in topOrder.\n\nThus, the graph is now sorted topologically!!");
	context.clearRect(0, 0, myCanvas.width, myCanvas.height);
	drawBackground();
	context.beginPath()
	context.font = "18px Menlo";
	context.fillStyle = "#6593F5";
	// adj list
	context.fillText("3:   1,   5,   6", 60, adjY + 80);
	// indegree list
	context.fillText("1:   0", 60, inY + 40);
	context.fillText("5:   0", 60, inY + 120);	
	context.fillText("6:   0", 60, inY + 140);
	// topOrder table
	context.font = "22px Menlo";
	context.fillText("5", topOrderX + 358, topOrderY + 30);
	context.fillText("6", topOrderX + 424, topOrderY + 30);
	context.fillStyle = "black";
	context.fillText("0", topOrderX + 28, topOrderY + 30);
	context.fillText("2", topOrderX + 94, topOrderY + 30);
	context.fillText("4", topOrderX + 160, topOrderY + 30);
	context.fillText("3", topOrderX + 226, topOrderY + 30);
	context.fillText("1", topOrderX + 292, topOrderY + 30);
	context.closePath();
}

function sortedButton() {
	count = 6;
	alert ("The graph is now sorted topologically!! :)");
	context.clearRect(0, 0, myCanvas.width, myCanvas.height);
	drawBackground();
	context.beginPath()
	context.fillStyle = "#477ef3";
	context.font = "22px Menlo";
	// topOrder table
	context.fillText("5", topOrderX + 358, topOrderY + 30);
	context.fillText("6", topOrderX + 424, topOrderY + 30);
	context.fillText("0", topOrderX + 28, topOrderY + 30);
	context.fillText("2", topOrderX + 94, topOrderY + 30);
	context.fillText("4", topOrderX + 160, topOrderY + 30);
	context.fillText("3", topOrderX + 226, topOrderY + 30);
	context.fillText("1", topOrderX + 292, topOrderY + 30);
	context.closePath();
}

// draw title 
function title() {
	context.beginPath();
	context.font = "27px apercu mono";
	context.fillStyle = "#1D7CF2";
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

	if (count === 2) {
		context.clearRect(60, inY + 20, 50, 26);
		context.clearRect(60, inY + 80, 50, 20);
		context.clearRect(60, inY + 120, 50, 20);
	} else if (count === 3) {
		context.clearRect(60, inY + 20, 50, 26);
		context.clearRect(60, inY + 80, 50, 20);
		context.clearRect(60, inY + 120, 50, 20);
		context.fillText("1:   1", 60, inY + 40); 
		context.fillText("4:   0", 60, inY + 100);
	} else if (count === 4) {
		context.clearRect(60, inY + 20, 50, 26);
		context.clearRect(60, inY + 60, 50, 20);
		context.clearRect(60, inY + 80, 50, 20);
		context.clearRect(60, inY + 120, 50, 20);
		context.fillText("1:   1", 60, inY + 40); 
		context.fillText("4:   0", 60, inY + 100);
	} else if (count === 5) {
		context.clearRect(60, inY + 20, 50, 20);
		context.clearRect(60, inY + 60, 50, 20);
		context.clearRect(60, inY + 80, 50, 20);
		context.clearRect(60, inY + 100, 50, 50); 
		context.fillText("3:   0", 60, inY + 80);
		context.fillText("4:   0", 60, inY + 100);
	} else if (count === 6) {
		context.clearRect(60, inY + 20, 50, 20);
		context.clearRect(60, inY + 60, 50, 100);
		context.fillText("1:   0", 60, inY + 40);
		context.fillText("3:   0", 60, inY + 80);
		context.fillText("4:   0", 60, inY + 100);
		context.fillText("5:   0", 60, inY + 120);	
		context.fillText("6:   0", 60, inY + 140);
	}
}

// --- draw graph ---
function drawGraph() {
	drawVertices();
	drawNumbers();
	drawArrows();
	drawTopOrder();
}

// draw vertices
function drawVertices() {
	context.fillStyle = "#E6E6FF";//"#F2D9FF";//"#CCFFFF";
	context.strokeStyle = "#A7CCD1";
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
	context.strokeStyle = "#6593F5";
	context.fillStyle = "#6593F5"; 
	// top arrows (following vertex labels are for its outgoing vertices)
	// vertex 0:
	context.moveTo(arrowTopX, arrowTopY);
	context.lineTo(arrowTopX + 70, arrowTopY);
	context.stroke();
	context.fillText(">", arrowTipX, arrowTipY);

	context.moveTo(arrowTopX - 30, arrowTopY + 35);
	context.lineTo(arrowTopX + 28, arrowBottomY - 32);
	context.stroke();

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
	arrowTips();
}

// arrow tips (different angles) / arched arrows for edges 
function arrowTips() {
	var arrowTip04 = new Image(); 
	arrowTip04.src = "images/arrow_tip_04.PNG"; // vertex 0 - 4 edge 
	arrowTip04.onload = function (e){
    	context.drawImage(arrowTip04, arrowTopX + 13, arrowBottomY - 55, 18, 25);
    }

    var arrowTip06 = new Image(); 
	arrowTip06.src = "images/arrow_tip_06.PNG"; // vertex 0 - 4 edge 
	arrowTip06.onload = function (e){
    	context.drawImage(arrowTip06, arrowTopX + 265, arrowBottomY - 38, 24, 23);
    }

    var arrowTip26 = new Image(); 
    arrowTip26.src = "images/arrow_tip_26.PNG"; // vertex 2 - 6 edge 
	arrowTip26.onload = function (e){
    	context.drawImage(arrowTip26, arrowTopX + 291, arrowBottomY - 55, 22, 24);
    }

    var arrow31 = new Image(); 
	arrow31.src = "images/arrow_31.png"; // vertex 3 - 1 edge 
	arrow31.onload = function (e){
    	context.drawImage(arrow31, arrowTopX + 76, arrowTopY - 76, 300, 60);
    }
    var arrowTip31 = new Image(); 
	arrowTip31.src = "images/arrow_tip_35.png"; // vertex 3 - 1 edge 
	arrowTip31.onload = function (e){
    	context.drawImage(arrowTip31, arrowTopX + 103, arrowTopY - 57, 20, 23);
    }

    var arrowTip35 = new Image(); 
    arrowTip35.src = "images/arrow_tip_35.PNG"; // vertex 3 - 5 edge 
	arrowTip35.onload = function (e){
    	context.drawImage(arrowTip35, arrowTopX + 187, arrowBottomY - 50, 20, 23);
    }

    var arrowTip36 = new Image(); 
    arrowTip36.src = "images/arrow_tip_36.PNG"; // vertex 3 - 6 edge 
	arrowTip36.onload = function (e){
    	context.drawImage(arrowTip36, arrowTopX + 318, arrowBottomY - 52, 20, 22);
    }

    var arrowTip43 = new Image(); 
    arrowTip43.src = "images/arrow_tip_43.PNG"; // vertex 4 - 3 edge 
	arrowTip43.onload = function (e){
    	context.drawImage(arrowTip43, arrowTopX + 329, arrowTopY - 6, 25, 23);
    }

    var arrow46 = new Image(); 
	arrow46.src = "images/arrow_46.png"; // vertex 4 - 6 edge 
	arrow46.onload = function (e){
    	context.drawImage(arrow46, arrowTopX + 50, arrowBottomY + 10, 300, 60);
    }
    var arrowTip46 = new Image(); 
	arrowTip46.src = "images/arrow_tip_43.PNG"; // vertex 4 - 6 edge 
	arrowTip46.onload = function (e){
    	context.drawImage(arrowTip46, arrowTopX + 297, arrowBottomY + 29, 25, 23);
    }
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
	//changeSlide();
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