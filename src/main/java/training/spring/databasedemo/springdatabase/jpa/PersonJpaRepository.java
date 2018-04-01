package training.spring.databasedemo.springdatabase.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import training.spring.databasedemo.springdatabase.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Person> findAll(){
		TypedQuery<Person> createNamedQuery = entityManager.createNamedQuery("all_persons", Person.class);
		return createNamedQuery.getResultList();
	}
	
	public Person findById(Long id){
		return entityManager.find(Person.class, id);
	}
	
	public Person insert(Person person){
		return entityManager.merge(person);
	}
	
	public Person update(Person person){
		return entityManager.merge(person);
	}
	
	public void deleteById(Long id){
		Person person = findById(id);
		entityManager.remove(person);
	}
}
