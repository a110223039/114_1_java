import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ScannerFormatterDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // 用 Scanner 讀取 scores.txt 的資料
        try (Scanner scanner = new Scanner(new File("scores.txt"))) {
            System.out.println("正在讀取 scores.txt...");

            while (scanner.hasNext()) {
                String name = scanner.next();      // 讀取姓名
                int score = scanner.nextInt();     // 讀取分數
                double gpa = scanner.nextDouble(); // 讀取 GPA

                // 根據分數判定等級
                String grade;
                if (score >= 90) {
                    grade = "A";
                } else if (score >= 80) {
                    grade = "B+";
                } else if (score >= 70) {
                    grade = "C+";
                } else {
                    grade = "C";
                }

                students.add(new Student(name, score, grade));
            }
        } catch (FileNotFoundException e) {
            System.out.println("檔案不存在: " + e.getMessage());
            return;
        }

        // 用 Formatter 寫入 outputScanner.txt
        try (Formatter formatter = new Formatter("outputScanner.txt")) {
            // 寫入標題
            formatter.format("=== 學生成績單 ===%n");
            formatter.format("%n");
            formatter.format("%-10s %5s %8s%n", "姓名", "分數", "等級");
            formatter.format("%-10s %5s %8s%n", "---", "---", "---");

            // 寫入讀取的學生資料
            for (Student student : students) {
                formatter.format("%-10s %5d %8s%n",
                    student.getName(),
                    student.getScore(),
                    student.getGrade());
            }

            System.out.println("資料已成功寫入 outputScanner.txt！");

        } catch (FileNotFoundException e) {
            System.out.println("無法建立檔案: " + e.getMessage());
        }
    }
}

