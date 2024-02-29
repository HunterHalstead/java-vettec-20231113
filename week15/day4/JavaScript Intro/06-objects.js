// Creating an object looks like json
let obj = { x: 1, 
            y: 2 
          };
// if you have the name of the property as a string you can acccess it using [] notation
console.log("x is " + obj.x);
let str = "x";
console.log("x is " + obj[str]);

// console.log("x is " + obj[x]);
// console.log("x is " + obj.str);

console.log(obj);
console.log(obj.greet) // greet property doesn't exist

obj.greet = function() {console.log("hello")}; // I can add properties to an object after it is created

console.log(obj.greet) // [Function (anonymous)]
obj.greet(); // invokes the function

// Freeze an object to prevent adding more properties
Object.freeze(obj);

obj.z = 23; 

console.log(obj.z); // TODO debug how to lock an object

// Iterable - can loop over using for...of
// Enumerable - can loop over an enumerable with a for...in

for (let p in obj) { // extracts name of property NOT value of property
    // console.log(typeof p) // string
    console.log("property p is now " + p + " so the property value is " + obj[p]); // bracket notation
}
console.log();

// Arrays are iterable
let recipe = ["ice cream", "brownies", "chocolate sauce", "sprinkles"];
for (let ingredient of recipe) {
    console.log(ingredient);
}
console.log();
for (let p in recipe) {
    console.log(p);
}
for (let index in recipe) {
    // console.log(typeof index); // string
    console.log((Number.parseInt(index) + 1) + ". " + recipe[index]); // convert string -> int with Number.parseInt
}