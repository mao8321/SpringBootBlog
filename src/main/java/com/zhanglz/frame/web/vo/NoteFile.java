package com.zhanglz.frame.web.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class NoteFile {
    @JsonProperty("TITLE")
    private String tilte;
    @JsonProperty("TIME")
    private String time;
    @JsonProperty("TEXT")
    private String text;
}
