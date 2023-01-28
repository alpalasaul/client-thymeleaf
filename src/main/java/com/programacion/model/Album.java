package com.programacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    private Integer id;
    private Singer singer;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date release_date;

}
