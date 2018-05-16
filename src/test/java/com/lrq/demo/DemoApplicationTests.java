package com.lrq.demo;

import com.github.pagehelper.Page;
import com.lrq.demo.dao.UserDao;
import com.lrq.demo.model.PageInfo;
import com.lrq.demo.model.User;
import com.lrq.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	private UserService userService;

	@Test
	public void testFindByPage() {
		Page<User> persons = userService.findByPage("H",0,2);
		// 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
		PageInfo<User> pageInfo = new PageInfo<>(persons);
		Assert.assertNotNull(persons);
		List<User> list = pageInfo.getList();
		for(User u : list){
			System.out.println(u.toString());
		}
	}
}
