package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.Agreement;
import umc.spring.domain.mapping.MemberPrefer;

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

    @Column(nullable = false, length =30)
    private String title;

    @Lob
    private String content ;

    // 해당 약관이 필수인지 : 필수면 1 , 필수 아니면 0
    @Column(nullable = false)
    private Boolean required ;

    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private List<Agreement> memberAgreeList = new ArrayList<>();
}
