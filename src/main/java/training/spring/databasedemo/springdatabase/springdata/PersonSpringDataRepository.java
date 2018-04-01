package training.spring.databasedemo.springdatabase.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import training.spring.databasedemo.springdatabase.entity.Person;


public interface PersonSpringDataRepository extends JpaRepository<Person, Long>{
}
