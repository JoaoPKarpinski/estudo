function retornarSoma(num){
    return new Promise((resolve, reject) => {
        resolve(num);
    });
}

const varias = () => {
    return Promise.all([retornarSoma(1),   // O método all da classe Promise retorna pro Then 
                        retornarSoma(2),   // todas as promises passadas por parametro. São passadas como um vetor,
                        retornarSoma(3)]); // portanto, sao retornadas como um vetor
}



varias().then(vetor => {
            console.log(vetor);
            return vetor;  // se o processo do then nao for algo retornavel, como uma operacao matematica,
        })                 // o retorno PRECISA ser explícito (linha 17)
        .then((vetor) => {
            console.log(vetor);
        })