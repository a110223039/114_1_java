public class TaskStatus {
    public static final int TODO = 0;
    public static final int IN_PROGRESS = 1;
    public static final int DONE = 2;

    public static String toText(int status) {
        if (status == TODO) return "TODO";
        if (status == IN_PROGRESS) return "IN_PROGRESS";
        if (status == DONE) return "DONE";
        return "UNKNOWN";
    }

    public static boolean isValid(int status) {
        return status == TODO || status == IN_PROGRESS || status == DONE;
    }
}