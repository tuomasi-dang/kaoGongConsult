package com.cl.entity.rsp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatCompletionResponse {

    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;
    private String system_fingerprint;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {
        private int index;
        private Message message;
        private Object logprobs;
        private String finish_reason;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Message {
        private String role;
        private String content;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Usage {
        private int prompt_tokens;
        private int completion_tokens;
        private int total_tokens;
        private PromptTokensDetails prompt_tokens_details;
        private int prompt_cache_hit_tokens;
        private int prompt_cache_miss_tokens;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PromptTokensDetails {
        private int cached_tokens;
    }
}