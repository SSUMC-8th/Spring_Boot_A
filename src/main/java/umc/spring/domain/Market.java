package umc.spring.domain;


import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Market extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =30)
    private String name;

    @Column(nullable = false, length = 20)
    private String code;

    @JoinColumn(name = "region_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    @JoinColumn(name="category_id")
    @ManyToOne(fetch= FetchType.LAZY)
    private FoodCategory category;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL) // market이 지워질때 그에 대한 리뷰도 같이 삭제되는게 맞으므로
    private List<Review> ReviewList = new ArrayList<>();

// 이게 필요가 있나 싶어 일단 지움
//    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL) // 미션도 마찬가지
//    private List<Mission> MissionList = new ArrayList<>();


}
