package Task3andBonus;


import java.io.Serializable;
import java.util.*;

public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;
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
