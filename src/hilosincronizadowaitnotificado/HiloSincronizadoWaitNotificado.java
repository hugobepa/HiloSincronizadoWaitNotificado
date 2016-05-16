/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosincronizadowaitnotificado;

/**
 *Invocando wait(que es un método de la clase Object) se  suspende el hilo 
 * indefinidamente hasta que alguien le envíe una 'señal' con el método notify o 
   notifyAll
 * 
 * La sincronización se lleva a cabo pues usando los métodos wait y notifiAll

* synchronized en la declaración del método.Cuando la máquina virtual inicia  la  
* ejecución de un método con este modificador adquiere un bloqueo en el objeto 
* sobre el que se ejecuta el método que impide que nadie más inicie la ejecución 
  en ese objeto
  * public synchronized int get() {}
 */
public class HiloSincronizadoWaitNotificado {

   public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();
 
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
        }
    }
}
 
class ThreadB extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            notify();
        }
    }
}