package kr.co.todoctodoc_back.symptomsCheck.urinaryCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUrinaryCheck is a Querydsl query type for UrinaryCheck
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUrinaryCheck extends EntityPathBase<UrinaryCheck> {

    private static final long serialVersionUID = 473646971L;

    public static final QUrinaryCheck urinaryCheck = new QUrinaryCheck("urinaryCheck");

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final DateTimePath<java.sql.Timestamp> urinaryCheckAlarm = createDateTime("urinaryCheckAlarm", java.sql.Timestamp.class);

    public final NumberPath<Integer> urinaryCheckNo = createNumber("urinaryCheckNo", Integer.class);

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

    public QUrinaryCheck(String variable) {
        super(UrinaryCheck.class, forVariable(variable));
    }

    public QUrinaryCheck(Path<? extends UrinaryCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUrinaryCheck(PathMetadata metadata) {
        super(UrinaryCheck.class, metadata);
    }

}

