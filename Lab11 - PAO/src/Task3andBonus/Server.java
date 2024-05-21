package Task3andBonus;


import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static List<User> users = new ArrayList<>();
    private static List<Topic> topics = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    processRequest(inputLine);
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void processRequest(String input) {
            String[] parts = input.split(" ", 3);
            if (parts.length < 2) return;

            String command = parts[0];
            String userName = parts[1];

            User user = getUserByName(userName);
            if (user == null) {
                user = new User(userName);
                users.add(user);
            }

            switch (command) {
                case "subscribe":
                    if (parts.length == 3) {
                        String topicName = parts[2];
                        Topic topic = getTopicByName(topicName);
                        if (topic == null) {
                            topic = new Topic(topicName);
                            topics.add(topic);
                        }
                        topic.subscribe(user);
                        out.println("Subscribed to " + topicName);
                    }
                    break;
                case "unsubscribe":
                    if (parts.length == 3) {
                        String topicName = parts[2];
                        Topic topic = getTopicByName(topicName);
                        if (topic != null) {
                            topic.unsubscribe(user);
                            out.println("Unsubscribed from " + topicName);
                        }
                    }
                    break;
                case "message":
                    if (parts.length == 3) {
                        String[] messageParts = parts[2].split(" ", 2);
                        if (messageParts.length == 2) {
                            String topicName = messageParts[0];
                            String messageContent = messageParts[1];

                            Topic topic = getTopicByName(topicName);
                            if (topic != null) {
                                sendMessageToTopic(user, topic, messageContent);
                            }
                        }
                    }
                    break;
                default:
                    out.println("Unknown command");
            }
        }

        private User getUserByName(String name) {
            for (User user : users) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
            return null;
        }

        private Topic getTopicByName(String name) {
            for (Topic topic : topics) {
                if (topic.getName().equals(name)) {
                    return topic;
                }
            }
            return null;
        }

        private void sendMessageToTopic(User sender, Topic topic, String content) {
            Message message = new Message(sender, topic.getName(), content);
            for (User user : topic.getSubscribers()) {
                if (!user.equals(sender)) {
                    System.out.println(message.formatMessage(user));
                }
            }
        }
    }
}
