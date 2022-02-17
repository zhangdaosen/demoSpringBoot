package com.example.demo;

import com.example.demo.dataSourceModel.DzsqKhdAj;
import com.example.demo.dataSourceModel.DzsqKhdShenoingxx;
import com.example.demo.dataSourceModel.DzsqKhdSqwj;
import com.example.demo.mysqlPlus.dao.slave.DzsqKhdAjDao;
import com.example.demo.mysqlPlus.dao.slave.DzsqKhdShenoingxxDao;
import com.example.demo.mysqlPlus.dao.slave.DzsqKhdSqwjDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class demoController {
    @Resource
    private DzsqKhdAjDao dzsqKhdAjDao;
    @Resource
    private DzsqKhdShenoingxxDao dzsqKhdShenoingxxDao;
    @Resource
    private DzsqKhdSqwjDao dzsqKhdSqwjDao;


    @ResponseBody
    @RequestMapping("/demo")
    public String demo(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DzsqKhdShenoingxx dzsqKhdShenoingxx = new DzsqKhdShenoingxx();
        dzsqKhdShenoingxx.setShenqingbh("{" + UUID.randomUUID().toString() + "}");
        dzsqKhdShenoingxx.setShenqinglx("0");
        dzsqKhdShenoingxx.setZhuanlimc("人源化ACE2基因改造小鼠模型的制备方法及应用");
        dzsqKhdShenoingxx.setChuangjianrq(new Date());
        dzsqKhdShenoingxx.setZhuangtai("0");
        int insert = dzsqKhdShenoingxxDao.insert(dzsqKhdShenoingxx);
        List<DzsqKhdShenoingxx> dzsqKhdShenoingxxes = dzsqKhdShenoingxxDao.selectList(null);
        dzsqKhdShenoingxxes.forEach(System.out::println);

        DzsqKhdAj dsqKhdAj = new DzsqKhdAj();
        dsqKhdAj.setAnjuanbh("{" + UUID.randomUUID().toString() + "}");
        dsqKhdAj.setAnjuanmc(sdf.format(date));
        dsqKhdAj.setTianxiems("0");
        dsqKhdAj.setAnjuanlx("0");
        dsqKhdAj.setShenqingbh(dzsqKhdShenoingxx.getShenqingbh());
        dsqKhdAj.setChuangjianrq(date);
        dsqKhdAj.setAnjuanzt("0");
        dsqKhdAj.setNeibubh("PT20210659-DD-P");
        dzsqKhdAjDao.insert(dsqKhdAj);
        DzsqKhdSqwj dzsqKhdSqwj = new DzsqKhdSqwj();
        dzsqKhdSqwj.setWenjianmc("实质审查请求书");
        dzsqKhdSqwj.setBiaogedm("110401");
        dzsqKhdSqwj.setWenjianlx("1");
        dzsqKhdSqwj.setAnjuanbh(dsqKhdAj.getAnjuanbh());
        dzsqKhdSqwj.setChuangjianlx("0");
        dzsqKhdSqwj.setChuangjianrq(date);
        dzsqKhdSqwj.setCunchulj("\\cases\\inventions\\d9a2d6b5-4034-4f58-b782-d8ed659a1ff0\\new\\110401\\110401.doc");
        dzsqKhdSqwj.setWenjianzt("1");
        dzsqKhdSqwj.setCounts("0");
        dzsqKhdSqwj.setPages("0");
        dzsqKhdSqwjDao.insert(dzsqKhdSqwj);
        return "123";
    }
}
