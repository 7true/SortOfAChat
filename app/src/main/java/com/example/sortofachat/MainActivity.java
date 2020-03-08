package com.example.sortofachat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Client client;

    @Override
    protected void onStart() {
        super.onStart();
        client = new Client();
        client.connect();
    }


    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText chatMessage = findViewById(R.id.chatMessage);
        Button sendButton = findViewById(R.id.sendButton);
        RecyclerView chatWindow = findViewById(R.id.chatWindow);

        final MessageController controller = new MessageController();
        controller.setIncomingLayout(R.layout.message)
                .setOutgoingLayout(R.layout.outgoing_message)
                .setMessageTextId(R.id.messageText)
                .setUserNameId(R.id.username)
                .setMessageTimeId(R.id.messageTime)
                .appendTo(chatWindow, this);

        controller.addMessage(
                new MessageController.Message("Hi, are you here?", "sanya", true)
        );

        controller.addMessage(
                new MessageController.Message("I'am allright, fine, thank you? How are you?", "rabota", false)
        );

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = chatMessage.getText().toString();
                controller.addMessage(new MessageController.Message(userMessage, "rabota", true));
                chatMessage.setText("");
            }
        });
    }
}
