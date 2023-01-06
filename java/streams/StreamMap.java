package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class StreamMap {
    public static void main(String[] args) {
        Consumer<String> print = System.out::print;
        List<String> marcas = Arrays.asList("BMW ", "Audi", "Honda");
        marcas.stream().map(m -> m.toUpperCase()).forEach(print);
        
        
        marcas.stream().map(Utilitarios.maiuscula).map(UtilitariosInterface::primeiraLetra).map(UtilitariosInterface::grito).forEach(print);
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
