package com.example.demo.hi;/**
 * Created by hkrt on 2019/4/18.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/18 16:47
 **/
@RestController
public class HIController {

    @RequestMapping("/hi")
    public String sayHi(){
        return "hello";
    }
}
