package com.sunkaisens.app;

import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.view.View;

import com.sunkaisens.app.observer.Observer_One;
import com.sunkaisens.app.observer.Publish;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:sjy
 * @date:2019-07-31
 * @email:sjy_mail@163.com
 * @Description:
 */
public class Test {
    public static void main(String[] args) {


        Publish publish = new Publish();

        publish.addObserver(new Observer_One());

        System.out.println("start time = " +new  SimpleDateFormat().format(new Date(System.currentTimeMillis())));

        for (int i = 0; i < 10000000; i++) {
            publish.publish(i);
        }
        System.out.println("end time = " +new  SimpleDateFormat().format(new Date(System.currentTimeMillis())));


    }
}
