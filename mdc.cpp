#include <stdio.h>



int mdc(int a, int b){
    int aux;
    if (a < b){
        aux = b;
        b = a;
        a = aux;
    }
	if (a % b == 0){
		return b;
	}
	else {
		return mdc(a, (a % b));
	}
}





int main(){
	int num1, num2, mult;


	scanf("%d %d", &num1, &num2);

	mult = mdc(num1, num2);

	printf("%d\n", mult);

	return 0;
}