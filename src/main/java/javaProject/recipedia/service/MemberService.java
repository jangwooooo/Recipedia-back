package javaProject.recipedia.service;

import javaProject.recipedia.domain.Member;
import javaProject.recipedia.dto.RequestDto;

public interface MemberService {
    void join(RequestDto member);
}
