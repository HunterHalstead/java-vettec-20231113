// ES6 added syntatic sugar to work with classes and objects easier

class Bird {
    #primaryColor; // # indicates the property is private
    constructor(color) {
        this.color = color;
    }

    get color() {
        return this.#primaryColor.toUpperCase();
    }

    set color(str) {
        this.#primaryColor = str ?? "white"; // ?? falls back the the second value if color is null
    }

}

const crow = new Bird("black");
console.log(crow.color); // calls the getter NOT the property directly

crow.color = null; // should call the setter
console.log(crow.color); // should call the getter

class Parrot extends Bird {

    constructor() {
        super("green");
    }
    talk() {
        console.log("Polly wants a cracker");
    }
}
const polly = new Parrot();
polly.talk();
console.log(polly.color);