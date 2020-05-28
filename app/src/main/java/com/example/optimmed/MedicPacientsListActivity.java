package com.example.optimmed;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MedicPacientsListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medic_activity_leftpacientsbutton);
        for(int i=1;i<=4;i++)
        {
            Button btn=new Button(this);
            btn.setId(i);
            btn.setText("Pacient %d"+i);
            @SuppressLint("WrongViewCast") LinearLayout ll = (LinearLayout)findViewById(R.id.button6);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(btn, lp);
        }
    }
}
