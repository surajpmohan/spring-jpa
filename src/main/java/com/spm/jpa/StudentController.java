package com.spm.jpa;

import com.spm.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Student post(@RequestBody Student student) {
        System.out.println(student.toString());
        studentRepository.save(student);
        System.out.println(student.toString());
        return student;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Student get(@PathVariable(value = "id") Long id) {
        return studentRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Student> getAll() {
        return (List<Student>)studentRepository.findAll();
    }
}
