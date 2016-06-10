package model.PhoneBook;

import model.PhoneBook.Person;
import model.PhoneBook.PhoneBook;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/5/10 0010.
 */
public class ValidationUtil {
    private static PhoneBook phoneBook = new PhoneBook();

    public static boolean nameIsValid(String name) throws SQLException, ClassNotFoundException {
        Person foundPerson = phoneBook.findPersonByName(name);
        if (foundPerson.getName() == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean phoneNumberIsValid(String addPhoneNumber){
        String regEx = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        Pattern patter = Pattern.compile(regEx);
        Matcher matcher = patter.matcher(addPhoneNumber);
        boolean matchResult =  matcher.matches();
        return matchResult;
    }
}
