/**
 *  UserServiceImpl TODO()
 */
package cn.smbms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smbms.mapper.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import cn.smbms.tools.Page;

/**
 * @author ggy
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public User findByName(String name) {
		return userMapper.findByName(name);
	}
	
	public Integer saveUser(User user) {
		return userMapper.saveUser(user);
	}
	
	public Page<User> findByPage(Map<String, Object> map) {
		//查找数据中记录总数中，count(*) 和limit配合
		// sql语句将返回空行，因为count(*)只会使sql语句产生一条结果记录，
		// 所以后面的limit 1,5 是完全找不到的。
		Integer count = userMapper.countByQuery(map);    //查找表中的总量
		Page<User> pa = new Page<User>();
		pa.setCount(count);
		pa.setIndex(Integer.parseInt(map.get("index").toString()));
		map.put("index", (pa.getIndex())*pa.getSize());
		map.put("size", pa.getSize());
		List<User> list = userMapper.findByQuery(map);
		pa.setList(list);
		return pa;
	}
	
	public Integer delectUser(Integer id) {
		return userMapper.deleteUser(id);
	}
	
	public User findByid(Integer id) {
		return userMapper.findByid(id);
	}
	
	public Integer updateUser(User user) {
		return userMapper.updateUser(user);
	}
	
	public Integer updatePwd(User user) {
		return userMapper.updatePwd(user);
	}

}
