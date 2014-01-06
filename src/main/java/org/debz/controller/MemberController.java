package org.debz.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Member;
import org.debz.service.MemberService;
import org.debz.utils.WebConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 2:40 PM
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
//    sid, surname, other_names, gender, phone_number, id_number, date_created, creator, uuid, voided, voided_by, date_voided
    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "/memberUpdateSave.json",method = RequestMethod.POST)
    public void voidSaveGroup(final @RequestBody Map<String, Object> map) {
        String uuid = (String) map.get("uuid");
        String surname = (String) map.get("surname");
        String other_names =  (String) map.get("other_names");
        String gender = (String) map.get("gender");
        if(gender.equals("Female")){
            gender ="F";
        }
        else{
            gender ="M";
        }
        String phone_number = (String) map.get("phone_number");
        String id_number = (String) map.get("id_number");
        String date_created = (String) map.get("date_created");
        String creator = (String) map.get("creator");
        String voided = (String) map.get("voided");
        String voided_by = (String) map.get("voided_by");
        String date_voided = (String) map.get("date_voided");

        if (StringUtils.isNotBlank(uuid)) {
            Member member = memberService.getMemberByUuid(uuid);

            if (StringUtils.isNotBlank(surname)||StringUtils.isNotBlank(other_names)||StringUtils.isNotBlank(gender)
                    ||StringUtils.isNotBlank(phone_number)||StringUtils.isNotBlank(id_number)||StringUtils.isNotBlank(creator) ) {
                member.setUuid(uuid);
                member.setSurname(surname);
                member.setOther_names(other_names);
                member.setGender(gender);
                member.setPhone_number(phone_number);
                member.setId_number(id_number);
                member.setCreator(creator);
                memberService.saveMember(member);
            }
            else {
                member.setVoided("1");
                memberService.saveMember(member);
            }
        }
        else {
            Member member = new Member();
            member.setSurname(surname);
            member.setOther_names(other_names);
            member.setGender(gender);
            member.setPhone_number(phone_number);
            member.setId_number(id_number);
            member.setCreator(creator);
            member.setUuid(UUID.randomUUID().toString());
            memberService.saveMember(member);
        }
    }

    @RequestMapping(value = "/list/allMembers.json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> view(final @RequestParam(value = "search") String search,
                             final @RequestParam(value = "pageNumber") Integer pageNumber,
                             final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
        int pages = (memberService.countMembers().intValue() + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (Member memberList : memberService.getMembers(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convertMember(memberList));
        }
        response.put("pages", pages);
        response.put("objects", objects);
        return response;
    }

    @RequestMapping(value = "/member.json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMember(final @RequestParam(value = "uuid") String uuid) {

        return WebConverter.convertMember(memberService.getMemberByUuid(uuid));
    }
    
    
}
