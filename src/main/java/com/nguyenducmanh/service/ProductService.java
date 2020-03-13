package com.nguyenducmanh.service;

import com.nguyenducmanh.entity.Product;
import com.nguyenducmanh.entity.Version;
import com.nguyenducmanh.model.request.ProductRequest;
import com.nguyenducmanh.model.request.VersionRequest;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findOne(long id);
    Product insert(ProductRequest productRequest);
    Product update(ProductRequest productRequest,long id);
    void delete(long id);
    Version updateVersion(VersionRequest versionRequest,long id);
    void deleteVersion(long id);
    void deleteOption(long id);

}
