package com.spm.jpa.repository;

import com.spm.jpa.StudentRepository;
import com.spm.jpa.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testSave(){
        Student student = Student.builder().firstName("Suraj").lastName("pm").build();
        studentRepository.save(student);
        Assert.assertNotNull(student.getStudentId());
        Student result = studentRepository.findOne(student.getStudentId());
        Assert.assertEquals(student, result);
    }

    @Test
    public void testFindAl(){
        List<Student> studentList = new ArrayList<>();
        Student student = Student.builder().firstName("Suraj").lastName("pm").build();
        studentList.add(student);
        student = Student.builder().firstName("abc").lastName("xy").build();
        studentList.add(student);
        studentRepository.save(studentList);
        List<Student> result = (List<Student>)studentRepository.findAll();
        Assert.assertEquals(studentList, result);
    }

}
