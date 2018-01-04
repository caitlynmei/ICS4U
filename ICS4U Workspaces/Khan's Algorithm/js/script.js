var slideIndex = 1;
showSlides(slideIndex);

// Next / Previous Controls
function plusSlides(num) {
	showSlides(slideIndex += num);
}

// Thumbnail Image Controls
function currentSlide(num) {
	showSlides(slideIndex = num);
}

function showSlides(num){
	var i;
	var slides = document.getElementByClassName("mySlides");
	var dots = document.getElementByClassName("dot");

	if (num > slides.length) {
		slideIndex = 1;
	}
	if (num < 1) {
		slideIndex = slides.length;
	}

	for (i = 0; i < slides.length; i++){
		slides[i].style.display = "none";
	}

	for (i = 0; i < dots.length; i++){
		dots[i].className.replace("active", "");
	}

	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += "active";
}


var canvas = document.getElementById('myCanvas');
var context = canvas.getContext('2d');

var circleRadius = 20;

var x = canvas.width / 2;
var y = canvas.height - 30;

drawTitle();

function drawTitle() {
	context.font = '20px Georgia';
	context.fillStyle = '#1B71DC';
	context.fillText('Khan\'s Topological Sorting Algorithm', x - 160, 45);
}

function drawCircle() {
	context.beginPath();
	context.fillStyle = '#1B71DC';
	context.fillStroke = 'black';
	context.strokeStyle = 'white';
	context.font = '20px Arial';
	context.lineWidth = 10;

	context.arc(canvas.width - 544, canvas.height - 355, circleRadius, 0, Math.PI*2, false);
	context.arc(canvas.width - 544, canvas.height - 280, circleRadius, 0, Math.PI*2, false);
	//context.arc(canvas.width - 544, canvas.height - 355, circleRadius, 0, Math.PI*2, false);
	//context.arc(canvas.width - 544, canvas.height - 355, circleRadius, 0, Math.PI*2, false);
	//context.arc(canvas.width - 544, canvas.height - 355, circleRadius, 0, Math.PI*2, false);
	context.fill();
	
	context.beginPath();
	context.fillStyle = 'white';
	context.fillText('A', canvas.width - 550, canvas.height - 350);
	context.fill();

	context.closePath();
}

function draw(){
		
	drawCircle();
}

setInterval(draw, 10);