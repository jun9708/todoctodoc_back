package kr.co.todoctodoc_back.symptomsCheck.urinaryCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUrinaryCheckDetails is a Querydsl query type for UrinaryCheckDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUrinaryCheckDetails extends EntityPathBase<UrinaryCheckDetails> {

    private static final long serialVersionUID = -669453753L;

    public static final QUrinaryCheckDetails urinaryCheckDetails = new QUrinaryCheckDetails("urinaryCheckDetails");

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final NumberPath<Integer> urinaryCheckDetailsNo = createNumber("urinaryCheckDetailsNo", Integer.class);

    public final StringPath userId = createString("userId");

    public QUrinaryCheckDetails(String variable) {
        super(UrinaryCheckDetails.class, forVariable(variable));
    }

    public QUrinaryCheckDetails(Path<? extends UrinaryCheckDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUrinaryCheckDetails(PathMetadata metadata) {
        super(UrinaryCheckDetails.class, metadata);
    }

}

