package entity;

import jakarta.persistence.*;
import java.util.List;

// 메뉴 그룹 정보를 관리하는 엔티티 클래스
@Entity
@Table(name = "menu_group")
public class MenuGroup {

    // 그룹 고유키 (자동 생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    // 가게 ID (필수)
    @Column(nullable = false)
    private Long storeId;

    // 그룹 이름 (필수, 최대 길이 255자)
    @Column(nullable = false, length = 255)
    private String groupName;

    // MenuManagement와의 연관관계 (1:N)
    @OneToMany(mappedBy = "menuGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuManagement> menuList;

}