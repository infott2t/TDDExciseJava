package main;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeStamp0 {
    
    private static Long lastId = 0L; //정적변수로 마지막 id추적.

    private Long id;
    private Long whoId;
    private String todo;  //LOGIN, LOGOUT, REST, Something do. ... .
    private Date stampDate;
    private String formatDate;      // 2024년 2월 12일 형식
    private String formatDateTime;  // 2024-02-12 13:00 형식.
    private String formatDateTime2; // 2024-02-12 13:00:00 형식.

    TimeStamp0(Long whoId, String todo){
        this.id = ++lastId;
        this.whoId = whoId;
        this.todo = todo;

        this.stampDate = new Date();
        SimpleDateFormat sdf01 = new SimpleDateFormat("yyyy년 M월 d일");
        SimpleDateFormat sdf02 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf03 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        this.formatDate = sdf01.format(this.stampDate);
        this.formatDateTime = sdf02.format(this.stampDate);
        this.formatDateTime2 = sdf03.format(this.stampDate);
    }

    public String getFormatDateTime2() {
        return formatDateTime2;
    }

    public Long getWhoId() {
        return whoId;
    }

    public String getTodo() {
        return todo;
    }
}
