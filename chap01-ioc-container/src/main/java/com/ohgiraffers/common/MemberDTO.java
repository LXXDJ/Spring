package com.ohgiraffers.common;

import lombok.*;

//@Data   // 아래 5가지를 다 포함 하지만 권장하진 않음 : 다른 요소를 하나 더 포함하고 있는 그게 오류 발생시키도 함

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private int sequence;
    private String id;
    private String pw;
    private String name;
}
