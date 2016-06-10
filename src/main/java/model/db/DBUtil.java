package model.db;

import model.PhoneBook.Person;

import java.sql.*;
import java.util.List;

public class DBUtil {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=true";
    private static String user = "root";
    private static String password = "199011081108";
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            System.out.println("Driver loaded");
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static int addPerson(Person person) throws SQLException {
        getConnection();
        //statement = connection.createStatement();
        String sql = "INSERT persons(name,phoneNumber) VALUES ('" + person.getName() + "','" + person.getPhoneNumber() + "')";
        int resultSet = statement.executeUpdate(sql);
        return resultSet;
    }

    public static int deletePerson(String name) throws SQLException {
        getConnection();
        //statement = connection.createStatement();
        String sql = "DELETE FROM persons WHERE name='" + name + "'";
        int resultSet = statement.executeUpdate(sql);
        return resultSet;
    }


    public static Person editPerson(String name, Person person) throws SQLException {
        getConnection();
        //statement = connection.createStatement();
        String sql = "UPDATE persons SET name='" + person.getName() + "',phonenumber='" + person.getPhoneNumber() + "'WHERE name='" + name + "'";
        statement.executeUpdate(sql);
        return person;
    }

    public static List<Person> loadPersons(List<Person> persons) throws SQLException {
        getConnection();
        //此处的statement不可省
        statement = connection.createStatement();
        String sql = "SELECT * FROM persons";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Person person = new Person();
            person.setName(resultSet.getString(1));
            person.setPhoneNumber(resultSet.getString(2));
            persons.add(person);
        }
        return persons;
    }

    public static Person findPersonByName(String name) throws ClassNotFoundException, SQLException {
        getConnection();
        statement = connection.createStatement();
        String sql = "SELECT * FROM persons WHERE name ='" + name + "'";
        resultSet = statement.executeQuery(sql);
        Person person = new Person();
        while (resultSet.next()) {
            person.setName(resultSet.getString(1));
            person.setPhoneNumber(resultSet.getString(2));
        }
        return person;
    }
}
