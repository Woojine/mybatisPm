package com.kh.mybatisPm.test;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {
    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("company") Company company);  // 입력된 데이터의 갯수를 반환

    @Select("SELECT * FROM company")
    @Results(id ="CompanyMap", value ={
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address"),
            // 간단한 선언으로 서브쿼리 사용하기
            @Result(property = "employeeList", column = "id", many=@Many(select = "com.kh.mybatisPm.test.EmployeeMapper.getByCompanyId"))
    })
    List<Company> getAll();

    @Select("SELECT * FROM company WHERE id=#{id}")
    @ResultMap("CompanyMap")
    Company getById(@Param("id") int id);
}
