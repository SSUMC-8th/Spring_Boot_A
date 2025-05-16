package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String description;

        private Integer reward;

        private LocalDate deadline;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "store_id")
        private Store store;

        @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
        private List<MemberMission> memberMissionList = new ArrayList<>();

    }
