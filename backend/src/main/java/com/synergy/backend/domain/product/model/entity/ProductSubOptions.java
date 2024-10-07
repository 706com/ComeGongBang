package com.synergy.backend.domain.product.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_sub_options")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSubOptions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "major_option_idx")
    private ProductMajorOptions majorOption;

    private String name;
    @Setter
    private Integer inventory;
    private Integer addPrice;

    @Version
    private Long version;
}