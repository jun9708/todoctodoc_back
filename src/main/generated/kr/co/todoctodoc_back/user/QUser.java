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

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isWithdraw = createBoolean("isWithdraw");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final BooleanPath role = createBoolean("role");

    public final DateTimePath<java.sql.Timestamp> userCreatedAt = createDateTime("userCreatedAt", java.sql.Timestamp.class);

    public final StringPath userImage = createString("userImage");

    public final StringPath username = createString("username");

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

