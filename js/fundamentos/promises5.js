const testeProbab = chanceErro => {
    return new Promise((resolve, reject) => {
        try{
            if (Math.random() < chanceErro){
                reject('Perdeu');
            }
            else{
                resolve('Tudo certo!');
            }
        }
        catch(e){        // pega um erro que acontece durante a execucao do bloco try e manda na reject,
            reject(e);   // que é tratrado no bloco catch, depois dos then.
        }
    });
}
/*
    A funcao reject retorna o valor do erro que pode ocorrer,
    podendo ser esse erro uma simples condicao definida pelo desenvolvedor (caso da linha 5)
    ou um erro nativo do javascript (caso da linha 12).
    Ambos serão tratados pelo metodo catch, chamado após a execução da promise.
*/ 

testeProbab(0.9).then(console.log)
                .then(console.log)
                .then(console.log) // o catch fica geralmente no final pois depois dele nenhum valor é retornado.
                .catch(err => console.log(`Ocorreu um erro: ${err}`));