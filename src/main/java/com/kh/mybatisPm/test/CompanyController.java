package com.kh.mybatisPm.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyMapper companyMapper;
    @PostMapping("")
    public int post(@RequestBody Company company) {
        return companyMapper.insert(company);
    }

    @GetMapping("")
    public List<Company> getAll() {
        return companyMapper.getAll();
    }
}
