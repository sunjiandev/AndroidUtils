package com.sunkaisens.androidutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:sjy
 * @date:2019-07-26
 * @email:sjy_mail@163.com
 * @Description: 神评论
 */
public class CmtMain {
    private String authorName;
    private String authorIconUri;
    private String content;
    private String likenum;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorIconUri() {
        return authorIconUri;
    }

    public void setAuthorIconUri(String authorIconUri) {
        this.authorIconUri = authorIconUri;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLikenum() {
        return likenum;
    }

    public void setLikenum(String likenum) {
        this.likenum = likenum;
    }

    @Override
    public String toString() {
        return "CmtMain{" +
                "authorName='" + authorName + '\'' +
                ", authorIconUri='" + authorIconUri + '\'' +
                ", content='" + content + '\'' +
                ", likenum='" + likenum + '\'' +
                '}';
    }
    public static void main(String[] args) {
        // 查找的字符串
        String line = "article block untagged mb15 typs_long";
        //正则表达式
        String pattern = "article block untagged mb15(.*?)";
        //Java正则表达式以括号分组，第一个括号表示以"（乙方）:"开头，第三个括号表示以" "(空格)结尾，中间括号为目标值，
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 创建 matcher 对象
        Matcher m = r.matcher(line);
        System.out.println("Found value: " + m.find());
    }
}
