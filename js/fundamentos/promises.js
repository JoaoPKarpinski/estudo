const pro = new Promise((cumprir, rejeitar) => { //geralmente, os nomes dessas funcoes que sao passadas como parametro pela Promisse sao RESOLVE e REJECT
    cumprir(10) // O resolve aceita apenas um parametro; retorna apenas um parametro. Para retornar varios valores, retorne um objeto

});

pro.then(valor => valor + 5)
    .then(valor => valor + 10)
    .then(valor => valor + 100)
    .then(valor => num = valor)
    .then(valor => console.log(valor));


