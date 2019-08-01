package com.sunkaisens.app.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author:sjy
 * @date:2019-07-31
 * @email:sjy_mail@163.com
 * @Description:
 */
public class Observer_One implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        System.out.println("Observer_One arg = " + arg);


    }
}
