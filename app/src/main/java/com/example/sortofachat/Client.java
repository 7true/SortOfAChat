package com.example.sortofachat;

import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class Client {
    WebSocketClient client;

    public void connect() {
        URI addr;
        try {
            addr = new URI("ws://35.210.129.230:8881");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        client = new WebSocketClient(addr) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Log.i("WSSERVER","Connected to server");
            }

            @Override
            public void onMessage(String message) {
                Log.i("WSSERVER", "Received message: " + message);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.i("WSSERVER", "Connection closed");
            }

            @Override
            public void onError(Exception ex) {
                Log.i("WSSERVER", "Error occured" + ex.getMessage());
            }
        };

        client.connect();
    }
}
