package umc.spring.service.membermissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.domain.enums.Progress;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;


@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> myProgressMissionList(Long memberId, Integer page) {

        Page<MemberMission> myMissionList = memberMissionRepository.findAllByMemberIdAndProgress(memberId, Progress.IN_PROGRESS, PageRequest.of(page, 10));

        return myMissionList;
    }
}
