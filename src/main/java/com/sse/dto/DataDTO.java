package com.sse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DataDTO {
    private String topic;
    private Date date;
}
