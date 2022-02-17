package com.example.demo.mysqlPlus.dao.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.xml.model.XmlLabel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface XmlLabelDao extends BaseMapper<XmlLabel> {

    List<XmlLabel> queryByParentId(@Param("parentId")Integer parentId);

    XmlLabel queryByXmlType(@Param("xmlType")String xmlType);

    List<Map<String,Object>> queryDate();
}
