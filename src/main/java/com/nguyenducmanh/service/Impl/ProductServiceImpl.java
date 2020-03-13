package com.nguyenducmanh.service.Impl;

import com.nguyenducmanh.entity.Option;
import com.nguyenducmanh.entity.Product;
import com.nguyenducmanh.entity.Version;
import com.nguyenducmanh.model.request.OptionRequest;
import com.nguyenducmanh.model.request.ProductRequest;
import com.nguyenducmanh.model.request.VersionRequest;
import com.nguyenducmanh.repository.OptionRepository;
import com.nguyenducmanh.repository.ProductRepository;
import com.nguyenducmanh.repository.VersionRepository;
import com.nguyenducmanh.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private VersionRepository versionRepository;
    private OptionRepository optionRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, VersionRepository versionRepository, OptionRepository optionRepository) {
        this.productRepository = productRepository;
        this.versionRepository = versionRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(long id) {
        return productRepository.findOneCustom(id);
    }

    @Override
    public Product insert(ProductRequest productRequest) {
        Product product = productRepository.findProductByName(productRequest.getName());
        checkOptions(productRequest.getVersionRequest().getOptionsRequests());
        if (product != null) {
            if (!checkVersion(product, productRequest)) {
                System.out.println("Sản phẩm đã có sẵn phiên bản này trong hệ thống");
                return null;
            } else {
                product = updateProduct(productRequest, product.getId(), product);
                return product;
            }
        }
        product = insertProduct(productRequest);
        return product;
    }

    @Override
    public Product update(ProductRequest productRequest, long id) {
        Product product = productRepository.findOneCustom(id);
        checkOptions(productRequest.getVersionRequest().getOptionsRequests());
        if (product == null) {
            product = insertProduct(productRequest);
            return product;
        }
        if (!checkVersion(product, productRequest)) {
            BeanUtils.copyProperties(productRequest, product);
            productRepository.save(product);
            System.out.println("Sản phẩm đã có sẵn phiên bản này trong hệ thống");
            return null;
        }
        product = updateProduct(productRequest, id, product);
        return product;
    }

    @Override
    public void delete(long id) {
        Product product = productRepository.findOneCustom(id);
        for (Version version : product.getVersions()) {
            for (Option option : version.getOptions()) {
                optionRepository.delete(option);
            }
            versionRepository.delete(version);
        }
        productRepository.delete(product);
    }

    @Override
    public Version updateVersion(VersionRequest versionRequest, long id) {
//        Version version = versionRepository.findOneCustom(id);
//        if (version == null) {
//            System.out.println("Không tìm thấy phiên bản này!!!");
//            return null;
//        }
//        checkOptions(versionRequest.getOptionsRequests());
//        for (Option option : version.getOptions()) {
//            optionRepository.delete(option);
//        }
//        for (OptionRequest optionRequest : versionRequest.getOptionsRequests()) {
//            Option option = new Option();
//            BeanUtils.copyProperties(optionRequest, option);
//            option.setVersion(version);
//            optionRepository.save(option);
//        }
//
//        BeanUtils.copyProperties(versionRequest, version);
//        version.setModifiedDate(new Date());
//
//        versionRepository.save(version);
//        return version;
        return null;
    }

    @Override
    public void deleteVersion(long id) {
        Version version = versionRepository.findOneCustom(id);
        for (Option option : version.getOptions()) {
            optionRepository.delete(option);
        }
        versionRepository.delete(version);
    }

    @Override
    public void deleteOption(long id) {
        optionRepository.delete(optionRepository.getOne(id));
    }

    private boolean checkVersion(Product product, ProductRequest productRequest) {
        VersionRequest vsr = productRequest.getVersionRequest();
        for (Version vs : product.getVersions()) {
            if (vs.getNameVersion().equals(vsr.getNameVersion())) {
                return false;
            }
        }
        return true;
    }

    private Product insertProduct(ProductRequest productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        product.setCreatedDate(new Date());

        Version version = new Version();
        insertVersion(productRequest, version, product);

        insertOption(productRequest, version);

        productRepository.save(product);
        return product;
    }

    private Product updateProduct(ProductRequest productRequest, long id, Product product) {
        BeanUtils.copyProperties(productRequest, product);
        product.setModifiedDate(new Date());

        Version version = new Version();
        insertVersion(productRequest, version, product);

        insertOption(productRequest, version);

        productRepository.save(product);
        return product;
    }

    private void insertOption(ProductRequest productRequest, Version version) {
        for (OptionRequest optionRequest : productRequest.getVersionRequest().getOptionsRequests()) {
            Option option = new Option();
            BeanUtils.copyProperties(optionRequest, option);
            option.setVersion(version);
            optionRepository.save(option);
        }
    }

    private void insertVersion(ProductRequest productRequest, Version version, Product product) {
        BeanUtils.copyProperties(productRequest.getVersionRequest(), version);
        version.setCreatedDate(new Date());
        version.setProduct(product);
        versionRepository.save(version);
    }

    private List<OptionRequest> checkOptions(List<OptionRequest> options) {
        for (int i = 0; i < options.size(); i++)
            for (int j = i + 1; j < options.size(); j++) {
                if (options.get(i).getName().equals(options.get(j).getName())) {
                    options.remove(options.get(i));
                }
            }
        return options;
    }
}
