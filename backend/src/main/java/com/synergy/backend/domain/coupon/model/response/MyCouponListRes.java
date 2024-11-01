package com.synergy.backend.domain.coupon.model.response;

import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyCouponListRes {

    private Long memberCouponIdx;
    private String name;
    private Integer discountPercent;
    private LocalDateTime publicationDate;
    private LocalDateTime expirationDate;

    public static MyCouponListRes from(MemberCoupon memberCoupon) {
        return MyCouponListRes.builder()
                .memberCouponIdx(memberCoupon.getIdx())
                .name(memberCoupon.getCoupon().getName())
                .discountPercent(memberCoupon.getCoupon().getDiscountPercent())
                .publicationDate(memberCoupon.getPublicationDate())
                .expirationDate(memberCoupon.getExpirationDate())
                .build();
    }
}
