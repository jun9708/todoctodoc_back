package kr.co.todoctodoc_back.symptomsCheck.mentalCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMentalCheckDetails is a Querydsl query type for MentalCheckDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMentalCheckDetails extends EntityPathBase<MentalCheckDetails> {

    private static final long serialVersionUID = 2007984613L;

    public static final QMentalCheckDetails mentalCheckDetails = new QMentalCheckDetails("mentalCheckDetails");

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final NumberPath<Integer> mentalCheckDetailsNo = createNumber("mentalCheckDetailsNo", Integer.class);

    public final StringPath userId = createString("userId");

    public QMentalCheckDetails(String variable) {
        super(MentalCheckDetails.class, forVariable(variable));
    }

    public QMentalCheckDetails(Path<? extends MentalCheckDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMentalCheckDetails(PathMetadata metadata) {
        super(MentalCheckDetails.class, metadata);
    }

}

