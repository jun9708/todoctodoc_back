package kr.co.todoctodoc_back.terms;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTerms is a Querydsl query type for Terms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTerms extends EntityPathBase<Terms> {

    private static final long serialVersionUID = -642100515L;

    public static final QTerms terms = new QTerms("terms");

    public final StringPath content1 = createString("content1");

    public final StringPath content2 = createString("content2");

    public final StringPath content3 = createString("content3");

    public final NumberPath<Integer> termsNo = createNumber("termsNo", Integer.class);

    public QTerms(String variable) {
        super(Terms.class, forVariable(variable));
    }

    public QTerms(Path<? extends Terms> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTerms(PathMetadata metadata) {
        super(Terms.class, metadata);
    }

}

