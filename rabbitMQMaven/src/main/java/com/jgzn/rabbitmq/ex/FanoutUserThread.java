package com.jgzn.rabbitmq.ex;

import com.jgzn.rabbitmq.util.ReceiveMQ;
import com.jgzn.rabbitmq.util.SendMQ;

public class FanoutUserThread {
	public static void main(String args[]) {
		Fanoutsend02 fanoutSend = new Fanoutsend02();
		Fanoutreceive02 fanoutReceive = new Fanoutreceive02();
		
		Thread fanoutsendThread = new Thread(fanoutSend);
		Thread fanoutreceiveThread = new Thread(fanoutReceive);
		
		fanoutsendThread.start();
		fanoutreceiveThread.start();
	}
}

class Fanoutsend02 implements  Runnable {
		SendMQ sendMQ = new SendMQ();
		public void run(){
			sendMQ.sendMQ();
		}
	}
	
class Fanoutreceive02 implements Runnable {
		public void run() {
			ReceiveMQ receiveMQ = new ReceiveMQ();
		    receiveMQ.receiveMQ();
		    }  
		}
		
	
	

