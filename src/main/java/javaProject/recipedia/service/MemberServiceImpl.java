package javaProject.recipedia.service;

import javaProject.recipedia.domain.Member;
import javaProject.recipedia.dto.RequestDto;
import javaProject.recipedia.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void join(RequestDto member) {
        Member member1 = Member.builder()
                .userId(member.getUserId())
                .userPassword(member.getUserPassword())
                .build();
        memberRepository.save(member1);
    }

    @Override
    public Member login(RequestDto member) {
        return memberRepository.findMemberByUserIdAndUserPassword(member.getUserId(), member.getUserPassword());
    }
}
