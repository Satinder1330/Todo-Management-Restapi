package com.learning.todo.Todo_Manager.helper;

import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
@Component
public class Helper {

    //  convert DateObject to Date
    public Date parseDate(Object dateObject){
        SimpleDateFormat format = new SimpleDateFormat();
        LocalDateTime ldt = (LocalDateTime) dateObject;
        LocalDate onlyDate = ldt.toLocalDate();
        return Date.from(onlyDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

    }
    //print array of ids
    public String printArray(int[]ids){
        StringBuilder sb = new StringBuilder();
        for (int id : ids) {
           sb.append(id);
           sb.append(",");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
