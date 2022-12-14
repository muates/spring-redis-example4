package com.example.springredisexample4.service.impl;

import com.example.springredisexample4.model.Member;
import com.example.springredisexample4.repository.MemberRepository;
import com.example.springredisexample4.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMember(Long id) throws InterruptedException {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty())
            return null;

        Thread.sleep(5000L);

        return member.get();
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMember(Long id, Member member) {
        return null;
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
