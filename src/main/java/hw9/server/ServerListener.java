package hw9.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerListener extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket clientSocket = new ServerSocket(Server.SERVER_PORT);
            Socket socket = clientSocket.accept();
            InputStream fromClient = socket.getInputStream();
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
            String message = null;
            while ((message = clientReader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
