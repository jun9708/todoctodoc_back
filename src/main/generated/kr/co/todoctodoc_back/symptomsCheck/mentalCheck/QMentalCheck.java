package kr.co.todoctodoc_back.symptomsCheck.mentalCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMentalCheck is a Querydsl query type for MentalCheck
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMentalCheck extends EntityPathBase<MentalCheck> {

    private static final long serialVersionUID = 586876317L;

    public static final QMentalCheck mentalCheck = new QMentalCheck("mentalCheck");

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> mentalCheckAlarm = createDateTime("mentalCheckAlarm", java.sql.Timestamp.class);

    public final NumberPath<Integer> mentalCheckNo = createNumber("mentalCheckNo", Integer.class);

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

    public QMentalCheck(String variable) {
        super(MentalCheck.class, forVariable(variable));
    }

    public QMentalCheck(Path<? extends MentalCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMentalCheck(PathMetadata metadata) {
        super(MentalCheck.class, metadata);
    }

}

