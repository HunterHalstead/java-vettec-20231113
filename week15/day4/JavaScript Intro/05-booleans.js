// JavaScript treats 0 and 1 as false and true

/*
"truthy" and "falsy" values
*/
if (true)
   console.log("apple")

if (1)
   console.log("pear")

let name;
if (name) // undefined is falsy
   console.log(name); // note: I am getting a warning that name is a deprecated reserved TypeScript keyword

/*
Falsy Values are:
- false
- 0
- undefined
- null
- ""
- NaN
*/
if ({})
   console.log("empty object is truthy")
else
   console.log("empty object is falsy")

if ([])
   console.log("empty array is truthy")
else
   console.log("empty array is falsy")

if ("")
   console.log("empty string is truthy")
else
   console.log("empty string is falsy")

console.log(0/0);
if (NaN)
   console.log("NaN is truthy")
else 
   console.log("NaN is falsy")

console.log("-".repeat(30));

// Boolean coercion
console.log(Boolean(1)); // true
console.log(Boolean(0)); // false
console.log(Boolean("hello")); // true
console.log(Boolean("")); // false
console.log(Boolean(1 == "1")) // true
console.log(Boolean([])); // true
console.log("1/0 " + Boolean(1/0)); // false? is actually true
console.log(Boolean({})); // true
console.log(Boolean(null)); // false

console.log("-".repeat(30));

////////////////////////////////////////
// JavaScript unexpected behaviours
console.log([] == ![]); // truthy but not "true" so ![] is !(false) is true
console.log(NaN === NaN); // false
console.log((1 / 0) == false);
console.log((1 / 0) == true);