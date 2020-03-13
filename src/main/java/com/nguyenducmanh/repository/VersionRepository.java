package com.nguyenducmanh.repository;

import com.nguyenducmanh.entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VersionRepository extends JpaRepository<Version, Long> {

    @Query("select p from Version p where p.id= :id")
    Version findOneCustom(@Param("id") long id);

//    @Query("select concat(p.name,' ',v.name) as nameProduct , vo.color as color,vo.camera as camera,vo.cpu as cpu" +
//            ",vo.display as display ,vo.gpu as gpu , vo.ram as ram , vo.price as price from Version v " +
//            "left join Product p ON p.id = v.producer.id left join v.versions vo where v.id =:id and vo.id = :oid")
//    List<CustomObject> findCustom(@Param("id") long id,@Param("oid") long oid);

//    @Query("select concat(p.name,' ',v.name) as nameProduct , v.image as img,v.id as id from Version v " +
//            "left join Product p ON p.id = v.product.id")
//    List<CustomObject2> findAllCustom();

    interface CustomObject {
        String getNameProduct();

        String getColor();

        Integer getRam();

        String getCpu();

        String getGpu();

        String getDisplay();

        String getCamera();

        Integer getPrice();

        String getImg();
    }

    interface CustomObject2 {
        String getNameProduct();

        String getImg();

        long getId();
    }
}
