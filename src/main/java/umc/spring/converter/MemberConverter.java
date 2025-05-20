package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.HashSet;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        return Member.builder()
                .socialType(request.getSocialType())
                .email(request.getEmail())
                .name(request.getName())
                .nickname(request.getNickname())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .address(request.getAddress())
                .detailAddress(request.getDetailAddress())
                .point(request.getPoint())
                .favoredFoods(new HashSet<>())
                .isCertified(false) // 디폴트 false
                .overFourteen(true) // 기본 동의했다고 가정하는 경우 true
                .build();
    }
}