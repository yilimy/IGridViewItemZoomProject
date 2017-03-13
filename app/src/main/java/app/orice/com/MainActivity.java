package app.orice.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void modeLayerListAction(View view){
        startActivity(new Intent(this,LayerGridViewActivity.class));
    }

    public void modeCodeAchieveAction(View view){
        startActivity(new Intent(this,CodeGridViewActivity.class));
    }

}
