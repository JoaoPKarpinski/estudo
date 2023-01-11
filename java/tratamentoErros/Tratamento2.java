package tratamentoErros;

public class Tratamento2 {
    
    public static void main(String[] args) /*throws Exception*/{ // isso tira a necessidade de lidar com a exception
        Tratamento2 erro = new Tratamento2();
        
        //erro.throwException1(); // a mensagem é mostrada pela própria exceção e o programa se encerra, pois nao houve tratamento no momento em que a exceção foi lançada.
        
        try {
            erro.throwException2();
            System.out.println("Sem erro :)");
        } catch (Exception e) {
            System.out.println(e.getMessage()); // aqui a mensagem não é mostrada somente pelo fato de ter ocorrido a exceção. O objeto Exception é "capturado" e assim podemos mostrar a mensagem que ele carrega usando o getMessage().
        }

        //erro1.throwException2();
    }

    public void throwException1(){
        throw new RuntimeException("Ocorreu o erro 1!!!"); // A palavra reservada "throw" é a responsável por lançar a respectiva exceção
    }

    public void throwException2() throws Exception {
        throw new Exception("Ocorreu o erro 2!!!!");
    }
    /*
     * Uma exceção da classe RuntimeException (e de qualquer classe que descenda dela) é uma unchecked exception,
     * ou seja, não NECESSITA tratamento, nem aviso de lançamento.
     * 
     * Pelo contrário, uma exceção da classe Exception (e de qualquer classe que descenda dela (exceto a classe RuntimeException, pelos 
     * motivos expostos em https://docs.oracle.com/javase/specs/jls/se7/html/jls-11.html#jls-11.1.1)) é uma checked exception
     * e, ao lançar ele, é NECESSÁRIO um tratamento de erro (bloco try-catch) ou da palavrinha "throws" (que tem esse exato fim) no método
     * que irá utilizar essa exceção.
     * Uma unchecked exception também PRECISA da palavrinha "throws" no método que lançará a exceção, como no exemplo acima, no método
     * throwException2().
     */

}
