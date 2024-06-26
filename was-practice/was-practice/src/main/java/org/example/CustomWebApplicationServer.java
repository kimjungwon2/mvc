package org.example;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@Getter
public class CustomWebApplicationServer {
    private final int port;

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            log.info("[CustomWebApplicationServer] started {} port.", port);
            Socket clientSocket;
            log.info("[CustomWebApplicationServer] waiting for client.");

            while((clientSocket = serverSocket.accept()) !=null){
                log.info("[CustomWebApplicationServer] client connected!");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
