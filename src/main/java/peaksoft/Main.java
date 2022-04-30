package peaksoft;

import org.hibernate.query.UnknownSqlResultSetMappingException;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Util util = new Util();
        User user = new User();

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Kunzaada", "Bekzhanova", (byte) 23);
        userDaoHibernate.saveUser("Azat", "Tashkozhoev", (byte) 30);
        userDaoHibernate.saveUser("Kubinec", "Tashkozhoev", (byte) 21);
        System.out.println(userDaoHibernate.existsByFirstName("Kubinec"));
        userDaoHibernate.removeUserById(3L);
        userDaoHibernate.getAllUsers().forEach(System.out::println);
        userDaoHibernate.cleanUsersTable();
     userDaoHibernate.dropUsersTable(user);


//        System.out.println(util.getConnection());


        // UserServiceImpl userService = new UserServiceImpl();
//   userService.createUsersTable();
//        userService.saveUser("Almaz","Janybekov", (byte) 20);
//        userService.saveUser("Muhammed","Toichubay", (byte) 24);
//        userService.saveUser("Azat","Ibraev", (byte) 12);
//        userService.saveUser("Tologon","Tekebaev", (byte) 25);
//        userService.saveUser("Kuba","Abdulniazov", (byte) 22);
        // System.out.println(userService.existsByFirstName("Kuba"));
//      userService.dropUsersTable();
        // System.out.println(userService.getAllUsers());
        // userService.cleanUsersTable();


    }
}
