package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

import java.time.LocalDate;


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
    @OneToOne(fetch = FetchType.LAZY) // 한 가게에서 하나의 미션만 있다고 가정했으므로
    private Market market;

    @Column(nullable = false)
    private LocalDate endDate; // 피드백에 따라 mission에 마감 기한을 넣고 계산하는 식으로

    @Column(nullable = false)
    private Long point ;

    @Lob
    private String content;

    // 음... mission이 삭제될일이 없을것 같은데.. 굳이 memberMission으로
    // 연결을 해줘야 하나?


}
