package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream1 {
   public static void main(String[] args) {
       List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9); // instanciamos a variavel como List a fim de manter a implementação no caso de haver a necessidade de uma mudança na implementação. Ao instanciar um objeto dessa interface, conseguimos trocar a implementação de Array.asList para qualquer objeto que implemente List.
       
        /*
        * Para percorrer todos os elementos 
        * do array com uma list simples:
        */
        for (int i = 0; i < nums.size(); i++){
            System.out.println(nums.get(i));
        }

        System.out.println("----------------");

        /*
        * Ou, alternativamente, usando foreach:
        */
        for (Integer num: nums){
            System.out.println(num);
        }

        System.out.println("----------------");

        /*
         * Agora, usando Stream para representar o
         * array:
         */
        Stream<Integer> sNums = nums.stream();

        sNums.forEach((num) -> System.out.println(num));
    }
}