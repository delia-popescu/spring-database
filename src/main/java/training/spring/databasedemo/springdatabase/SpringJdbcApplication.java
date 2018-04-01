package training.spring.databasedemo.springdatabase;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import training.spring.databasedemo.springdatabase.entity.Person;
import training.spring.databasedemo.springdatabase.jdbc.PersonJdbcDAO;

//@SpringBootApplication
public class SpringJdbcApplication  implements CommandLineRunner{

	@Autowired
	private PersonJdbcDAO personDao;
	
	Logger logger = LoggerFactory.getLogger(SpringJdbcApplication.class);

	public static void main(String[] args){
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("All persons -> {}", personDao.findAll());
		logger.info("Person with id 10001 -> {}", personDao.findById(10001L));
		logger.info("Persons with name Delia -> {}", personDao.getByName("Delia"));
		logger.info("Deleting persons with id 10001");
		personDao.deleteById(10001L);
		personDao.insert(new Person(10004L, "Oana", "Craiova", new Timestamp(System.currentTimeMillis())));
		personDao.update(new Person(10002L, "Flori", "Timisoara", new Timestamp(System.currentTimeMillis())));
		logger.info("All persons -> {}", personDao.findAll());
	}
}
