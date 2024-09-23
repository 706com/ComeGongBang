package com.synergy.backend.domain.review.service;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.review.model.entity.Review;
import com.synergy.backend.domain.review.model.request.CreateReviewReq;
import com.synergy.backend.domain.review.model.response.MyReviewListRes;
import com.synergy.backend.domain.review.model.response.ProductReviewRes;
import com.synergy.backend.domain.review.model.response.ReadDetailReviewRes;
import com.synergy.backend.domain.review.repository.ReviewRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    // 리뷰 작성
    public void createReview(CreateReviewReq req, Long memberIdx) throws BaseException {
        Member member = memberRepository.findById(memberIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_USER));

        Product product = productRepository.findById(req.getProductIdx()).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        if (!orderRepository.existsByIdxAndMemberIdx(req.getOrderIdx(), memberIdx)) {
            throw new BaseException(BaseResponseStatus.PURCHASE_REQUIRED);
        }

        if (req.getContent().length() < 15) {
            throw new BaseException(BaseResponseStatus.MIN_REVIEW_LENGTH);
        }

        if (req.getScore() < 0 || req.getScore() > 5) {
            throw new BaseException(BaseResponseStatus.INVALID_RATING);
        }

        reviewRepository.save(req.toEntity(member, product));
    }

    // 해당 상품 리뷰 리스트 조회
    public Page<ProductReviewRes> readReviewList(Long productIdx, int page, int size) throws BaseException {
        Pageable pageable = PageRequest.of(page, size);
        return reviewRepository.findByProductIdx(productIdx, pageable);
    }

    // 리뷰 상세 조회
    public ReadDetailReviewRes readReviewDetail(Long reviewIdx) throws BaseException {
        Review review = reviewRepository.findById(reviewIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_REVIEW));

        return ReadDetailReviewRes.from(reviewIdx, review);
    }


    public Page<MyReviewListRes> getMyReviewList(Long memberIdx, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return reviewRepository.findByReVIewByMemberIdx(memberIdx, pageable);

    }
}