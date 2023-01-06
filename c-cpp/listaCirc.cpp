#include <stdio.h>
#include <stdlib.h>

struct celula{
    int num;
    celula *prox;
};

void inserir(celula *&cursor, int n){
    celula *novo = (celula*)malloc(sizeof(celula));
    novo -> num = n;
    novo -> prox = NULL;
    if (cursor == NULL){
        novo -> prox = novo;
        cursor = novo;
    }
    else{
        novo -> prox = cursor -> prox;
        cursor -> prox = novo;
    }
}


int remover(celula *&cursor){
    int n;
    celula *aux;

    if (cursor == NULL){
        return 0;
    }
    if (cursor -> prox == cursor){
        n = cursor -> num;
        cursor = NULL;
        return n;
    }
    else {
        aux = cursor -> prox;
        n = aux -> num;
        cursor -> prox = cursor -> prox -> prox;
        free(aux);
        return n;
    }
}

void avancar(celula *&cursor){
    if (cursor != NULL){
        cursor = cursor -> prox;
    }
}

int main(){
    celula *curs = NULL;
    inserir(curs, 5);
    inserir(curs, 7);
    inserir(curs, 9);
    inserir(curs, 54);
    int n;

    printf("oi\n");
    avancar(curs);
    n = remover(curs);
    printf("zoso");

    return 0;
}