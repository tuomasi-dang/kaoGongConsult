package com.cl.entity.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DeepSeekRequest {

    @NotBlank(message = "问题不能为空")
    private String ask;

    // Getter 和 Setter
    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }
}