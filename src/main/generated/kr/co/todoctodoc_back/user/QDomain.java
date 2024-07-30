package kr.co.todoctodoc_back.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDomain is a Querydsl query type for Domain
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDomain extends EntityPathBase<Domain> {

    private static final long serialVersionUID = 797701380L;

    public static final QDomain domain = new QDomain("domain");

    public final StringPath domainName = createString("domainName");

    public final NumberPath<Integer> domainNo = createNumber("domainNo", Integer.class);

    public QDomain(String variable) {
        super(Domain.class, forVariable(variable));
    }

    public QDomain(Path<? extends Domain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDomain(PathMetadata metadata) {
        super(Domain.class, metadata);
    }

}

