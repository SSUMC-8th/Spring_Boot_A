package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFavoredFood is a Querydsl query type for FavoredFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFavoredFood extends EntityPathBase<FavoredFood> {

    private static final long serialVersionUID = -1731290833L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFavoredFood favoredFood = new QFavoredFood("favoredFood");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.spring.domain.enums.FoodKind> foodKind = createEnum("foodKind", umc.spring.domain.enums.FoodKind.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFavoredFood(String variable) {
        this(FavoredFood.class, forVariable(variable), INITS);
    }

    public QFavoredFood(Path<? extends FavoredFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFavoredFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFavoredFood(PathMetadata metadata, PathInits inits) {
        this(FavoredFood.class, metadata, inits);
    }

    public QFavoredFood(Class<? extends FavoredFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

