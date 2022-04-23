package com.unal.jpql.pagingAndSorting;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class PagingSortingController {

    @Autowired
    IPagingSorting iPagingSorting;

//      SAVE >> sadece db'ye eleman ekliyor paging ile birşey yok
//    // http://localhost:8080/pagingandsorting/save
    @GetMapping("pagingandsorting/save")
    @ResponseBody
    public String getPandS() {
        List<PagingSorting> pandslist = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            pandslist.add(PagingSorting
                    .builder()
                            .id(0L)
                            .pagingName("Adi: ".concat(""+i))
                    .build());
        }

        //liste olarak eklemek saveAll
        iPagingSorting.saveAll(pandslist);

        StringBuilder builder = new StringBuilder();
        builder.append("Eklendi: <br/> <br/>");
        for (var entity : pandslist) {
            log.info(entity);
            builder.append(entity+"<br/>");
        }

        return builder+"";
    }




















    //  0. SAYFADAKİ YANİ 1.SAYFADAKİ İLK 5 ELEMANI GETİRİYOR
    // http://localhost:8080/pagingandsorting/paging
//    @GetMapping("/pagingandsorting/paging")
//    @ResponseBody
//    public String getPaging() {
//        Pageable pageable = PageRequest.of(0,5);
//        Page<PagingSorting> entities = iPagingSorting.findAll(pageable);
//
//        for (var entity : entities) {
//            log.info(entity);
//        }
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("Getirildi: <br/> <br/>");
//        for (var entity : entities) {
//            log.info(entity);
//            builder.append(entity+"<br/>");
//        }
//
//        return builder+"";
//    }




    // PATHVARİABLE İLE VERDİĞİM PAGE E AİT İLK 5 ELEMAN GETİRİLDİ
    // http://localhost:8080/pagingandsorting/paging/1
//    @GetMapping("/pagingandsorting/paging/{paging}")
//    @ResponseBody
//    public String getPagingSpecial(@PathVariable(name = "paging") int paging) {
//        Pageable pageable = PageRequest.of(paging,5);
//        Page<PagingSorting> entities = iPagingSorting.findAll(pageable);
//
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("Getirildi: <br/><br/>");
//        for (var entity : entities) {
//            log.info(entity);
//            builder.append(entity+"<br/>");
//        }
//
//        return builder+"";
//    }







    // KÜÇÜKTEN BÜYÜĞE SIRALAMA sort.by içine entitydeki field yazılıyor
    // http://localhost:8080/pagingandsorting/sorting/asc
    @GetMapping("/pagingandsorting/sorting/asc")
    @ResponseBody
    public String getSortingAsc() {

        // pagingName >> entity'deki isim ile aynı olacak
        Sort sort = Sort.by("pagingName");
        Iterable<PagingSorting> entities = iPagingSorting.findAll(sort);

        StringBuilder builder = new StringBuilder();
        builder.append("Küçükten büyüğe sıralandı: <br/><br/>");
        for (var entity : entities) {
            log.info(entity);
            builder.append(entity+"<br/>");
        }

        return builder+"";
    }











    // BÜYÜKTEN KÜÇÜĞE SIRALAMA
    // http://localhost:8080/pagingandsorting/sorting/desc
//    @GetMapping("/pagingandsorting/sorting/desc")
//    @ResponseBody
//    public String getSortingDesc() {
//
//        // entity deki isim olacak
//        Sort sort = Sort.by("pagingName").descending();
//        Iterable<PagingSorting> entities = iPagingSorting.findAll(sort);
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("Büyükten küçüğe sıralandı: <br/><br/>");
//        for (var entity : entities) {
//            log.info(entity);
//            builder.append(entity+"<br/>");
//        }
//
//        return builder+"";
//    }



    // SAYFA, ELEMAN SAYISI VE SIRALAMA TÜRÜNE GÖRE SORTİNG
    // http://localhost:8080/pagingandsorting/sorting/asc1
//    @GetMapping("/pagingandsorting/sorting/asc1")
//    @ResponseBody
//    public String getSortingPaging() {
//
//        Pageable pageable = PageRequest.of(0,10,Sort.by("pagingName").descending());
//        Page<PagingSorting> entities = iPagingSorting.findAll(pageable);
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("Küçükten büyüğe sıralandı: <br/><br/>");
//        for (var entity : entities) {
//            log.info(entity);
//            builder.append(entity+"<br/>");
//        }
//
//        return builder+"";
//    }
















}
