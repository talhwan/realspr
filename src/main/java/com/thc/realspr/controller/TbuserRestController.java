package com.thc.realspr.controller;

import com.thc.realspr.dto.TbuserDto;
import com.thc.realspr.service.TbuserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/tbuser")
@RestController
public class TbuserRestController {

    private final TbuserService tbuserService;
    public TbuserRestController(
            TbuserService tbuserService
    ) {
        this.tbuserService = tbuserService;
    }
    /*
    @PostMapping("")
    public Map<String, Object> create(@RequestBody Map<String, Object> param){
        System.out.println(param);
        return tbuserService.create(param);
    }
    @GetMapping("/get/{id}")
    public Map<String, Object> detail(@PathVariable("id") String id){
        System.out.println(id);
        return tbuserService.get(id);
    }
    @PutMapping("")
    public Map<String, Object> update(@RequestBody Map<String, Object> param){
        System.out.println(param);
        return tbuserService.update(param);
    }
    */
    @PostMapping("")
    public ResponseEntity<TbuserDto.TbuserAfterCreateDto> create(@RequestBody TbuserDto.TbuserCreateDto param){
        System.out.println("param : " + param);
        return ResponseEntity.status(HttpStatus.CREATED).body(tbuserService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<TbuserDto.TbuserAfterCreateDto> update(@RequestBody TbuserDto.TbuserUpdateDto param){
        System.out.println(param);
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.update(param));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<TbuserDto.TbuserSelectDto> detail(@PathVariable("id") String id){
        System.out.println(id);
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.get(id));
    }
}
