package training.spring.databasedemo.springdatabase.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import training.spring.databasedemo.springdatabase.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getLong("id"));
			person.setName(rs.getString("name").toUpperCase());
			person.setLocation(rs.getString("location").toUpperCase());
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person ", new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person findById(Long id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] { id },
				new PersonRowMapper());
	}

	public List<Person> getByName(String name) {
		return jdbcTemplate.query("select * from person where name = ?1", new Object[] { name },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public void deleteById(Long id) {
		jdbcTemplate.update("delete from person where id = ?", new Object[] { id });
	}

	public void insert(Person person) {
		jdbcTemplate.update("insert into person values (?, ?, ?, ?)",
				new Object[] { person.getId(), person.getBirthDate(), person.getLocation(), person.getName() });
	}

	public void update(Person person) {
		jdbcTemplate.update("update person set (name, location,birth_date)=(?, ?, ?) where id=?",
				new Object[] {person.getName(), person.getLocation(), person.getBirthDate(), person.getId() });
	}
}
