package umc.spring.domain;


import jakarta.persistence.*;
import umc.spring.domain.common.BaseEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Notification extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "notification")
    private List<ReviewNotification> reviewNotificationList = new ArrayList<>();

    @OneToMany(mappedBy = "notification")
    private List<MissionNotification> MissionNotificationList = new ArrayList<>();

}
