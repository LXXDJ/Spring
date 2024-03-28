package com.ohgiraffers;

import java.util.Map;

public class MemberService {
    private final MemberDAO memberDAO;

    public MemberService(MemberDAO memberDAO){this.memberDAO = memberDAO;}

    public Map<Long, MemberDTO> selectMembers(){
        System.out.println("selectMembers() 실행");
        return memberDAO.selectMembers();
    }

    public MemberDTO selectMember(Long id){
        System.out.println("selectMember() 실행");
        return memberDAO.selectMember(id);
    }
}
