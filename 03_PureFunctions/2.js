let cartItems = [];

function addToCart(cartItems, item) {
    return [...cartItems, item];
}

let cart = [];
console.log(cart = addToCart(cart, 'Apple'));  // Ausgabe: ['Apple']
console.log(cart = addToCart(cart, 'Banana')); // Ausgabe: ['Apple', 'Banana']
console.log(cart = addToCart(cart, 'Orange')); // Ausgabe: ['Apple', 'Banana', 'Orange']



// Nicht mehr wirklich random, dafür pure
function multiplyWithRandom(number, randomValue) {
    return number * randomValue;
}

console.log(multiplyWithRandom(5, Math.random(10)));
console.log(multiplyWithRandom(10, Math.random(3)));



// Methode printed halt nichts mehr ist dafür aber pure
function printAndReturnString(str) {
    return str;      // Rückgabe der Zeichenkette
}

console.log(printAndReturnString("Hello")); // Ausgabe: Hello



// Funktion zum Abrufen des ersten Zeichens einer Zeichenkette
function firstCharacter(str) {
    if (typeof str !== 'string' || str.length === 0) {
        return '';
    }
    return str.charAt(0);
}

console.log(firstCharacter("Hello")); // Ausgabe: H
console.log(firstCharacter("JavaScript")); // Ausgabe: J
console.log(firstCharacter(""));           // ""
console.log(firstCharacter(null));         // ""



// Funktion zum Teilen einer Zahl durch eine andere
function divideNumbers(dividend, divisor) {
    if (typeof dividend !== 'number' || typeof divisor !== 'number' || divisor === 0) {
        return NaN;
    }
    return dividend / divisor;
}

console.log(divideNumbers(10, 2)); // Ausgabe: 5
console.log(divideNumbers(8, 4));  // Ausgabe: 2
console.log(divideNumbers(8, 0));          // NaN
console.log(divideNumbers("10", 2));       // NaN