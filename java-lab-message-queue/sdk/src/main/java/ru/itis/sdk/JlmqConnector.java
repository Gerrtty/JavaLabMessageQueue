package ru.itis.sdk;

import lombok.Data;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Data
public class JlmqConnector {

    private final String port;
    private Session session;

    private JlmqConnector(Connector connector) {
        port = connector.port;
    }

    public static class Connector {

        private String port = "";

        public Connector port(String val) {
            port = val;
            return this;
        }

        public JlmqConnector connect() {
            Endpoint endpoint = new CustomClientEndPoint();
            Session session = null;
            try {
                session =
                        ContainerProvider.getWebSocketContainer()
                                .connectToServer(endpoint,
                                        new URI("ws://localhost:" + port + "/ws"));
            } catch (DeploymentException | IOException | URISyntaxException e) {
                e.printStackTrace();
            }
            JlmqConnector jlmqConnector = new JlmqConnector(this);
            jlmqConnector.session = session;
            return jlmqConnector;
        }
    }

    public Producer<?> producer() {
        return new Producer<>(this);
    }

    public Consumer consumer() {
        return new Consumer(this);
    }
}
