package training.spring.databasedemo.springdatabase;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import training.spring.databasedemo.springdatabase.entity.Person;
import training.spring.databasedemo.springdatabase.jpa.PersonJpaRepository;

//@SpringBootApplication
public class SpringJpaApplication  implements CommandLineRunner{

	@Autowired
	private PersonJpaRepository personDao;
	
	Logger logger = LoggerFactory.getLogger(SpringJpaApplication.class);

	public static void main(String[] args){
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("All persons -> {}", personDao.findAll());
		logger.info("Person with id 10001 -> {}", personDao.findById(10001L));
		logger.info("Deleting persons with id 10001");
		personDao.deleteById(10001L);
		logger.info("All persons after delete-> {}", personDao.findAll());
		personDao.insert(new Person("Oana", "Craiova", new Timestamp(System.currentTimeMillis())));
		personDao.update(new Person("Flori", "Timisoara", new Timestamp(System.currentTimeMillis())));
		logger.info("All persons after insert-> {}", personDao.findAll());
	}
}
