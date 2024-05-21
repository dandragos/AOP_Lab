package Task3andBonus;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChatSystem implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<User> users;
    private List<Topic> topics;

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

    public Topic getTopicByName(String name) {
        for (Topic topic : topics) {
            if (topic.getName().equals(name)) {
                return topic;
            }
        }
        return null;
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
