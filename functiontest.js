const speakthetime = function(name = 'mcree', time = 'high noon')
{
    let speakphrase = name +": it's " + time;
    console.log(speakphrase);
}

speakthetime();

//arrow function
const calcVolume = (length = 1, width = 1, height = 1) => length * width * height;
let volume = calcVolume();
console.log(volume);

const greet = () => 'Howdy Partner';
console.log(greet());

let people = ['Man', 'Manchester', 'Manchestera'];
let html2 = '';
people.forEach(function(person) {
    html2 += `<li style="color: purple">${person}</li>`;
})
console.log(html2);
const ul = document.querySelector('.people');
ul.innerHTML = html2;

let anobject = {
    anname: 'Derex',
    anage: '42',
    anarray: ['south', 'park', 'trevor', 'canada', 'lol'],
    afunction(){
        console.log('im a real boy!');
    },
    typeeacharray(){
        this.anarray.forEach(x => {
            console.log(x);
        })
    }
};
console.log(anobject.anage);

console.log(anobject.afunction());

const blogs = [{title: 'Derex', likes: 42},{title: 'Derex'}]

anobject.typeeacharray();

caveman = {number: 50};
const caveman2 = caveman;
caveman = {number: 25};
console.log(caveman2);

const caveman3 = {name: 'xd'};
const caveman4 = caveman3;
console.log(caveman4);
caveman3.name = 'dx';
console.log(caveman4);

