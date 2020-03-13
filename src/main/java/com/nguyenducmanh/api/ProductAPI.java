package com.nguyenducmanh.api;

import com.nguyenducmanh.entity.Product;
import com.nguyenducmanh.entity.Version;
import com.nguyenducmanh.model.request.ProductRequest;
import com.nguyenducmanh.model.request.VersionRequest;
import com.nguyenducmanh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> insert(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.insert(productRequest));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductRequest productRequest,@PathVariable long id){
        return ResponseEntity.ok(productService.update(productRequest,id));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product findOne(@PathVariable long id){
        return productService.findOne(id);
    }

    //VersionAPI
    @PutMapping("/version/{id}")
    public ResponseEntity<Version> updateVersion(@RequestBody VersionRequest versionRequest, @PathVariable long id){
        return ResponseEntity.ok(productService.updateVersion(versionRequest,id));
    }
}
