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

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final StringPath diagnosisDate = createString("diagnosisDate");

    public final StringPath hormoneTherapyName = createString("hormoneTherapyName");

    public final StringPath hormoneTherapyStartDate = createString("hormoneTherapyStartDate");

    public final StringPath injectionStartDate = createString("injectionStartDate");

    public final NumberPath<Integer> medicalNo = createNumber("medicalNo", Integer.class);

    public final StringPath surgeryDate = createString("surgeryDate");

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

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

