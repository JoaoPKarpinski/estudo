package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamMatch {
    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(new Aluno(7.3), new Aluno(8.0), new Aluno(5.5), new Aluno(10.0), new Aluno(9.4));
        
        /*
         * o método negate() retorna um objeto Predicate que nega o resultado da test() do objeto "original". 
         * ***Olhar construção interna da interface Predicate.    
         */
        Predicate<Aluno> aprovado = (a) -> a.getMedia() >= 6.0;
        Predicate<Aluno> reprovado = aprovado.negate();  
        
        System.out.println(alunos.stream().allMatch(aprovado)); // Retorna true se TODAS as iterações retornarem true (se todos os alunos foram aprovados).
        System.out.println(alunos.stream().anyMatch(reprovado)); // Retorna true se ALGUMA das iterações retornar true (se houver algum reprovado).
        System.out.println(alunos.stream().noneMatch(reprovado)); // Retorna true se NENHUMA das iterações retornar true (se nao houver nenhum reprovado).
        
    }
}
