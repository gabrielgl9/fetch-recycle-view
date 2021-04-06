package com.example.fetchrecicleview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchrecicleview.R;
import com.example.fetchrecicleview.models.Todo;

import java.util.List;


public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> listaTodos;

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public View viewTodo;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewTodo = itemView;
        }
    }
    public TodoAdapter(List<Todo> todos) {
        this.listaTodos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_todos, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo obj = (Todo) this.listaTodos.get(position);
        TextView titleTextView = holder.viewTodo.findViewById(R.id.titleTextView);
        TextView idTextView = holder.viewTodo.findViewById(R.id.idTextView);
        titleTextView.setText("Título: " + obj.getTitle() + "");
        idTextView.setText("ID: " + obj.getId());
        CheckBox completedCheckBox = holder.viewTodo.findViewById(R.id.completedCheckBox);
        completedCheckBox.setChecked(obj.isCompleted());
    }



    @Override
    public int getItemCount() {
        return this.listaTodos.size();
    }
}