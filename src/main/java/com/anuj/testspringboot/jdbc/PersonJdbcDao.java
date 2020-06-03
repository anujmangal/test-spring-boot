package com.anuj.testspringboot.jdbc;

import com.anuj.testspringboot.jdbc.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PersonMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(LocalDate.parse(resultSet.getString("birth_date")));
            return person;
        }
    }

    public List<Person> getAllPersons(){
        return jdbcTemplate.query("select * from Person", new PersonMapper());
    }

    public int deleteById(int personId){
        return jdbcTemplate.update("delete from Person where id= ?", 1001);
    }

    public int insertPerson(Person person){
        return jdbcTemplate.update("insert into Person(id, name, location, birth_date) values (?, ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
    }

    public int updatePerson(String personName, int personId){
        return jdbcTemplate.update("update Person set name = ? where id = ?", personName, personId);
    }
}
