package com.unal.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
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

         if (computer.isPresent()) {
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

    // http://localhost:8080/computer/update/4
    @GetMapping("/computer/update/{id}")
    @ResponseBody
    public String update(@PathVariable(name = "id") Long id) {

        Optional<Computer> computer =  computerRepository.findById(id);

        if (computer.isPresent()) {

            Computer computer1 = Computer
                    .builder()
                    .computerId(id)
                    .computerName("asus laptop")
                    .computerTrade("asus tuf")
                    .computerPrice(18950)
                    .build();
            computerRepository.save(computer1);
            var entity = computer.get();
            return "data bulundu: "+entity +"<br/><br/>güncellendi: "+computer1;
        }else {
            return "böyle bir data bulunamadı: "+id;
        }
    }

    // http://localhost:8080/computer/updateComputer/3
    @GetMapping("/computer/updateComputer/{id}")
    @ResponseBody
    public String updateComputer(@PathVariable(name = "id") Long id) {

        System.setProperty("java.awt.headless","false");
        Optional<Computer> computer =  computerRepository.findById(id);
        String name,trade;
        double price;

        if (computer.isPresent()) {
            var entity = computer.get();
            var entity1 = computer.get();

            name = JOptionPane.showInputDialog("bilgisayar adı giriniz:");
            trade = JOptionPane.showInputDialog("bilgisayar markası giriniz:");
            price = Double.parseDouble(JOptionPane.showInputDialog("fiyatını giriniz:"));

            entity.setComputerName(name);
            entity.setComputerTrade(trade);
            entity.setComputerPrice(price);

            computerRepository.save(entity);

            return "data bulundu: "+entity +"<br/><br/>güncellendi: "+entity1;
        }else {
            return "böyle bir data bulunamadı: "+id;
        }
    }



































}
