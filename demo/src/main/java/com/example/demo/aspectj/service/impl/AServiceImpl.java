package com.example.demo.aspectj.service.impl;/**
 * Created by hkrt on 2019/4/15.
 */

import com.example.demo.aspectj.service.AService;
import org.springframework.stereotype.Service;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/15 17:05
 **/
@Service
public class AServiceImpl implements AService {
    @Override
    public String sayHelloA() {
        return this.getClass().getSimpleName();
    }
}
