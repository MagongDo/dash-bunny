package entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

// 사장님 쿠폰 정보를 관리하는 엔티티 클래스
@Entity
@Table(name = "owner_coupon")
public class OwnerCoupon {

    // 사장님 쿠폰 ID (자동 생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    // 가게 ID (필수)
    @Column(nullable = false)
    private Long storeId;

    // 쿠폰 승인 상태 (열거형, 필수)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private CouponStatus couponStatus;

    // 쿠폰명 (필수, 최대 길이 255자)
    @Column(nullable = false, length = 255)
    private String couponName;

    // 할인 금액 (필수)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discountPrice;

    // 최소 주문 금액 (필수)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal minDeliveryPrice;

    // 만료기한 (필수)
    @Column(nullable = false)
    private LocalDate expiryDate;

    // 할인 방식 (열거형, 필수)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private DiscountType discountType;

    // 최대 할인 금액 (할인 방식이 퍼센트일 경우 적용)
    @Column(precision = 10, scale = 2)
    private BigInteger maximumDiscount;

}

// 쿠폰 승인 상태를 정의하는 열거형
enum CouponStatus {
    PENDING, // 대기 중
    ONGOING, // 진행 중

}

// 할인 방식을 정의하는 열거형
enum DiscountType {
    FIXED,   // 정액 할인
    PERCENT  // 정률 할인
}