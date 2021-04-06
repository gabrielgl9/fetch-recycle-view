package com.example.fetchrecicleview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchrecicleview.R;
import com.example.fetchrecicleview.models.Album;
import com.example.fetchrecicleview.models.Post;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> listaPosts;

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public View viewPost;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPost = itemView;
        }
    }
    public PostAdapter(List<Post> posts) {
        this.listaPosts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_posts, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post obj = (Post) this.listaPosts.get(position);
        TextView titleTextView = holder.viewPost.findViewById(R.id.titleTextView);
        TextView idTextView = holder.viewPost.findViewById(R.id.idTextView);
        TextView bodyTextView = holder.viewPost.findViewById(R.id.bodyTextView);
        titleTextView.setText("Título: " + obj.getTitle());
        idTextView.setText("ID: " + obj.getId());
        bodyTextView.setText("Corpo: " + obj.getBody());
    }



    @Override
    public int getItemCount() {
        return this.listaPosts.size();
    }
}