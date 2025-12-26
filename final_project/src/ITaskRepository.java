import java.util.ArrayList;

public interface ITaskRepository {

    void addUser(User u);
    ArrayList<User> getUsers();
    User findUserById(int id);

    void addTask(Task t);
    ArrayList<Task> getTasks();
    Task findTaskById(int id);
}