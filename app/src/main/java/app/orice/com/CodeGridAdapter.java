package app.orice.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Orice on 2017/3/13.
 */

public class CodeGridAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] data;
    private int selectedId = -1;
    private int clickId = -1;

    public CodeGridAdapter(Context context, @NonNull String[] data){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void setNotifyDataChange(int id) {
        selectedId = id;
        super.notifyDataSetChanged();
    }

    public void setNotifyItemSelected(int id) {
        clickId = id;
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            view = inflater.inflate(R.layout.item_mode_code,null);
            holder = new Holder();
            holder.textView = (TextView) view.findViewById(R.id.item_text);
            holder.frameView = view.findViewById(R.id.item_frame);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.textView.setText(data[i]);
        if(clickId == i){
            holder.frameView.setBackgroundResource(R.drawable.item_bg_focused);
        }else{
            if(selectedId == i){
                holder.frameView.setBackgroundResource(R.drawable.item_bg_focused);
            }else{
                holder.frameView.setBackgroundResource(android.R.color.transparent);
            }
        }
        return view;
    }

    class Holder{
        View frameView;
        TextView textView;
    }
}
