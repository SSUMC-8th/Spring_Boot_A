package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewNotification is a Querydsl query type for ReviewNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewNotification extends EntityPathBase<ReviewNotification> {

    private static final long serialVersionUID = -2134508017L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewNotification reviewNotification = new QReviewNotification("reviewNotification");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMarket market;

    public final QNotification notification;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewNotification(String variable) {
        this(ReviewNotification.class, forVariable(variable), INITS);
    }

    public QReviewNotification(Path<? extends ReviewNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewNotification(PathMetadata metadata, PathInits inits) {
        this(ReviewNotification.class, metadata, inits);
    }

    public QReviewNotification(Class<? extends ReviewNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.market = inits.isInitialized("market") ? new QMarket(forProperty("market"), inits.get("market")) : null;
        this.notification = inits.isInitialized("notification") ? new QNotification(forProperty("notification"), inits.get("notification")) : null;
    }

}

