package com.projetos.CrudSpring.controller;

import com.projetos.CrudSpring.dto.ProductDTO;
import com.projetos.CrudSpring.dto.ProductPutDTO;
import com.projetos.CrudSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return service.getAllProducts();
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Validated ProductDTO data){
        service.registerProduct(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Validated ProductPutDTO data){
        service.updateProduct(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
