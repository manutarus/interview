package org.debz.service.impl;

import org.debz.DAO.MemberDAO;
import org.debz.model.Member;
import org.debz.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 2:07 PM
 */
public class MemberServiceImpl implements MemberService{
    @Autowired
    public MemberDAO memberDAO;

    public Member saveMember(Member member){
        return memberDAO.saveMember(member);
    }
    public Member getMemberByUuid(final String uuid){
        return memberDAO.getMemberByUuid(uuid);
    }
    public List<Member> getMembers(final String search, final Integer pageNumber, final Integer pageSize){
        return memberDAO.getMembers(search,pageNumber,pageSize);
    }
    public Number countMembers(){
        return memberDAO.countMembers();
    }
    public Member getMemberByName(String name){
        return memberDAO.getMemberByName(name);
    }
}
