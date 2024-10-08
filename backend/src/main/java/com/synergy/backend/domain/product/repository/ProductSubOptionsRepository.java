package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.entity.ProductSubOptions;
import jakarta.persistence.LockModeType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductSubOptionsRepository extends JpaRepository<ProductSubOptions, Long> {
    @Query("SELECT s FROM ProductSubOptions s LEFT JOIN s.majorOption m LEFT JOIN s.majorOption.product"
            + " WHERE s.majorOption.product = :product"
            + " AND s.majorOption.name = :major"
            + " AND s.name = :sub")
    Optional<ProductSubOptions> findSubOptionByProduct(Product product, String major, String sub);

    @Modifying // 데이터를 수정하거나 삭제하는 쿼리
    @Query("UPDATE ProductSubOptions s SET s.inventory = s.inventory - :count WHERE s.majorOption.product = :product"
            + " AND s.majorOption.name = :major AND s.name = :sub AND s.inventory >= :count")
    int decreaseInventory(@Param("product") Product product,
                          @Param("major") String major,
                          @Param("sub") String sub,
                          @Param("count") int count);
    //재고가 부족하면 아무런 작업도 하지 않음

}