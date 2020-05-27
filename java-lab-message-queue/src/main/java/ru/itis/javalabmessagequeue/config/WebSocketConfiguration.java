package ru.itis.javalabmessagequeue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itis.javalabmessagequeue.handler.WebSocketMessagesHandler;

@Configuration
public class WebSocketConfiguration implements WebSocketConfigurer {

    private final WebSocketMessagesHandler handler;

    public WebSocketConfiguration(WebSocketMessagesHandler handler) {
        this.handler = handler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(handler, "/ws");
    }
}
