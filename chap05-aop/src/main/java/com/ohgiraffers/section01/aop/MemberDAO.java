package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {
    private final Map<Long, MemberDTO> memberMap;

    public MemberDAO(){
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDTO(1L, "판다"));
        memberMap.put(2L, new MemberDTO(2L, "다람쥐"));
    }

    public Map<Long, MemberDTO> selectMembers(){
        return memberMap;
    }

    public MemberDTO selectMember(Long id){
        MemberDTO returnMemeber = memberMap.get(id);

        if(returnMemeber == null) throw new RuntimeException("해당하는 id의 회원 없음");

        return returnMemeber;
    }
}