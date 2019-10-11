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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class WebService {
    public void initFile(String fileName){
        NoteFile noteFile = initNote(fileName);
        try{
            FileUtils.createHtml(noteFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public NoteFile initNote(String fileName){
        File file = new File(FileUtils.getPath()+"static/text/"+fileName);
        NoteFile noteFile = new NoteFile();
        String text = FileUtils.getFileText(file);
        noteFile.setText(text);
        noteFile.setTilte(file.getName());
        noteFile.setTime(DateUtils.longTimeToDate(file.lastModified()));
        return noteFile;
    }

    public List<String> getFileList(){
        File files = new File(FileUtils.getPath()+"static/text/");
        List<String> nameList  = new ArrayList<String>();
        if(files.isDirectory()){
            for(File file : files.listFiles()){
                nameList.add(file.getName());
            }
        }
        return nameList;
    }
}
