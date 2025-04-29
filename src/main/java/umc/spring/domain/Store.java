package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
//import umc.spring.domain.enums.StoreType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(nullable = false, length = 30)
    private String name;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, length = 10)
//    private StoreType storeType;

    @Column
    private Float rate;

    @Column(nullable = false, length = 256)
    private String address;

    @Column(name = "detail_address", length = 256)
    private String detailAddress;
}
