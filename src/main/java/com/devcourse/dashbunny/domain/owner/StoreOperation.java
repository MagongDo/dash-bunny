package com.devcourse.dashbunny.domain.owner;

import jakarta.persistence.*;

// 가게의 운영정보를 관리하는 엔티티
@Entity
public class StoreOperation {

    @Id
    @GeneratedValue
    private Long operationId;

    @OneToOne
    @JoinColumn(name = "store_id",nullable = false, unique = true)
    private StoreManagement store;

    //영업시간 (예: "09:00-22:00")
    private String openingHours;

    //휴게시간 (예: "09:00-22:00")
    private String breakTime;

    //휴무일
    private String holidayDays;

    //휴무 안내글
    @Column(columnDefinition="TEXT")
    public String holidayNotice;

    //일시 중지 상태
    private boolean isPaused = false;

/*
    // 포장 여부
    @Column(nullable = false)
    private boolean isTakeout = true;
*/

    //사장님이 입력하는 배달 가능 동
    private String deliveryArea;

    // 최소 배달 예상 시간 (예: 13분)
    private String minDeliveryTime;

    // 최대 배달 예상 시간 (예 : 40분)
    private String maxDeliveryTime;
}
