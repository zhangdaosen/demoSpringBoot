package com.example.demo.dataSourceModel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "DZSQ_KHD_GJXZQH")//指定表名
public class DzsqKhdGjxzqh {
    @TableId(type = IdType.AUTO)
    private String gjxzqhId;
    private String gjxzqhdm;
    private String gjxzqhmc;
    private String gjxzqhsj;
    private String gjxzqhyzbm;
    private String zhuantai;

    public String getGjxzqhId() {
        return gjxzqhId;
    }

    public void setGjxzqhId(String gjxzqhId) {
        this.gjxzqhId = gjxzqhId;
    }

    public String getGjxzqhdm() {
        return gjxzqhdm;
    }

    public void setGjxzqhdm(String gjxzqhdm) {
        this.gjxzqhdm = gjxzqhdm;
    }

    public String getGjxzqhmc() {
        return gjxzqhmc;
    }

    public void setGjxzqhmc(String gjxzqhmc) {
        this.gjxzqhmc = gjxzqhmc;
    }

    public String getGjxzqhsj() {
        return gjxzqhsj;
    }

    public void setGjxzqhsj(String gjxzqhsj) {
        this.gjxzqhsj = gjxzqhsj;
    }

    public String getGjxzqhyzbm() {
        return gjxzqhyzbm;
    }

    public void setGjxzqhyzbm(String gjxzqhyzbm) {
        this.gjxzqhyzbm = gjxzqhyzbm;
    }

    public String getZhuantai() {
        return zhuantai;
    }

    public void setZhuantai(String zhuantai) {
        this.zhuantai = zhuantai;
    }
}
