package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.FavoredFood;
import umc.spring.domain.Member;
import umc.spring.exception.GeneralException;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new GeneralException(ErrorStatus.MEMEBER_DUPLICATE_EMAIL);
        }

        Member newMember = MemberConverter.toMember(request);

        // FavoredFood를 생성하여 Member에 연관시키는 로직
        Set<FavoredFood> favoredFoodSet = Optional.ofNullable(request.getFavoredFoodsList())
                .orElse(List.of())  // null일 경우 빈 리스트 처리
                .stream()
                .map(foodKind -> FavoredFood.builder()
                        .foodKind(foodKind)
                        .member(newMember)
                        .build())
                .collect(Collectors.toSet());

        newMember.getFavoredFoods().addAll(favoredFoodSet);

        return memberRepository.save(newMember);
    }
}