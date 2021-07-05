import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.util.Scanner;

public class Main {
    private static UserDao userDao = new UserDao();
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
                    userDao.create(user1);
                    System.out.println("New user:");
                    userDao.printUser(user1);
                    break;
                case "read":
                    System.out.println("Enter the user id of the user to be downloaded:");
                    int id1 = scan.nextInt();
                    scan.nextLine();
                    User user2 = userDao.read(id1);
                    System.out.println("You downloaded the user with:");
                    userDao.printUser(user2);
                    break;
                case "update":
                    System.out.println("Enter the id of the user whose data you want to update:");
                    int id2 = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter username:");
                    String username2 = scan.nextLine();
                    System.out.println("Enter email:");
                    String email2 = scan.nextLine();
                    System.out.println("Enter password:");
                    String password2 = scan.nextLine();
                    User user3 = new User(id2, username2, email2, password2);
                    userDao.update(user3);
                    user3 = userDao.read(user3.getId());
                    System.out.println("Field values after updating:");
                    userDao.printUser(user3);
                    break;
                case "delete":
                    System.out.println("Enter the id of the user whose data you want to delete:");
                    int id3 = scan.nextInt();
                    scan.nextLine();
                    User user4 = userDao.read(id3);
                    System.out.println("You have deleted user with:");
                    userDao.printUser(user4);
                    userDao.delete(id3);
                    break;
                case "findAll":
                    User[] arrUser = userDao.findAll();
                    for (int i=0; i<arrUser.length; i++){
                        userDao.printUser(arrUser[i]);
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
