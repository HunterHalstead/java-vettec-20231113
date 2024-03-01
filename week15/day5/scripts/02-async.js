// JavaScript is single threaded
// The JS engine has a stack, heap, and queue
// so callback functions can get pushed onto the queue an executed asynchrounsly

// synchronous execution
console.log("first")
console.log("second")
console.log("third")

// asynchronous - allows certain operations (like data fetching) to occur concurrently
// - necessary to avoid blocking the webpage from doing other things like processing user input

// setTimeout - executes once after a delay (in ms)
setTimeout(() => console.log("Happy Belated Birthday!"), 2000); // 2sec


// setInterval - executes repeatedly at a given interval
let x = 1;
let id = setInterval(() => console.log(x++), 1000); // repeat every sec

// stop the interval after 10sec
setTimeout(() => clearInterval(id), 10000); // wait 10sec 

// Update the content of the div every second

let myDiv = document.getElementById("my-div");
let counter = 1;
setInterval(() => { myDiv.innerText = ++counter }, 1000);