package Task3andBonus;


import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public User getSender() {
        return sender;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }
}
