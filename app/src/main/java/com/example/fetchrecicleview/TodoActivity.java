package com.example.fetchrecicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fetchrecicleview.adapters.TodoAdapter;
import com.example.fetchrecicleview.models.Todo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
                                                                Response.ErrorListener{

    List <Todo> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/todos";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Todo obj = new Todo(json.getInt("id"),
                        json.getInt("userId"),
                        json.getString("title"),
                        json.getBoolean("completed"));

                todos.add(obj);
            }

            RecyclerView recyclerView = findViewById(R.id.recicleViewTodos);
            LinearLayoutManager linearLayoutManagerHorinzontal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(linearLayoutManagerHorinzontal);

            TodoAdapter todoAdapter = new TodoAdapter(todos);
            recyclerView.setAdapter(todoAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"deu erro: "+msg, Toast.LENGTH_LONG).show();
    }

}