package org.debz.service;

import org.debz.model.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 2:03 PM
 */

@Transactional
public interface MemberService {

    public Member saveMember(final Member member);
    public List<Member> getMembers(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countMembers();
    public Member getMemberByUuid(final String uuid);
    public Member getMemberByName(String name);
}
