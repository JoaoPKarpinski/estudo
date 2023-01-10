package streams;

public class Aluno {
    private double media;
    private static int totalAlunos; // valor padrão em java para numéricos é 0
    private int numero;

    public Aluno(double media){
        totalAlunos++;
        this.numero = totalAlunos;
        this.media = media;
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
