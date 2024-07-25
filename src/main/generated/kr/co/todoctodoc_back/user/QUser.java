package kr.co.todoctodoc_back.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1696982005L;

    public static final QUser user = new QUser("user");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final BooleanPath role = createBoolean("role");

    public final StringPath tel = createString("tel");

    public final DateTimePath<java.sql.Timestamp> userCreatedAt = createDateTime("userCreatedAt", java.sql.Timestamp.class);

    public final StringPath userid = createString("userid");

    public final StringPath username = createString("username");

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

