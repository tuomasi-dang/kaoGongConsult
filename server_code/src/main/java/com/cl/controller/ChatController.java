package com.cl.controller;


import java.util.Arrays;
import java.util.Map;

import com.cl.entity.req.DeepSeekRequest;
import com.cl.entity.rsp.ChatCompletionResponse;
import com.cl.entity.rsp.ChatMessage;
import com.cl.service.DeepSeekService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.entity.ChatEntity;
import com.cl.entity.view.ChatView;
import com.cl.service.ChatService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import reactor.core.publisher.Mono;

/**
 * 管理员聊天
 * 后端接口
 *
 * @author
 * @email
 * @date 2024-12-31 14:57:50
 */
@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private DeepSeekService deepSeekService;

    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ChatEntity chat,
                  HttpServletRequest request) {
        QueryWrapper<ChatEntity> ew = new QueryWrapper<ChatEntity>();


        PageUtils page = chatService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chat), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ChatEntity chat,
                  HttpServletRequest request) {
        if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
            chat.setUserid((Long) request.getSession().getAttribute("userId"));
        }
        QueryWrapper<ChatEntity> ew = new QueryWrapper<ChatEntity>();

        PageUtils page = chatService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chat), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ChatEntity chat) {
        QueryWrapper<ChatEntity> ew = new QueryWrapper<ChatEntity>();
        ew.allEq(MPUtil.allEQMapPre(chat, "chat"));
        return R.ok().put("data", chatService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChatEntity chat) {
        QueryWrapper<ChatEntity> ew = new QueryWrapper<ChatEntity>();
        ew.allEq(MPUtil.allEQMapPre(chat, "chat"));
        ChatView chatView = chatService.selectView(ew);
        return R.ok("查询管理员聊天成功").put("data", chatView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ChatEntity chat = chatService.getById(id);
        chat = chatService.selectView(new QueryWrapper<ChatEntity>().eq("id", id));
        return R.ok().put("data", chat);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ChatEntity chat = chatService.getById(id);
        chat = chatService.selectView(new QueryWrapper<ChatEntity>().eq("id", id));
        return R.ok().put("data", chat);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChatEntity chat, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(chat);
        if (StringUtils.isNotBlank(chat.getAsk())) {
            chatService.update(new UpdateWrapper<ChatEntity>().set("isreply", 0).eq("userid", request.getSession().getAttribute("userId")));
            chat.setUserid((Long) request.getSession().getAttribute("userId"));
            chat.setIsreply(1);
        }
        if (StringUtils.isNotBlank(chat.getReply())) {
            chatService.update(new UpdateWrapper<ChatEntity>().set("isreply", 0).eq("userid", chat.getUserid()));
            chat.setAdminid((Long) request.getSession().getAttribute("userId"));
        }
        chatService.save(chat);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChatEntity chat, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(chat);
        chat.setUserid((Long) request.getSession().getAttribute("userId"));
        if (StringUtils.isNotBlank(chat.getAsk())) {
            chatService.update(new UpdateWrapper<ChatEntity>().set("isreply", 0).eq("userid", request.getSession().getAttribute("userId")));
            chat.setUserid((Long) request.getSession().getAttribute("userId"));
            chat.setIsreply(1);
        }
        if (StringUtils.isNotBlank(chat.getReply())) {
            chatService.update(new UpdateWrapper<ChatEntity>().set("isreply", 0).eq("userid", chat.getUserid()));
            chat.setAdminid((Long) request.getSession().getAttribute("userId"));
        }
        chatService.save(chat);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChatEntity chat, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(chat);
        chatService.updateById(chat);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        chatService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 接入DeepSeek
     *
     * @param deepSeekRequest
     * @return
     */
    @PostMapping("/response")
    public ChatMessage getChatResponse(@RequestBody DeepSeekRequest deepSeekRequest) {
        log.info("Received request: {}", deepSeekRequest.getAsk()); // 添加日志
        return deepSeekService.getChatResponse(deepSeekRequest);
    }

}
