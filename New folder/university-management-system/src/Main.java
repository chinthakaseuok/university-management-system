import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String name,username,password;
        int age;
        String subject;
        int option,log;
        int course;
        Scanner input=new Scanner(System.in);

        System.out.println("Welcome to University Management System");
        System.out.println("");
        System.out.println("Select, [1] sign up, [2] sign in");
        log=input.nextInt();

        System.out.println("Please select an option to proceed");
        System.out.println("Press [1] Register as a Student");
        System.out.println("Press [2] Register as a Lecturer");

        option=input.nextInt();
        Subject sub=new Subject();

        switch (option){
            case 1:
                System.out.println("Student Registration");
                System.out.println("");
                System.out.println("Please Submit following information");
                System.out.println("1:  Name:");
                name=input.next();
                System.out.println("  Age:");
                age=input.nextInt();
                System.out.println("  Username:");
                username=input.next();
                System.out.println("  Password:");
                password=input.next();
                System.out.println(" Select course number from following list,");
                System.out.println("[1]"+modules.SENG1111_Introduction_to_Programming);
                System.out.println("[2]"+modules.SENG1112_Fndamantales_of_Engineering);
                System.out.println("[3]"+modules.SENG1113_Data_Structures_and_Algorithms);
                course=input.nextInt();
                Student student=new Student();

                switch (course){
                    case 1:
                        sub.setSubName(modules.SENG1111_Introduction_to_Programming);
                        break;
                    case 2:
                        sub.setSubName(modules.SENG1112_Fndamantales_of_Engineering);
                        break;
                    case 3:
                        sub.setSubName(modules.SENG1113_Data_Structures_and_Algorithms);
                        break;
                    default:
                }
                student.setStdAge(age);
                student.setStdName(name);
                System.out.println("You have successfully registered for following courses: ");
                //System.out.println("Name    :"+student.getStdName());
                //System.out.println("Age     :"+student.getStdAge());
                System.out.println(sub.getSubName());
                System.out.println("thank you !");
                break;


            case 2:
                System.out.println("Lecturer Registration");
                System.out.println("");
                System.out.println("Please Submit following information");
                System.out.println("  Name:");
                name=input.next();
                System.out.println("  Age:");
                age=input.nextInt();
                System.out.println("  Username:");
                username=input.next();
                System.out.println("  Password:");
                password=input.next();
                System.out.println(" Select course number from following list,");
                System.out.println("[1]"+modules.SENG1111_Introduction_to_Programming);
                System.out.println("[2]"+modules.SENG1112_Fndamantales_of_Engineering);
                System.out.println("[3]"+modules.SENG1113_Data_Structures_and_Algorithms);
                course=input.nextInt();
                Lecture lecturer=new Lecture();
                switch (course){
                    case 1:
                        sub.setSubName(modules.SENG1111_Introduction_to_Programming);
                        break;
                    case 2:
                        sub.setSubName(modules.SENG1112_Fndamantales_of_Engineering);
                        break;
                    case 3:
                        sub.setSubName(modules.SENG1113_Data_Structures_and_Algorithms);
                        break;
                    default:
                }
                lecturer.setName(name);
                lecturer.setAge(age);
                lecturer.setUsername(username);
                System.out.println("Lecturer Registration Completed");
                System.out.println("Name    :"+lecturer.getName());
                System.out.println("Age     :"+lecturer.getAge());
                System.out.println("Subject :"+sub.getSubName());
                break;
            default:

        }




    }
}