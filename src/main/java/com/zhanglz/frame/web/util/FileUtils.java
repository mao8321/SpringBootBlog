package com.zhanglz.frame.web.util;

import com.zhanglz.frame.web.vo.NoteFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@Slf4j
public class FileUtils {
    public static String getPath() {
        String path = null;
        try {
            path = ResourceUtils.getURL("classpath:").getPath();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return path;
    }

    public static String getFileText(File file) {
        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        try {

            is = new FileInputStream(file);
            int index = 0;
            while (-1 != (index = is.read())) {
                sb.append((char) index);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return sb.toString();
    }

    public static void createHtml(NoteFile note) throws Exception{
        File file = new File(getPath()+"static/noteframe/note_01.html");
        File files = new File(getPath() + "templates/"+note.getTilte()+".html");
        log.info(getPath());
        if(!files.exists()){
            files.createNewFile();
        }
        String text = FileUtils.getFileText(file);
        text = text.replace("@@title@@",note.getTilte());
        text = text.replace("@@time@@",note.getTime());
        text = text.replace("@@text@@",note.getText());
        FileOutputStream fos = new FileOutputStream(files);
        fos.write(text.getBytes());
        fos.close();
    }
}
