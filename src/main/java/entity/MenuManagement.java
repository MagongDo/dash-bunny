package entity;

import jakarta.persistence.*;

// 메뉴 정보를 관리하는 엔티티 클래스
@Entity
@Table(name = "menu_management")
public class MenuManagement {

    // 메뉴 고유키 (자동 생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    // 가게 고유키 (필수)
    @Column(nullable = false)
    private Long storeId;

    // 그룹 고유키 (MenuGroup과 연관 관계 설정)
    @ManyToOne
    @JoinColumn(name = "groupId", nullable = false)
    private MenuGroup menuGroup;

    // 메뉴 이름 (필수, 최대 길이 255자)
    @Column(nullable = false, length = 255)
    private String menuName;

    // 메뉴 설명 (TEXT 타입)
    @Column(columnDefinition = "TEXT")
    private String menuContent;

    // 메뉴 사진 (파일 경로나 URL, 최대 길이 255자)
    @Column(length = 255)
    private String menuImage;

    // 재고 등록 여부 (boolean 타입)
    @Column(nullable = false)
    private boolean stockAvailable;

    // 메뉴 재고 수량
    @Column
    private Integer menuStock;

}