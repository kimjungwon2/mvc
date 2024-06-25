package org.example;



import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class CustomWebApplicationServer {
    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void main(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            logger.debug("[CustomWebApplicationServer] started {} port.", port);
            Socket clientSocket;
            logger.debug("[CustomWebApplicationServer] waiting for client.");

            while((clientSocket = serverSocket.accept()) !=null){
                logger.debug("[CustomWebApplicationServer] client connected!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
