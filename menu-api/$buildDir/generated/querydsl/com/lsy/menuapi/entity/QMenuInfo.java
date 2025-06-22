package com.lsy.menuapi.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenuInfo is a Querydsl query type for MenuInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMenuInfo extends EntityPathBase<MenuInfo> {

    private static final long serialVersionUID = -1378781220L;

    public static final QMenuInfo menuInfo = new QMenuInfo("menuInfo");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath defaultMenuYn = createString("defaultMenuYn");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath menuCode = createString("menuCode");

    public final StringPath menuName = createString("menuName");

    public final StringPath menuOrder = createString("menuOrder");

    public final StringPath menuUrl = createString("menuUrl");

    public final StringPath parentMenuCode = createString("parentMenuCode");

    public final StringPath parentMenuName = createString("parentMenuName");

    public final StringPath parentMenuOrder = createString("parentMenuOrder");

    public final DateTimePath<java.time.LocalDateTime> updateDt = createDateTime("updateDt", java.time.LocalDateTime.class);

    public final StringPath updateUser = createString("updateUser");

    public QMenuInfo(String variable) {
        super(MenuInfo.class, forVariable(variable));
    }

    public QMenuInfo(Path<? extends MenuInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenuInfo(PathMetadata metadata) {
        super(MenuInfo.class, metadata);
    }

}

