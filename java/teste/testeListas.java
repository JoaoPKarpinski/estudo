package teste;

import java.util.ArrayList;

public class testeListas {
    public static void main(String[] args){
        ArrayList<Livro> lista = new ArrayList<>();
        lista.add(new Livro("moby dick", 650));
        lista.add(new Livro("edgar allan poe vol1", 350));
        lista.add(new Livro("dracula", 450));
        lista.add(new Livro("grandes esperancas", 700));      // toString é usado no metodo get da classe ArrayList. Porem, a implementação 
        lista.add(new Livro("admiravel mundo novo", 350));    // da classe Object geralmente não é a mais desejada, entao precisa sobrescrever (no caso, na classe Livro).
        lista.add(new Livro("hamlet", 150));
        

        System.out.println(lista.contains(new Livro("dracula", 450))); // contains e remove usam o metodo equals, que foi sobrescrito na classe Livro
        
        System.out.println(lista.remove(0)); 
        System.out.println(lista.remove(new Livro("moby dick", 650)));
    } 
}
