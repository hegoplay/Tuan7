package tuan1.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import tuan1.entities.Clazz;
import tuan1.entities.Enrollment;
//import tuan1.entities.Enrollment;
import tuan1.entities.Student;

@Transactional
public class StudentDAO {
	public static Student findById(String id) {
		Constant.manager.clear();
		
		return Constant.manager.find(Student.class, id);
		
	}
	public static void deleteById(String id) {
		Constant.manager.clear();
		Constant.manager.remove(findById(id));
		Constant.manager.getTransaction().commit();
	}
	public static void insert(Student c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.persist(c);
		Constant.manager.getTransaction().commit();
		
	}
	public static void update(Student c) {
		Constant.manager.clear();
		Constant.manager.getTransaction().begin();
		Constant.manager.merge(c);
		Constant.manager.getTransaction().commit();
		
	}
//	2. Tính sỉ số sinh viên theo từng lớp học, giảm dần theo sỉ số.
	public static Map<Clazz,Integer> getSisoByLophoc(){
//		method group clazz and count from them
		CriteriaBuilder cb = Constant.manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Student> students = cq.from(Student.class);
		cq.multiselect(students.get("clazz"),cb.count(students)).groupBy(students.get("clazz"));
		List<Tuple> ls = Constant.manager.createQuery(cq).getResultList();
		Map<Clazz,Integer> mp = new HashMap<Clazz, Integer>();
		for(Tuple x : ls) {
			
			mp.put((Clazz)x.get(0), ((Long)x.get(1)).intValue());
//			System.out.println((Long)x.get(1));
		}
		return mp;
	}
//	3. Tính điểm trung bình của các môn học của các sinh viên
	public static Map<Student,Float> listSinhvienDiemTB(){
		CriteriaBuilder cb = Constant.manager.getCriteriaBuilder();
		
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Map<Student,Float> mp = new HashMap<>();
		
		Root<Enrollment> enrollRoot = cq.from(Enrollment.class);
		
		Join<Object, Object> join = enrollRoot.join("student",JoinType.RIGHT);
		
		
		
		CriteriaQuery<Tuple> select = cq.multiselect(
				enrollRoot.get("student"),
				cb.avg(enrollRoot.get("score")));
		select.groupBy(enrollRoot.get("student"));
		List<Tuple> ls = Constant.manager.createQuery(cq).getResultList();
		
		for(Tuple x : ls) {
			
			mp.put((Student)x.get(0), ((Double)x.get(1)).floatValue());
//			System.out.println((Long)x.get(1));
		}
		
		return mp;
		
	}
//	5. Những sinh viên học môn “Lập Trình Phân tán với Công Nghệ Java” có điểm cao
//	nhất.
	public static List<Student> listSinhvienGioiJava(){
		List<Student> ls = new ArrayList<>();
		
		TypedQuery<Student> query = Constant.manager.createQuery(
				"SELECT distinct s FROM Enrollment e "
				+ "JOIN e.student s "
				+ "where e.course.name = :name and "
				+ "e.score = (select max(e1.score) from Enrollment e1 where e1.course.name = :name) "
				+ "group by s",Student.class).
				setParameter("name", "Lập Trình Phân tán với Công Nghệ Java");
		 ls = query.getResultList();
		
		return ls;
	}
}
