package com.example.app;

import java.util.Map;

import com.example.app.Component;
import com.example.app.DataBinding;
import com.example.app.MemberDao;
import com.example.app.Member;

// Annotation 적용
@Component("/member/update.do")
public class MemberUpdateController implements Controller, DataBinding {
  MemberDao memberDao;
  
  public MemberUpdateController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "no", Integer.class,
        "member", com.example.app.Member.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("member");
    
    if (member.getEmail() == null) { 
      Integer no = (Integer)model.get("no");
      Member detailInfo = memberDao.selectOne(no);
      model.put("member", detailInfo);
      return "/member/MemberUpdateForm.jsp";

    } else { 
      memberDao.update(member);
      return "redirect:list.do";
    }
  }
}
