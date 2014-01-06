package org.debz.DAO;

import org.debz.model.Member;
import java.util.List;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 1:51 PM
 */
public interface MemberDAO {

    public Member saveMember(final Member member);
    public List<Member> getMembers(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countMembers();
    public Member getMemberByUuid(final String uuid);
    public Member getMemberByName(String name);
    
    
}
