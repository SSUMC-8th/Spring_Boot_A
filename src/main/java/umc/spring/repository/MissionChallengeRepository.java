package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MissionChallengeRepository
        extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
