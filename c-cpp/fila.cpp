#include <stdio.h>
#include <stdlib.h>

struct celula{
    int num;
    celula *prox;
};

void inserirNaFila(celula *&inicio, celula *&fim, int num){
    celula *aux;
    aux = (celula*)malloc(sizeof(celula));
    aux -> num = num;
    aux -> prox = NULL;
    if (fim == NULL){
        inicio = aux;
        fim = inicio;
    }
    else {
        fim -> prox = aux;
        fim = aux;
    }
}

/*RETORNA O VALOR DESENFILEIRADO*/
int desenfileirar(celula *&inicio, celula *&fim){
    int n;
    celula *aux;

    if (inicio == NULL){
        return 0;
    }
    else{
        n = inicio -> num;
        aux = inicio;
        inicio = inicio -> prox;
        if (inicio == NULL){
            fim = NULL;
        }
        free(aux);
        return n;
    }
}


/*ESSA FUNCAO NAO É PRÓPRIA DA ESTRUTURA DE FILA, MAS É INTERESSANTE ENTENDER A FUNCIONALIDADE DELA*/
void inserirNoInicio(celula *&inicio, celula *&fim, int num){
    celula *aux = (celula*)malloc(sizeof(celula));

    aux -> num = num;
    aux -> prox = NULL;
    if (inicio == NULL){
        inicio = aux;
        fim = inicio;
    }
    else {
        aux -> prox = inicio;
        inicio = aux;
    }
}
/****************************************************************************************************/


int main(){
    celula *ini = NULL, *fim = NULL, *aux;
    int n, op, qntd;
    
    printf("Quantos elementos?\n");
    scanf("%d", &qntd);

    for (int i = 0; i < qntd; i++){
        scanf("%d", &n);
        inserirNaFila(ini, fim, n);
    }

    aux = ini;
    while(aux != NULL){
        printf("%d ", aux -> num);
        aux = aux -> prox;
    }

    printf("\n\ndesenfileirar?\n");
    scanf("%d", &op);

    while(op > 0){
        printf("%d\n", desenfileirar(ini, fim));
        if (ini == NULL){
            printf("\n\nFim da fila!\n");
            break;
        }

        aux = ini;
        while(aux != NULL){
            printf("%d ", aux -> num);
            aux = aux -> prox;
        }

        printf("\n\ndesenfileirar?\n");
        scanf("%d", &op);
    }

    return 0;
}