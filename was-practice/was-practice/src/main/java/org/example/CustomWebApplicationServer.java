package org.example;


import lombok.Getter;
import org.calculate.Calculator;
import org.calculate.PositiveNumber;

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

                    HttpRequest httpRequest = new HttpRequest(br);
                    if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")){
                        QueryStrings queryStrings = httpRequest.getQueryStrings();

                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                    }
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
