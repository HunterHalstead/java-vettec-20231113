# History of JavaScript

- Java and JavaScript are two different programming languages

> [!WARNING]
> Java is to JavaScript as car is to carpet

- They use similar programming syntax (both draw from the C programming language)
    - JavaScript is a scripting language
    - JavaScript is singlethreaded but still supports Asynchronous function execution
    - not strictly typed

- 1995 Brendan Eich wrote the JavaScript programming language in 10 days

    - "Mocha" rebranded as "LiveScript" rebranded as JavaScript

- 1996 Microsoft release JScript a version of JavaScript for their Internet Explorer 3

- 1997 European Computer Manufacturer Association (ECMA) establishes a standard for JavaScript implementations

    - Current version is ECMAScript 2023 aka (ES14)

- 2015 ES6 added great functionality we will talk about today 
    - arrow functions (labmdas => )
    - class notation (supports OOP)
    - template literals (String.format in Java)
    - Promises (this is like Java Futures multithreading)

- 2009 Ryan Dahl introduced NodeJS to run JavaScript outside of the browser (now we can use JavaScript for web server backend development)
 - Google Chrome V8 Engine (JavaScript Runtime environemnt)

Now we have multiple ways to run out JavaScript
1. In our HTML page inside a `<script>` tag
2. In our HTML page by linking in .js file via 
```html
<script src="file/path"></script>
```
3. In our terminal using the `node` command
4. In our terminal using the `node` command and a file name
```
> node hello.js
```

## V8 Engine

- open source JavaScript engine developed by Google

Features:

1. Just-in-time Compilation (JIT) - faster than interpretted languages, it can do optimization in how the code is compiled and executed at runtime
2. Gargabe collection - reduces memory consumption
3. Embeddable into any C++ program, example NodeJS

- Suggestion: run a function in different browsers and see how long they take

```JavaScript
console.time("my-timer")
myFunction()
console.timeEnd("my-timer")
```