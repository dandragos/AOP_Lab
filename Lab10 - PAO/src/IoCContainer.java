import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class IoCContainer implements CustomContainer {
    private final Map<String, Object> instances = new HashMap<>();
    private final Map<String, Function<CustomContainer, ?>> factoryMethods = new HashMap<>();

    @Override
    public <T> boolean addInstance(T instance) {
        if (instance == null) {
            throw new IoCContainerException("Null is not allowed as a parameter");
        }
        String className = instance.getClass().getName();
        return addInstance(instance, className);
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if (instance == null || customName == null) {
            throw new IoCContainerException("Null is not allowed as a parameter");
        }
        if (instances.containsKey(customName)) {
            throw new IoCContainerException("Instances cannot be redeclared");
        }
        instances.put(customName, instance);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new IoCContainerException("Null is not allowed as a parameter");
        }
        String className = type.getName();
        return (T) getInstance(type, className);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null || customName == null) {
            throw new IoCContainerException("Null is not allowed as a parameter");
        }
        Object instance = instances.get(customName);
        if (instance == null) {
            if (factoryMethods.containsKey(customName)) {
                instance = factoryMethods.get(customName).apply(this);
                instances.put(customName, instance);
            } else {
                throw new IoCContainerException("Cannot provide instance");
            }
        }
        if (!type.isInstance(instance)) {
            throw new IoCContainerException("Invalid type for object");
        }
        return (T) instance;
    }

    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
        if (type == null || factoryMethod == null) {
            throw new IoCContainerException("Null is not allowed as a parameter");
        }
        String className = type.getName();
        factoryMethods.put(className, factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (type == null) {
            throw new IoCContainerException("Null is not allowed as a parameter");
        }
        String className = type.getName();
        if (!factoryMethods.containsKey(className)) {
            throw new IoCContainerException("Cannot provide instance");
        }
        return type.cast(factoryMethods.get(className).apply(new CustomContainer() {
            @Override
            public <T> boolean addInstance(T instance) {
                throw new UnsupportedOperationException();
            }

            @Override
            public <T> boolean addInstance(T instance, String customName) {
                throw new UnsupportedOperationException();
            }

            @Override
            public <T> T getInstance(Class<T> type) {
                return type.cast(parameters.get(type.getName()));
            }

            @Override
            public <T> T getInstance(Class<T> type, String customName) {
                return type.cast(parameters.get(customName));
            }

            @Override
            public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
                throw new UnsupportedOperationException();
            }

            @Override
            public <T> T create(Class<T> type, Map<String, Object> parameters) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void close() throws Exception {
                throw new UnsupportedOperationException();
            }
        }));
    }

    @Override
    public void close() throws Exception {
        for (Object instance : instances.values()) {
            if (instance instanceof AutoCloseable) {
                ((AutoCloseable) instance).close();
            }
        }
    }
}
