package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Student;

public class StudentDao {
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("dev");
	EntityManager manager= factory.createEntityManager();
	EntityTransaction transaction= manager.getTransaction();
	
 public void save(Student std)
 {
	 transaction.begin();
	 manager.persist(std);
	 transaction.commit();
 }
	
 public Student fetch(String email)
 {
	 List<Student> list=manager.createQuery("select x from Student x where email=?1").setParameter(1, email).getResultList();
	 if(list.isEmpty())
	 {
		 return null;
	 }
	 else{
		 return list.get(0);
	 }
 }
 public Student fetch(long number)
	 {
		 List<Student> list=manager.createQuery("select x from Student x where number=?1").setParameter(1, number).getResultList();
		 if(list.isEmpty())
		 {
			 return null;
		 }
		 else{
			 return list.get(0);
		 }
 }
 public List<Student> fetch()  //fetch all
 {
	 List<Student> list=manager.createQuery("select x from Student x").getResultList();
	 {
		 return list;
	 }
 }

public void delete(int id) {
	 transaction.begin();
	 manager.remove(manager.find(Student.class, id));
	 transaction.commit();
}

//to edit
public Student fetch(int id) {
 return manager.find(Student.class,id);
}

public void update(Student student) {
	 transaction.begin();
	 manager.merge(student);
	 transaction.commit();
}
}
