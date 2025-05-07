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

    //콘솔에 로그를 찍어주기 위해서, 도메인 코드에 toString() 메서드를 재정의 -챕터6
    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + rate +
                ", region=" + (region != null ? region.getRegionSector() : "N/A") + // region의 이름 출력
                '}';
    }


}
