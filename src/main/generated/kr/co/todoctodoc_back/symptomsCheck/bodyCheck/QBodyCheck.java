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

    public final NumberPath<Integer> bodyCheckNo = createNumber("bodyCheckNo", Integer.class);

    public final StringPath score = createString("score");

    public final StringPath userId = createString("userId");

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

