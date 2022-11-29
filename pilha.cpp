#include <stdio.h>
#include <stdlib.h>


struct celula{
	int num;
	celula* prox;
};


void empilhar(celula* &topo, int num){
	celula *aux;
	aux = (celula*)malloc(sizeof(celula));
	aux -> num = num;
	aux -> prox = topo;
	topo = aux;
}


int desempilhar(celula *&topo){
	celula *aux;
	int n;

	if(topo == NULL){
		return 0;
	}
	else{
		aux = topo;
		n = aux -> num;
		topo = topo -> prox;
		free(aux);
		return n;
	}
}


int main(){
	celula *topo = (celula*)malloc(sizeof(celula));
	celula *aux;
	int op;
	int num;

	topo = NULL;

	for (int i = 0; i < 5; i++){
		scanf("%d", &num);
		empilhar(topo, num);
	}
	
	aux = topo;
	printf("%d", aux -> num);
	for (int i = 0; i < 5; i++){
		aux = aux -> prox;
		if (aux == NULL){
			printf("\nFIM DA PILHA");
		}
		else{
			printf(" - %d", aux -> num);
		}
	}

	printf("\nquer desempilhar?");
	scanf("%d", &op);

	while (op > 0){
		printf("\n%d - n desepilhado\n", desempilhar(topo));
		if (topo == NULL){
			printf("\npilha vazia!\n");
			break;
		}
		aux = topo;
		printf("%d", aux -> num);
		while(aux != NULL){
			aux = aux -> prox;
			if (aux == NULL){
				printf("\nFIM DA PILHA");
			}
			else{
				printf(" - %d", aux -> num);
			}
		}
		printf("\nquer desempilhar?");
		scanf("%d", &op);
	}


	return 0;
}