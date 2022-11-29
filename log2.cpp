#include <stdio.h>



int log2(int n){
	if (n / 2 == 1){
		return 1;
	}
	else {
		return 1 + log2(n / 2);
	}
}






int main(){
	int num;

	scanf("%d", &num);

	printf("%d\n", log2(num));


	return 0;
}