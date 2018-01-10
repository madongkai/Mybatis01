

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.bdqn.dao.UserMapper;
import com.bdqn.entity.User;
import com.bdqn.entity.UserEx;
import com.bdqn.utils.MyBatisUtil;

public class UserMapperTest {
	
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCount() {
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			
			//第一种方式:调用selectOne方法执行查询操作
			//count = sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			
			//第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
			count = sqlSession.getMapper(UserMapper.class).count();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		
		logger.debug("UserDaoTest count---> " + count);
	}
	
	@Test
	public void testGetUserList(){
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			
			//第一种方式:调用selectList方法执行查询操作
			//userList = sqlSession.selectList("cn.smbms.dao.user.UserMapper.getUserList");
			String nnnn = "赵";
			//第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
			userList = sqlSession.getMapper(UserMapper.class).getUserListByName(nnnn);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(User user: userList){
			logger.debug("testGetUserList userCode: " + user.getUserCode() + " and userName: " + user.getUserName());
		}
	}
	
	@Test
	public void testGetUserList2(){
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			
			//第一种方式:调用selectList方法执行查询操作
			//userList = sqlSession.selectList("cn.smbms.dao.user.UserMapper.getUserList");
			
			//第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
			User user = new User();
			user.setUserName("张");
			user.setGender(2);
			userList = sqlSession.getMapper(UserMapper.class).getUserList(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(User user: userList){
			logger.debug("testGetUserList userCode: " + user.getUserCode() + " and userName: " + user.getUserName());
		}
	}
	
	@Test
	public void testGetUserList3(){
		SqlSession sqlSession = null;
		List<UserEx> userList = new ArrayList<UserEx>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			
			//第一种方式:调用selectList方法执行查询操作
			//userList = sqlSession.selectList("cn.smbms.dao.user.UserMapper.getUserList");
			
			//第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
			User user = new User();
			user.setUserName("张");
			user.setGender(1);
			userList = sqlSession.getMapper(UserMapper.class).getUserListAndRole(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(UserEx userEx: userList){
			logger.debug(userEx.getRoleName()+ " testGetUserList userCode: " + userEx.getUserCode() + " and userName: " + userEx.getUserName());
		}
	}
	
	@Test
	public void testDelUser(){
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			
			//第一种方式:调用selectList方法执行查询操作
			//userList = sqlSession.selectList("cn.smbms.dao.user.UserMapper.getUserList");
			
			//第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
			int id = 14;
			count = sqlSession.getMapper(UserMapper.class).delUser(id);
			/*int i = 10/0;*/
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			count = 0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
			logger.debug("删除"+count);
	}

}
