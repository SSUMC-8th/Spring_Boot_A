package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Term extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int version;

    @Column(length = 30, nullable = false)
    private String title;

    @Lob
    private String content;

    @Column(nullable = false)
    private Boolean required = true;

    @OneToMany(mappedBy = "term")
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}
