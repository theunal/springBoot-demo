package com.unal.jpql.spesificQuery;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class LaptopController {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private LaptopImp laptopImp;


    // http://localhost:8080/laptop/save
    @GetMapping("/laptop/save")
    @ResponseBody
    public String getLaptopSave() {

        Laptop laptop = null;

            laptop = Laptop
                    .builder()
                    .id(2L)
                    .laptopName("Adı: ")
                    .laptopPrice(3000)
                    .build();
            laptopRepository.save(laptop);



        return "Laptop eklendi";

    }

    // http://localhost:8080/laptop/findminprice/3000
    @GetMapping("/laptop/findminprice/{price}")
    @ResponseBody
    public String getLaptopMinPrice(@PathVariable(name = "price") double price) {

        Iterable<Laptop> list = laptopImp.findMin(price);
        for (Laptop laptop : list) {
            log.info(laptop);
        }

        return list+"";

    }

    // 1 - getLaptopStartsWith
    // http://localhost:8080/laptop/findminprice/3000
    @GetMapping("/laptop/findminprice/{name}")
    @ResponseBody
    public String getLaptopStartsWith(@PathVariable(name = "name") double name) {

        Iterable<Laptop> list = laptopImp.findMin(name);
        for (Laptop laptop : list) {
            log.info(laptop);
        }

        return list+"";

    }















}
