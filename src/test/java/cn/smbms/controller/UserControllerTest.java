package cn.smbms.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class) //调用Spring单元测试类
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
@WebAppConfiguration
@Transactional
/**
 * @author chris
 * @date 2020-10-09 14:57
 */
public class UserControllerTest {

    @Autowired
    protected WebApplicationContext context;
    private MockMvc mockMvc;        //SpringMVC提供的Controller测试类
    private String url;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testLogin() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/login.html")
                        .param("userCode", "admin")
                        .param("userPassword", "123456"))
// 密码错误                .param("userCode", "admin")
//                        .param("userPassword", "1234567"))
// 账户错误                .param("userCode", "admin1")
//                        .param("userPassword", "123456"))
// 密码为空                .param("userCode", "admin")
//                        .param("userPassword", ""))
// 账户为空                .param("userCode", "")
//                        .param("userPassword", "123456"))
// 账户密码都为空           .param("userCode", "")
//                        .param("userPassword", ""))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Test
    public void userAdd() {
    }

    @Test
    public void testUserAdd() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/userAdd.html")
                .param("userCode", "123")
                .param("userName", "小明")
                .param("userPassword", "0000000")
                .param("gender", "1")
                .param("birthday", "1983-12-10")
                .param("phone", "13688884457")
                .param("address", "北京市海淀区成府路207号")
                .param("userRole", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
}