# 03 Pure Functions

## Aufgabe 1

### Aufgabe 1.1

```JavaScript
let cartItems = [];

function addToCart(item) {
    cartItems.push(item);
    return cartItems;
}

console.log(addToCart('Apple'));  // Ausgabe: ['Apple']
console.log(addToCart('Banana')); // Ausgabe: ['Apple', 'Banana']
console.log(addToCart('Orange')); // Ausgabe: ['Apple', 'Banana', 'Orange']
```

- [X] Nur ein Rückgabewert
- [ ] Resultat nur Abhängig von übergebenen Parametern
- [ ] Verändert keine existierenden Werte
- impure

### Aufgabe 1.2

```JavaScript
function add(a, b) {
    return a + b;
}

console.log(add(5, 3)); // Ausgabe: 8
console.log(add(2, 4)); // Ausgabe: 6
```

- [X] Nur ein Rückgabewert
- [X] Resultat nur Abhängig von übergebenen Parametern
- [X] Verändert keine existierenden Werte
- pure

### Aufgabe 1.3

```JavaScript
function firstCharacter(str) {
    return str.charAt(0);
}

console.log(firstCharacter("Hello")); // Ausgabe: H
console.log(firstCharacter("JavaScript")); // Ausgabe: J
```

- [X] Nur ein Rückgabewert
- [X] Resultat nur Abhängig von übergebenen Parametern
- [X] Verändert keine existierenden Werte
- pure

### Aufgabe 1.4

```JavaScript
// Methode, um eine Zahl mit einem zufälligen Wert zu multiplizieren
function multiplyWithRandom(number) {
    const randomValue = Math.random(); // Generiert einen zufälligen Wert zwischen 0 und 1
    return number * randomValue;
}

console.log(multiplyWithRandom(5)); // Ausgabe: Eine zufällige Zahl zwischen 0 und 5
console.log(multiplyWithRandom(10)); // Ausgabe: Eine zufällige Zahl zwischen 0 und 10
```

- [X] Nur ein Rückgabewert
- [ ] Resultat nur Abhängig von übergebenen Parametern
- [X] Verändert keine existierenden Werte
- impure

### Aufgabe 1.5

```JavaScript
// Funktion zum Teilen einer Zahl durch eine andere
function divideNumbers(dividend, divisor) {
    return dividend / divisor;
}

console.log(divideNumbers(10, 2)); // Ausgabe: 5
console.log(divideNumbers(8, 4));  // Ausgabe: 2
```

- [X] Nur ein Rückgabewert
- [X] Resultat nur Abhängig von übergebenen Parametern
- [X] Verändert keine existierenden Werte
- pure

### Aufgabe 1.6

```JavaScript
// Methode zum Ausgeben und Rückgeben einer Zeichenkette
function printAndReturnString(str) {
    console.log(str); // Ausgabe der Zeichenkette auf der Konsole
    return str;      // Rückgabe der Zeichenkette
}

console.log(printAndReturnString("Hello")); // Ausgabe: Hello
```

- [ ] Nur ein Rückgabewert
- [X] Resultat nur Abhängig von übergebenen Parametern
- [X] Verändert keine existierenden Werte
- impure
