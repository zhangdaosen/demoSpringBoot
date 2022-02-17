package com.example.demo.dataSourceModel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "DZSQ_KHD_AJ")//指定表名
public class DzsqKhdAj {
    @TableId(type = IdType.ASSIGN_UUID)
    private String anjuanbh;  //案卷编号
    private String anjuanh;   //案卷号
    private String anjuanmc;  //案卷名称
    private String tianxiems; //填写模式 0:新申请 1:答复补正 2:主动提交 3:快捷事务
    private String anjuanlx;  //案卷类型 0:新申请 2:中间文件
    private String shenqingbh; //申请编号
    private Date chuangjianrq; //创建日期
    private String zhucedm;    //注册代码
    private String anjuanzt;   //案卷状态 0:编辑 1:待发送 2:发送成功 3:发送失败 4:服务器拒收 5:已删除 6:已收到回执
    private Date qianmingrq;   //签名日期
    private String anjuanbbh;  //案卷包编号（ZIP）
    private String anjuanblj;  //案卷包路径（ZIP）
    private String beizhu;     //备注
    private String qianmcn;    //签名CN
    private String neibubh;
    private Date fasongrq;
    private String baoid;

    public String getAnjuanbh() {
        return anjuanbh;
    }

    public void setAnjuanbh(String anjuanbh) {
        this.anjuanbh = anjuanbh;
    }

    public String getAnjuanh() {
        return anjuanh;
    }

    public void setAnjuanh(String anjuanh) {
        this.anjuanh = anjuanh;
    }

    public String getAnjuanmc() {
        return anjuanmc;
    }

    public void setAnjuanmc(String anjuanmc) {
        this.anjuanmc = anjuanmc;
    }

    public String getTianxiems() {
        return tianxiems;
    }

    public void setTianxiems(String tianxiems) {
        this.tianxiems = tianxiems;
    }

    public String getAnjuanlx() {
        return anjuanlx;
    }

    public void setAnjuanlx(String anjuanlx) {
        this.anjuanlx = anjuanlx;
    }

    public String getShenqingbh() {
        return shenqingbh;
    }

    public void setShenqingbh(String shenqingbh) {
        this.shenqingbh = shenqingbh;
    }

    public Date getChuangjianrq() {
        return chuangjianrq;
    }

    public void setChuangjianrq(Date chuangjianrq) {
        this.chuangjianrq = chuangjianrq;
    }

    public String getZhucedm() {
        return zhucedm;
    }

    public void setZhucedm(String zhucedm) {
        this.zhucedm = zhucedm;
    }

    public String getAnjuanzt() {
        return anjuanzt;
    }

    public void setAnjuanzt(String anjuanzt) {
        this.anjuanzt = anjuanzt;
    }

    public Date getQianmingrq() {
        return qianmingrq;
    }

    public void setQianmingrq(Date qianmingrq) {
        this.qianmingrq = qianmingrq;
    }

    public String getAnjuanbbh() {
        return anjuanbbh;
    }

    public void setAnjuanbbh(String anjuanbbh) {
        this.anjuanbbh = anjuanbbh;
    }

    public String getAnjuanblj() {
        return anjuanblj;
    }

    public void setAnjuanblj(String anjuanblj) {
        this.anjuanblj = anjuanblj;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getQianmcn() {
        return qianmcn;
    }

    public void setQianmcn(String qianmcn) {
        this.qianmcn = qianmcn;
    }

    public String getNeibubh() {
        return neibubh;
    }

    public void setNeibubh(String neibubh) {
        this.neibubh = neibubh;
    }

    public Date getFasongrq() {
        return fasongrq;
    }

    public void setFasongrq(Date fasongrq) {
        this.fasongrq = fasongrq;
    }

    public String getBaoid() {
        return baoid;
    }

    public void setBaoid(String baoid) {
        this.baoid = baoid;
    }
}
