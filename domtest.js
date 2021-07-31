//doc object
const paragraphthing = document.querySelector('div > p.error');
console.log(paragraphthing);
paragraphthing.innerText = 'Now different';


const paras = document.querySelectorAll('h1')
console.log(paras[1]);
paras.forEach( x =>{
    console.log(x);
    paras.innerText += ' new version';
})

//get element by ID
const title = document.getElementById('title');
console.log(title);

const seconderror = document.querySelector('.seconderror')
console.log(seconderror.innerHTML);
seconderror.innerHTML += '<p>New Error</p>';