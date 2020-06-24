package com.qa.mobileautomation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.qa.mobileautomation")
@PropertySource("classpath:endpoints.properties")
public class Config {
}
