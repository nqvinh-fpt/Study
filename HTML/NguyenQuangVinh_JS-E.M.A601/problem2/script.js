let info
// Add your code here
let artist = {
  name: 'Son Tung M-TP',
  nationality: 'Vietnamese',
  genre: 'pop',
  debut: '2015',
  songs: [
    {
      name: 'Con mua ngang qua',
      released: 2012
    },
    {
      name: 'Hay trao cho anh'
    }
  ]
};
info = "The " + artist.nationality + " " + artist.genre + " star " + artist.name + " were active since " + artist.debut + ".<br>";
info += "His/her first song, " + artist.songs[0].name + ", was released in " + artist.songs[0].released + ".<br>";
info += "His/her last song " + artist.songs[1].name  + " is the most succesfully by far. ";
// Don't edit the code below here!
const section = document.querySelector('section');
let para1 = document.createElement('p');
para1.innerHTML = info;
section.appendChild(para1);