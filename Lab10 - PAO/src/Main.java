import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CustomContainer container = new IoCContainer();


        container.addInstance(new StudentDao());
        StudentDao dao = container.getInstance(StudentDao.class);
        System.out.println(dao != null ? "StudentDao instance added" : "Failed to add StudentDao instance");


        container.addInstance(new TeacherDao(), "teacherDao1");
        TeacherDao teacherDao = container.getInstance(TeacherDao.class, "teacherDao1");
        System.out.println(teacherDao != null ? "TeacherDao instance added with custom name" : "Failed to add TeacherDao instance with custom name");


        container.addFactoryMethod(StudentService.class, (c) -> new StudentService(c.getInstance(StudentDao.class)));
        StudentService studentService = container.getInstance(StudentService.class);
        System.out.println(studentService != null ? "StudentService instance created via factory" : "Failed to create StudentService instance via factory");


        Map<String, Object> parameters = new HashMap<>();
        parameters.put(StudentDao.class.getName(), new StudentDao());
        StudentService prototypeStudentService = container.create(StudentService.class, parameters);
        System.out.println(prototypeStudentService != null ? "Prototype StudentService instance created" : "Failed to create prototype StudentService instance");


        try {
            container.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class StudentDao implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Closing StudentDao");
    }
}

class TeacherDao {}

class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
