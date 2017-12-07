//var x = document.getQuerySelectorAll('.class1');
// document.location.href = "";
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d"); // 2D rendering context
var ballRadius = 30; // orig 10

var x = canvas.width / 2;
var y = canvas.height - 30;
var dx = 2;
var dy = -2;

var ballColour = getRandomColor();

// --- paddle --- 
var paddleHeight = 10;
var paddleWidth = 75;
var paddleX = (canvas.width - paddleWidth) / 2;

var rightPressed = false; // initially not pressed, thus false
var leftPressed = false;

// --- bricks ---
var brickRowCount = 3;
var brickColumnCount = 5;
var brickWidth = 75;
var brickHeight = 20;
var brickPadding = 5;
var brickOffsetTop = 30;
var brickOffsetLeft = 30;

var bricks = [];
var c;
var  r;
for (c = 0; c < brickColumnCount; c++) {
	bricks[c] = [];
	for (r = 0; r < brickRowCount; r++) {
		bricks[c][r] = { x: 0, y: 0, status: 1 };
	}
}
// --- extra ---
//var dropMe = drop();

var score = 0;
var lives = 3;

var hearts = new Array(lives);

document.addEventListener("keydown", keyDownHandler, false); // when pressed, function will be executed 
document.addEventListener("keyup", keyUpHandler, false);
document.addEventListener("mousemove", mouseMoveHandler, false);

// --- functions --- 

// --- mouse ---
function mouseMoveHandler(e) {
	var relativeX = e.clientX - canvas.offsetLeft;
	if (relativeX > 0 && relativeX < canvas.width) {
		paddleX = relativeX - paddleWidth / 2;
	}
}

// --- paddle --- 
function keyDownHandler(e) { // "e" is an event, parameter 
	if (e.keyCode == 39) {
		rightPressed = true;
	}

	else if (e.keyCode == 37) {
		leftPressed = true;
	}
}

function collosionDetection() {
	for (c = 0; c < brickColumnCount; c++) {
		for (r = 0; r < brickRowCount; r++) {
			var b = bricks[c][r];
			if (b.status == 1){
				if (x > b.x && x < b.x + brickWidth && y > b.y && y < b.y + brickHeight) {
					dy = -dy;
					b.status = 0;
					score++;
					if (score == brickRowCount * brickColumnCount) {
						alert("YOU WIN, CONGRATULATIONS!!");
						document.location.href = "levelTwo.html";
						//document.location.reload();
					}
				}
			}
		}
	}
}

function drawScore() {
	context.font = "16px Arial";
	context.fillStyle = "#494C5D";
	context.fillText("Score: " + score, 8, 20); // last 2 is coordinates 
}

function drawLives() {
	/*
	var livesImg = new Image();
	livesImg.src = "images/Lives.PNG";
	var livesX = canvas.width - 115;
	var livesY = 5;
	context.drawImage(livesImg, livesX, livesY, 30, 30);
	*/
	context.font = "16px Arial";
	context.fillStyle = "#494C5D";
	context.fillText("Lives: ", canvas.width - 115, 20); // 3rd is maxWidth 
	drawHearts();
}

function drawHearts() {
	var heartImg = new Image();
	heartImg.src = "images/Heart.PNG";
	for (i = 0; i < lives; i++){
		var heartX = (canvas.width - 75) + (20 * i);
		var heartY = 1;
		context.drawImage(heartImg, heartX, heartY, 30, 30);
	}
}

function keyUpHandler(e) {
	if (e.keyCode == 39) {
		rightPressed = false;
	}

	else if (e.keyCode == 37) {
		leftPressed = false;
	}
}

// --- drawing --- 
function drawBall() {
	var ballImg = new Image();
	ballImg.src = "images/Ball.PNG";
	//var ballX = (canvas.width - 75) + (20 * i);
	context.drawImage(ballImg, x, y, ballRadius, ballRadius);

	/*
	context.beginPath();
	context.arc(x, y, ballRadius, 0, Math.PI*2);
	context.fillStyle = ballColour;
	context.fillStroke = ballColour;
	context.fill();
	context.closePath();
	*/

}

function drawPaddle() {
	context.beginPath();
	context.rect(paddleX, canvas.height - paddleHeight, paddleWidth, paddleHeight);
	context.fillStyle = "#21B3D2";
	context.fill();
	context.closePath();
}

function drawBricks() {
	for (c = 0; c < brickColumnCount; c++) {
		for (r = 0; r < brickRowCount; r++) {
			if (bricks[c][r].status == 1) { // if status == 1, draw; if status == 0, don't 
				var brickX = (c * (brickWidth + brickPadding)) + brickOffsetLeft;
				var brickY = (r * (brickWidth + brickPadding)) + brickOffsetTop;
				bricks[c][r].x = brickX; // setting x position of each brick 
				bricks[c][r].y = brickY;

				context.beginPath();
				context.rect(brickX, brickY, brickWidth, brickHeight); // printing a brick 
				context.fillStyle = ballColour;
				context.fill();
				context.closePath();
			}
		}
	}
}

function draw(){
	context.clearRect(0, 0, canvas.width, canvas.height); // 1 & 2) x, y coord of top left, 3 & 4) x, y coord of bottom right 
	drawBricks();
	drawBall();
	drawPaddle();
	drawScore();
	drawLives();
	//drawHearts();
	collosionDetection();

	// bouncing off the left and right 
	if (x + dx > canvas.width - ballRadius || x + dx < ballRadius){
		dx = -dx; 
		ballColour = getRandomColor();
	}

	// bouncing off top & game over on bottom 
	if (y + dy < ballRadius){
		dy = -dy; // reverse movement of ball
		ballColour = getRandomColor();
	}
	else if (y + dy > canvas.height - ballRadius) {
		if (x > paddleX && x < paddleX + paddleWidth) {
			dy = -dy;
			ballColour = getRandomColor();
		} 
		else {
			lives--;
			if (!lives) {
				alert("GAME OVER");
				document.location.reload();
			}
			else {
				x = canvas.width / 2;
				y = canvas.height - 30;
				dx = 2;
				dy = -2;
				paddleX = (canvas.width - paddleWidth) / 2;
			}
		}
	}

	// moving the paddle 
	if (rightPressed && paddleX < canvas.width - paddleWidth) {
		paddleX += 7;
	} 
	else if (leftPressed && paddleX > 0) {
		paddleX -= 7;
	}

	x += dx;
	y += dy;

	requestAnimationFrame(draw); 
	/* ^ draw() function is executed again and again within this loop give control of 
	 * framerate to browser, it will sync the framerate accordingly and render the 
	 * shaped only when needed.
	 * --> produces more efficient and smoother animation loop than setInterval() method  
	 */
}

draw();

//setInterval(draw, 10); // call every 10 milliseconds 

function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var ballColour = '#';
  var i;
  for (i = 0; i < 6; i++) {
    ballColour += letters[Math.floor(Math.random() * 16)];
  }
  return ballColour;
}

/*
function drop() {
	var item = BLOCKS.block({
		slices: [{
			name: "falling",
			scr: "images/creamsicle.png"
		}, {
			name: "crashed",
			scr: "images/creamsicle-broken.png"
		}
	}]
});
*/
/*
// --- lesson 1: declaring ---
// --- rectangle --- 
context.beginPath();
context.rect(20, 40, 50, 50); // defining rectangle 
// ^ 1st 2 # specify coordinates of the top left corner, 2nd 2 # specify width and height
context.fillStyle = "#EF0E2E"; // stores a colour
context.fill(); // paints the rectangle 
context.closePath();

// --- circle --- 
context.beginPath();
context.arc(240, 160, 20, 0, Math.PI*2, false);
// ^ 1 & 2) x, y coordinates of arc's center, 3) arc radius, 4) start angle and end angle (rad)
// 5) direction of drawing (false for clockwise, true for cc) 
context.fillStyle = "green";
context.fill();
context.closePath();

// --- empty rectangle --- 
context.beginPath();
context.rect(160, 10, 100, 40);
context.strokeStyle = "rgba(0, 0, 255, 0.5)";
context.stroke(); // colour on outer stroke 
context.closePath();
*/