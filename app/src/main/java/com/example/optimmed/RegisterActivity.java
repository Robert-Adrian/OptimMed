package com.example.optimmed;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegisterActivity extends AppCompatActivity {
    RequestQueue queue;
    int medicOrpacient = 0;
    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.register_activity);
        queue = Volley.newRequestQueue(this);
        //----------------------------------Scaled the Logo App---------------------------------------
        //find my ImageView
        ImageView view = (ImageView)findViewById(R.id.imageView) ;

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

        //------------------------------------------------------------------------------------------------





        Switch switchBtn = findViewById(R.id.switch1);
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView codMedic = (TextView)findViewById(R.id.textView7);
                if (((Switch)v).isChecked()) {
                    codMedic.setVisibility(View.INVISIBLE);
                    //medicOrpacient = 2;
                } else {
                    codMedic.setVisibility(View.VISIBLE);
                   // medicOrpacient = 1;
                }
            }
        });
    }

    private int dpToPx(int dp) {
        float density = getApplicationContext().getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }

    public void loginActivity(View view) throws JSONException, InterruptedException {
        final List<String> listaEmail = new ArrayList<>();
        listaEmail.add("@gmail.com");
        listaEmail.add("@yahoo.com");
        String password = ((EditText)findViewById(R.id.editText3)).getText().toString().trim();
        final String email = ((EditText)findViewById(R.id.editText4)).getText().toString().trim();
        final int[] emailCorrect = {0};


        Switch switchBtn = findViewById(R.id.switch1);
        if (!switchBtn.isChecked()) {
            final int codMedic = Integer.parseInt(((EditText)findViewById(R.id.textView7)).getText().toString());
            final boolean[] codValid = {false};
            final String username = ((EditText)findViewById(R.id.editText2)).getText().toString().trim();


            String urlPacient = "http://18.223.115.1:8080/optimed/pacienti/addPacient";

            final JSONObject object = new JSONObject();
            object.put("idMedic", String.valueOf(codMedic));
            object.put("utilizator", username);
            object.put("parola", password);
            object.put("email", email);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, urlPacient, object, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);

            request = new JsonObjectRequest(Request.Method.GET, "http://18.223.115.1:8080/optimed/pacienti/findByUserName/" + username, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (response.getString("utilizator").equals(username)) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);

        } else {
            final String username = ((EditText)findViewById(R.id.editText2)).getText().toString().trim();


            String urlMedic = "http://18.223.115.1:8080/optimed/medici/addMedic";

            final JSONObject object = new JSONObject();
            object.put("utilizator", username);
            object.put("parola", password);
            object.put("email", email);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, urlMedic, object, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);

            request = new JsonObjectRequest(Request.Method.GET, "http://18.223.115.1:8080/optimed/medici/findByUserName/" + username, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (response.getString("utilizator").equals(username)) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);
        }
    }
}
