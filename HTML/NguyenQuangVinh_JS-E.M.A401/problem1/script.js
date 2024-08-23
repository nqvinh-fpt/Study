// Add your code here
var finalQuote
 var quoteStart = "Don't judge each day by the harvest you reap ";
 var quoteEnd = "but by the seeds that you plant.";
finalQuote=quoteStart+quoteEnd
 // Don't edit the code below here!
 var section = document.querySelector('section');
 var para1 = document.createElement('p');
 para1.textContent = finalQuote;

section.appendChild(para1)