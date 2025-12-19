public class Student {
    private String name;
    private int score;
    private String grade;

    public Student(String name, int score, String grade) {
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + " " + score + " " + grade;
    }
}

