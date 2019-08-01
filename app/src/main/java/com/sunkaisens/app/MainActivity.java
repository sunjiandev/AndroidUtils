package com.sunkaisens.app;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private View content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        content = LayoutInflater.from(this).inflate(R.layout.activity_main, null);

        setContentView(content);


    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                long start = new Date().getTime();
                PdfDocument document = new PdfDocument();
                int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
                int screenHeight = getWindowManager().getDefaultDisplay().getHeight();

                    PdfDocument.PageInfo.Builder pb = new PdfDocument.PageInfo.Builder(screenWidth, screenHeight, 1);
                    PdfDocument.PageInfo pageInfo = pb.create();
                    PdfDocument.Page page = document.startPage(pageInfo);
                    content.draw(page.getCanvas());
                    document.finishPage(page);


                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test1.pdf";
                System.out.println("path = " + path);
                File file = new File(path);
                if (!file.exists())
                {
                    file.getParentFile().mkdirs();
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileOutputStream outputStream;
                try {
                    outputStream = new FileOutputStream(file);
                    document.writeTo(outputStream);
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                document.close();
                long end = new Date().getTime();
                Log.d("sjy","cost time = " + (end - start) / 1000.0f + "s");
            }
        }).start();

    }

}
