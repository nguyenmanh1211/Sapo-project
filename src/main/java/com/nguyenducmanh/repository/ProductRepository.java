package com.nguyenducmanh.repository;

import com.nguyenducmanh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("select p.name as nameProducer,v.name as nameVersion , vo.color as color,vo.camera as camera,vo.cpu as cpu" +
//            ",vo.display as display ,vo.gpu as gpu , vo.ram as ram , vo.price as price from Product p " +
//            "left join Version v ON p.id = v.producer.id left join v.versions vo ")
//    List<CustomObject> findCustom();

    @Query("select p from Product p where  p.id = :id")
    Product findOneCustom(long id);
    @Query("select p from Product p where p.name = :name")
    Product findProductByName(@Param("name")String name);


    interface CustomObject {
        String getNameProducer();

        String getNameVersion();

        String getColor();

        Integer getRam();

        String getCpu();

        String getGpu();

        String getDisplay();

        String getCamera();

        Integer getPrice();
    }

}
