package kr.co.todoctodoc_back.hormoneLink;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHormoneLink is a Querydsl query type for HormoneLink
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHormoneLink extends EntityPathBase<HormoneLink> {

    private static final long serialVersionUID = 1617214091L;

    public static final QHormoneLink hormoneLink = new QHormoneLink("hormoneLink");

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final NumberPath<Integer> hormoneLinkNo = createNumber("hormoneLinkNo", Integer.class);

    public final StringPath hormoneNo = createString("hormoneNo");

    public final StringPath userId = createString("userId");

    public QHormoneLink(String variable) {
        super(HormoneLink.class, forVariable(variable));
    }

    public QHormoneLink(Path<? extends HormoneLink> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHormoneLink(PathMetadata metadata) {
        super(HormoneLink.class, metadata);
    }

}

