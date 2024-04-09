package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Topic {
    private String name;
    private Map<User, Boolean> subscribers;

    public Topic(String name) {
        this.name = name;
        subscribers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void subscribe(User user) {
        subscribers.put(user, true);
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    public List<User> getSubscribers() {
        return new ArrayList<>(subscribers.keySet());
    }
}

class Message {
    private User sender;
    private String topic;
    private String content;

    public Message(User sender, String topic, String content) {
        this.sender = sender;
        this.topic = topic;
        this.content = content;
    }

    public String formatMessage(User recipient) {
        return "[" + recipient.getName() + "] " + sender.getName() + " @ " + topic + ": " + content;
    }
}

class ChatSystem {
    private List<User> users;
    List<Topic> topics;

    public ChatSystem() {
        users = new ArrayList<>();
        topics = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void createTopic(String name) {
        topics.add(new Topic(name));
    }

    public void subscribeToTopic(User user, Topic topic) {
        topic.subscribe(user);
    }

    public void unsubscribeFromTopic(User user, Topic topic) {
        topic.unsubscribe(user);
    }

    public void sendMessage(User sender, Topic topic, String content) {
        Message message = new Message(sender, topic.getName(), content);
        for (User user : topic.getSubscribers()) {
            if (!user.equals(sender)) {
                System.out.println(message.formatMessage(user));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Crearea utilizatorilor
        User adrian = new User("Adrian");
        User ion = new User("Ion");
        User maria = new User("Maria");
        User matei = new User("Matei");

        ChatSystem chatSystem = new ChatSystem();


        chatSystem.addUser(adrian);
        chatSystem.addUser(ion);
        chatSystem.addUser(maria);
        chatSystem.addUser(matei);

        chatSystem.createTopic("gatit");
        chatSystem.createTopic("programare");


        Topic cookingTopic = chatSystem.topics.get(0);
        Topic programmingTopic = chatSystem.topics.get(1);

        cookingTopic.subscribe(adrian);
        cookingTopic.subscribe(maria);

        programmingTopic.subscribe(adrian);
        programmingTopic.subscribe(ion);
        programmingTopic.subscribe(maria);
        programmingTopic.subscribe(matei);


        chatSystem.sendMessage(ion, programmingTopic, "Salutare!");
        chatSystem.sendMessage(adrian, cookingTopic, "Omlette du fromage");
    }
}

//Design patternul folosit este Observer, deoarece User este subiectul, iar Topic si ChatSystem sunt observatorii.
