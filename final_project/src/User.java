public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        this.id = id;
        this.name = name.trim();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public String toString() {
        return "[" + id + "] " + name;
    }
}