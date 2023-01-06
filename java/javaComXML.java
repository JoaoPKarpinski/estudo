import java.io.File;
import java.io.FileReader;
// // import java.io.FileWriter;
import java.io.IOException;

public class javaComXML {
    public static void main(String[] args){
        File file = new File("teste.xml");
        char[] arq = new char[500];
        int tam;
        String todoArq = "";
        String[] fatias;
        String pedaco;
        try {
            FileReader fr = new FileReader(file);
            tam = fr.read(arq);
            for (int i = 0; i < tam; i++){
                System.out.print(arq[i]);
                todoArq = todoArq + arq[i];
            }
            
            System.out.println("\n\nstring formada:\n" + todoArq);
            
            if (todoArq.contains("xs:simpleType")){
                System.out.println("\n\nfunciona: " + todoArq.indexOf("xs:simpleType"));
                System.out.println("Fatias: ");

                fatias = todoArq.split("xs:sequence");
                for(String str: fatias){
                    System.out.println('\n' + str);
                }

                pedaco = fatias[1];
                System.out.println("e esse é o pedaco: \n" + pedaco);
                
                // // FileWriter fw = new FileWriter(file); //se quisesse escrever no fim do arquivo, deveria colocar no parametro do construtor "file.append()".
                // // fw.write(todoArq);
                // // fw.flush(); //por se tratar de uma classe que usa buffer, algum dado pode se perder no meio da stream. Portanto, a fim de não perder dados, o flush "empurra", todos os possíveis dados restantes que não foram processados.
                // // fw.close();

            }
            // // else{
            // //     System.out.println("\n\nnao tem");
            // //     todoArq = todoArq.replace("xs:tipoComplicado", "xs:simpleType");
                
            // //     FileWriter fw = new FileWriter(file); // instanciar um objeto FileWriter apaga os dados do arquivo, se nao for no modo append
            // //     fw.write(todoArq);
            // //     fw.flush();
            // //     fw.close();
            // // }
            fr.close();
        } catch (IOException e) { //a palavrinha "throws" obriga o tratamento do erro ao usar esse metodo. Nesse caso, o metodo construtor "FileReader(file)". 
            System.out.println(e);
        }
    } 
}

/*   SOBRE INSTANCIAR UMA VARIAVEL COM O CONTRATO DE INTERFACE
*    Você deve declarar uma variável como a interface se você precisa apenas do que está na interface. Se precisa do que está na classe concreta então 
*    deve declarar a classe concreta.
*
*    Fazer um cast ou outra coisa, é adotar um erro para consertar o primeiro erro cometido.
*
*    Interfaces devem ser usadas para segregar responsabilidades. Você programa para interface para que aquilo que receberá o objeto só possa acessar 
*    o que está naquele tipo. É proposital que não deixa acessar os demais membros do objeto concreto. Se usou a interface, aquele código desconhece 
*    o que não está na interface.
*
*    Ainda quer chamar didSomething() e ser por uma interface? Tem duas possibilidades:
*
*    Crie uma nova interface com esse método e aí poderá declarar a variável com o tipo da interface, acessar o método desejado, e estará programando 
*    para a interface. Considero este o mais adequado, mas pode não ser, em um exemplo abstrato assim, tudo é possível;
*    Coloque o método na interface já existente e poderá acessá-lo. Pode não ser o que deseja, mas é uma possibilidade. Eu não sei o que deseja, os 
*    nomes usados não indicam o que deveria ser.
*    Na verdade apesar de ser útil para ver o funcionamento, programar para interface em algo simples assim não tem utilidade prática alguma. É útil 
*    usar esta técnica quando tem sistemas complexos, que precisarão de manutenção e flexibilidade para trocar a implementação sem ter que trocar o contrato.
*/


/*
 * Seguindo essa mesma lógica, instanciar uma classe usando o construtor de uma subclasse da mesma é, lógicamente, usar os metodos da classe 
 * da forma que foram implementados na subclasse.
 */