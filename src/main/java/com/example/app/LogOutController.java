package com.example.app;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.app.Component;

// Annotation 적용
@Component("/auth/logout.do")
public class LogOutController implements Controller {
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    HttpSession session = (HttpSession)model.get("session");
    session.invalidate();
    
    return "redirect:login.do";
  }
}
