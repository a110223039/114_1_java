import java.util.ArrayList;

public class UserService extends BaseService {

    private ITaskRepository repo;
    private int nextUserId = 1;

    public UserService(ITaskRepository repo) {
        this.repo = repo;
    }

    public User createUser(String name) {
        require(name != null && !name.trim().equals(""), "name cannot be empty");

        ArrayList<User> users = repo.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name.trim())) {
                throw new IllegalArgumentException("user already exists");
            }
        }

        User u = new User(nextUserId++, name.trim());
        repo.addUser(u);
        return u;
    }

    public ArrayList<User> listUsers() {
        return repo.getUsers();
    }

    public User getUser(int id) {
        User u = repo.findUserById(id);
        require(u != null, "user not found");
        return u;
    }
}
