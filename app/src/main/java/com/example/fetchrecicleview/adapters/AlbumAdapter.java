package com.example.fetchrecicleview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchrecicleview.R;
import com.example.fetchrecicleview.models.Album;
import com.example.fetchrecicleview.models.Todo;

import java.util.List;


public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<Album> listaAlbuns;

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        public View viewAlbum;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewAlbum = itemView;
        }
    }
    public AlbumAdapter(List<Album> albuns) {
        this.listaAlbuns = albuns;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_albums, parent, false);
        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album obj = (Album) this.listaAlbuns.get(position);
        TextView titleTextView = holder.viewAlbum.findViewById(R.id.titleTextView);
        TextView idTextView = holder.viewAlbum.findViewById(R.id.idTextView);
        titleTextView.setText("Título: " + obj.getTitle() + "");
        idTextView.setText("ID: " + obj.getId());
    }



    @Override
    public int getItemCount() {
        return this.listaAlbuns.size();
    }
}