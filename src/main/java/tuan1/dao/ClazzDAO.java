package tuan1.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tuan1.entities.Clazz;
import tuan1.entities.ClazzProfile;
import tuan1.entities.Student;

public class ClazzDAO {
	public static Clazz findById(String id) {
		Constant.manager.clear();
		
		return Constant.manager.find(Clazz.class, id);
		
	}
	public static void deleteById(String id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
	}
	public static void insert(Clazz c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(Clazz c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static List<Clazz> clazzWithNoStudent(){
		 List<Clazz> ls = new ArrayList<>();
//		 Get CriteriaBuilder
		 CriteriaBuilder cb = Constant.manager.getCriteriaBuilder();
//		 Create query
		 CriteriaQuery<Tuple> cq = cb.createTupleQuery();
//		 Create root need to get value
		 Root<Student> studentRoot = cq.from(Student.class);
//		 Join clazz that we need (Optimal)
		 studentRoot.join("clazz",JoinType.RIGHT);
//		 create conditions
//		 Predicate pre = cb.
		 
//		 select value
		 Path<Object> path = studentRoot.get("clazz");
//		 having(cb.equal(cb.count(studentRoot),0));
//		 
		 List<Tuple> l = Constant.manager.createQuery(cq).getResultList();
		 for(Tuple t : l) {
			 ls.add((Clazz)t.get(0));
		 }
		 
		 return ls;
	}
//	4. Những lớp học chưa có sinh viên
	public static List<Clazz> listLophocNull(){
		 List<Clazz> ls = new ArrayList<>();
		 TypedQuery<Clazz> query = Constant.manager.createQuery("SELECT distinct c FROM Student s RIGHT JOIN s.clazz c where (s.id is null)",Clazz.class);
		 ls = query.getResultList();
		 return ls;
	}
}
