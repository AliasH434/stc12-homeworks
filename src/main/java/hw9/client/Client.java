package hw9.client;

/*
Разработать клиент-серверный чат

1. Система состоит из двух приложений: клиента и сервера

2. В рантайме может быть любое количество экземпляров клиента. При старте каждому присваивается идентификатор

3. Клиент из консоли отправляет сообщения, которые получают все остальные клиенты и выводят у себя в консоль

4. Сервер отвечает за координацию клиентов и присвоение им идентификаторов

5. Сервер в консоли логирует все сообщения всех клиентов
 */

import hw9.server.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static Integer CLIENT_PORT = 4988;

    public static void main(String[] args) {
        ClientListener clientListener = new ClientListener();
        clientListener.start();
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", Server.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            OutputStreamWriter serverOutput = new OutputStreamWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String message;
            while ((message = scanner.nextLine()) != "") {
                BufferedWriter bufferedWriter = new BufferedWriter(serverOutput);
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
