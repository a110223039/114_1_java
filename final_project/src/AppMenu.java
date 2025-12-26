import java.util.ArrayList;
import java.util.Scanner;

public class AppMenu {

    private Scanner sc = new Scanner(System.in);

    private ITaskRepository repo;
    private UserService userService;
    private TaskService taskService;

    public AppMenu(ITaskRepository repo) {
        this.repo = repo;
        this.userService = new UserService(repo);
        this.taskService = new TaskService(repo);
    }

    public void start() {
        while (true) {
            try {
                showMenu();
                int c = readInt("選擇：");

                if (c == 0) {
                    System.out.println("Bye!");
                    break;
                }

                handle(c);

            } catch (Exception ex) {
                System.out.println("錯誤：" + ex.getMessage());
            }

            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("=== 任務管理系統 Task Management System ===");
        System.out.println("1) 新增使用者");
        System.out.println("2) 列出使用者");
        System.out.println("3) 新增任務");
        System.out.println("4) 列出任務（全部）");
        System.out.println("5) 列出任務（依狀態）");
        System.out.println("6) 列出任務（依負責人）");
        System.out.println("7) 變更任務狀態");
        System.out.println("8) 指派任務");
        System.out.println("9) 搜尋任務（標題關鍵字）");
        System.out.println("10) 排序（依優先度高→低）");
        System.out.println("0) 離開");
    }

    private void handle(int c) {
        if (c == 1) createUser();
        else if (c == 2) listUsers();
        else if (c == 3) createTask();
        else if (c == 4) listTasks(taskService.listAll());
        else if (c == 5) listByStatus();
        else if (c == 6) listByAssignee();
        else if (c == 7) changeStatus();
        else if (c == 8) assignTask();
        else if (c == 9) searchTask();
        else if (c == 10) sortPriority();
        else System.out.println("無此選項");
    }

    private void createUser() {
        String name = readLine("使用者名稱：");
        User u = userService.createUser(name);
        System.out.println("新增成功：" + u);
    }

    private void listUsers() {
        ArrayList<User> users = userService.listUsers();
        if (users.size() == 0) {
            System.out.println("(目前沒有使用者)");
            return;
        }
        for (User u : users) {
            System.out.println(u);
        }
    }

    private void createTask() {
        String title = readLine("任務標題：");
        String due = readLine("截止日(yyyy-MM-dd)：");
        int p = readInt("優先度(1~5)：");

        String s = readLine("指派使用者ID（直接 Enter 表示不指派）：");
        Integer assigneeId = null;
        if (!s.trim().equals("")) assigneeId = parseIntSafe(s.trim());

        Task t = taskService.createTask(title, due, p, assigneeId);
        System.out.println("新增任務成功：" + t);
    }

    private void listTasks(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("(目前沒有任務)");
            return;
        }
        String today = readLine("今天日期(yyyy-MM-dd)：");
        for (Task t : tasks) {
            System.out.println(t.toStringWithToday(today));
        }
    }

    private void listByStatus() {
        System.out.println("0=TODO, 1=IN_PROGRESS, 2=DONE");
        int st = readInt("狀態：");
        ArrayList<Task> list = taskService.filterByStatus(st);
        listTasks(list);
    }

    private void listByAssignee() {
        int uid = readInt("使用者ID：");
        ArrayList<Task> list = taskService.filterByAssignee(uid);
        listTasks(list);
    }

    private void changeStatus() {
        int tid = readInt("任務ID：");
        System.out.println("0=TODO, 1=IN_PROGRESS, 2=DONE");
        int st = readInt("新狀態：");
        taskService.changeStatus(tid, st);
        System.out.println("狀態更新成功");
    }

    private void assignTask() {
        int tid = readInt("任務ID：");
        int uid = readInt("指派使用者ID：");
        taskService.assignTask(tid, uid);
        System.out.println("指派成功");
    }

    private void searchTask() {
        String kw = readLine("關鍵字：");
        ArrayList<Task> list = taskService.searchByTitleKeyword(kw);
        listTasks(list);
    }

    private void sortPriority() {
        ArrayList<Task> list = taskService.listAll();
        taskService.sortByPriorityDesc(list);
        listTasks(list);
    }

    // ===== 輸入工具 =====
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            try {
                return parseIntSafe(s.trim());
            } catch (Exception ex) {
                System.out.println("請輸入整數");
            }
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private int parseIntSafe(String s) {
        if (s == null || s.equals("")) throw new IllegalArgumentException("empty number");
        int sign = 1;
        int i = 0;
        if (s.charAt(0) == '-') { sign = -1; i = 1; }
        int v = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') throw new IllegalArgumentException("not a number");
            v = v * 10 + (c - '0');
        }
        return v * sign;
    }
}
