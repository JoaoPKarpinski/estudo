package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args) {
        Consumer<String> print = System.out::println;
        List<String> marcas = Arrays.asList("BMW", "Audi", "Honda");
        marcas.stream().map(m -> m.toUpperCase()).forEach(print);
                
        marcas.stream().map(Utilitarios.maiuscula)/*.map(UtilitariosInterface::primeiraLetra)*/.map(UtilitariosInterface::grito).forEach(print);


        List<String> numerosStr = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

        /*
         * O metodo Map, como bem diz o nome, mapeia a stream de acordo com a lambda do tipo Function<T, R>
         * (onde o tipo R é o retornado, e o tipo T é o passado por parametro).
         * 
         * No caso da Function retornar um Integer, como na situção abaixo, o que é retornado pelo map é: uma
         * Stream do tipo Integer.
         */
        Stream<Integer> numerosInt = numerosStr.stream().map((num) -> Integer.valueOf(num));

        numerosInt.forEach(System.out::println);
    }
}

class Utilitarios {
    public final static UnaryOperator<String> maiuscula = n -> n.toUpperCase();
        
    public final static UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + "";

    public final static UnaryOperator<String> grito = (p) -> p + "!!!";
}

interface UtilitariosInterface {
    public static String maiuscula(String n){ 
        return n.toUpperCase();
    }
        
    public static String primeiraLetra(String n){
        return n.charAt(0) + "";
    }

    public static String grito(String p){
        return p + "!!!";
    }
}
