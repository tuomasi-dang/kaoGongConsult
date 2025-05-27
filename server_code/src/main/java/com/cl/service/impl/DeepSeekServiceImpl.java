package com.cl.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.cl.config.WebClientConfig;
import com.cl.entity.req.DeepSeekRequest;
import com.cl.entity.rsp.ChatCompletionResponse;
import com.cl.entity.rsp.ChatMessage;
import com.cl.service.DeepSeekService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okio.Buffer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class DeepSeekServiceImpl implements DeepSeekService {

    private final WebClientConfig apiKey;
    private final WebClientConfig config;

    public DeepSeekServiceImpl(WebClientConfig apiKey, WebClientConfig config) {
        this.apiKey = Objects.requireNonNull(apiKey, "API Key 不能为空");
        this.config = Objects.requireNonNull(config, "配置不能为空");
    }

    public ChatMessage getChatResponse(DeepSeekRequest deepSeekRequest) {
        // 初始化 OkHttpClient
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        // 构建请求体
        MediaType mediaType = MediaType.parse("application/json");
        String jsonBody = buildRequestBody(deepSeekRequest.getAsk().trim()); // 动态构建请求体
        RequestBody requestBody = RequestBody.create(jsonBody, mediaType);

        // 打印请求体内容（调试用）
        Buffer buffer = new Buffer();
        try {
            requestBody.writeTo(buffer);
            System.out.println("Request Body Content: " + buffer.readUtf8());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建 Headers
        Headers headers = new Headers.Builder()
                .add("Content-Type", "application/json")
                .add("Accept", "application/json")
                .add("Authorization", "Bearer " + apiKey.getDeepSeekConfigUrl())
                .build();

        // 创建 HttpUrl
        HttpUrl url = HttpUrl.parse(config.getDeepSeekConfigHost());
        if (url == null) {
            throw new IllegalArgumentException("URL 参数无效");
        }

        // 构造 Request
        Request request = new Request.Builder()
                .url(url)
                .method("POST", requestBody)
                .headers(headers)
                .build();

        // 执行请求并处理响应
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("请求失败: " + response.code() + " - " + response.message());
            }

            String responseBody = Objects.requireNonNull(response.body()).string();
            System.out.println("Response Body: " + responseBody);

            // 解析响应为 ChatCompletionResponse 对象
            ObjectMapper objectMapper = new ObjectMapper();
            ChatCompletionResponse chatCompletionResponse = objectMapper.readValue(responseBody, ChatCompletionResponse.class);
            List<ChatCompletionResponse.Choice> choices = chatCompletionResponse.getChoices();
            String resultMessage = "";
            ChatMessage chatMessage = new ChatMessage();
            if (CollectionUtils.isNotEmpty(choices)) {
                List<ChatCompletionResponse.Message> messageList = choices.stream().map(ChatCompletionResponse.Choice::getMessage).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(messageList)) {
                    ChatCompletionResponse.Message message = messageList.get(0);
                    if (Objects.nonNull(message)) {
                        resultMessage = message.getContent();
                        chatMessage.setContent(resultMessage);
                        return chatMessage;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("请求异常: " + e.getMessage(), e);
        }
        return new ChatMessage();
    }


    // 构建请求体
    private String buildRequestBody(String message) {
        return """
                {
                  "model": "deepseek-chat",
                  "messages": [
                    {
                      "role": "system",
                      "content": "You are a helpful assistant."
                    },
                    {
                      "role": "user",
                      "content": "%s"
                    }
                  ],
                  "stream": false
                }
                """.formatted(message);
    }
}