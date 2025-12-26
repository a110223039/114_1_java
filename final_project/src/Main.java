public class Main {
    public static void main(String[] args) {
        ITaskRepository repo = new InMemoryTaskRepository();
        AppMenu menu = new AppMenu(repo);
        menu.start();
    }
}