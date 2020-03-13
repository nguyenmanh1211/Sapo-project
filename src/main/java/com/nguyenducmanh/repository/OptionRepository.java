package com.nguyenducmanh.repository;

import com.nguyenducmanh.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OptionRepository extends JpaRepository<Option,Long> {
    @Query("select o from Option  o where o.id = :id")
    Option findOneCustom(@Param("id")long id);
}
