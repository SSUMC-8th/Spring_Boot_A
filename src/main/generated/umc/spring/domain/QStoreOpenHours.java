package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreOpenHours is a Querydsl query type for StoreOpenHours
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreOpenHours extends EntityPathBase<StoreOpenHours> {

    private static final long serialVersionUID = 602064560L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreOpenHours storeOpenHours = new QStoreOpenHours("storeOpenHours");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final TimePath<java.time.LocalTime> closeTime = createTime("closeTime", java.time.LocalTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<java.time.DayOfWeek> dayOfWeek = createEnum("dayOfWeek", java.time.DayOfWeek.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final TimePath<java.time.LocalTime> openTime = createTime("openTime", java.time.LocalTime.class);

    public final QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreOpenHours(String variable) {
        this(StoreOpenHours.class, forVariable(variable), INITS);
    }

    public QStoreOpenHours(Path<? extends StoreOpenHours> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreOpenHours(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreOpenHours(PathMetadata metadata, PathInits inits) {
        this(StoreOpenHours.class, metadata, inits);
    }

    public QStoreOpenHours(Class<? extends StoreOpenHours> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

