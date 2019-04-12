package com.example.t31_profile_page_design_xml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button mFollow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mIcon = (ImageView) findViewById(R.id.imageView);
         mFollow =(Button) findViewById(R.id.btnFollow);

        //Next you need to use RoundedBitmapDrawable to change the shape of the image to circle,
        // this method takes a Bitmap and makes it circle. You might be wondering how you can get
        // a Bitmap from an ImageView? And the answer is you use one of the Bitmap methods called BitmapFactory.
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.profile);

        //Once you get the Bitmap, you can then use RoundedBitmapDrawable.
        RoundedBitmapDrawable mDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        mDrawable.setCircular(true);

        //You can change the background color of the image using Android setColorFilter.
        mDrawable.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorAccent), PorterDuff.Mode.DST_OVER);


        //Lastly you can set the image with the circle shape to the ImageView.
        mIcon.setImageDrawable(mDrawable);

        //when you tap on the Button, the text will change from (Follow me) to (Following) and vice versa.
        //use Android Button setOnClickListener and inside the onClick you check whether you’ve
        // previously tapped or not on the Button.
        mFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFollow.getText().toString().equalsIgnoreCase("Follow me")) {
                    mFollow.setText("Following");
                } else {
                    mFollow.setText("Follow me");
                }
            }
        });

    }
}
