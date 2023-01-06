function gerarAleatorio(min, max){
    if (min > max){
        [min, max] = [max, min];
    }
    return parseInt(Math.random() * (max - min + 1));
}

function gerarNum(repetidos){
    return new Promise((resolve, reject) => {
        let num = gerarAleatorio(1, 5);
        if (repetidos.includes(num)){
            reject(-1);
        }
        else{
            resolve(num);
        }
    });
}


async function gerarVetorAleatorio(qntNum, repetidos){
    var vetor = [];
    let num = 0;
    for (let i = 0; i < qntNum; i++){
        vetor.push(await gerarNum(repetidos)); // quando a promise da erro, o processo é cancelado
    }
    return vetor;
}

gerarVetorAleatorio(5, [1]).then(vet => console.log(vet )).catch(console.log);