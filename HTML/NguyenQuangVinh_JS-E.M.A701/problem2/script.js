let machineActive = false;
let score = 75;
let response;
function check() {
  if (!machineActive) {
    response = "The machine is turned off. Turn it on to process your score.";
  } else {
    if (score < 0 || score > 100) {
      response = "This is not possible, an error has occurred.";
    } else if (score >= 0 && score <= 19) {
      response = "That was a terrible score — total fail!";
    } else if (score >= 20 && score <= 39) {
      response = "You know some things, but it's a pretty bad score. Needs improvement.";
    } else if (score >= 40 && score <= 69) {
      response = "You did a passable job, not bad!";
    } else if (score >= 70 && score <= 89) {
      response = "That's a great score, you really know your stuff.";
    } else if (score >= 90 && score <= 100) {
      response = "What an amazing score! Did you cheat? Are you for real?";
    }
  }
}
const section = document.querySelector('section');
machineActive=false;
check();
let para1 = document.createElement('p');
para1.innerHTML = "You score is " + score + "<br>" + response;
machineActive=true;
check();
let para2 = document.createElement('p');
para2.innerHTML = "You score is " + score + "<br>" + response;
section.appendChild(para1);
section.appendChild(para2);