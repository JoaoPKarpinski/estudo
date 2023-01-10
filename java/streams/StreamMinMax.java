package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamMinMax {
    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(new Aluno(7.3), new Aluno(8.0), new Aluno(5.5), new Aluno(10.0), new Aluno(9.4));
        
        Comparator<Aluno> comparador = (aluno1, aluno2) -> {
            if (aluno1.getMedia() > aluno2.getMedia()){
                return 1; // o metodo é construído dessa forma para fazer funcionar o max()
            }
            else if (aluno1.getMedia() < aluno2.getMedia()){
                return -1;
            }
            else {
                return 0;
            }
        };

        /*
         * O metodo max() retorna o objeto Optional que tiver o maior value (atributo na classe Optional)
         * enquanto o min() retorna o que tiver o menor value, obviamente.
         * Relembrando: o metodo get() retorna o objeto armazenado no Optional (nesse caso, uma obj Stream).
         * 
         * Relembrando, também: para aparecer algo além do hashcode no print, é preciso implementar o método
         * toString, herdado da classe Object. 
         */
        System.out.println(alunos.stream().max(comparador).get() + "\n");

        alunos.stream().forEach((a) -> { System.out.println(a.toString() + " " + a.getMedia()); });
    }
}
