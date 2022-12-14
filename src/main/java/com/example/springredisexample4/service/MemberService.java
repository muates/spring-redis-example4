package com.example.springredisexample4.service;

import com.example.springredisexample4.model.Member;

import java.util.List;

public interface MemberService {
    Member addMember(Member member);
    Member getMember(Long id) throws InterruptedException;
    List<Member> getMembers();
    Member updateMember(Long id, Member member);
    void deleteMember(Long id);
}
