package teste;


public class variosTeste extends superclasse {
    static int posicao = 0;
    public static void main(String[] args){
        variosTeste instTeste = new variosTeste();
        superclasse instSuper = new variosTeste(5);

        instSuper.chovendo();
        instSuper.metodoTop();
       // instSuper.metodoSoDaTeste();

        instTeste.metodoTop();                             
        System.out.println(variosTeste.posicao);          // testando o uso de 
        Thread thread = new Thread(new Runnable(){    // interfaces ao estilo
            public void run(){                            // lambda function (só que sem ser lambda ainda)
                System.out.println("ooi");             
            }
        });
        thread.run();
        
        testeClasseQueImprime testeImp = new testeClasseQueImprime();
        testeImp.correr(new testeInterface() {
            public void imprimir(){
                System.out.println("3 + 6 = 9");
            }
        });

        testeInterface testeInterface = () -> {System.out.println("testando a lambda");};
        testeInterface.imprimir();
    }

    public variosTeste(){
        super(0);
        posicao++; // como um valor static, não precisa do "this", que se refere à instância.
    }
    public variosTeste(int n){
        super(n);
        posicao++; // como um valor static, não precisa do "this", que se refere à instância.
    }

    public void metodoTop(){
        System.out.println("metodo da teste");
    }
    
    public void metodoSoDaTeste(){
        System.out.println("metodo só da teste");
    }
}

class superclasse {
    int num;
    int num2;

    public superclasse(int n){
        this.num = n;
    }
    public void metodoTop(){
        System.out.println("metodo da superclasse");
    }
    public void chovendo(){
        System.out.println("chovendo na superclasse");
    }
}


interface testeInterface{
    void imprimir();
}

class testeClasseQueImprime implements testeInterface{

    @Override
    public void imprimir() {
        System.out.println("imprimindo :)");    
    }

    public void correr(testeInterface teste){
        teste.imprimir();
    }
    
}