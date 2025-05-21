package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 20)
        private String name;

        private Float score;

        @Column(nullable = false, length = 40)
        private String address;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "region_id")
        private Region region;

        @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
        private List<Mission> missionList = new ArrayList<>();

        @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
        private List<Review> reviewList = new ArrayList<>();

}
