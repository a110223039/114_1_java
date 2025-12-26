import java.util.ArrayList;

public class TaskService extends BaseService {

    private ITaskRepository repo;
    private int nextTaskId = 1;

    public TaskService(ITaskRepository repo) {
        this.repo = repo;
    }

    public Task createTask(String title, String dueDate, int priority, Integer assigneeId) {

        User assignee = null;
        if (assigneeId != null) {
            assignee = repo.findUserById(assigneeId);
            require(assignee != null, "assignee not found");
        }

        Task t = new Task(nextTaskId++, title, dueDate, priority, assignee);
        repo.addTask(t);
        return t;
    }

    public void changeStatus(int taskId, int status) {
        Task t = getTask(taskId);
        t.setStatus(status);
    }

    public void assignTask(int taskId, int userId) {
        Task t = getTask(taskId);
        User u = repo.findUserById(userId);
        require(u != null, "user not found");
        t.setAssignee(u);
    }

    public Task getTask(int id) {
        Task t = repo.findTaskById(id);
        require(t != null, "task not found");
        return t;
    }

    public ArrayList<Task> listAll() {
        return repo.getTasks();
    }

    public ArrayList<Task> filterByStatus(int status) {
        ArrayList<Task> result = new ArrayList<Task>();
        for (Task t : repo.getTasks()) {
            if (t.getStatus() == status) {
                result.add(t);
            }
        }
        return result;
    }

    // Lambda（排序）
    public void sortByPriorityDesc(ArrayList<Task> list) {
        list.sort((a, b) -> b.getPriority() - a.getPriority());
    }
    public ArrayList<Task> filterByAssignee(int userId) {
        ArrayList<Task> result = new ArrayList<Task>();

        for (Task t : repo.getTasks()) {
            User a = t.getAssignee();
            if (a != null && a.getId() == userId) {
                result.add(t);
            }
        }

        return result;
    }

    public ArrayList<Task> searchByTitleKeyword(String kw) {
        ArrayList<Task> result = new ArrayList<Task>();

        if (kw == null) kw = "";
        kw = kw.trim();

        for (Task t : repo.getTasks()) {
            if (t.getTitle().indexOf(kw) >= 0) {
                result.add(t);
            }
        }

        return result;
    }

}

