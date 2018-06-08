
// Game Objects
var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d"); 
var keystate; // for keyboard states (up, down, right, left keys are pressed)
var frames; // for animation
var score; // player's score (amount of "apples" eaten by snake)
var gameOver = false; // for when player presses gameover button

// --- constant variables --- 
// Amount of columns and rows on grid
var columns = 26; 
var rows = 26;

// IDs
var EMPTY = 0; 
var SNAKE = 1; 
var FRUIT = 2; // "dubbed apple"

// Keyboard Directions (that controls where snake travels)
var left = 0;
var up = 1;
var right = 2; 
var down = 3;

// Key Codes for left, up, right, down arrow keys 
var key_left = 37; // left arrow key
var key_up = 38; // up arrow key
var key_right = 39; // right arrow key
var key_down = 40; // down arrow key

// 2D Grid Data Structure which the "apple" and snake travel on
var grid = {
	width: null, // num of columns
	height: null, // num of rows
	_grid: null, // 2D array grid

	// method: initially fills in grid
	// direction: is just a starting value
	// col: num of columns
	// row: num of rows
	initial: function (direction, col, row) {
		this.width = col;
		this.height = row;
		this._grid = [];
		
		for (var x = 0; x < col; x++) {
			this._grid.push([]);
			for (var y = 0; y < row; y++) {
				this._grid[x].push(direction);
			}
		}
	},

	// method: set value of grid cell, (x, y)
	// value: a num value
	// x: x position
	// y: y position
	set: function (value, x, y) {
		this._grid[x][y] = value;
	},

	// method: get value of grid cell, (x, y)
	// x: x position
	// y: y position
	get: function (x, y) {
		return this._grid[x][y];
	}
}

// the snake uses a queue data structure; snake that player moves
var snake = {
	direction: null, // assigned direction number
	last: null, // last element in queue
	_queue: null, // array for storing queue data structure

	// method: sets initial start position and direction of queue
	initial: function (direction, x, y) {
		this.direction = direction;
		this._queue = [];
		this.insert(x, y);
	},

	// method: adds an element onto queue
	insert: function (x, y) {
		this._queue.unshift({x:x, y:y});
		this.last = this._queue[0];
	},

	// method: removes and returns the first element in queue
	remove: function() {
		return this._queue.pop();
	}
}

// method: randomly sets "apple" at a free grid cell
function setFood() {
	var empty = [];
	
	// find empty grid cells
	for (var x = 0; x < grid.width; x++) {
		for (var y = 0; y < grid.height; y++) {
			if (grid.get(x, y) === EMPTY) {
				empty.push({x:x, y:y});
			}
		}
	}
	var randomPosition = empty[Math.floor(Math.random() * (empty.length-1))]; // selects a random grid cell
	grid.set(FRUIT, randomPosition.x, randomPosition.y); // sets the "apple" to the randomly selected grid cell
}

// main method: starts/controls the game
function main() {
	// canvas
	canvas.width = columns * 20; // width of canvas
	canvas.height = rows * 20; // height of canvas
	
	// context 
	context.font = "15px Cambria"; // for score text in bottom left corner 

	frames = 0; 
	keystate = {};

	// determines keyboard input (which key is pressed)
	document.addEventListener("keydown", function(event) {
		keystate[event.keyCode] = true;
	});
	document.addEventListener("keyup", function(event) {
		delete keystate[event.keyCode];
	});

	// begin game
	initial();
	loop();
}

// method: initiates and resets game objects 
function initial() {
	score = 0;
	
	grid.initial(EMPTY, columns, rows);

	var stopPos = {x:Math.floor(columns/2), y:rows-1};
	snake.initial(up, stopPos.x, stopPos.y);
	grid.set(SNAKE, stopPos.x, stopPos.y);

	setFood();
}

// method: loops the game for updates and drawing objects on canvas
function loop() {
	if (!gameOver) {
		update();
		draw();

		window.requestAnimationFrame(loop, canvas);
	} else {
		endMessage();
	}
}

// method: updates game (which key is pressed, where snake travels, calculates score)
function update() {
	frames++;

	// controlling snake direction with pressed keys (up, right, down, left)
	if (keystate[key_left] && snake.direction !== right) {
		snake.direction = left;
	}
	if (keystate[key_right] && snake.direction !== left) {
		snake.direction = right;
	}
	if (keystate[key_up] && snake.direction !== down) {
		snake.direction = up;
	}
	if (keystate[key_down] && snake.direction !== up) {
		snake.direction = down;
	}

	// game state updates every 5 frames 
	if (frames % 5 === 0) {
		// for popping the last snake queue element (head)
		var nx = snake.last.x;
		var ny = snake.last.y;

		// updating snake position due to direction 
		switch (snake.direction) {
			case left:
				nx--;
				break;
			case up:
				ny--;
				break;
			case right:
				nx++;
				break;
			case down: 
				ny++;
				break;
		}

		// game over conditions 
		if (0 > nx || nx > grid.width-1 || 0 > ny || ny > grid.height-1 || 
			grid.get(nx, ny) === SNAKE) 
		{
			return initial();
		} 

		// determines when snake overlaps "apple" and sets a new position for the "apple"
		if (grid.get(nx, ny) === FRUIT) {
			var tail = {x:nx, y:ny};
			score++; // increments score
			setFood();
		} else { // removes 1st element (tail) from snake queue 
			var tail = snake.remove();
			grid.set(EMPTY, tail.x, tail.y);
			tail.x = nx;
			tail.y = ny;
		}
		// add the new snake id position to snake queue 
		grid.set(SNAKE, tail.x, tail.y);
		snake.insert(tail.x, tail.y);
	}
}

// method: draws objects on grid 
function draw() {
	var tileWidth = canvas.width/grid.width;
	var tileHeight = canvas.height/grid.height;

	for (var x = 0; x < grid.width; x++) {
		for (var y = 0; y < grid.height; y++) {
			// fills the grid cells depending on what id (empty cell, snake cell, apple cell)
			switch (grid.get(x, y)) {
				case EMPTY:
					context.fillStyle = "#0C0C0C";
					break;
				case SNAKE:
					context.fillStyle = "#52C7A7";
					break;
				case FRUIT:
					context.fillStyle = "#E96436";
					break;
			}
			context.fillRect(x*tileWidth, y*tileHeight, tileWidth, tileHeight);
		}
	}
	context.fillStyle = "#000";
	context.fillText("SCORE: " + score, 10, canvas.height-10);
}

// method: closing message
function endMessage() {
	alert("Thank you for playing Snake! You most recently achieved an impressive score of: " + score +"! Have a nice day!! :)");
}

// methods: button actions 
$(document).ready(function(){
	// start game button 
	$( "#startBtn" ).button().on( "click", function() {
	  gameOver = false;
	  main();
	});

	// end game button 
	$( "#endBtn" ).button().on( "click", function() {
	  gameOver = true;
	});
});