package teste;

import java.util.function.Consumer;

public class Livro implements Consumer<String>{
    int pag;
    int ano;
    String titulo;

    public Livro(String titulo, int nPag){
        this.pag = nPag;
        this.titulo = titulo;
    }

    public int getPag(){
        return this.pag;
    }
    public String getTitulo(){
        return this.titulo;
    }

    public void mostraTitulo(){
        System.out.println(this.titulo);
    }

    public void printLivro(){
        if (this.ano > 0){
            System.out.println(this.titulo + " - " + this.pag + " páginas. (" + this.ano + ")");
        }
        else{
            System.out.println(this.titulo + " - " + this.pag + " páginas.");
        }
    }

    /**
     * Implementando os métodos necessários para o funcionamento das ferramentas
     * de Array. 
     */
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        Livro comp = (Livro)obj;
        if (this.titulo.equals(comp.titulo) && this.pag == comp.pag){
            return true;
        }
        return false;
    }
    Consumer<String> iniciarLinha(Consumer<String> func){
        return (String t) -> {
            accept(t); 
            func.accept(t);
        };
    }

    @Override
    public void accept(String t) {
        System.out.println("a accept da classe ta sendo chamada");
    }
}

