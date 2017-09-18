package com.formation.tutoandroidrxjava.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.formation.tutoandroidrxjava.R;
import com.formation.tutoandroidrxjava.databinding.ItemAlbumBinding;
import com.formation.tutoandroidrxjava.models.Album;
import com.formation.tutoandroidrxjava.viewmodel.ItemAlbumViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by tarikalaoui on 16/09/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumAdapterViewHolder> {
    private List<Album> albumList;

    public AlbumAdapter() {
        this.albumList = Collections.emptyList();
    }

    @Override public AlbumAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAlbumBinding itemAlbumBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_album,
                        parent, false);
        return new AlbumAdapterViewHolder(itemAlbumBinding);
    }

    @Override public void onBindViewHolder(AlbumAdapterViewHolder holder, int position) {
        holder.bindAlbum(albumList.get(position));
    }

    @Override public int getItemCount() {
        return albumList.size();
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
        notifyDataSetChanged();
    }

    public static class AlbumAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemAlbumBinding mItemAlbumBinding;

        public AlbumAdapterViewHolder(ItemAlbumBinding itemAlbumBinding) {
            super(itemAlbumBinding.itemAlbum);
            this.mItemAlbumBinding = itemAlbumBinding;
        }

        void bindAlbum(Album album) {
            if (mItemAlbumBinding.getItemAlbumViewModel() == null) {
                mItemAlbumBinding.setItemAlbumViewModel(
                        new ItemAlbumViewModel(album, itemView.getContext()));
            } else {
                mItemAlbumBinding.getItemAlbumViewModel().setAlbum(album);
            }
        }
    }
}
