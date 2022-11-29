#include <stdio.h>
#include <stdlib.h>

struct celula{
	int num;
	celula *prox;
};

/*Adiciona um novo nó à lista*/
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

/*Remove o ultimo nó de uma lista simplesmente encadeada e retorna seu valor.
Chega ao penúltimo nó da fila (se nao tiver apenas um nó),
e atribui ao campo "prox" da mesma o valor NULL.
Em seguida, libera o espaço de memória.
Se for o caso de ter apenas um nó, ao nó é atribuido o valor NULL.
EM AMBAS AS SITUAÇÕES OS VALORES DO NÓ EXCLUÍDO TEM SEU VALOR RETORNADO*/
int removerUltimo(celula *&ini){
	celula *aux;
	int n;

	if (ini != NULL && ini -> prox != NULL){
		aux = ini;
		while (aux -> prox -> prox != NULL){
			aux = aux -> prox;
		}
		n = aux -> prox -> num;
		aux -> prox = NULL;
		aux = aux -> prox;
		free(aux);
		
		return n;
	}
	else if (ini -> prox == NULL){
		n = ini -> num;
		ini = NULL;
		return n;
	}
	else{
		return 0;
	}
}

/*Remove todos os nós da lista.
Armazena numa variável auxiliar a variável "inicio".
Em seguida, libera a memoria de aux e a "inicio" recebe o "prox"
de "inicio", até que "inicio" seja nulo (NULL).*/
void removerTudo(celula *&ini){
	celula *aux;
	aux = ini;
	
	while(ini != NULL){
		ini = ini -> prox;
		free(aux);
		aux = ini;
	}
}


/*Insere uma celula após a posição i de uma lista simplesmente encadeada.
Cria a celula no corpo da função e, ao ter certeza de que não se trata de uma lista vazia,
procura o indice i na lista, sempre se certificando de que não chegará ao final.
Após chegar ao indice i, um ponteiro auxiliar recebe o "prox" da celula[i],
e, em seguida, a mesma recebe como "prox" a celula nova, e a celula nova recebe o antigo prox,
armazenado no ponteiro anterior.*/
void inserePosI(celula *&ini, int indice, int num){
	celula *aux, *prox, *novo;
	novo = (celula*)malloc(sizeof(celula));
	novo -> num = num;
	novo -> prox = NULL;

	if (ini != NULL){
		aux = ini;
		for (int i = 0; i < indice; i++){
			if (aux == NULL){
				break;
			}
			aux = aux -> prox;
		}
		if (aux != NULL){
			prox = aux -> prox;
			if (prox == NULL){
				aux -> prox = novo;
			}
			else{
				aux -> prox = novo;
				novo -> prox = prox;
			}
		}
	}

}



/*Remove a i-ésima celula da lista. 
Atribui a uma variavel a celula anterior à celula[i] (no caso, i-1), 
atribui a uma variavel auxiliar a celula que se deseja que seja excluida, 
e atribui ao campo "prox" da celula[i-1] o ponteiro prox da celula[i]. 
Assim, a cadeia "passa por cima" da celula que se deseja excluir. 
Após isso, a memoria atribuida à mesma é liberada.*/
celula* removeI(celula *&ini, int i){
	celula *aux, *aux2 = NULL;
	int n;
	aux = ini;
	i = i-1;

	if (i == -1){
		if (ini != NULL){
			aux = ini;
			ini = ini -> prox;
			free(aux);
			return ini;
		}
	}

	else if (ini != NULL){
		for (int j = 0; j < i ; j++){
			if (aux -> prox == NULL){
				return ini;
			}
			aux = aux -> prox;
		}

		aux2 = aux -> prox;
		aux -> prox = aux2 -> prox;
		free(aux2);
		return ini;
	}
	return aux2;

}


/*Cria uma lista encadeada a partir da intersecção de duas listas encadeadas*/
celula* interseccao(celula *&lista1, celula *&lista2){
	celula *inter = (celula*)malloc(sizeof(celula));
	celula *aux1, *aux2;

	inter = NULL;

	aux1 = lista1;
	while (aux1 != NULL){
		aux2 = lista2;
		while (aux2 != NULL){
			if (aux2 -> num == aux1 -> num){
				adicionar(inter, aux2 -> num);
			}				
			aux2 = aux2 -> prox;
		}
		aux1 = aux1 -> prox;
	}


	return inter;
}

/*Cria uma lista encadeada a partir da uniao entre duas listas encadeadas*/
celula* uniaoComRep(celula *&lista1, celula *&lista2){
	celula *aux, *l3 = (celula*)malloc(sizeof(celula));
	l3 = NULL;

	aux = lista1;
	while (aux != NULL){
		adicionar(l3, aux -> num);
		aux = aux -> prox;
	}
	
	aux = lista2;
	while (aux != NULL){
		adicionar(l3, aux -> num);
		aux = aux -> prox;
	}
	removerTudo(lista1);
	removerTudo(lista2);

	return l3;
}



/*Concatena duas listas simplesmente encadeadas sem cabeça*/
celula* concatenar(celula *lista1, celula *&lista2){
	celula *aux = lista2;
	while (aux != NULL){
		adicionar(lista1, aux -> num);
		aux = aux -> prox;
	}

	removerTudo(lista2);

	return lista1;
}



int main(){
	celula *ini1 = NULL, *ini2 = NULL, *concat;
	celula *teste;
	int ult;

	for (int i = 1; i < 12; i++){
		adicionar(ini1, i);
	}

	for (int i = 5; i < 30; i++){
		adicionar(ini2, i);
	}

	teste = ini1;
	while(teste != NULL){
		printf("%d ", teste -> num);
		teste = teste -> prox;
	}
	printf("\n");

	teste = ini2;
	while(teste != NULL){
		printf("%d ", teste -> num);
		teste = teste -> prox;
	}
	printf("\n");

	teste = interseccao(ini1, ini2);

	while(teste != NULL){
		printf("%d ", teste -> num);
		teste = teste -> prox;
	}
	printf("\n");


































	// // // // teste = removeI(ini1, 10);
	// // // // inserePosI(ini1, 0, 56);

	// // // // while(teste != NULL){
	// // // // 	printf("%d ", teste -> num);
	// // // // 	teste = teste -> prox;
	// // // // }


	// ult = removerUltimo(ini);

	// teste = ini;
	// while(teste != NULL){
	// 	printf("%d ", teste -> num);
	// 	teste = teste -> prox;
	// }

	// removerTudo(ini);

	// teste = ini;
	// if (ini == NULL){
	// 	printf("\nLista vazia!\n");
	// }
	// else{
	// 	while(teste != NULL){
	// 		printf("%d ", teste -> num);
	// 		teste = teste -> prox;
	// 	}
	// }


	return 0;
}		