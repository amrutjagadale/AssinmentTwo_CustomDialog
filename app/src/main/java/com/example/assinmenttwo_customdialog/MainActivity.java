package com.example.assinmenttwo_customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showDialogButton = findViewById(R.id.show_dialog_button);
        showDialogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showImageSliderDialog();
            }
        });
    }

    private void showImageSliderDialog() {
        ArrayList<Integer> imageIds = new ArrayList<>();
        imageIds.add(R.drawable.image1);
        imageIds.add(R.drawable.download);
        imageIds.add(R.drawable.images);
        imageIds.add(R.drawable.images3);
        imageIds.add(R.drawable.images4);
        imageIds.add(R.drawable.images5);
        imageIds.add(R.drawable.images6);
        imageIds.add(R.drawable.images7);

        int delay = 3000; // 3 seconds
        boolean loop = true;
        String title = "Image Slider";

        ImageSliderDialog dialog = new ImageSliderDialog(this, title, imageIds, delay, loop);
        dialog.show();
    }
}