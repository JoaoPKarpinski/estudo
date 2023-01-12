package tratamentoErros.excecoes;

/*
 * Basicamente, uma exceção personalizada é apenas uma classe que descende de 
 * Throwable, Exception, ou RuntimeException -- como é o caso desses dois 
 * exemplos. Os métodos das superclasses podem ser sobrescritos, como é o caso de getMessage() 
 * aqui, e também novos metodos particulares à classe podem ser criados. Porém, de qualquer forma,
 * pela descendencia da classe, um throw de um objeto dela irá parar a execução do programa.  
 */

public class NumeroInvalidoException extends RuntimeException {
    private String nomeAtributo;

    public NumeroInvalidoException(String nomeAtr){
        this.nomeAtributo = nomeAtr;
    }

    @Override
    public String getMessage() {
        return String.format("O numero no atributo %s é inválido.", nomeAtributo);
    }
}