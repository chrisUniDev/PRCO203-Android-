package com.example.bbahealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ZoomTwoActivity extends AppCompatActivity {

    ImageButton closeButton;
    ImageView imageView;
    private ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_two);

        setTitle("Beacon Center Map");

        closeButton = (ImageButton) findViewById(R.id.imageButtonCloseZoomTwo);
        imageView = (ImageView) findViewById(R.id.imageTestTwo);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

                //Toast.makeText(getApplicationContext(), "Closing", Toast.LENGTH_LONG).show();
            }
        });


        scaleGestureDetector = new ScaleGestureDetector(this, new MySimpleOnScaleGestureListener(imageView));
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
        //return super.onTouchEvent(event);
    }

    private class MySimpleOnScaleGestureListener
            extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        ImageView viewMyImage;

        float factor;

        public MySimpleOnScaleGestureListener(ImageView iv) {
            super();
            viewMyImage = iv;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            factor = 1.0f;
            return true;
            //return super.onScaleBegin(detector);
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            float scaleFactor = detector.getScaleFactor() - 1;
            factor += scaleFactor;
            viewMyImage.setScaleX(factor);
            viewMyImage.setScaleY(factor);
            return true;
            //return super.onScale(detector);
        }
    }
}
