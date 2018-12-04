package com.wang.controller.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wang.model.Car;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/3 上午11:09  by  王帅（wangshuai@cloud-young.com）创建
 */
@RestController
@RequestMapping("/car")
public class ApiController {
    //ModelAttribute 使用
//    private String func="";
//    @ModelAttribute
//    public void init02()
//    {
//        func+="init"+2;
//    }
//    @ModelAttribute
//    public void init()
//    {
//        func+="init"+1;
//    }

    ///get /car?name=bb
    @RequestMapping(method = RequestMethod.GET)
    public Car get(@RequestParam(value = "id", defaultValue = "1") Integer id, String name) {
        Car car = new Car(id, name);
        car.setId(id);
        car.setName(name);
        return car;
    }

    ///get /car/p?name=bb
    @RequestMapping(path = "p", method = RequestMethod.GET)
    public Car get1(@RequestParam(value = "id", defaultValue = "2") Integer id, String name) {
        Car car = new Car(id, name);
        return car;
    }

    //get /car/2018-04-03
    ///@PathVariable可以被应用于所有 简单类型 的参数上，比如int、long、Date等类型。
    @RequestMapping(path = "/{day}", method = RequestMethod.GET)
    public Date get2(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date day) {
        return day; //1522713600000
    }

    //get /car/l/23.2
    @RequestMapping(path = "/l/{l}", method = RequestMethod.GET)
    public double get2(@PathVariable long l) {
        return l; //23.0
    }


    ///正则匹配
    //get  /car/reg/222.aadf
    @RequestMapping(path = "/reg/{version:\\d+}{extension:\\.[a-z]+}", method = RequestMethod.GET)
    public String get4(@PathVariable String version, @PathVariable String extension) {
        return version + extension; //222.aadf
    }

    ///矩阵变量 (需要开启：<annotation-driven enable-matrix-variables="true" />)
    //如果要允许矩阵变量的使用，你必须把 RequestMappingHandlerMapping 类的 removeSemicolonContent 属性设置为false。该值默认是true的。
// get  /car/arr/q=1;q=2;q=3   [ "1",  "2",  "3"]
    ///car/arr/q=1,2,3    [ "1",  "2",  "3"]
    @RequestMapping(path = "/arr/{arr}", method = RequestMethod.GET)
    public List get5(@MatrixVariable(name = "q", pathVar = "arr") List<String> vars) {
        return vars;//[ "1",  "2",  "3"]
    }

    //get /car/map/q=1;q=2;d=3
    @RequestMapping(path = "/map/{map}", method = RequestMethod.GET)
    public Map get52(@MatrixVariable Map<String, String> vars) {
        return vars; //{ "q": "1", "d": "3" }  //key重复时保留先出现的，2没被加入
    }

    // GET /pets/42;q=11;r=22
    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET)
    public String findPet(@PathVariable String petId, @MatrixVariable String q) {
        // petId == 42
        // q == 11
        return "petId=" + petId + ";q=" + q;
    }

    // GET /owners/42;q=11/pets/21;q=22
    @RequestMapping(path = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
    public String findPet(
            @MatrixVariable(name = "q", pathVar = "ownerId") int q1,
            @MatrixVariable(name = "q", pathVar = "petId") int q2) {
        // q1 == 11
        // q2 == 22
        return "q1=" + q1 + ";q2=" + q2;
    }

    // GET /pet/42
    @RequestMapping(path = "/pet/{petId}", method = RequestMethod.GET)
    public Integer findPet(@MatrixVariable(required = false, defaultValue = "1") int q) {
        // q == 1
        return q;
    }

    @RequestMapping(path = "/paramtest", method = RequestMethod.GET)
    public void get6(HttpServletRequest request) {
        System.out.println();

    }

    @RequestMapping(path = "/datestr/{json}", method = RequestMethod.GET)
    public Car get7(String json) {
        json = "{    \"marketDate\": \"2016-01-11 9:16 上午 UTC\"}";
        Date date = new Date();
        Car car = new Car();
        car.setMarketDate(date);
        if (json != "") {
            ObjectMapper mapper = new ObjectMapper();
            try {
                car = mapper.readValue(json, Car.class);
            } catch (Exception ex) {
            }
        }
        return car;
    }
}

