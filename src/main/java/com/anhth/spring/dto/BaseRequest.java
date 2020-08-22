package com.anhth.spring.dto;

import lombok.Data;

@Data
public class BaseRequest {
    private String apiKey;
    private String sessionId;
    private String username;
    private String wsCode;
    private UserDTO wsRequest;

}
