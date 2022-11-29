#include <stdio.h>

struct celula{
	int num;
	celula *prox;
};


void adicionar(celula *&inicio, int num){
	celula *aux;
	celula *novo = (celula*)malloc(sizeof(celula));
	novo -> prox = NULL;
	novo -> num = num;

	if (inicio == NULL){
		inicio = novo;
	}
	else{
		aux = inicio;
		while (aux -> prox != NULL){
			aux = aux -> prox;
		}
		aux -> prox = novo;
	}
}


int main(){




	return 0;
}