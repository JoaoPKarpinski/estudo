const fs = require('fs');
const path = require('path')

const caminho = path.join(__dirname, 'teste.txt');
console.log(caminho);

function ler(cam){
    return new Promise((resolve, reject) => {
        fs.readFile(cam, (_, conteudo) => {
            resolve(conteudo.toString());
        });
    });
}


ler(caminho).then(console.log);