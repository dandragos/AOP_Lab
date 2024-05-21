package Task3andBonus;


import java.io.*;
import java.net.*;

public class Client {
    private String userName;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String userName) {
        this.userName = userName;
    }

    public void connect(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        new Thread(new IncomingReader()).start();
    }

    public void subscribe(String topic) {
        out.println("subscribe " + userName + " " + topic);
    }

    public void unsubscribe(String topic) {
        out.println("unsubscribe " + userName + " " + topic);
    }

    public void sendMessage(String topic, String message) {
        out.println("message " + userName + " " + topic + " " + message);
    }

    private class IncomingReader implements Runnable {
        public void run() {
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client("Adrian");
            client.connect("localhost", 12345);

            client.subscribe("gatit");
            client.sendMessage("gatit", "Omlette du fromage");

            new Client("Ion");
            client.connect("localhost", 12345);

            client.subscribe("gatit");
            client.sendMessage("gatit", "Fasole");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
