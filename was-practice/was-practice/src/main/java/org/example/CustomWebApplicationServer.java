package org.example;


import lombok.Getter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


@Getter
public class CustomWebApplicationServer {
    private final int port;

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

                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    String line;
                    while ((line = br.readLine()) != "") {
                        System.out.println(line);
                    }
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
