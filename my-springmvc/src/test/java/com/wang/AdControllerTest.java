package com.wang;

import com.wang.controller.AdController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/14 17:14  by  王帅（wangshuai@cloud-young.com）创建
 */
public class AdControllerTest {
    @Test
    public void testHelloWorld(){
        AdController adController=new AdController();
        //测试helloWorld()返回值是否为hello World
        assertEquals ("Hello World",adController.helloWorld());
    }
    /** 使用mockMvc测试
     * @Descpription:
     * @version 1.0  2018/8/14 17:21   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @Test
    public void testIndex() throws Exception{
        AdController adController=new AdController();
        MockMvc mockMvc =standaloneSetup(adController).build();
        mockMvc.perform(get("/ad/index"))  //get方式请求/ad/index
                .andExpect(view().name("ad/index")); //预期得到视图名ad/index
         //测试helloWorld()返回值是否为hello World
       // assertEquals ("Hello World",adController.helloWorld());
    }
    @Test
    public void testSave() throws Exception {
        AdController adController = new AdController();
        MockMvc mockMvc = standaloneSetup(adController).build();
        mockMvc.perform(post("/ad/save")
        .param("name","xiao")
        .param("code","xm"))
                .andDo(MockMvcResultHandlers.print())
               // .andExpect(status().isOk())
                .andExpect(content().string(equalTo("xiaoxm")))
                //.andReturn()
             // .andExpect(redirectedUrl("ad/saveSuccess"))
               // .andExpect(forwardedUrl("ad/saveSuccess"))
        ;
    }
    @Test
    public void testForward() throws Exception{
        AdController adController=new AdController();
        MockMvc mockMvc =standaloneSetup(adController).build();
        mockMvc.perform(get("/ad/forwardTest"))
                .andExpect(forwardedUrl("/ad/"));
    }
    @Test
    public void testRedirectedUrl() throws Exception{
        AdController adController=new AdController();
        MockMvc mockMvc =standaloneSetup(adController).build();
        mockMvc.perform(get("/ad/redirectedTest"))
                .andExpect(redirectedUrl("/ad/"));
    }
    @Test
    public void testHello() throws Exception {
        AdController adController = new AdController();
        MockMvc mockMvc = standaloneSetup(adController).build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ad/index");
        mockMvc.perform( requestBuilder)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void testValid() throws Exception {
        AdController adController = new AdController();
        MockMvc mockMvc = standaloneSetup(adController).build();
        mockMvc.perform(post("/ad/validtest")
                .param("name","xiao")
                .param("id","999"))
                .andDo(MockMvcResultHandlers.print())
                 .andExpect(status().isOk())

        ;
    }
    @Test
    public void testparamByList() throws Exception {
        AdController adController = new AdController();
        MockMvc mockMvc = standaloneSetup(adController).build();
        mockMvc.perform(post("/ad/paramByList")
                .param("id","22")
                )
                .andDo(MockMvcResultHandlers.print())
                // .andExpect(status().isOk())
                .andExpect(content().string(equalTo("22")))
        //.andReturn()
        // .andExpect(redirectedUrl("ad/saveSuccess"))
        // .andExpect(forwardedUrl("ad/saveSuccess"))
        ;
    }

}
