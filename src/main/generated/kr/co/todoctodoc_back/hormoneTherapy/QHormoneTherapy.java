package kr.co.todoctodoc_back.hormoneTherapy;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHormoneTherapy is a Querydsl query type for HormoneTherapy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHormoneTherapy extends EntityPathBase<HormoneTherapy> {

    private static final long serialVersionUID = -1729696629L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHormoneTherapy hormoneTherapy = new QHormoneTherapy("hormoneTherapy");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final kr.co.todoctodoc_back.medicalRecord.QMedicalRecord medicalRecord;

    public final StringPath name = createString("name");

    public QHormoneTherapy(String variable) {
        this(HormoneTherapy.class, forVariable(variable), INITS);
    }

    public QHormoneTherapy(Path<? extends HormoneTherapy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHormoneTherapy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHormoneTherapy(PathMetadata metadata, PathInits inits) {
        this(HormoneTherapy.class, metadata, inits);
    }

    public QHormoneTherapy(Class<? extends HormoneTherapy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.medicalRecord = inits.isInitialized("medicalRecord") ? new kr.co.todoctodoc_back.medicalRecord.QMedicalRecord(forProperty("medicalRecord")) : null;
    }

}

