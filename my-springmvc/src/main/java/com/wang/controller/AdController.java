package com.wang.controller;

import com.wang.model.CalculateModel;
import com.wang.model.CarPO;
import com.wang.services.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.*;
import java.net.MalformedURLException;

/**
 * Description:Controller的基本语法测试
 * All Rights Reserved.
 *
 * @version 1.0  2018/3/6 下午2:38  by  王帅（wangshuai@cloud-young.com）创建
 */
@Controller
@RequestMapping("ad")
public class AdController {
    @Autowired
    CalculateModel calculateModel;
    @Autowired
    Calculate calculate;

    //get:  /ad/index
    @RequestMapping({"/", "index"})
    public String index(Model model) {
        model.addAttribute("isActive", true);
        model.addAttribute("name", "ad-index");
        return "ad/index";
    }

    //get: /ad/findex
    @RequestMapping(value = "findex", method = {RequestMethod.GET})
    public ModelAndView ftlindex(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("findex");
        mv.addObject("name", "My First Spring Mvc and Freemarker !");
        mv.addObject("requestParam", request.getQueryString());
        return mv;
    }

    //get:  /ad/hello?p=
    @RequestMapping("hello")
    //  @ResponseBody
    public String getFirstPage(Model model, @RequestParam Integer p  /*@requestBody*/) {
        //  @ResponseBody   @requestBody   返回和接收json
        model.addAttribute("test", "my name is freemarker");
        model.addAttribute("x", calculateModel.getX());
        model.addAttribute("p", p);
        return "ad/hello";
    }

    @RequestMapping("w3c")
    public String redirect() {
        return "redirect:/image/w3c.png";
    }

    @RequestMapping(path = "/body", method = RequestMethod.GET)
    @ResponseBody //直接返回内容 hello world
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(path = "/calc", method = RequestMethod.GET)
    @ResponseBody
    public String calc() {
        Integer sum = calculate.add(2, 3);
        return "" + sum;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(String name, String code) {
        return name + code;
    }

    @RequestMapping({"edit"})
    public String edit(Model model) {
        return "ad/edit";
    }
    @RequestMapping(value = "paramByList", method = RequestMethod.POST)
    @ResponseBody
    public int paramByList(@RequestParam int id) {
    //public String paramByList(@RequestParam CarPO po) {

        return  id;
    }
}
