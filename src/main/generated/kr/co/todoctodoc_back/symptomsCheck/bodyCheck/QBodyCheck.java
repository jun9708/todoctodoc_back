package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBodyCheck is a Querydsl query type for BodyCheck
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBodyCheck extends EntityPathBase<BodyCheck> {

    private static final long serialVersionUID = 501501867L;

    public static final QBodyCheck bodyCheck = new QBodyCheck("bodyCheck");

    public final DateTimePath<java.sql.Timestamp> bodyCheckAlarm = createDateTime("bodyCheckAlarm", java.sql.Timestamp.class);

    public final NumberPath<Integer> bodyCheckNo = createNumber("bodyCheckNo", Integer.class);

    public final NumberPath<Integer> bodyCheckScore = createNumber("bodyCheckScore", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

    public QBodyCheck(String variable) {
        super(BodyCheck.class, forVariable(variable));
    }

    public QBodyCheck(Path<? extends BodyCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBodyCheck(PathMetadata metadata) {
        super(BodyCheck.class, metadata);
    }

}

