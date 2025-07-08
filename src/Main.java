import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Student{

    public Student(String name, int studentGrade, char gradeLetter) {
        this.name = name;
        this.studentGrade = studentGrade;
        this.gradeLetter = gradeLetter;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    int studentGrade;

    char gradeLetter;

    public char getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter(char gradeLetter) {
        this.gradeLetter = gradeLetter;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int numberOfStudent;

        System.out.println("Student Grade Analyzer");
        System.out.print("Enter number of Students: ");
        numberOfStudent = scan.nextInt();
        scan.nextLine(); //nextInt() does not read the newline character


        for(int i = 0; i < numberOfStudent; i++){
            System.out.print("Enter your name: ");
            String name = scan.nextLine();
            System.out.print("Enter score for " + name +": ");
            int studentGrade = scan.nextInt();
            scan.nextLine();
            char gradeLetter = (studentGrade >= 90) ? 'A' :
                               (studentGrade >= 80) ? 'B' :
                               (studentGrade >= 70) ? 'C' :
                               (studentGrade >= 60) ? 'D' : 'F';
            if (studentGrade >= 0 && studentGrade <= 100) {
                System.out.println(name + " got grade: " + gradeLetter);
            }else
                System.out.println("Invalid Grade");
            System.out.println(" ");// space
            students.add(new Student(name,studentGrade,gradeLetter));
        }
        System.out.println("----- Class Summary -----");
        int sum = 0;
        for (Student student : students) {
                sum += student.getStudentGrade();
        }
        double average = (double)sum/students.size();
        System.out.printf("Average score: %.2f%n",average);
        int a=0,b=0,c=0,d=0,f=0;
        for (Student student : students) {
            if (student.getGradeLetter() == 'A'){
                a++;
            } else if (student.getGradeLetter() == 'B'){
                b++;
            } else if (student.getGradeLetter() == 'C') {
                c++;
            } else if (student.getGradeLetter() == 'D') {
                d++;
            } else if (student.getGradeLetter() == 'F') {
                f++;
            }
        }
        System.out.println("Grade Counts: A:" + a + " B:" + b + " C:" + c + " D:" + d + " F:" + f);

        List<Student> topStudents = new ArrayList<>();

        int highestGrade = -1;
        for (Student student : students){
            if (student.getStudentGrade() > highestGrade){
                highestGrade = student.getStudentGrade();
            }
        }
        for (Student student : students) {
            if (student.getStudentGrade() == highestGrade) {
                topStudents.add(student);
            }
        }

        for (Student student : topStudents) {
            System.out.println("Top Student(s): " + student.getName() + " (" + student.getStudentGrade() + ")");
        }
    }
}