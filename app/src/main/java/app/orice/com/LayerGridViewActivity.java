package app.orice.com;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by Orice on 2017/3/13.
 */

public class LayerGridViewActivity extends Activity
        implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {

    private String[] data = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",};
    private GridView gridView;
    private LayerGridAdapter adapter;
    private View mPreView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        initGridView();
    }

    private void initGridView() {
        adapter = new LayerGridAdapter(this, data);
        gridView.setAdapter(adapter);
        gridView.setOnFocusChangeListener(this);
        gridView.setOnItemSelectedListener(this);
    }

    @Override
    public void onContentChanged() {
        gridView = (GridView) findViewById(R.id.gridview);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (hasFocus) {
            View v = gridView.getSelectedView();
            if (v != null) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enlarge_10);
                v.startAnimation(animation);
                mPreView = v;
            } else {
                if (mPreView != null) {
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink_10);
                    mPreView.startAnimation(animation);
                    mPreView = null;
                }

            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.hasFocus()){
            if(mPreView!=null){
                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink_10);
                mPreView.startAnimation(animation);
            }
            Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enlarge_10);
            view.startAnimation(animation);
            mPreView=view;
        }else{
            if(mPreView!=null){
                Animation   animation=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink_10);
                mPreView.startAnimation(animation);
                mPreView=null;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        if(mPreView!=null){
            Animation   animation=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink_10);
            mPreView.startAnimation(animation);
            mPreView=null;
        }
    }
}
