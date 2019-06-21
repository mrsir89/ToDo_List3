
package com.example.app;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;///////////////////////////////////

import spms.annotation.Component;
import spms.vo.Project;




// <<sql mapper file>>


// Dao 객체에서는 sql문을 직접 사용하지 않는다.
// MyBatis 에서 제공하는 SqlSessionFactory를 사용한다.
// sql문을 호출할 수 있도록 id를 설정해준다.
// 그러면 해당 id와 맵핑(연결)된 sql문이 호출된다.

@Component("projectDao")
public class MySqlProjectDao implements ProjectDao {
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

  public List<Project> selectList(HashMap<String, Object> paramMap) throws Exception { // 특별히 전달할 정보는 없기때문에 id만 
	  SqlSession sqlSession = sqlSessionFactory.openSession();
	  try {
		return sqlSession.selectList("spms.dao.ProjectDao.selectList",paramMap); // "~"  가 id  (를 가지고 sql을 찾아야 한다)
	}finally {
		//catch는 안하는데 MyBatis로그 설정을 통해  에러를 확인할 수 있기 때문
		sqlSession.close();
	}
	 
  }// selectList() end

	public int insert(Project project) throws Exception { // 고객이 요청하는 정보가 때마다 달리지기 때문에
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert("spms.dao.ProjectDao.insert", project);// project는 값을 전달한다 insert는 인자가 필요. 성공/실패 여부만 반환
			sqlSession.commit();// auto 가능.
			return count;
		} finally {
			sqlSession.close();
		}
	}// insert() end
  
	public Project selectOne(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("spms.dao.ProjectDao.selectOne", no);//
		} finally { 

		}

	}// selectOne() end
	
	// project는 브라우저가 보낸 수정된 값
	// original은 DB에 존재하는 현재 정보
	// 이 두개를 비교해서 차이가 나는 것만 paramMap에 저장할 것이다.
	public int update(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			Project original = sqlSession.selectOne("spms.dao.ProjectDao.selectOne",project.getNo());//현재상태 받아온다. 비교하기 위해?
			Hashtable<String, Object> paramMap = new Hashtable<String, Object>();
			
			if(!project.getTitle().equals(original.getTitle())){
				paramMap.put("title", project.getTitle());  
			}
			if(!project.getContent().equals(original.getContent())) {
				paramMap.put("content", project.getContent());
			}
			if(project.getStartDate().compareTo(original.getStartDate())!=0) {
				paramMap.put("startDate", project.getStartDate());
			}
			if(project.getEndDate().compareTo(original.getEndDate())!=0){
				paramMap.put("endDate", project.getEndDate());
			}
			if(project.getState()!=original.getState()) {
				paramMap.put("state", project.getState());
			}
			if(project.getTags().equals(original.getTags())){
				paramMap.put("tags",project.getTags());
			}
			
			
			// 수정된 것이 있다면,
			if(paramMap.size()>0) {
				paramMap.put("no", project.getNo());
				int count = sqlSession.update("spms.dao.ProjectDao.update", paramMap);
				sqlSession.commit();
				return count;
			}else {
				return 0;
			}
			
			
		} finally {
			sqlSession.close();
		}
		
	}//update() end

	public int delete(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.delete("spms.dao.ProjectDao.delete",no);
			sqlSession.commit(); // 
			return count;
			
		} finally {
			sqlSession.close();
		}
		
	}//delete() end
	
	
}// class end
