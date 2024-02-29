// JavaScript uses prototypical inheritance
// Every object has a prototype that it inherits from

let obj = { x: 1, y: 2};

// All objects have a prototype they inherit from
// The default is Object.prototype

console.log(Object.prototype);

// Create an object and use it as the prototype of another object

function Animal(type) {
    this.type = type;
}

function Dog(name) {
    this.name = name;
}

Dog.prototype = Object.create(Animal.prototype);
Object.setPrototypeOf(Dog, Animal);

function Person(name) {
    this.name = name;
}

const student =  {
    grade: grade,
    __proto__: new Person()
}