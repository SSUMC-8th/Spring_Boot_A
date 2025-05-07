package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionNotification is a Querydsl query type for MissionNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionNotification extends EntityPathBase<MissionNotification> {

    private static final long serialVersionUID = 171881579L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionNotification missionNotification = new QMissionNotification("missionNotification");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.mapping.QMemberMission memberMission;

    public final QNotification notification;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMissionNotification(String variable) {
        this(MissionNotification.class, forVariable(variable), INITS);
    }

    public QMissionNotification(Path<? extends MissionNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionNotification(PathMetadata metadata, PathInits inits) {
        this(MissionNotification.class, metadata, inits);
    }

    public QMissionNotification(Class<? extends MissionNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberMission = inits.isInitialized("memberMission") ? new umc.spring.domain.mapping.QMemberMission(forProperty("memberMission"), inits.get("memberMission")) : null;
        this.notification = inits.isInitialized("notification") ? new QNotification(forProperty("notification"), inits.get("notification")) : null;
    }

}

