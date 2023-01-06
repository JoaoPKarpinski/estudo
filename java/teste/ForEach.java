package teste;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ForEach {
    static void imprimirComMensagem(String str){
        System.out.println("Bom dia! " + str);
    }

    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Mensagem 1", "Mensagem 2", "Mensagem 3", "Mensagem 4");
        lista.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                imprimirComMensagem(t);
            }                                            // varios jeitos de usar a forEach do objeto tipo List
        });

        System.out.println("");

        lista.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println("Bom dia! " + t);
            }
        });

        System.out.println("");

        lista.forEach((nome) -> {
            System.out.println("Bom dia! " + nome);
        });

        System.out.println("");

        lista.forEach(System.out::println);

        System.out.println("");

        lista.forEach(ForEach::imprimirComMensagem);

        Livro li = new Livro("titulo", 10);
        
        //li.iniciarLinha((a) -> System.out.println("aqui ta indo o printar" + a)).andThen(palavra -> System.out.println("aqui ta indo o andThen" + palavra)).accept("aqui ta indo o accept");   // lembranca do quao chato é fazer isso
        
        li.iniciarLinha((a) -> System.out.println("aqui ta indo o printar" + a)).
                andThen((a) -> System.out.println("passando pelo primeiro andThen")).
                andThen((a) -> System.out.println("passando pelo segundo andThen")).
                accept(" string muito top");
        
        System.out.println(li.toString());
        
        
        // Consumer fTeste = li.iniciarLinha((a) -> System.out.println("aqui ta indo o printar" + a));
        // fTeste.accept("teste string");
    }
}
