package com.example.additional.controller;

import com.example.additional.DTO.CountExpelledDTO;
import com.example.additional.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping
@AllArgsConstructor
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @GetMapping("/ping")
    @ResponseBody
    public String helthCheck(){
        return "pong";
    }
    @ResponseBody
    @GetMapping("/group/{group-id}/expel-all")
    public ResponseEntity<CountExpelledDTO> expelAllStudentsInGroup(@PathVariable("group-id") Long groupId) {
        return ResponseEntity.ok(productServiceImpl.expelAllStudentsInGroup(groupId));
    }
    @ResponseBody
    @PutMapping("/statistics/count-expelled")
    public ResponseEntity<CountExpelledDTO> countExpelledAllTime() {
        return ResponseEntity.ok(productServiceImpl.getCountAllStudent());

    }

}
