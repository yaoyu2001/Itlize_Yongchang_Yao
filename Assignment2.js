// 1 Create a constructor function Calculator that creates objects with 3 methods:
// ● read() asks for two values using prompt and remembers them in object properties.
// ● sum() returns the sum of these properties.
// ● mul() returns the multiplication product of these properties.

function Calculator() {
    this.first = 0;
    this.second = 0;

    this.read = function () {
        this.first = parseInt(prompt("Please input this first value"));
        this.second = parseInt(prompt("Please input this second value"));
    };

    this.sum = function () {
        return this.first + this.second;
    };

    this.mul = function () {
        return this.first * this.second;
    }
}

var cal = new Calculator();
cal.read();
console.log("This sum of two values is "+ cal.sum());
console.log("This multiplication product of two values is "+ cal.mul());

// 2 Create a constructor function called Hero That will accept the
// arguments name and occupation.
// 1. Use Hero.prototype to add a method whoAreYou that will return:
// My name is [the hero's name] and I am a [the hero's occupation].
// 2. Use the Hero constructor to create an object hero1 with the name Michaelangello and occupation Ninja.
// 3. Use the whoAreYou method to log to the console hero1's name and occupation.

function Hero(name, occupation) {
    this.name = name;
    this.occupation = occupation;
}

Hero.prototype = {
    constructor : Hero,
    whoAreYou:function () {
        return "My name is: " + this.name + " and I am a " + this.occupation;
    }
};

const hero1 = new Hero("Michaelangello", "Ninja");
console.log(hero1.whoAreYou());