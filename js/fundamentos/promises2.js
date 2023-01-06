// setTimeout(() => {
//     console.log("passaram 2 segundos");
//     setTimeout(() => {
//         console.log("passaram 2 segundos");
//         setTimeout(() => {
//             console.log("passaram 2 segundos");
//         }, 2000);
//     }, 2000);
// }, 2000);

/* ESSE É O PRINCIPAL MOTIVO DO USO DE PROMISES
   QUANTO MAIOR FICA O CODIGO, QUANTO MAIOR FICA A NECESSIDADE DE CHAMAR CALLBACKS,
   MAIS ILEGIVEL E GRANDE FICA O CODIGO. AO USAR PROMISSES,
   O TRATAMENTO QUE O RESOLVE RECEBE NO THEN É MUITO MAIS CLARO DO QUE
   NUM CALLBACK HELL
*/

const timeout = (tempo) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("passaram 2 segundos")
            resolve(10);
        }, tempo);
    });
}

timeout(2000).then((v) => timeout(2000))
             .then((v) => timeout(2000));
