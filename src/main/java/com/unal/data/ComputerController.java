package com.unal.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class ComputerController {

    @Autowired
    private IComputerRepository computerRepository;

    public ComputerController(IComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    // http://localhost:8080/computer/save
    @GetMapping("/computer/save")
    @ResponseBody
    public String saveComputer() {
        Computer computer = Computer.builder()
                .computerId(0L)
                .computerName("bilgisayar adı")
                .computerTrade("marka")
                .computerPrice(7000)
        .build();
        computerRepository.save(computer);
        return "Ekleme basarili: "+computer.getComputerName();
    }


    // http://localhost:8080/computer/requestparam?computerName=requestParamComputer
    @GetMapping("/computer/requestparam")
    @ResponseBody
    public String saveComputerRequestParam(
            @RequestParam(name = "computerName") String computerName) {

        Computer computer = Computer.builder()
                .computerId(0L)
                .computerName(computerName)
                .computerTrade("marka")
                .computerPrice(7000)
                .build();
        computerRepository.save(computer);

        return "Ekleme basarili: "+computer.getComputerName();
    }

    // http://localhost:8080/computer/findbyid/1
    @GetMapping("/computer/findbyid/{id}")
    @ResponseBody
    public String findById(@PathVariable(name = "id") Long id) {

         Optional<Computer> computer =  computerRepository.findById(id);

         if (!computer.isEmpty()) {
             var entity = computer.get();
             return "bulundu: "+entity;
         }else {
             return "böyle bir data bulunamadı: "+id;
         }
    }

    // http://localhost:8080/computer/delete/4
    @GetMapping("/computer/delete/{id}")
    @ResponseBody
    public String deleteById(@PathVariable(name = "id") Long id) {

        Optional<Computer> computer =  computerRepository.findById(id);

        if (computer.isPresent()) {
            var entity = computer.get();
            computerRepository.deleteById(id);
            return "silindi: "+entity;
        }else {
            return "böyle bir data bulunamadı: "+id;
        }
    }



































}
