package controller;

import java.util.concurrent.Semaphore;

public class CorredorThread extends Thread {
	
	private int pessoaId;
	private Semaphore semaforo;
	
	public CorredorThread(int pessoa, Semaphore semaforo) {
		this.pessoaId=pessoa;
		this.semaforo=semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cruzarPorta();
			semaforo.release();
		}
	}

	private void porta() {
		int distancia=200;
		int percorrido;
		try {
			for(percorrido=0;percorrido<distancia;percorrido+=(int) (Math.random()*3)+4){
				sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void cruzarPorta() {
		int abrirPorta=(int)(Math.random()*2)+1;
		try {
			sleep(abrirPorta);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A "+(pessoaId+1)+" pessoa passou pela porta.");
		System.out.println("======================================");
	}
	
}
