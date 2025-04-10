package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewNotification extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="notification_id")
    @ManyToOne(fetch= FetchType.LAZY)
    private Notification notification;

    @JoinColumn(name="market_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Market market;

}
