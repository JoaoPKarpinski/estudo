#include <stdio.h>


int conta(int tam, int v[], int n){
	if (tam == 0 ){
		if (v[tam] == n){
			return 1;
		}
		else {
			return 0;
		}
	}
	else {
		if (v[tam] == n){
			return 1 + conta(tam - 1, v, n);
		}
		else {
			return 0 + conta(tam - 1, v, n);
		}
	}
}




int main(){
	int tam, n;

	scanf("%d", &tam);
	int vet[tam];

	for (int i = 0; i < tam; i++){
		scanf("%d", &vet[i]);
	}

	scanf("%d", &n);

	printf("%d\n", conta(tam, vet, n));

	return 0;
}