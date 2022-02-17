package com.example.demo;

import com.example.demo.dataSourceModel.DzsqKhdGjxzqh;
import com.example.demo.dataSourceModel.DzsqKhdMobanpz;
import com.example.demo.mysqlPlus.dao.master.CpcCityDao;
import com.example.demo.mysqlPlus.dao.master.MobanpzDao;
import com.example.demo.mysqlPlus.dao.master.UserDao;
import com.example.demo.mysqlPlus.dao.slave.DzsqKhdGjxzqhDao;
import com.example.demo.mysqlPlus.dao.slave.DzsqKhdMobanpzDao;
import com.example.demo.mysqlPlus.model.CpcCity;
import com.example.demo.mysqlPlus.model.Mobanpz;
import com.example.demo.mysqlPlus.model.User;
import com.example.demo.xml.service.XmlService;
import javafx.beans.binding.When;
import org.apache.velocity.runtime.directive.Foreach;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlus {
    @Resource
    private UserDao userMapper;
    @Resource
    private XmlService xmlService;
    @Resource
    private DzsqKhdGjxzqhDao dzsqKhdGjxzqhDao;
    @Resource
    private CpcCityDao cpcCityDao;
    @Resource
    private DzsqKhdMobanpzDao dzsqKhdMobanpzDao;
    @Resource
    private MobanpzDao mobanpzDao;

    @Test
    public void testSelect(){
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void createXml(){
        Map<String,Object> map = new HashMap<>();
        map.put("appNumber","申请号");
        map.put("caseCnName","专利名称");
        map.put("applicationName","申请人");
        map.put("officeName","签章");
        map.put("ssqqDateYear","2021");
        map.put("ssqqDateMonth","4");
        map.put("ssqqDateDay","9");
        xmlService.createXml(map,"110401");
    }


    @Test
    public void updateXml(){
        xmlService.updateXml();
    }
    @Test
    public void addCity(){
        List<DzsqKhdGjxzqh> dzsqKhdGjxzqhs = dzsqKhdGjxzqhDao.selectList(null);
        for (DzsqKhdGjxzqh dzsqKhdGjxzqh : dzsqKhdGjxzqhs) {
            CpcCity cpcCity = new CpcCity();
            cpcCity.setCitycode(dzsqKhdGjxzqh.getGjxzqhdm());
            cpcCity.setCityname(dzsqKhdGjxzqh.getGjxzqhmc());
            cpcCity.setParentcode(dzsqKhdGjxzqh.getGjxzqhsj());
            cpcCityDao.insert(cpcCity);
        }
    }
    @Test
    public void queryFileType(){
        List<DzsqKhdMobanpz> dzsqKhdMobanpzs = dzsqKhdMobanpzDao.selectList(null);
        for (DzsqKhdMobanpz dzsqKhdMobanpz:
                dzsqKhdMobanpzs) {
            Mobanpz mobanpz = new Mobanpz();
            mobanpz.setBiaogedm(dzsqKhdMobanpz.getBiaogedm());
            mobanpz.setBiaogemc(dzsqKhdMobanpz.getBiaogemc());
            mobanpz.setShenqinglx(dzsqKhdMobanpz.getShenqinglx());
            mobanpz.setWenjianlx(dzsqKhdMobanpz.getWenjianlx());
            mobanpzDao.insert(mobanpz);
        }
    }


    public static void main(String[] args) {
        String str = "1996";
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            String sz = "";
            sz = str.substring(i,i+1);
            String zh = zh(Integer.valueOf(sz));
            string = string + zh;

        }

        System.out.println(string);
    }


    public static String zh(int i){
        String str = "";
        switch (i) {
            case 1:
                str = "一";
                break;
            case 2:
                str = "二";
                break;
            case 3:
                str = "三";
                break;
            case 4:
                str = "四";
                break;
            case 5:
                str = "五";
                break;
            case 6:
                str = "六";
                break;
            case 7:
                str = "七";
                break;
            case 8:
                str = "八";
                break;
            case 9:
                str = "九";
                break;
            case 0:
                str = "〇";
                break;
        }
        return str;
    }

}
