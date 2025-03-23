package com.cl.service;

import com.cl.entity.req.DeepSeekRequest;
import com.cl.entity.rsp.ChatMessage;

public interface DeepSeekService {
    ChatMessage getChatResponse(DeepSeekRequest deepSeekRequest);
}