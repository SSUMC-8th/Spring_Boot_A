package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFavoritefood is a Querydsl query type for Favoritefood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFavoritefood extends EntityPathBase<Favoritefood> {

    private static final long serialVersionUID = -2028155962L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFavoritefood favoritefood = new QFavoritefood("favoritefood");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.spring.domain.enums.FoodKind> foodKind = createEnum("foodKind", umc.spring.domain.enums.FoodKind.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFavoritefood(String variable) {
        this(Favoritefood.class, forVariable(variable), INITS);
    }

    public QFavoritefood(Path<? extends Favoritefood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFavoritefood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFavoritefood(PathMetadata metadata, PathInits inits) {
        this(Favoritefood.class, metadata, inits);
    }

    public QFavoritefood(Class<? extends Favoritefood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
    }

}

