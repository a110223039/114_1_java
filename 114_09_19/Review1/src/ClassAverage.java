import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args ){
        Scanner input = new Scanner(System.in);

        int total = 0;
        int gradeCounter = 0;

        System.out.println("輸入完成按Ctrl-z離開(Window) 或 ctrl-d(Mac/Linux)結束輸入\n ");

        while (input.hasNext()){
            if (input.hasNextInt()){
                System.out.println("請輸入整數成績");
                input.next(); //跳過非整數輸入
                continue;
            }else {
                System.out.println("輸入錯誤,請輸入整數成績");
                input.next();
            }
//            int grade = input.nextInt(); //讀取成績
//            if(grade == -1) break;
//            total += grade; //累計總分
//            gradeCounter++;
            //成績計數器+1
        }

        if (gradeCounter != 0){
            double average = (double) total / gradeCounter; //計算平均分
            System.out.printf("總分: %d%n",total);
            System.out.printf("成績數: %d%n",gradeCounter);
            System.out.printf("平均成績: %.2f%n", average);
        } else {
            System.out.println("沒有輸入任何成績");
        }
    }
}
