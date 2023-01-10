package streams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Reduce2 {
    public static void main(String[] args) {
        CalcMedia inicial = new CalcMedia();

        BiFunction<CalcMedia, Aluno, CalcMedia> acumulador = (media, aluno) -> { // Superclasse da interface BinaryOperator.
            return media.adicionar(aluno.getMedia());
        }; 
        BinaryOperator<CalcMedia> agrupador = (mTotal, mAtual) -> {
            return mTotal.adicionar(mAtual.getTotal());
        };
        
        // Criando stream
        Stream<Aluno> alunos = Stream.of(new Aluno(10.0), new Aluno(9.0), new Aluno(8.3), new Aluno(7.2), new Aluno(3.2)); 
        
        /*
         * Nesse presente exemplo, o metodo usado é o reduce(), mas na sua forma onde recebe 3 parametros:
         * - VARIÁVEL INICIAL (a que acumulará em si todas as iteracões do metodo (como um x = x + y));
         * - MÉTODO QUE DARÁ AS INSTRUÇÕES DA "ACUMULAÇÃO" (método que irá agrupar os dados desejados do jeito desejado (nesse caso,
         *   em objetos da classe desejada));
         * - MÉTODO QUE JUNTARÁ OS OBJETOS INSTANCIADOS EM UM UNICO RESULTADO. 
         */
        double mediaAprov = alunos.filter(aluno -> aluno.getMedia() >= 6.0).reduce(inicial, acumulador, agrupador).calcular();

        System.out.println(mediaAprov); // média total dos aprovados.


        // Usando a mesma lógica, com a classe Double.
        BiFunction<CalcMedia, Double, CalcMedia> acumulador2 = (media, nota) -> { // Superclasse da interface BinaryOperator.
            return media.adicionar(nota);
        }; 
        BinaryOperator<CalcMedia> agrupador2 = (mTotal, mAtual) -> {
            return mTotal.adicionar(mAtual.getTotal());
        };
        

        try {
            double mediaTotal = alunos.map((aluno) -> aluno.getMedia()).reduce(inicial, acumulador2, agrupador2).calcular();
            System.out.println(mediaTotal);
        } catch (IllegalStateException e) { // Lidando com "Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed".
            System.out.println("Exceção capturada.\nA stream já passou por modificações e precisou ter seus dados 'reatribuídos'");
            alunos = Stream.of(new Aluno(10.0), new Aluno(9.0), new Aluno(8.3), new Aluno(7.2), new Aluno(3.2));
            double mediaTotal = alunos.map((aluno) -> aluno.getMedia()).reduce(inicial, acumulador2, agrupador2).calcular();
            System.out.println(mediaTotal);        
        }
    }
}


class CalcMedia {
    private int qnt;
    private double total;

    public CalcMedia adicionar(double valor){
        this.qnt++;
        this.total = this.total + valor;
        return this;
    }

    public double calcular(){
        return this.total / this.qnt;
    }

    public double getTotal(){
        return this.total;
    }
}