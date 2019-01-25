package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/15 19:38  by  王帅（wangshuai@cloud-young.com）创建
 */
@Controller
@RequestMapping("rd")
public class RedirectTestController {
    @RequestMapping(value = "forwardTest", method = RequestMethod.GET)
    public String forwardTest() {
        return "forward:/rd/";//客户端不可见
    }

    @RequestMapping(value = "redirectedTest", method = RequestMethod.GET)
    public String redirectedTest() {
        return "redirect:/rd/"; //httpstatus 302,可看到地址栏变化
    }

    @RequestMapping("index1")
    //@ResponseBody
    public String index1(Model model) {
        model.addAttribute("p", "abcd");
        return "redirect:/rd/index2?p={p}"; // 占位符填充，p中所有不安全字符会转义，更安全
    }

    @RequestMapping("index2")
    @ResponseBody
    public String index2(String p) {
        return "index2:p=" + p;
    }

    /// flash 属性
    @RequestMapping("index3")
    //@ResponseBody
    public String index3(RedirectAttributes ra) {
        HashMap hashMap = new HashMap();
        hashMap.put("k1", 2);
        hashMap.put("k2", 3);
        ra.addFlashAttribute("hashMap", hashMap);//添加flash 属性
        return "redirect:/rd/index4";
    }

    @RequestMapping("index4")
    @ResponseBody
    public String index4(Model model) {
        if (model.containsAttribute("hashMap")) {
            Map<String, Object> hm = model.asMap();
            HashMap<String, Object> hm2 = (HashMap<String, Object>) hm.get("hashMap");
            return "index4:k1=" + hm2.get("k1");
        }
        return "index2";
    }

    @RequestMapping("index5")

    public void index5(Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            // request.getRequestDispatcher("/behaviordata/list").forward(request, response);//forward 方式 传参数
            response.sendRedirect("/rd/index1");
        } catch (Exception ex) {
        }
    }
}
