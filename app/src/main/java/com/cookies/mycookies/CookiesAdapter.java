package com.cookies.mycookies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 16/08/2017.
 */

public class CookiesAdapter extends RecyclerView.Adapter<CookiesAdapter.ViewHolder> {

    private final OnItemClickListener listener;
    private ArrayList<CookiesModel> listcookies;

    public CookiesAdapter(ArrayList<CookiesModel> listcookies, OnItemClickListener listener){
        this.listcookies = listcookies;
        this.listener = listener;
    }

    @Override
    public CookiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cookies, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(CookiesAdapter.ViewHolder holder, int position) {
        holder.click(listcookies.get(position), listener);
        holder.tvId.setText(String.valueOf(listcookies.get(position).getId()));
        holder.judul.setText(listcookies.get(position).getJudul());
        holder.deskripsi.setText(listcookies.get(position).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return listcookies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, judul, deskripsi;


        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            judul = (TextView) itemView.findViewById(R.id.tvJudul);
            deskripsi = (TextView) itemView.findViewById(R.id.tvDeskripsi);

            tvId.setVisibility(View.GONE);
        }


        public void click(final CookiesModel cookiesModel, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(cookiesModel);
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onClick(CookiesModel item);
    }



}
