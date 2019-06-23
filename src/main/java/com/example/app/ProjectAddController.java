package com.example.app;

import java.util.Map;

import com.example.app.Component;
import com.example.app.DataBinding;
import com.example.app.ProjectDao;
import com.example.app.Project;

@Component("/project/add.do")
public class ProjectAddController implements Controller, DataBinding {
  ProjectDao projectDao;
  
  public ProjectAddController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "project", com.example.app.Project.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Project project = (Project)model.get("project");
    if (project.getTitle() == null) {
      return "/project/ProjectForm.jsp";
      
    } else {
      projectDao.insert(project);
      return "redirect:list.do";
    }
  }
}
