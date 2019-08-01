package com.sunkaisens.app;

import android.content.Context;

/**
 * @author:sjy
 * @date:2019-07-31
 * @email:sjy_mail@163.com
 * @Description:
 */
public class Person {

    private String name;

    private int age;

    public static class Builder {
        private Context context;
        private String name;
        private int age;

        public Builder(Context context) {

            this.context = context;
        }

        public Builder setName(String name) {

            this.name = name;
            return this;
        }

        public Builder setAge(int age) {

            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

}
