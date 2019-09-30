package com.zhanglz.frame.web.service;

import com.zhanglz.frame.web.util.DateUtils;
import com.zhanglz.frame.web.util.FileUtils;
import com.zhanglz.frame.web.vo.NoteFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Date;

@Slf4j
@Service
public class WebService {
    public void initFile(){
        File file  = new File(FileUtils.getPath()+"static/noteframe/note_01.html");
        File files  = new File(FileUtils.getPath()+"static/text/hello.txt");
        NoteFile noteFile = new NoteFile();
        String text = FileUtils.getFileText(file);
        text = text.replace("@@title@@","笔记");
        text = text.replace("@@time@@","2019-9-30 17:45");
        text = text.replace("@@text@@","哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        if(file.exists()){
            noteFile.setText(text);
            noteFile.setTilte(file.getName());
            noteFile.setTime(DateUtils.longTimeToDate(file.lastModified()));
        }
        try{
            FileUtils.createHtml(noteFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
