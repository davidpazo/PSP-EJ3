package Hilos;

/**** @author dpazolopez ****/
public class Ejercicio3 extends Thread {

    Thread hilo = new Thread();
    static int cont = 1;
    int cont2 = 0;

    public Ejercicio3(String nom) {
        super(nom);
    }

    public static void main(String[] args) {
        
        new Ejercicio3("Hilo" + cont).start();
    }

    @Override
    public void run() {
        try {
            
            System.out.println(getName());
            while (cont <= 5) {
                cont++;
                hilo = new Ejercicio3("Hilo" + cont);
                
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName() + " procesando");
                    System.out.println("Hilo anterior esperando");
                    sleep(100);
                }
                
                if (cont2 <= 5) {
                    
                    hilo.start();
                    hilo.join();
                }
                System.out.println(getName() + " ha terminado");
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido "+ex);
        }
    }
}