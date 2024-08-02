package kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBodyCheckDetails is a Querydsl query type for BodyCheckDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBodyCheckDetails extends EntityPathBase<BodyCheckDetails> {

    private static final long serialVersionUID = 2064351692L;

    public static final QBodyCheckDetails bodyCheckDetails = new QBodyCheckDetails("bodyCheckDetails");

    public final NumberPath<Integer> bodyCheckDetailsNo = createNumber("bodyCheckDetailsNo", Integer.class);

    public final NumberPath<Integer> cardiovascularScore = createNumber("cardiovascularScore", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final NumberPath<Integer> heatSensationScore = createNumber("heatSensationScore", Integer.class);

    public final NumberPath<Integer> painScore = createNumber("painScore", Integer.class);

    public final NumberPath<Integer> sleepScore = createNumber("sleepScore", Integer.class);

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

    public QBodyCheckDetails(String variable) {
        super(BodyCheckDetails.class, forVariable(variable));
    }

    public QBodyCheckDetails(Path<? extends BodyCheckDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBodyCheckDetails(PathMetadata metadata) {
        super(BodyCheckDetails.class, metadata);
    }

}

