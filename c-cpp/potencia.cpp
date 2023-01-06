#include <stdio.h>


int potencia(int x, int n){
	if (n == 1){
		return x;
	}
	else {
		return x * potencia(x, (n-1));
	}
}



int main(){
	int num, x, result;


	printf("insira o numero e a potencia\n");
	scanf("%d %d", &num, &x); 

	result = potencia(num, x);

	printf("o resultado é: %d\n", result);

	return 0;
}