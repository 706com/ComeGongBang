package com.synergy.backend.domain.product.model.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductSubOptionsRes {

    private String name;
    private Integer inventory;
    private Integer addPrice;

}