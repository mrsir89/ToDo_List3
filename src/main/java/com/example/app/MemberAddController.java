package com.example.app;

import java.util.Map;

import com.example.app.Component;
import com.example.app.DataBinding;
import com.example.app.MemberDao;
import com.example.app.Member;

// Annotation 적용
@Component("/member/add.do")
public class MemberAddController implements Controller, DataBinding {
  MemberDao memberDao;
  
  public MemberAddController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "member", com.example.app.Member.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("member");
    if (member.getEmail() == null) { // 입력폼을 요청할 때
      return "/member/MemberForm.jsp";
    } else { // 회원 등록을 요청할 때
      memberDao.insert(member);
      return "redirect:list.do";
    }
  }
}
