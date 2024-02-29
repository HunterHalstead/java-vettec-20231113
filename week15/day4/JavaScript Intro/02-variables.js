// This is a comment

/*
This is a multline
coment
*/

/*
There are 3 ways to declare a variable
1. var - legacy method pre-ES6
2. let - block scoped
3. const - like Java final keyword cannot be reassigned
NOT STRICTLY TYPED 
*/

// int x = 1; JAVA

////////////////////////////////
// Method 1:
var x = 1; // global scope
           // or function scope if defined in a function
x2 = 2; // defaults to var declaration if you forget

////////////////////////////////
// Method 2:
let y = 2; // block scope

////////////////////////////////
// Method 3:
const z = 3; 
// z = 4; // causes TypeError

///////////////////////////////
// Block Scope example

if (true) {
    var a = 10;
    let b = 20;
}
console.log(a);
// console.log(b); // ReferenceError: b is not defined

///////////////////////////////
// Variable hoisting 
// - variables are declared at the top of the scope they are defined in
// - variables are assigned the value undefined when they are declared
console.log(myVar)
var myVar = "hi"; // declaration is hoisted, the initialization is NOT

// console.log(myVar2); // throws an error if try to access myVar2 before initialization
let myVar2 = 2;

console.log(myVar3); // throws an error if try to access myVar3 before initialization
const myVar3 = 3;