import java.util.ArrayList;

public class InMemoryTaskRepository implements ITaskRepository {

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public void addUser(User u) {
        users.add(u);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findUserById(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        return null;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task findTaskById(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                return tasks.get(i);
            }
        }
        return null;
    }
}