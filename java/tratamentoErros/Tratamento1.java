package tratamentoErros;

public class Tratamento1 {
    /*  Exception != Error. Error é uma condição da qual o sistema não pode se recuperar: a tarefa deve ser encerrada.
     *  Pelo contrário, de uma Exception o sistema consegue se recuperar e a tarefa pode ser concluída.
     *  Ambas as classes descendem da superclasse Throwable. 
     */

    public static void main(String[] args) {
        //Exemplo básico do famoso try-catch:
        try {
            System.out.println(56 / 0);
        } catch (ArithmeticException e) {
            System.out.println("ocorreu o erro: " + e.getMessage());
        }
    }
    
}
