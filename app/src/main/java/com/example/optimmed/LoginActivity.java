package com.example.optimmed;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.NoSuchElementException;

public class LoginActivity extends AppCompatActivity {
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.login_activity);

        queue = Volley.newRequestQueue(this);

//----------------------------------Scaled the Logo App---------------------------------------
        //find my ImageView
        ImageView view = (ImageView)findViewById(R.id.imageView4) ;

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


    }

    private int dpToPx(int dp) {
        float density = getApplicationContext().getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }

    public void forgotPwd(View view) {
        Intent intent = new Intent(this, ForgotPwdActivity.class);
        startActivity(intent);
    }

    public void mainActivity(View view) throws IOException {
        String urlPacient = "http://18.223.115.1:8080/optimed/pacienti/login/" + ((EditText) findViewById(R.id.textView)).getText().toString().trim() + "/" + ((EditText) findViewById(R.id.textView3)).getText().toString().trim();
        String urlMedic = "http://18.223.115.1:8080/optimed/medici/login/" + ((EditText) findViewById(R.id.textView)).getText().toString().trim() + "/" + ((EditText) findViewById(R.id.textView3)).getText().toString().trim();
        final String[] nume = new String[1];
        final String[] pass = new String[1];
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlPacient, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    nume[0] = response.getString("utilizator");
                    pass[0] = response.getString("parola");

                   // System.out.println(nume + " " + pass);

                    if (!nume[0].trim().equals(((EditText)findViewById(R.id.textView)).getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Numele de utilizator este incorect!", Toast.LENGTH_SHORT).show();
                    } else if (!pass[0].trim().equals(((EditText)findViewById(R.id.textView3)).getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Parola este incorecta!", Toast.LENGTH_SHORT).show();
                    } else if (nume[0].trim().equals(((EditText)findViewById(R.id.textView)).getText().toString()) && pass[0].trim().equals(((EditText)findViewById(R.id.textView3)).getText().toString())) {
                        Intent intent = new Intent(getApplicationContext(), PacientActivity.class);
                        startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


       queue.add(request);

        request = new JsonObjectRequest(Request.Method.GET, urlMedic, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    nume[0] = response.getString("utilizator");
                    pass[0] = response.getString("parola");

                    // System.out.println(nume + " " + pass);
                    if (!nume[0].trim().equals(((EditText)findViewById(R.id.textView)).getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Numele de utilizator este incorect!", Toast.LENGTH_SHORT).show();
                    } else if (!pass[0].trim().equals(((EditText)findViewById(R.id.textView3)).getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Parola este incorecta!", Toast.LENGTH_SHORT).show();
                    } else if (nume[0].trim().equals(((EditText)findViewById(R.id.textView)).getText().toString().trim()) && pass[0].trim().equals(((EditText)findViewById(R.id.textView3)).getText().toString().trim())) {
                        Intent intent = new Intent(getApplicationContext(), MedicActivity.class);
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
