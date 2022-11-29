#include <stdio.h>


int sequencia(int n){
	printf("%d ", n);
	if (n == 1){
		return 1;
	}
	else {
		if(n % 2 == 0){
			return 1 + sequencia(n / 2);
		}
		else {
			return 1 + sequencia((n * 3) + 1);
		}
	}
}






int main(){
	int num, qntd;

	scanf("%d", &num);

	qntd = sequencia(num);

	printf("%d", qntd);


	return 0;
}