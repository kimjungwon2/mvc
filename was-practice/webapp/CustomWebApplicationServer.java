package org.webapp;


import lombok.Getter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Getter
public class CustomWebApplicationServer {
    private final int port;

    private final ExecutorService executorService= Executors.newFixedThreadPool(10);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println(port);
            Socket clientSocket;
            System.out.println("Waiting client");

            while((clientSocket = serverSocket.accept()) !=null){
                System.out.println("[CustomWebApplicationServer] client connected!");

                /**
                 * 사용자 요청을 메인 Thread가 처리
                 * **/

                executorService.execute(new ClientRequestHandler(clientSocket));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
