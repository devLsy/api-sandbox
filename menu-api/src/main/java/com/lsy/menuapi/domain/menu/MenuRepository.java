package com.lsy.menuapi.domain.menu;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class MenuRepository {

    private final JPAQueryFactory factory;

//    public List<String> findByDefaultMenu() {
//        return factory.select(menuInfo.menuCode)
//                .from(menuInfo)
//                .where(menuInfo.defaultMenuYn.eq("Y"))
//                .fetch();
//    }
}
