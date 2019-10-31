import java.net.SocketPermission;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int op;
        System.out.println("Welcome to University Management System");
        System.out.println("");
        System.out.println("Press [1] Register as a Student");
        System.out.println("Press [2] Register as a Lecturer");
        Scanner in=new Scanner(System.in);
        Student s=new Student();
        s.name=in.next();
        s.age=in.nextInt();
        op=in.nextInt();
    }
}
