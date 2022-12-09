package javaProject.recipedia.service;

import javaProject.recipedia.domain.Member;
import javaProject.recipedia.dto.RequestMemberDto;

public interface MemberService {
    void join(RequestMemberDto member);
    Member login(RequestMemberDto member);
}
