#include <stdio.h>
#include <stdlib.h>


struct celula{
	int val;
	celula* prox;
};

void inserir(celula *&lista, int valor){
	celula *novo, *aux;
	novo = (celula*)malloc(sizeof(celula));
	novo -> prox = NULL;
	novo -> val = valor;
	aux = lista;

	if (lista == NULL){
		lista = novo;
	}
	else {
		while(aux -> prox != NULL){
			aux = aux -> prox;
		}
		aux -> prox = novo;
	}

}





int main(){
	celula *lista;
	lista = (celula*)malloc(sizeof(celula));
	lista = NULL;
	int novo;

	while (1){
		scanf("%d", &novo);
		if (novo == 0){
			break;
		}
		inserir(lista, novo);
	}

	printf("%d -- %d", lista -> val, lista -> prox -> val);


	return 0;
}