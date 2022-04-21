package peaksoft;

import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

//        Util util = new Util();
//        System.out.println(util.getConnection());


        UserServiceImpl userService = new UserServiceImpl();
   //userService.createUsersTable();
//        userService.saveUser("Almaz","Janybekov", (byte) 20);
//        userService.saveUser("Muhammed","Toichubay", (byte) 24);
//        userService.saveUser("Azat","Ibraev", (byte) 12);
//        userService.saveUser("Tologon","Tekebaev", (byte) 25);
//        userService.saveUser("Kuba","Abdulniazov", (byte) 22);
      System.out.println(userService.existsByFirstName("Kuba"));
//      userService.dropUsersTable();
       // System.out.println(userService.getAllUsers());
       // userService.cleanUsersTable();



    }
}
