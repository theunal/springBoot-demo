package com.unal.jpql;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class TeacherController {

    @Autowired
    TeacherRepository repository;


    // http://localhost:8080/ownQueryInterface/list
    @GetMapping("ownQueryInterface/list")
    @ResponseBody
    public String getTeacherList(Model model){
        List<Teacher> teacherEntityList = new ArrayList<>();
        for(int i = 1; i<=10 ; i++){
            teacherEntityList.add(Teacher.builder().teacherId(0L).teacherName("Adi".concat(""+i)).teacherSurname("Soyadi".concat(""+i)).build());
        }
        teacherEntityList.add(Teacher.builder().teacherId(0L).teacherName("Adi11").teacherSurname("balicak").build());
        teacherEntityList.add(Teacher.builder().teacherId(0L).teacherName("Adi12").teacherSurname("balicak").build());

        //liste olarak eklemek saveAll
        repository.saveAll(teacherEntityList);

            return teacherEntityList+"";

    }




    // http://localhost:8080/getSurname/surname1
    @GetMapping("/getSurname/{surname}")
    @ResponseBody
    public String getSurname(@PathVariable(name = "surname") String surname) {
        Iterable<Teacher> list = repository.findTeachersByTeacherSurname(surname);
        for (Teacher t : list) {
            log.info(t);
        }
        return list+"";
    }



}
