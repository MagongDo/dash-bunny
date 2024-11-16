package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

// 가게 관리 및 가게 정보를 저장하는 엔티티 클래스
@Entity
@Table(name = "store_management")
public class StoreManagement {

    // 가게 ID (자동 생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    // 회원 ID (필수)
    @Column(nullable = false)
    private Long userId;

    // 가게 이름 (필수, 최대 길이 255자)
    @Column(nullable = false, length = 255)
    private String storeName;

    // 가게 소개 내용 (TEXT 타입)
    @Column(columnDefinition = "TEXT")
    private String description;

    // 가게 전화번호 (필수, 최대 길이 13자)
    @Column(nullable = false, length = 13)
    private String contactNumber;

    // 가게 위치 (필수, 최대 길이 255자)
    @Column(nullable = false, length = 255)
    private String location;

    // 가게 상태 (ENUM 타입, 기본값: PENDING)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StoreStatus storeStatus = StoreStatus.PENDING;

    // 카테고리 1
    @Column
    private String category1;

    // 카테고리 2
    @Column
    private String category2;

    // 카테고리 3
    @Column
    private String category3;

    // 가게 등록 서류 (필수, 최대 길이 255자)
    @Column(nullable = false, length = 255)
    private String storeRegistrationDocs;

    // 매출 금액 (소수점 2자리까지)
    @Column(precision = 19, scale = 2)
    private BigDecimal money;

    // 포장 여부 (0 또는 1로 표현)
    @Column(nullable = false)
    private int type;

    // 최소 배달 예상 시간 (단위: 분)
    @Column
    private Integer minDeliveryTime;

    // 최대 배달 예상 시간 (단위: 분)
    @Column
    private Integer maxDeliveryTime;

    // 평점 (소수점 1자리까지, 예: 4.5)
    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;

    // 찜한 횟수
    @Column(nullable = false)
    private int dibsCount;

    // 리뷰 수
    @Column(nullable = false)
    private int reviewCount;

    // 쇼츠 링크 (필요시 필드명 수정)
    @Column
    private String field;  // 'field'를 의미 있는 이름으로 바꾸세요

    // Getters and Setters
}

// 가게 상태를 나타내는 ENUM
enum StoreStatus {
    PENDING,    // 등록 대기 중
    REGISTERED  // 등록 완료
}