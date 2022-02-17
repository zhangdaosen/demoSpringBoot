package com.example.demo.dataSourceModel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "DZSQ_KHD_MOBANPZ")
public class DzsqKhdMobanpz {
    @TableId(type = IdType.AUTO)
    private String mobanbh;
    private String biaogedm;
    private String biaogemc;
    private String cunchulj;
    private String dtd;
    private String schema;
    private String shenqinglx;
    private String wenjianlx;
    private String banben;
    private String shifouzx;


    public String getMobanbh() {
        return mobanbh;
    }

    public void setMobanbh(String mobanbh) {
        this.mobanbh = mobanbh;
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

    public String getCunchulj() {
        return cunchulj;
    }

    public void setCunchulj(String cunchulj) {
        this.cunchulj = cunchulj;
    }

    public String getDtd() {
        return dtd;
    }

    public void setDtd(String dtd) {
        this.dtd = dtd;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
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

    public String getBanben() {
        return banben;
    }

    public void setBanben(String banben) {
        this.banben = banben;
    }

    public String getShifouzx() {
        return shifouzx;
    }

    public void setShifouzx(String shifouzx) {
        this.shifouzx = shifouzx;
    }
}
