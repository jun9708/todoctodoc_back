package kr.co.todoctodoc_back.medicalRecord;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMedicalRecord is a Querydsl query type for MedicalRecord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMedicalRecord extends EntityPathBase<MedicalRecord> {

    private static final long serialVersionUID = 344243731L;

    public static final QMedicalRecord medicalRecord = new QMedicalRecord("medicalRecord");

    public final DatePath<java.time.LocalDate> diagnosisDate = createDate("diagnosisDate", java.time.LocalDate.class);

    public final ListPath<kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy, kr.co.todoctodoc_back.hormoneTherapy.QHormoneTherapy> hormoneTherapy = this.<kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy, kr.co.todoctodoc_back.hormoneTherapy.QHormoneTherapy>createList("hormoneTherapy", kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy.class, kr.co.todoctodoc_back.hormoneTherapy.QHormoneTherapy.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> hormoneTherapyStartDate = createDate("hormoneTherapyStartDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> surgeryDate = createDate("surgeryDate", java.time.LocalDate.class);

    public final StringPath useid = createString("useid");

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

