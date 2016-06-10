
package model.PhoneBook;

import model.db.DBUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xubt on 4/23/16.
 */
public class PhoneBook {

    public void addPerson(Person person) throws Exception {
       DBUtil.addPerson(person);
    }

    public List<Person> loadPersons(List<Person> persons) throws SQLException, ClassNotFoundException {
        DBUtil.loadPersons(persons);
        return persons;
    }


    public Person findPersonByName(String name) throws ClassNotFoundException, SQLException {
        return DBUtil.findPersonByName(name);
    }

    public Person editPerson(String name, Person person) throws ClassNotFoundException, SQLException {
        DBUtil.editPerson(name,person);
        return person;
    }

    public void deletePerson(String name) throws ClassNotFoundException, SQLException {
        DBUtil.deletePerson(name);
    }
}