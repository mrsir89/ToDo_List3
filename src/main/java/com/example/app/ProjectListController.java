package com.example.app;

import java.util.HashMap;
import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.controls.Controller;
import spms.dao.ProjectDao;

@Component("/project/list.do") // orderCond=PNO_ASC 넘어올때 객체 
public class ProjectListController implements Controller, DataBinding {
  ProjectDao projectDao;
  
  public ProjectListController setMemberDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  
  @Override
	public Object[] getDataBinders() { 
	  return new Object[] {
			  "orderCond", String.class   //String클래스로 넘어감.
	  };
	  	
	} // getDateBinders() end
  
  

  @Override
  public String execute(Map<String, Object> model) throws Exception {
	  HashMap<String, Object> paramMap = new HashMap<String, Object>();
	  paramMap.put("orderCond", model.get("orderCond"));
    model.put("projects", projectDao.selectList(paramMap));
    return "/project/ProjectList.jsp";
  }
}





