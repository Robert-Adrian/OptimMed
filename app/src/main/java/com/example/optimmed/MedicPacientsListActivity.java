package com.example.optimmed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.NoSuchElementException;

public class MedicPacientsListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medic_activity_leftpacientsbutton);

       FloatingActionButton floatingActionButton=findViewById(R.id.floatingActionButton5);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
               /* Toast.makeText(MedicPacientsListActivity.this, "Searchbox here!", Toast.LENGTH_SHORT).show();*/
              /*  EditText editText=findViewById(R.id.editText7);
                editText.setVisibility(View.VISIBLE);*/
                Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar3);
                toolbar.setVisibility(View.VISIBLE);
            }
        });

        // Find the ScrollView
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView2);

        // Create a LinearLayout element
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Add Buttons
        Button button = new Button(scrollView.getContext());
        button.setText("Pacient 1\\n Pacientul 1 este intr-o stare buna de sanatate \\n Click pe pacient pentru un raport complet");
        linearLayout.addView(button);
        scrollView.addView(button);
        /*for(int i=1;i<=4;i++)
        {
            Button btn=new Button(this);
            btn.setId(i);
            btn.setText("Pacient %d"+i);
            @SuppressLint("WrongViewCast") LinearLayout ll = (LinearLayout)findViewById(R.id.button6);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(btn, lp);
        }*/
        //----------------------------------Scaled the Logo App---------------------------------------
        //find my ImageView
        ImageView view=(ImageView)findViewById(R.id.imageView8) ;

        Bitmap bitmap = null;

        try {
            //get ImageView and my image properties
            Drawable drawing = view.getDrawable();
            bitmap = ((BitmapDrawable) drawing).getBitmap();
        } catch (NullPointerException e) {
            throw new NoSuchElementException("No drawable on given view");
        } catch (ClassCastException e) {
            e.printStackTrace();

        }

        // Get current dimensions AND the desired bounding box
        int width = 0;

        try {
            width = bitmap.getWidth();
        } catch (NullPointerException e) {
            throw new NoSuchElementException("Can't find bitmap on given view/drawable");
        }

        int height = bitmap.getHeight();
        int bounding = dpToPx(320);

        // Determine how much to scale: the dimension requiring less scaling is
        // closer to the its side. This way the image always stays inside your
        // bounding box AND either x/y axis touches it.
        float xScale = ((float) bounding) / width;
        float yScale = ((float) bounding) / height;
        float scale = (xScale <= yScale) ? xScale : yScale;

        // Create a matrix for the scaling and add the scaling data
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        // Create a new bitmap and convert it to a format understood by the ImageView
        Bitmap scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        width = scaledBitmap.getWidth(); // re-use
        height = scaledBitmap.getHeight(); // re-use
        BitmapDrawable result = new BitmapDrawable(scaledBitmap);


        // Apply the scaled bitmap and result my image scaled
        view.setImageDrawable(result);

        // Now change ImageView's dimensions to match the scaled image
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }
    private int dpToPx(int dp) {
        float density = getApplicationContext().getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }

}
