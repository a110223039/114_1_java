public class Task {
    private int id;
    private String title;
    private String dueDate;
    private int priority;
    private int status;
    private User assignee;

    public int getPriority() {
        return priority;
    }

    public Task(int id, String title, String dueDate, int priority, User assignee) {
        if (title == null || title.trim().equals("")) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
        if (!DateUtil.isValidDate(dueDate)) {
            throw new IllegalArgumentException("dueDate must be yyyy-MM-dd");
        }
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("priority must be 1..5");
        }

        this.id = id;
        this.title = title.trim();
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = TaskStatus.TODO;
        this.assignee = assignee;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getStatus() { return status; }
    public User getAssignee() { return assignee; }

    public void setStatus(int newStatus) {
        if (!TaskStatus.isValid(newStatus)) {
            throw new IllegalArgumentException("invalid status");
        }
        status = newStatus;
    }

    public void setAssignee(User u) {
        assignee = u;
    }

    public String toString() {
        String a = (assignee == null) ? "(unassigned)" : assignee.getName();
        return "[" + id + "] " + title +
                " | due=" + dueDate +
                " | p=" + priority +
                " | " + TaskStatus.toText(status) +
                " | " + a;
    }
        public boolean isOverdue(String today) {
            if (!DateUtil.isValidDate(today)) return false;
            if (status == TaskStatus.DONE) return false;
            return dueDate.compareTo(today) < 0;
        }

        public String toStringWithToday(String today) {
            String base = toString();
            if (isOverdue(today)) return base + "  OVERDUE";
            return base;
           }
}
