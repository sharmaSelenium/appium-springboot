package com.qa.mobileautomation.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class Endpoints {
    @Value("${aut}")
    private String aut;
    @Value("${url}")
    private String url;
    @Value("${androidDevice}")
    private String androidDevice;
    @Value("${iosDevice}")
    private String iosDevice;
    @Value("${androidPlatformVersion}")
    private String androidPlatformVersion;
    @Value("${executionType}")
    private String executionType;
    @Value("${iosPlatformVersion}")
    private String iosPlatformVersion;


    public Supplier<String> getAppType = () -> aut;
    public Supplier<String> getAndroidDevice = () -> androidDevice;
    public Supplier<String> getIosDevice = () -> iosDevice;
    public Supplier<String> getURL = () -> url;
    public Supplier<String> getAndroidVersion = () -> androidPlatformVersion;
    public Supplier<String> getExecutionMode = () -> executionType;
    public Supplier<String> getIosVersion = () -> iosPlatformVersion;

}
