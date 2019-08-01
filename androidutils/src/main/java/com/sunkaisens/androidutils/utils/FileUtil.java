package com.sunkaisens.androidutils.utils;

import android.os.Environment;

import com.sunkaisens.androidutils.SunApp;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * @author:sjy
 * @date:2019-07-22
 * @email:sjy_mail@163.com
 * @Description:
 */
public class FileUtil {
    
    private static volatile FileUtil mInstance;

    private FileUtil() {
    }

    public static FileUtil getInstance() {
        if (mInstance == null) {
            synchronized (FileUtil.class) {
                if (mInstance == null) {
                    mInstance = new FileUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 判断sd 卡是否存在
     *
     * @return true or false
     */
    public boolean sdcardExist() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 判断文件或者目录是否存在
     *
     * @param dir 文件或者目录的路径
     * @return 结果
     */
    public boolean dirExist(String dir) {
        if (StringUtils.isEmpty(dir)) {
            throw new RuntimeException("传入的字符串不可为空");
        }
        File file = new File(dir);
        return file.exists();
    }

    /**
     * 获取程序的缓存路径
     *
     * @return 路径
     */
    public String getCache() {
        return SunApp.getInstance().getContext().getCacheDir().getPath();
    }

    /**
     * 将文本写入文件
     *
     * @param content 内容
     * @param file    路径
     */
    public void writeStr2File(String content, File file) {
        FileOutputStream fos = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(null, fos);
        }
    }

    /**
     * 把流写入文件
     *
     * @param inputStream 流
     * @param file        文件
     */
    public void writeStrean2File(InputStream inputStream, File file) {

        FileOutputStream fos = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            inputStream.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(inputStream, fos);
        }

    }

    /**
     * 从文件中读取内容
     *
     * @param file 文件路径
     * @return 返回的字符串
     */
    public String readStrFromFile(File file) {
        StringBuilder result = new StringBuilder();
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = new FileInputStream(file);
            // 用来保存每行读取的内容
            String line;
            reader = new BufferedReader(new InputStreamReader(is));
            // 读取第一行
            line = reader.readLine();
            // 如果 line 为空说明读完了
            while (line != null) {
                // 将读到的内容添加到 buffer 中
                result.append(line);
                // 读取下一行
                line = reader.readLine();
            }
            reader.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(is, null);
            close(reader, null);
        }

        return result.toString();
    }

    /**
     * 删除文件及目录
     *
     * @param folder 目录
     */
    public void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }


    private void close(InputStream in, OutputStream out) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void close(Reader reader, Writer writer) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
