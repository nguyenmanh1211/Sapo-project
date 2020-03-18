package com.nguyenducmanh.Validator;

import com.nguyenducmanh.annotation.Version;
import com.nguyenducmanh.entity.Product;
import com.nguyenducmanh.model.request.VersionRequest;
import com.nguyenducmanh.repository.ProductRepository;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VersionValidator implements ConstraintValidator<Version, Object> {

    private String field;
    private String fieldMatch;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(Version constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean valid=true;
        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(field);
        VersionRequest fieldMatchValue = (VersionRequest) new BeanWrapperImpl(value)
                .getPropertyValue(fieldMatch);
        Product product = productRepository.findProductByName((String) fieldValue);
        if (product!=null){
            for (com.nguyenducmanh.entity.Version version:product.getVersions()){
                if (fieldMatchValue.getNameVersion().compareToIgnoreCase(version.getNameVersion())==0)
                    valid = false;
            }
        }
        return valid;
    }
}
