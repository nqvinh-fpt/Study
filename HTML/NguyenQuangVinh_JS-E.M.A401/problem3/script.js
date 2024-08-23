let quote = 'I dO nOT lIke gREen eGgS anD HAM';
let fixedQuote = quote.charAt(0).toUpperCase() + quote.slice(1).toLowerCase()+".";
// Add your code here
// Don't edit the code below here!
let finalQuote = fixedQuote.substring(0,fixedQuote.indexOf("green eggs and ham"))+"green eggs and ham"+"."
const section = document.querySelector('section');

let para1 = document.createElement('p');
para1.textContent = fixedQuote;
let para2 = document.createElement('p');
para2.textContent = finalQuote;

section.appendChild(para1);
section.appendChild(para2);