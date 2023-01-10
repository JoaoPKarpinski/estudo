package streams;

import java.util.Arrays;
import java.util.List;

public class Reduce1 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        
        // int resultado = lista.stream().reduce((total, num) -> {
        //     return num + total;
        // }).get(); 

        /*
        * O método get(), da classe Optional, retorna o valor armazenado no objeto -- nesse caso, retornado pelo metodo reduce()
        */
        
        int resultado = lista.stream().reduce((total, atual) -> total + atual).get();
        int diferença = lista.stream().reduce((total, atual) -> total + 1 + atual).get() - resultado; // isso não da certo, pois o total começa com o valor do primeiro elemento, deixando desnecesária a primeira iteração 
        double media = resultado / diferença;
        System.out.println("media = " + media + " diferenca " + diferença);

        System.out.println(resultado);

        resultado = lista.parallelStream().reduce(100, (total, atual) -> total + atual); // essa "forma" do metodo reduce retorna o tipo generico.

        System.out.println(resultado);
    }
}