function timeout(tempo){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log(`passaram ${tempo/1000} segundos`)
            resolve(10);
        }, tempo);
        if (tempo < 1000){
            reject(-1);
        }
    });
}

const objetoQualquer = {num: 0};

async function funcaoQuePermiteAtribuir(obj){
    obj.num = await timeout(9000).catch(e => e); // Sem o AWAIT, a variavel receberia a promise pendente/incompleta (promise <pending>). 

    obj.num = obj.num + (await timeout(9000).catch(e => e)) + 40; // No caso de erro, a promise retorna o valor da reject (nesse caso, -1).
    
    console.log(objetoQualquer.num);
}

// Uma função assíncrona tem a permissão para usar a palavra-chave await para fazer com que a promise (sim, a prática está ligada às promises)
// seja concluida e o valor retornado antes do prosseguimento do código. Faz com que as operações sejam síncronas.

funcaoQuePermiteAtribuir(objetoQualquer);

