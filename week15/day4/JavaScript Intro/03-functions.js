// Declaring a function
function myFunction() {
    console.log("my function is awesome!")
}

function hello(name) {
    // console.log("hello " + name);
    // Use a template literal!
    console.log(`hello ${name}`); // backticks with ${} to reference variable's values
}
// Calling a function
myFunction();
hello("george");

///////////////////////////////
// Aside: Template literals - declared with back-ticks
let temp = `hello
there
this 
is 
cool`;
console.log(temp);
// Useful for multiline strings and string concatenation with variables
let temp2 = `hi hi ${temp}`;
console.log(temp2);
//////////////////////////////////

// Using var vs let in function's block-scope
function day(good) {
    // var description; hoisted to top of function scope
    if (good) { // block where defined
        var description = "wonderful";
        // let descriptor = "so so"; // block scoped cannot reference outside this block
    }
    // console.log(`today is ${descriptor} ${description}`) // can I access variables?
    console.log(`today is ${description}`) // can I access variables?
}
day(true);

// store functions in variables - functions are first class citizens
let talk = function() { console.log("talking")}
talk();

//////////////////////////////////////////////////////////////////////
// Closures
console.log();
console.log();
console.log();
console.log();
console.log();
function a() {
    let name = "bob";
    function b() {
        console.log(name + " is awesome")
    }
    return b;
}
const myB = a(); // store the function b AND all the variables that were in lexicographic scope
// at this point a() has finished executing
// let is block scoped so we would expect the variable name to now be garbage collected
myB();

// Example of closure
function repeater(x) {
    function inner(str) {
        console.log(str.repeat(x));
    }
    return inner;
}
const doubler = repeater(2);
const tripler = repeater(3);

doubler("kitty");
tripler("meow");