package tratamentoErros.excecoes;


public class StringVaziaException extends RuntimeException {
    private String nomeAtributo;

    public StringVaziaException(String nomeAtr) {
        this.nomeAtributo = nomeAtr;
    }

    @Override
    public String getMessage() {
        return String.format("A String do atributo %s está vazia.", this.nomeAtributo);
    }
}