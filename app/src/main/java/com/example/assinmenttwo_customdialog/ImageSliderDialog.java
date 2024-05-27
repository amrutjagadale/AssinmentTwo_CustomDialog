package com.example.assinmenttwo_customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import java.util.ArrayList;
//import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ImageSliderDialog extends Dialog {
    private Context context;
    private ArrayList<Integer> imageIds;
    private int delay;
    private boolean loop;
    private String title;
    private ImageView imageView;
    private TextView titleView, imageIndexView;
    private ImageView closeIcon;
    private int currentIndex = 0;
    private Handler handler;
    private Runnable runnable;

    public ImageSliderDialog(Context context, String title, ArrayList<Integer> imageIds, int delay, boolean loop) {
        super(context);
        this.context = context;
        this.title = title;
        this.imageIds = imageIds;
        this.delay = delay;
        this.loop = loop;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_image_slider);

        titleView = findViewById(R.id.dialog_title);
        closeIcon = findViewById(R.id.close_icon);
        imageView = findViewById(R.id.image_view);
        imageIndexView = findViewById(R.id.image_index);

        titleView.setText(title);
        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (currentIndex >= imageIds.size()) {
                    if (loop) {
                        currentIndex = 0;
                    } else {
                        dismiss();
                        return;
                    }
                }
                imageView.setImageResource(imageIds.get(currentIndex));
                imageIndexView.setText("Image " + (currentIndex + 1) + " of " + imageIds.size());
                currentIndex++;
                handler.postDelayed(this, delay);
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.post(runnable);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }
}