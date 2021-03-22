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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class) //调用Spring单元测试类
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
@WebAppConfiguration
@Transactional
/**
 * @author chris
 * @date 2020-10-15 21:05
 */
public class BillControllerTest {

    @Autowired
    protected WebApplicationContext context;
    private MockMvc mockMvc;        //SpringMVC提供的Controller测试类
    private String url;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void billadd() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/billAdd.html")
                .param("billCode", "bill2020_001")
                .param("productName", "沐浴露")
                .param("productDesc", "日用品-沐浴类")
                .param("productUnit", "瓶")
                .param("productCount", "200")
                .param("totalPrice", "2000")
                .param("isPayment", "2")
                .param("createBy", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}