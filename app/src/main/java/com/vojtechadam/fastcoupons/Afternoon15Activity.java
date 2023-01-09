package com.vojtechadam.fastcoupons;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Afternoon15Activity extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("");

        setContentView(R.layout.afternoon_15);

        TextView textView6 = findViewById(R.id.textView6);
        TextView timer = findViewById(R.id.timerText);
        Button main = findViewById(R.id.button);
        TextView code = findViewById(R.id.code);
        code.setVisibility(View.GONE);
        ImageView qrcode = findViewById(R.id.qrcode);
        View blurImage = findViewById(R.id.blurImage);
        blurImage.setVisibility(View.GONE);
        TextView date = findViewById(R.id.date);

        Date nowDate = Calendar.getInstance().getTime();
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DAY_OF_WEEK, +(day.get(Calendar.DAY_OF_WEEK) + 2));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM", Locale.getDefault());
        String monthYear = df.format(nowDate);
        date.setText("Vyprší " + monthYear + "-" + day.get(Calendar.DATE));

        findViewById(R.id.button).setOnClickListener(view1 -> {
            // create an instance of the snackbar
            final Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "", Snackbar.LENGTH_INDEFINITE);

            // inflate the custom_snackbar_view created previously
            View customSnackView = getLayoutInflater().inflate(R.layout.snackbar_timer, null);

            // set the background of the default snackbar as transparent
            snackbar.getView().setBackgroundColor(Color.TRANSPARENT);

            // now change the layout of the snackbar
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();

            // set padding of the all corners as 0
            snackbarLayout.setPadding(0, 0, 0, 0);

            Button activate = customSnackView.findViewById(R.id.activate);
            Button dismiss = customSnackView.findViewById(R.id.dismiss);

            activate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Remove drawable on right and change on left
                    textView6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_timer_24_black, 0, 0, 0);
                    // Change text
                    textView6.setText("Využij během");
                    // Show timer text
                    timer.setVisibility(View.VISIBLE);
                    // Hide Button
                    main.setVisibility(View.GONE);
                    // Show code
                    code.setVisibility(View.VISIBLE);
                    // Blur Image
                    blurImage.setVisibility(View.VISIBLE);
                    // Create timer 900000
                    new CountDownTimer(900000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            String timeLeft = String.format("%02d:%02d", (millisUntilFinished / 1000) / 60, (millisUntilFinished / 1000) % 60);
                            timer.setText(timeLeft);
                        }

                        public void onFinish() {
                            textView6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_repeat, 0, R.drawable.ic_baseline_check_circle_24, 0);
                            textView6.setText("Opakující se nabídka");
                            timer.setVisibility(View.GONE);
                            main.setVisibility(View.VISIBLE);
                            code.setVisibility(View.GONE);
                            qrcode.setVisibility(View.GONE);
                            blurImage.setVisibility(View.GONE);
                        }
                    }.start();

                    // Create code
                    Random r = new Random();

                    int min = 0;
                    int max = 9;

                    int num2 = r.nextInt(max - min + 1) + min;
                    int num3 = r.nextInt(max - min + 1) + min;
                    int num1 = r.nextInt(max - min + 1) + min;
                    int num5 = r.nextInt(max - min + 1) + min;
                    int num6 = r.nextInt(max - min + 1) + min;
                    int num4 = r.nextInt(max - min + 1) + min;
                    String codeForQr = ("M " + num1 + num2 + num3 + " " + num4 + num5 + num6);
                    code.setText("" + codeForQr);

                    // Create QR code
                    MultiFormatWriter writer = new MultiFormatWriter();

                    try {
                        BitMatrix matrix = writer.encode(codeForQr, BarcodeFormat.QR_CODE
                                , 550, 550);
                        BarcodeEncoder encoder = new BarcodeEncoder();
                        Bitmap bitmap = encoder.createBitmap(matrix);
                        qrcode.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                    // Hide snackbar
                    snackbar.dismiss();
                }
            });

            dismiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });

            // add the custom snack bar layout to snackbar layout
            snackbarLayout.addView(customSnackView, 0);

            snackbar.show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}