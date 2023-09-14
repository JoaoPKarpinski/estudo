import java.util.*;

//Interfaces funcionais funcionam da seguinte forma:

public class MyClass {
    public static void main(String args[]) {/* 
        Comparador.realizarComparacao(1, 1, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                System.out.println("metodo compare");
                return (a == b ? 0 : 1);
            }
        });
        */


        Comparador.realizarComparacao(1, 1, MyClass::comparar);
    }

    public static int comparar(Integer a, Integer b){
        System.out.println("metodo comparar");
        return (a == b ? 0 : 1);
    }
}


class Comparador{
    public static void realizarComparacao(int a, int b, Comparator<Integer> metodoComparacao){
        String str = metodoComparacao.compare(a, b) == 0 ? "iguais" : "diferentes";
        System.out.println("os numeros inseridos sao " + str);
    }
}
//O método passado por parâmetro nao necessita ser implementado por um "objeto" do tipo esperado, somente precisa dos parametros e retornos iguais aos declarados na interface funcional.
