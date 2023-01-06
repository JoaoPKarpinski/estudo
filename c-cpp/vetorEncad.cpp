#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct celula{
	char nome[31];
	celula *prox;
};


void adicionar(celula *&lista, char x[]){
	celula *novo, *aux;
	novo = (celula*)malloc(1 * sizeof(celula));

	strcpy(novo -> nome, x);
	novo -> prox = NULL;


	if (lista == NULL){
		lista = novo;
	}
	else{
		aux = lista;
		while (aux -> prox != NULL){
			aux = aux -> prox;
		}

		aux -> prox = novo;
	}
}

void imprimir(celula *lista){
	celula *aux;
	aux = lista;

	while (aux != NULL){
		printf("%s ", aux -> nome);
		aux = aux -> prox;
	}
}

celula* interseccao(celula *l1, celula *l2){
	celula *novo, *aux1, *aux2;
	novo = (celula*)malloc(sizeof(celula));
	novo = NULL;

	aux1 = l1;
	aux2 = l2;
	while (aux1 != NULL){
		while (aux2 != NULL){
			if (strcmp(aux1 -> nome, aux2 -> nome) == 0){
				adicionar(novo, aux1 -> nome);
			}

			aux2 = aux2 -> prox;
		}

		aux1 = aux1 -> prox;
		aux2 = l2;
	}

	return novo;
}



int main(){
	celula *l1, *l2, *l3;
	char nome[31];

	l1 = (celula*)malloc(1 * sizeof(celula));
	l2 = (celula*)malloc(1 * sizeof(celula));
	l3 = (celula*)malloc(1 * sizeof(celula));
	l1 = NULL;
	l2 = NULL;
	l3 = NULL;

	while (1){
		scanf("%s", nome);
		if (strcmp(nome, "FIM") == 0){
			break;
		}

		adicionar(l1, nome);
	}

	while (1){
		scanf("%s", nome);
		if (strcmp(nome, "FIM") == 0){
			break;
		}

		adicionar(l2, nome);
	}


	l3 = interseccao(l1, l2);

	if (l3 == NULL){
		printf("VAZIA\n");
	}
	else {
        imprimir(l3);
	}




	return 0;
}