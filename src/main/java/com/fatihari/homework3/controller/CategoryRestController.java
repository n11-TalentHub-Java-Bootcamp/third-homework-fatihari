package com.fatihari.homework3.controller;

import com.fatihari.homework3.entity.Category;
import com.fatihari.homework3.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/")
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public List<Category> findAll() {
        return iCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable String id) {
        return iCategoryService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody Category category)
    {
        category = iCategoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        iCategoryService.deleteById(id);
    }

}