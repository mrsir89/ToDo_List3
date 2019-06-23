package com.example.app;

import java.util.Map;

import com.example.app.Component;
import com.example.app.DataBinding;
import com.example.app.MemberDao;

// Annotation 적용
@Component("/member/delete.do")
public class MemberDeleteController implements Controller, DataBinding {
  MemberDao memberDao;
  
  public MemberDeleteController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "no", Integer.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Integer no = (Integer)model.get("no");
    memberDao.delete(no);
    
    return "redirect:list.do";
  }
}
