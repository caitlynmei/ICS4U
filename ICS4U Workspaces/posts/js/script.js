function hoverAction(){
	//console.log('hi');
	//alert('bye');
	
	var el = document.getElementById('sample'); // don't care what type of variable, grabs the element by id
	el.style.color = 'green'; // each element has a style property which is a map with key as the css property 


	var arr = arrayPractice();
	//arr[7]();
	
	var answer = bigMathFunction(1, 20);

	var mapMe = mapPractice();

	var elements = document.querySelectorAll('h1'); // returns an array - same selector rules as array
	var i;
	for (i=0; i<elements.length; i++){
		elements[i].style.color = mapMe.color;
	}

	var mapMe2 = mapPractice2();

}

/* We can return values from a function but we do not need to specify the type */
/* We can accept agruments but again we do not have to specify the type */

function bigMathFunction(i, j){
	var count;
	var sum = 0;
	for (count = i; count <=j; count++){
		sum += count;
	}

	var evenOdd = (sum%2==0) ? 'even' : 'odd';

	/*if (sum%2 == 0){*/
	var el = document.getElementById('p2');
	el.innerHTML = '<img src="images/dog.jpg" widge = "25%"/>';
	//document.location = "amazon....";
	console.log('This is the sum: ' + sum + ' and it is ' + evenOdd);
	/*} else {
		console.log('This is the sum: ' + sum + ' and it is odd');
	}*/


	console.log('This is the sum: ' + sum);

	return sum;
}

function arrayPractice(){
	var arr = []; // who cares about size 

	arr[0] = 'hi';
	arr[1] = 6;
	arr[8] = true;
	arr[7] = fn;

	var i = 0;
	for (i = 0; i<arr.length; i++){
		if (arr[i] !== undefined){
			console.log(arr[i]);
		}
	}

	return arr;
}

var fn = function(){
	alert(1);
}

function mapPractice(){
	var obj = {};
	obj.color = 'red';
	obj['color'] = 'blue';

	var ex = 'color';
	obj[ex] = 'yellow';

	return obj;
}

function mapPractice2(){
	var objArr = {};

	var i;
	for (i = 0; i<10; i++){
		objArr[i] = 'hi';
	}

	//objArr['hi'] = objArr; // not a good idea 

	return objArr;
}