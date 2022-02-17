package com.example.demo.xml.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "xml_label")
public class XmlLabel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer parentId;
    private String levelStr;
    private String labelName;
    private String valueProperty;
    private String xmlType;
    private String memo;
    @TableField(exist = false)
    private List<XmlLabel> xmlLabelList;

    public List<XmlLabel> getXmlLabelList() {
        return xmlLabelList;
    }

    public void setXmlLabelList(List<XmlLabel> xmlLabelList) {
        this.xmlLabelList = xmlLabelList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLevelStr() {
        return levelStr;
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getValueProperty() {
        return valueProperty;
    }

    public void setValueProperty(String valueProperty) {
        this.valueProperty = valueProperty;
    }

    public String getXmlType() {
        return xmlType;
    }

    public void setXmlType(String xmlType) {
        this.xmlType = xmlType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
