package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams{
    public static void main(String[] args) {
        Consumer<Object> println = System.out::println;
        
        /*
         * Importante ressaltar que, após o Java 8, a nova funcionalidade que permite a criação de metodos
         * static -- que, por consequencia, não são abstract, como anteriormente era obrigatório à todos os
         * metodos, salvo o default -- em interfaces foi adicionada. Metodos static são permitidos em interfaces.
         */
        Stream<String> palavras = Stream.of("abacate", "mesa", "caminhão", "árvore"); // o metodo static "of" chama o metodo Arrays.stream(values) para retornar uma Stream.
        
        palavras.forEach(println); // o metodo forEach recebe uma interface funcional como parametro (uma interface Consumer, que recebe um parametro e retorna void), por isso o objeto "println" recebe a referencia de sout

        String[] maisPalavras = {"notebook", "lampada", "bandagem", "tesoura"};

        Stream.of(maisPalavras).forEach(println); // retorna um Stream do array passado no parametro.

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream().forEach(println);

        int[] intNumeros = {7, 8, 9, 10, 11, 12};
        Arrays.stream(intNumeros).forEach((num) -> System.out.println(num)); // esse metodo aceita apenas arrays mais basicos (TipoDoObjeto[]).
        


        // Stream.generate(() -> "a"). forEach(println); // gerando elementos infinitos de acordo com a lambda.
        // Stream.iterate(0, n -> n + 1) .forEach(println); // gerando elementos infinitos de acordo com o valor inicial (primeiro parametro) e a lambda.
    }
}