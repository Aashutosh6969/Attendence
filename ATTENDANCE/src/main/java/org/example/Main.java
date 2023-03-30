package org.example;

import org.example.model.Attendance;
import org.example.model.Class;
import org.example.model.Users;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = Dbhandler.connect();
        Dbhandler db = new Dbhandler();
        String username;
        String password;

        System.out.println("Press 1 to insert data");
        System.out.println("Press 2 to select data");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input==1){
            System.out.println("Press 1 to insert in users table");
            System.out.println("Press 2 to insert in class table");
            System.out.println("Press 3 to insert in attendence table");
            int input2 = scanner.nextInt();
            if (input2==1) {
                System.out.println("Enter new username");
                username = scanner.next();
                System.out.println("Set password");
                password = scanner.next();
                Users users = new Users(username, password);
                db.insert_user(connection, users.getUsername(), users.getPassword());
            }
            if (input2==2){
                System.out.println("Enter class name");
                String class_name= scanner.next();
                db.insert_class(connection,class_name);
            }
            if (input2 == 3){
                System.out.println("Enter user id");
                int user_id= scanner.nextInt();
                System.out.println("Enter class id");
                int class_id = scanner.nextInt();
                System.out.println("Enter 1 for present and 0 for absent");
                int attendence = scanner.nextInt();
                Attendance att = new Attendance(class_id,user_id,attendence);
                db.insert_attendence(connection,class_id,user_id,attendence);
            }


        }
        if(input == 2){
            System.out.println("Press 1 to select from users");
            System.out.println("Press 2 to select from class");
            int input3= scanner.nextInt();
            if(input3 == 1){
                System.out.println("Enter user id");
                int inp_id = scanner.nextInt();
                db.select_users(connection,inp_id);
            }
            if(input3 == 2 ){
                System.out.println("Enter class id");
                int class_id = scanner.nextInt();
                db.select_class(connection,class_id);
            }
        }
    }
}