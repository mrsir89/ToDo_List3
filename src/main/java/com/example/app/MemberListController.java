package com.example.app;

import java.util.Map;

import com.example.app.Component;
import com.example.app.MemberDao;

// Annotation 적용
@Component("/member/list.do")
public class MemberListController implements Controller {
  MemberDao memberDao;
  
  public MemberListController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    model.put("members", memberDao.selectList());
    return "/member/MemberList.jsp";
  }
}
