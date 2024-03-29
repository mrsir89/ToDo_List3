package com.example.app;

import java.util.Map;

import com.example.app.Component;
import com.example.app.DataBinding;

import com.example.app.ProjectDao;
import com.example.app.Project;

@Component("/project/update.do")
public class ProjectUpdateController implements Controller, DataBinding {
  ProjectDao projectDao;
  
  public ProjectUpdateController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "no", Integer.class,
        "project", com.example.app.Project.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Project project = (Project)model.get("project");
    
    if (project.getTitle() == null) { 
      Integer no = (Integer)model.get("no");
      Project detailInfo = projectDao.selectOne(no);
      model.put("project", detailInfo);
      return "/project/ProjectUpdateForm.jsp";

    } else { 
      projectDao.update(project);
      return "redirect:list.do";
    }
  }
}
