package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="market_id")
    @ManyToOne(fetch = FetchType.LAZY) // 한 가게에서 하나의 미션만 있다고 가정했으므로
    private Market market;

    @Column(nullable = false)
    private LocalDate endDate; // 피드백에 따라 mission에 마감 기한을 넣고 계산하는 식으로

    @Column(nullable = false)
    private Long point ;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy= "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();


}
