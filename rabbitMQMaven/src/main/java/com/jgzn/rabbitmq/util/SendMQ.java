package com.jgzn.rabbitmq.util;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class SendMQ {
	private final static String HOST = "localhost";
	private final static String EXCHANGE_NAME = "fanout";
	private final static String QUEUE = "temp_fanout";
	private final static String ROUTKEY = "mq.fanout";

	public void sendMQ() {
		// 创建连接和频道
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);

		Connection connection = null;
		Channel channel = null;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			// 声明转发器和类型
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
			channel.basicQos(1);
			channel.queueBind(QUEUE, EXCHANGE_NAME, ROUTKEY);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("welcome to chatroom!");

		System.out.println("if you want quit,please click q to quit....");

		System.out.println("please first input your nickname:");

		@SuppressWarnings("resource")
		Scanner scanner2 = new Scanner(System.in);
		String nickname = scanner2.next();
		System.out.println("please input what you want to say:");
		String message = null;

		while (true) {
			@SuppressWarnings("resource")
			Scanner scanner3 = new Scanner(System.in);
			String inputtoexit = scanner3.next();
			// System.out.println("inputtoexit" + inputtoexit);
			if ("q".equals(inputtoexit)) {
				System.exit(0);
			} else {
				message = nickname + " say: " + inputtoexit;
			}
			// 往转发器上发送消息
			try {
				channel.basicPublish(EXCHANGE_NAME, "",
						MessageProperties.PERSISTENT_TEXT_PLAIN,
						message.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println(" [x] Sent '" + message + "'");

	}
}
