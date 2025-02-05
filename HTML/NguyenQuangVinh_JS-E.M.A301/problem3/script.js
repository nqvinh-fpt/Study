// Statement 1: The elephant weights less than the mouse
let eleWeight = 1000;
let mouseWeight = 2;
// Statement 2: The Ostrich is taller than the duck
let ostrichHeight = 2;
let duckHeight = 0.3;
// Statement 3: The two passwords match
let pwd1 = 'stromboli';
let pwd2 = 'stROmBoLi';

let weightComparison = eleWeight < mouseWeight;
let heightComparison = ostrichHeight > duckHeight;
let pwdMatch = pwd1 === pwd2; 

const section = document.querySelector('section');

let para1 = document.createElement('p');
let para2 = document.createElement('p');
let para3 = document.createElement('p');

let weightTest = weightComparison ? 'True — elephants weight less than mice!?' : 'False — of course an elephant is heavier than a mouse!';
let heightTest = heightComparison ? 'True — an ostrich is indeed taller than a duck!' : 'False — apparently a duck is taller than an ostrich!?';
let pwdTest = pwdMatch ? 'True — the passwords match.' : 'False — the passwords do not match; please check them';

para1.textContent = weightTest;
section.appendChild(para1);
para2.textContent = heightTest;
section.appendChild(para2);
para3.textContent = pwdTest;
section.appendChild(para3);
