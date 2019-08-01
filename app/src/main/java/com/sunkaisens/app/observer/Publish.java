package com.sunkaisens.app.observer;

import java.util.Observable;

/**
 * @author:sjy
 * @date:2019-07-31
 * @email:sjy_mail@163.com
 * @Description:
 */
public class Publish extends Observable {

    public void publish(Object data){

        setChanged();
        notifyObservers(data);
    }
}
