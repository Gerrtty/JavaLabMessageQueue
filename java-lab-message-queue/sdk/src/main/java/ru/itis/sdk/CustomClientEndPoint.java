package ru.itis.sdk;

import lombok.NoArgsConstructor;

import javax.websocket.ClientEndpoint;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

@ClientEndpoint
@NoArgsConstructor
public final class CustomClientEndPoint extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        System.out.println("Connection");
    }
}
