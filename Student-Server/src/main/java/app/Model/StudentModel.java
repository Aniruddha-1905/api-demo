package app.Model;

import java.util.List;

import app.Student.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentModel {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("app.data");

    // READ ALL
    public List<StudentEntity> getAllStudents() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery(
                    "SELECT s FROM StudentEntity s",
                    StudentEntity.class
            ).getResultList();
        }
    }

    // READ ONE
    public StudentEntity getStudent(int rollno) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(StudentEntity.class, rollno);
        }
    }

    // CREATE
    public void addStudent(StudentEntity s) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(s);
            tx.commit();
        } finally {
            em.close();
        }
    }

    // UPDATE
    public void updateStudent(StudentEntity s) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(s);
            tx.commit();
        } finally {
            em.close();
        }
    }

    // DELETE
    public void deleteStudent(int rollno) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            StudentEntity s = em.find(StudentEntity.class, rollno);
            if (s != null) {
                tx.begin();
                em.remove(s);
                tx.commit();
            }
        } finally {
            em.close();
        }
    }
}
