package tratamentoErros.excecoes;

import tratamentoErros.Pessoa;

public class Validar {
    private Validar(){
    
    }
    
    public static void pessoa(Pessoa pessoa) throws RuntimeException{
        if (pessoa == null){
            throw new NullPointerException();
        }
        if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()){ // trim() tira os espaços em branco da string
            throw new StringVaziaException("nome");
        }
        if (pessoa.getIdade() < 0 || pessoa.getIdade() > 123){
            throw new NumeroInvalidoException("idade");
        }
    } 
}

/* 
 * Somente o fato de um objeto de exceção ser lançado já é suficiente para a execução do programa ser interrompida,
 * se não houver tratamento, claro.
 */