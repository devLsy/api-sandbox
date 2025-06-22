package com.lsy.menuapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu_info", schema = "menu")
public class MenuInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_code", nullable = false)
    private String menuCode;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "menu_order", nullable = false)
    private String menuOrder;

    @Column(name = "menu_url", nullable = false)
    private String menuUrl;

    @Column(name = "parent_menu_code", nullable = false)
    private String parentMenuCode;

    @Column(name = "parent_menu_order")
    private String parentMenuOrder;

    @Column(name = "parent_menu_name", nullable = false)
    private String parentMenuName;

    @Column(name = "default_menu_yn", nullable = false)
    private String defaultMenuYn;

    @Column(name = "create_user", nullable = false)
    private String createUser;

    @CreationTimestamp
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Column(name = "update_user", nullable = false)
    private String updateUser;

    @UpdateTimestamp
    @Column(name = "update_dt")
    private LocalDateTime updateDt;

}
