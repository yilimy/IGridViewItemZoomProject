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

public class LayerGridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] data;

    public LayerGridAdapter(Context context, @NonNull String[] data){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
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
            view = inflater.inflate(R.layout.item_mode_layer,null);
            holder = new Holder();
            holder.textView = (TextView) view.findViewById(R.id.item_text);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.textView.setText(data[i]);
        return view;
    }

    class Holder{
        TextView textView;
    }
}
