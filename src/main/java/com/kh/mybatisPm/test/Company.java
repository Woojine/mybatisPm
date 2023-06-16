package com.kh.mybatisPm.test;

import lombok.Data;

import java.util.List;

@Data // @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정해주는 매우 유용한 어노테이션입니다.
public class Company {
    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList;
}
