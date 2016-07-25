package com.example.macuser.statusbardemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.macuser.statusbardemo.R;
import com.example.macuser.statusbardemo.model.SongListModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
            convertView = inflater.inflate(R.layout.item_song_list,
                    null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SongListModel model = listData.get(position);
        if (model != null) {
            holder.itemSonglistName.setText(model.getListname());
            holder.itemSonglistCount.setText(model.getPlaycount());
        }
        return convertView;
    }


    class ViewHolder {
        @BindView(R.id.item_songlist_name)
        TextView itemSonglistName;
        @BindView(R.id.item_songlist_count)
        TextView itemSonglistCount;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}