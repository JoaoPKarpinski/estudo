package tratamentoErros;

import tratamentoErros.excecoes.Validar;

public class Tratamento3 {
    public static void main(String[] args) {
        Pessoa pessoaNormal = new Pessoa("Ahab", 45);
        Pessoa pessoaNula = null;
        Pessoa pessoaSemNome = new Pessoa(" ", 3);
        Pessoa pessoaVelhaDemais = new Pessoa("Ishmael", 124);
        
        // Validar.pessoa(pessoaSemNome);

        try {
            Validar.pessoa(pessoaNormal);
            // Validar.pessoa(pessoaNula);
            // Validar.pessoa(pessoaSemNome);
            Validar.pessoa(pessoaVelhaDemais);
        } catch (NullPointerException e) {
            System.out.println("Objeto vazio.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        /*
         * As instâncias de RuntimeException e suas descendentes, como já dito aqui
         * são exceções com as quais não se precisa, necessariamente, lidar -- não precisam
         * de try-catch para existirem. 
         */

        System.out.println("Fim!");
    }
}