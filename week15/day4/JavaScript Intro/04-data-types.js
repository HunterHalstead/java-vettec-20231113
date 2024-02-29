// Even though JavaScript is loosely typed it still has data types

///////////////////////////////////////////
//  Primitive Data Types - are all immutable
// - number
// - string
// - boolean
// - BigInt
// - Symbol (a unique symbol type - added later in JavaScript)

let x = 1;
console.log(x);
console.log(typeof x);
x = "hello";
console.log(x);
console.log(typeof x);


///////////////////////////////////////////
// Type Coercion

console.log("2" + 2); // concatenation
console.log(2 - "2"); // type coercion string -> number
console.log(2 / "2"); // type coercion string -> number
console.log(2 * "2"); // type coercion string -> number

///////////////////////////////////////////
// string methods
let str = "";
console.log(str.concat("hello").toUpperCase().slice(1));
console.log(`str = "${str}"`);

//////////////////////////////////////////
// number methods
let pi = 3.14159;
console.log(pi.toFixed(20));
console.log(pi.toFixed(2));

///////////////////////////////////////////
// Equality
console.log("" == str);

console.log(1 == "1"); // type coercion

console.log(1 === "1"); // strictly-typed equality (for type safe comparison)

//////////////////////////////////////////
// undefined and null
let un; // undefined - indicates a variable has not  been assigned a value yet (normally unintentional)
console.log(un);
let nu = null; // null - placeholder for an object (normally intentional)
console.log(nu);

///////////////////////////////////////////
// Arrays
let arr = [1, "hi", true];
console.log(arr);

//////////////////////////////////////////
// Objects
let obj = { x : 1, y : 2 };
console.log(obj);