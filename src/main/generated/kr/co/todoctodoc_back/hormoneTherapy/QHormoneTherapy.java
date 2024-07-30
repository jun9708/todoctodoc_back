package kr.co.todoctodoc_back.hormoneTherapy;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHormoneTherapy is a Querydsl query type for HormoneTherapy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHormoneTherapy extends EntityPathBase<HormoneTherapy> {

    private static final long serialVersionUID = -1729696629L;

    public static final QHormoneTherapy hormoneTherapy = new QHormoneTherapy("hormoneTherapy");

    public final NumberPath<Integer> hormoneNo = createNumber("hormoneNo", Integer.class);

    public final StringPath therapyName = createString("therapyName");

    public QHormoneTherapy(String variable) {
        super(HormoneTherapy.class, forVariable(variable));
    }

    public QHormoneTherapy(Path<? extends HormoneTherapy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHormoneTherapy(PathMetadata metadata) {
        super(HormoneTherapy.class, metadata);
    }

}

