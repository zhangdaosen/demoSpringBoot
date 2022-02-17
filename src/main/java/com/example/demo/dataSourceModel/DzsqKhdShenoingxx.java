package com.example.demo.dataSourceModel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "DZSQ_KHD_SHENQINGXX")//指定表名
public class DzsqKhdShenoingxx {
    @TableId(type = IdType.ASSIGN_UUID)
    private String shenqingbh; //申请编号
    private String shenqinglx; //申请类型  0:普通申请--发明 1:普通申请--新型 2:普通申请--外观 3:PCT申请--发明 4:PCT申请--新型 5:复审 6:无效
    private String zhuanlimc; //专利名称
    private String shenqingh; //申请号
    private String zhuanlih;  //专利号
    private String weineibh;  //委内编号
    private String guojisqh;  //国际申请号
    private Date shenqingr;   //申请日
    private Date chuangjianrq; //创建日期
    private String zhuangtai; //状态 0:新申请 1:受理不通过 2:受理通过 3:审查中
    private String beizhu;   //备注

    public String getShenqingbh() {
        return shenqingbh;
    }

    public void setShenqingbh(String shenqingbh) {
        this.shenqingbh = shenqingbh;
    }

    public String getShenqinglx() {
        return shenqinglx;
    }

    public void setShenqinglx(String shenqinglx) {
        this.shenqinglx = shenqinglx;
    }

    public String getZhuanlimc() {
        return zhuanlimc;
    }

    public void setZhuanlimc(String zhuanlimc) {
        this.zhuanlimc = zhuanlimc;
    }

    public String getShenqingh() {
        return shenqingh;
    }

    public void setShenqingh(String shenqingh) {
        this.shenqingh = shenqingh;
    }

    public String getZhuanlih() {
        return zhuanlih;
    }

    public void setZhuanlih(String zhuanlih) {
        this.zhuanlih = zhuanlih;
    }

    public String getWeineibh() {
        return weineibh;
    }

    public void setWeineibh(String weineibh) {
        this.weineibh = weineibh;
    }

    public String getGuojisqh() {
        return guojisqh;
    }

    public void setGuojisqh(String guojisqh) {
        this.guojisqh = guojisqh;
    }

    public Date getShenqingr() {
        return shenqingr;
    }

    public void setShenqingr(Date shenqingr) {
        this.shenqingr = shenqingr;
    }

    public Date getChuangjianrq() {
        return chuangjianrq;
    }

    public void setChuangjianrq(Date chuangjianrq) {
        this.chuangjianrq = chuangjianrq;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
}
