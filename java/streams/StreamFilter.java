package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import teste.Livro;

/*
 * O metodo filter funciona, muito intuitivamente, filtrando cada elemento 
 * da Stream e retornando o resultado em outra Stream. 
 * 
 * Importante: a stream retornada é do mesmo tipo que a original, apenas com 
 * possíveis elementos a menos.
 */
public class StreamFilter {
    public static void main(String[] args) {
        List<Livro> livros = Arrays.asList(new Livro("moby dick", 650),
                                           new Livro("edgar allan poe vol1", 350),
                                           new Livro("dracula", 450),
                                           new Livro("grandes esperancas", 700),
                                           new Livro("admiravel mundo novo", 350),
                                           new Livro("hamlet", 150));

        Stream<Livro> livrosFiltrados = livros.stream().filter((li) -> li.getPag() >= 200);

        System.out.println("Livros com 200 páginas ou mais:");
        
        livrosFiltrados.forEach(Livro::printLivro);
        

        Stream<Livro> livrosFiltrados2 = livros.stream().filter((li) -> li.getPag() >= 200).filter((li) -> li.getTitulo().charAt(0)  == 'a');
        
        System.out.println("\nLivros com 200 páginas ou mais e tenham o título iniciado com a letra A:");

        livrosFiltrados2.forEach(Livro::printLivro);

    }
}
