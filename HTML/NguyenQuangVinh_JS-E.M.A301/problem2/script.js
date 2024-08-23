// Final result should be 10.42
// Add/update your code here
let result = (7 + 13) / (9 + 7);
let result2 = 100 / (2 * 6);
let finalResult = result * result2;

finalNumber = finalResult.toFixed(2); 

// Don't edit the code below here!
const section = document.querySelector('section');

let para1 = document.createElement('p');
para1.textContent = `Your finalResult is ${finalNumber}`;

let para2 = document.createElement('p');
let finalNumberCheck =
  isNaN(finalNumber) === false
    ? 'finalNumber is a number type. Well done!'
    : `Ooops! finalNumber is not a number.`;
para2.textContent = finalNumberCheck;

section.appendChild(para1);
section.appendChild(para2);
