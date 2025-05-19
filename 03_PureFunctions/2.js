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
