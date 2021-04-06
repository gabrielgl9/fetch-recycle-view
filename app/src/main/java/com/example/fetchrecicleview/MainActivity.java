package com.example.fetchrecicleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Redirect to Todos
        Button buttonTodo = (Button) findViewById(R.id.todoButton);
        buttonTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TodoActivity.class);
                startActivity(intent);
            }
        });

        // Redirect to posts
        Button buttonPost = (Button) findViewById(R.id.postButton);
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PostActivity.class);
                startActivity(intent);
            }
        });

        // Redirect to albums
        Button buttonAlbum = (Button) findViewById(R.id.albumbutton);
        buttonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AlbumActivity.class);
                startActivity(intent);
            }
        });
    }
}