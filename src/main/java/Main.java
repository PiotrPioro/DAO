import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = "";
        Scanner scan = new Scanner(System.in);

        while(true){
            displayMenu();
            input = scan.nextLine();
            switch (input) {
                case "create":
                    System.out.println("Enter username");
                    String username1 = scan.nextLine();
                    System.out.println("Enter email:");
                    String email1 = scan.nextLine();
                    System.out.println("Enter password:");
                    String password1 = scan.nextLine();
                    User user1 = new User(username1, email1, password1);
                    UserDao.create(user1);
                    System.out.println("New user:");
                    UserDao.printUser(user1);
                    break;
                case "read":
                    System.out.println("Enter the user id of the user to be downloaded:");
                    int id1 = scan.nextInt();
                    User user2 = UserDao.read(id1);
                    System.out.println("You downloaded the user with:");
                    UserDao.printUser(user2);
                    break;
                case "update":
                    System.out.println("Enter the id of the user whose data you want to update:");
                    int id2 = scan.nextInt();
                    System.out.println("Enter username:");
                    String username2 = scan.nextLine();
                    System.out.println("Enter email:");
                    String email2 = scan.nextLine();
                    System.out.println("Enter password:");
                    String password2 = scan.nextLine();
                    User user3 = new User(id2, username2, email2, password2);
                    UserDao.update(user3);
                    user3 = UserDao.read(user3.getId());
                    System.out.println("Field values after updating:");
                    UserDao.printUser(user3);
                    break;
                case "delete":
                    System.out.println("Enter the id of the user whose data you want to delete:");
                    int id3 = scan.nextInt();
                    User user4 = UserDao.read(id3);
                    System.out.println("You have deleted user with:");
                    UserDao.printUser(user4);
                    UserDao.delete(id3);
                    break;
                case "findAll":
                    User[] arrUser = UserDao.findAll();
                    for (int i=0; i<arrUser.length; i++){
                        UserDao.printUser(arrUser[i]);
                        System.out.println();
                    }
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a correct option.");
                }
           }
       }

        public static void displayMenu(){
            System.out.println("Please select an option:");
            System.out.println("create");
            System.out.println("read");
            System.out.println("update");
            System.out.println("delete");
            System.out.println("findAll");
            System.out.println("exit");
        }
}
