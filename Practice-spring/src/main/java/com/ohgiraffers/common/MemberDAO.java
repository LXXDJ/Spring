package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemberDAO {
    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO(){
        memberMap = new HashMap<>();

        memberMap.put(3, new MemberDTO(3, "user03", "pass03", "호랑이"));
        memberMap.put(4, new MemberDTO(4, "user04", "pass04", "고양이"));
    }

    public MemberDTO selectMember(int sequence){
        return memberMap.get(sequence);
    }

    public boolean insertMember(MemberDTO newMember){
        int before = memberMap.size();

        memberMap.put(newMember.getSequence(), newMember);

        int after = memberMap.size();

        return after > before ? true : false;
    }
}
