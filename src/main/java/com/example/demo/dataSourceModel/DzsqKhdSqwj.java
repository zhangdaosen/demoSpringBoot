package com.example.demo.dataSourceModel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "DZSQ_KHD_SQWJ")//指定表名
public class DzsqKhdSqwj {
    @TableId(type = IdType.AUTO)
    private String wenjianbh;   //文件编号
    private String wenjianmc;   //文件名称
    private String biaogedm;    //表格代码
    private String wenjianlx;   //文件类型 0:新申请 1:附加文件 2;中间文件(除附加文件外) 3:修改译文 4:修改文本
    private String anjuanbh;    //案卷编号
    private String chuangjianlx; //创建类型 0:新建 1:导入
    private Date chuangjianrq;   //创建日期
    private String cunchulj;     //存储路径
    private String wenjianzt;    //文件状态 0:未编辑 1:已编辑
    private String counts;       //页数或项数（权利要求书：项数 其他：页数）
    private String beizhu;       //备注
    private String pages;
    private String zhengmingyt;
    private String zhengminglx;

    public String getWenjianbh() {
        return wenjianbh;
    }

    public void setWenjianbh(String wenjianbh) {
        this.wenjianbh = wenjianbh;
    }

    public String getWenjianmc() {
        return wenjianmc;
    }

    public void setWenjianmc(String wenjianmc) {
        this.wenjianmc = wenjianmc;
    }

    public String getBiaogedm() {
        return biaogedm;
    }

    public void setBiaogedm(String biaogedm) {
        this.biaogedm = biaogedm;
    }

    public String getWenjianlx() {
        return wenjianlx;
    }

    public void setWenjianlx(String wenjianlx) {
        this.wenjianlx = wenjianlx;
    }

    public String getAnjuanbh() {
        return anjuanbh;
    }

    public void setAnjuanbh(String anjuanbh) {
        this.anjuanbh = anjuanbh;
    }

    public String getChuangjianlx() {
        return chuangjianlx;
    }

    public void setChuangjianlx(String chuangjianlx) {
        this.chuangjianlx = chuangjianlx;
    }

    public Date getChuangjianrq() {
        return chuangjianrq;
    }

    public void setChuangjianrq(Date chuangjianrq) {
        this.chuangjianrq = chuangjianrq;
    }

    public String getCunchulj() {
        return cunchulj;
    }

    public void setCunchulj(String cunchulj) {
        this.cunchulj = cunchulj;
    }

    public String getWenjianzt() {
        return wenjianzt;
    }

    public void setWenjianzt(String wenjianzt) {
        this.wenjianzt = wenjianzt;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getZhengmingyt() {
        return zhengmingyt;
    }

    public void setZhengmingyt(String zhengmingyt) {
        this.zhengmingyt = zhengmingyt;
    }

    public String getZhengminglx() {
        return zhengminglx;
    }

    public void setZhengminglx(String zhengminglx) {
        this.zhengminglx = zhengminglx;
    }
}
