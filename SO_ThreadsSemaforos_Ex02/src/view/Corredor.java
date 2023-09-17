package view;

import java.util.concurrent.Semaphore;
import controller.CorredorThread;

public class Corredor {
	public static void main(String[] args) {
		Semaphore semaforo=new Semaphore(1);
		for(int i=0;i<4;i++) {
			Thread corredorThead=new CorredorThread(i, semaforo);
			corredorThead.start();
		}
	}
}
