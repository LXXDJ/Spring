package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Poketmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("poketmonServicePrimary")
public class PoketmonService {
    private Poketmon poketmon;

//    @Autowired    // 생성자가 하나만 있을때에는 @Autowired를 생략해도 문제없음, 만약 다른 생성자가 있다면(ex. 기본생성자) 오류남
    public PoketmonService(Poketmon poketmon){
        this.poketmon = poketmon;
    }

    public void poketmonAttack(){
        poketmon.attack();
    }
}
