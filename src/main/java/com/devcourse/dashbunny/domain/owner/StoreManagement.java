package com.devcourse.dashbunny.domain.owner;

import com.devcourse.annotation.TSID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

// 가게 관리 및 가게 정보를 저장하는 엔티티 클래스
@Setter
@Getter
@Entity
@Table(name = "store_management")
public class StoreManagement {

    // 회원 ID
    @Id
    @TSID
    @Column(name = "store_id", nullable = false)
    private String storeId;

    // 가게 이름 (필수, 최대 길이 255자)
    @Column(nullable = false, length = 255)
    private String storeName;

    // 가게 소개 내용 (TEXT 타입)
    @Column(columnDefinition = "TEXT")
    private String description;

    // 가게 전화번호 (필수, 최대 길이 13자)
    @Column(nullable = false, length = 13)
    private String contactNumber;

    // 가게 위치 (주소, 위도와 경도)
    // 1.주소 (필수, 최대 길이 255자)
    @Column(nullable = false, length = 255)
    private String address;

    // 2.위도와 경도 (필수, JSON 형태로 저장)
    @Column(columnDefinition = "JSON", nullable = false)
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
    private String shortsUrl;

    // Getters and Setters -> 롬복 사용
}

// 가게 상태를 나타내는 ENUM -> 이넘 클래스를 따로 만들까요? 아니면 확인이 이게 더 편하신지요?
enum StoreStatus1 {
    PENDING,    // 등록 대기 중
    REGISTERED,  // 등록 완료
    REGISTRATION, // 가게 등록 실패
    OPEN, // 영업중
    PENDING_OPEN, // 영업 준비 중
    TEMP_CLOSE, // 휴업중
    CLOSURE_PENDING, // 페업 신청 대기 중
    CLOSED // 폐업
}