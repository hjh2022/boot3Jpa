package com.example.boot3jpa;

import com.example.boot3jpa.dao.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    MemberRepository memberRepository; // DI

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }


}
