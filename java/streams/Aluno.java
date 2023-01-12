package streams;

public class Aluno {
    private double media;
    private static int totalAlunos; // valor padrão em java para numéricos é 0
    private int numero;
    private String nome;
    private int idade;

    public Aluno(double media){
        totalAlunos++;
        this.numero = totalAlunos;
        this.media = media;
    }

    public Aluno(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public Double getMedia(){
        return this.media;
    }

    public int getNumero(){
        return this.numero;
    }

    public String toString(){
        return String.valueOf(this.numero);
    }
}
