package com.example.demo.mysqlPlus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "mobanpz")
public class Mobanpz {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String biaogedm;
    private String biaogemc;
    private String shenqinglx;
    private String wenjianlx;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiaogedm() {
        return biaogedm;
    }

    public void setBiaogedm(String biaogedm) {
        this.biaogedm = biaogedm;
    }

    public String getBiaogemc() {
        return biaogemc;
    }

    public void setBiaogemc(String biaogemc) {
        this.biaogemc = biaogemc;
    }

    public String getShenqinglx() {
        return shenqinglx;
    }

    public void setShenqinglx(String shenqinglx) {
        this.shenqinglx = shenqinglx;
    }

    public String getWenjianlx() {
        return wenjianlx;
    }

    public void setWenjianlx(String wenjianlx) {
        this.wenjianlx = wenjianlx;
    }
}
