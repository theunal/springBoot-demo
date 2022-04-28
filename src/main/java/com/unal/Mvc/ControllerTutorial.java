package com.unal.Mvc;

import com.unal.rest.product.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerTutorial {

    //http://localhost:8080/
    @GetMapping("/")
    @ResponseBody
    public String getRoot() {
        return "Root bileşeni";
    }

    //http://localhost:8080/templates/thymeleaf1
    @GetMapping("/templates/thymeleaf1")
    public String getThymleaf1() {
        return "thymeLeaf-1";
    }

    //http://localhost:8080/templates/thymeleaf2
    @GetMapping("/templates/thymeleaf2")
    public String getThymleaf2(Model model) {
        model.addAttribute("key", "Model Merhabalar Nasılsınız");
        return "thymeLeaf-2";
    }

    //http://localhost:8080/templates/thymeleaf3
    @GetMapping("/templates/thymeleaf3")
    public String getThymleaf3(Model model) {
        model.addAttribute("key", "Model Merhabalar Nasılsınız");
        return "css-js-3";
    }

    //http://localhost:8080/templates/thymeleaf4
    @GetMapping("/templates/thymeleaf4")
    public String getThymleaf4(Model model) {
        ProductDto productDto = ProductDto.builder().
                productId(12L).
                productName("iPhone 7").
                price(6500.0).
                trade("marka").build();
        model.addAttribute("key2", productDto);
        return "object-4";
    }

    //http://localhost:8080/templates/thymeleaf5
    @GetMapping("/templates/thymeleaf5")
    public String getThymleaf5(Model model) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto(1, "iphone 7", 6500, "apple"));
        productDtoList.add(new ProductDto(2, "iphone 8", 7801, "apple"));
        productDtoList.add(new ProductDto(3, "iphone x", 9584, "apple"));
        productDtoList.add(new ProductDto(4, "iphone 12", 16845, "apple"));
        model.addAttribute("keys", productDtoList);

        return "object-5";
    }

    // path variable
    //http://localhost:8080/templates/thymeleaf6/44
    @GetMapping("/templates/thymeleaf6/{id}")
    public String getPathVariable(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("key", "id: " + id);
        return "pathvar-6";
    }

    //http://localhost:8080/templates/thymeleaf7/44
    @GetMapping({"/templates/thymeleaf7", "/templates/thymeleaf7/{id}"})
    public String getPathVariableNonRequired(Model model, @PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            model.addAttribute("key", "id: " + id);
        } else {
            model.addAttribute("key", "aradıgınız urun bulunamadı");
        }

        return "pathvar-7";
    }

    // attribute den önce ? koyuyoruz sonra = yazıp deger veriyoruz
    // iki attribute i birleştirmek için &
    //http://localhost:8080/templates/thymeleaf8?ad=yusuf&soyad=unal
    @GetMapping("/templates/thymeleaf8")
    public String getRequestParam(
            Model model,
            @RequestParam(name = "ad", required = false,defaultValue = "") String ad,
            @RequestParam(name = "soyad", required = false, defaultValue = "") String soyad) {

//        if (ad == null) {
//            ad = " ";
//        } else if (soyad == null) {
//            soyad = " ";
//        }
            model.addAttribute("key", "ad soyad: " + ad + " " + soyad);


        return "requestParam-8";
    }


}
