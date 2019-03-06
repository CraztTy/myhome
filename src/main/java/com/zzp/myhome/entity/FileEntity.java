package com.zzp.myhome.entity;

import java.util.Date;

/**
 * @author :  ZHANGZP
 * @Description :
 * @Creation Date:  2019/3/5
 */
public class FileEntity {

    private Integer id;
    private String fileName;
    private String filePath;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
