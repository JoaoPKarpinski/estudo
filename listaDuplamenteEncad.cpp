#include <stdio.h>
#include <stdlib.h>

struct celula{
    int num;
    celula *ant;
    celula *prox;
};


void inserir(celula *&ini, int num){
    celula *aux, *novo = (celula*)malloc(sizeof(celula));
    novo -> num = num;
    novo -> prox = NULL;
    novo -> ant = NULL;

    if (ini == NULL){
        ini = novo;
    }
    else {
        aux = ini;
        while (aux -> prox != NULL){
            aux = aux -> prox;
        }
        novo -> ant = aux;
        aux -> prox = novo;
    }
}


void remove(celula *&ini, int n){
    celula *aux;

    aux = ini;
    while (aux != NULL && aux -> num != n){
        aux = aux -> prox;
    }
    if (aux != NULL){        // vendo se nao chegou ao final da lista sem achar o numero buscado
        if (aux -> ant == NULL){           // vendo se é o primeiro item da lista
            if (ini -> prox == NULL){      // vendo se é o unico item da lista
                ini = NULL; // se for o ultimo, remove (seta pra null) sem mais alteracao
            }
            else{
                ini = ini -> prox; // se for só o primeiro, a primeira posicao vira o proximo
                ini -> ant = NULL; 
            }

        }

        else{    // aqui é qualquer item menos o primeiro
            aux -> ant -> prox = aux -> prox; 
            if (aux -> prox != NULL){         // vendo se nao é o ultimo item, pq se for, 
                aux -> prox -> ant = aux -> ant; // o proximo vai ser "nulo", sem nenhum atributo, sem "anterior"
            }
            free(aux);
        }
    }

   else{
        printf("\nnulo\n");
    }
}


int main(){
    int n, op;
    celula *inicio = NULL;

    printf("quer por?\n");
    scanf("%d", &op);
    while(op > 0){
        scanf("%d", &n);
        inserir(inicio, n);
        printf("\nquer por mais coisa?\n");
        scanf("%d", &op);
    }

    printf("\nquer desalocar?\n");
    scanf("%d", &op);
    while (op > 0){
        printf("\nelemento para busca: ");
        scanf("%d", &n);
        remove(inicio, n);

        printf("\n\nremove mais?\n");
        scanf("%d", &op);
    }


    return 0;
}