package kr.co.todoctodoc_back.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domainNo;

    @Column(length = 50, nullable = false, unique = true)
    private String domainName;

}
