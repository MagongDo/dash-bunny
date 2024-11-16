package com.devcourse.dashbunny.domain.owner;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// 가게의 배달 범위를 정하는 깃발 엔티티
@Entity
@Table(name = "flag")
public class StoreFlag {

    // 깃발 ID (자동 생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flagId;

    // 가게 ID (필수)
    @Column(nullable = false)
    private Long storeId;

    // 위치 정확도 (소수점 6자리까지)
    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal accuracy;

    // 고도 (소수점 6자리까지)
    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal altitude;

    // 고도 정확도 (소수점 6자리까지)
    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal altitudeAccuracy;

    // 방향 (소수점 6자리까지)
    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal heading;

    // 위도 (소수점 6자리까지)
    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal latitude;

    // 경도 (소수점 6자리까지)
    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal longitude;

    // 속도 (소수점 6자리까지) - 'field2'를 의미 있는 이름으로 바꾸세요
    //예상 도착 시간을 위한 필드일까요? !! 그럼 deliverySpeed가 명확할 것 같습니다! 그게 아니라면 speed 이것도 단순하게 좋을듯 합니다.
    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal deliverySpeed;  // 'field2'를 의미 있는 이름으로 변경 필요

    // 데이터 기록 시간 (필수)
    @Column(nullable = false)
    private LocalDateTime recordedTime;

}