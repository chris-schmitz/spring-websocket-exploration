package com.schmitz.messagingstompwebsocket.controller;

import com.schmitz.messagingstompwebsocket.domain.Greeting;
import com.schmitz.messagingstompwebsocket.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Heya, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
