package com.lsy.menuapi.domain.menu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindMenuListResponseDto {

    @Schema(description = "상위 메뉴 코드", example = "ADMIN-GUEST")
    private String parentMenuCode;

    @Schema(description = "메뉴 코드", example = "ADMIN-GUEST-001")
    private String menuCode;

    @Schema(description = "상위 메뉴명", example = "방문/협력사 관리")
    private String parentMenuName;

    @Schema(description = "메뉴명", example = "방문 예약 현황")
    private String menuName;

    @Schema(description = "메뉴 URL", example = "/visit/reservation")
    private String menuUrl;

}
