package com.example.macuser.statusbardemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.macuser.statusbardemo.R;
import com.example.macuser.statusbardemo.model.SongListModel;

import java.util.List;

/**
 * Created by macuser on 16/7/22.
 **/
public class PersonalSongListAdapter extends BaseAdapter {

    private Context context;
    private List<SongListModel> listData;
    private LayoutInflater inflater;

    public PersonalSongListAdapter(Context context, List<SongListModel> listData) {
        super();
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public SongListModel getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_song_list,
                    null);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return null;
    }

    class ViewHolder {

    }
}