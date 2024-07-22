package kr.co.todoctodoc_back.medicalRecord;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMedicalRecord is a Querydsl query type for MedicalRecord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMedicalRecord extends EntityPathBase<MedicalRecord> {

    private static final long serialVersionUID = 344243731L;

    public static final QMedicalRecord medicalRecord = new QMedicalRecord("medicalRecord");

    public final NumberPath<Long> hormoneNo = createNumber("hormoneNo", Long.class);

    public final StringPath hormoneTherapy = createString("hormoneTherapy");

    public final DatePath<java.time.LocalDate> injectionDate = createDate("injectionDate", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> takeDate = createDate("takeDate", java.time.LocalDate.class);

    public QMedicalRecord(String variable) {
        super(MedicalRecord.class, forVariable(variable));
    }

    public QMedicalRecord(Path<? extends MedicalRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMedicalRecord(PathMetadata metadata) {
        super(MedicalRecord.class, metadata);
    }

}

