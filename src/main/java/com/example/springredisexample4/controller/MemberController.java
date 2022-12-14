package com.example.springredisexample4.controller;

import com.example.springredisexample4.model.Member;
import com.example.springredisexample4.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public Member add(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @Cacheable(value = "member", key = "#id")
    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) throws InterruptedException {
        return memberService.getMember(id);
    }

    @CachePut(value = "member", key = "#id")
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @CacheEvict(value = "member", key = "#id")
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }
}
