package com.wgg.sb2.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelTest {
    private static final Logger log = LoggerFactory.getLogger(ExcelTest.class);

    @Test
    public void test01() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        //获得工作簿对象
        /*
         EasyExcel.read()参数：
            pathName  		文件路径；"d:\\学员信息表.xlsx"
        	head			每行数据对应的实体；Student.class
        	readListener	读监听器，每读一样就会调用一次该监听器的invoke方法
         */
        ExcelReaderBuilder excelReaderBuilder = EasyExcel.read("d:\\学员信息表.xlsx", Student.class, new StudentReadListener());
        //读取工作表
        ExcelReaderSheetBuilder sheet = excelReaderBuilder.sheet();
        //读取工作表内容:sheet方法参数：工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
        sheet.doRead();
    }

    @Test
    public void test02() {
        /*
         * 工作簿对象
         * @param pathName 文件路径名称
         * @param head 封装写出的数据实体的类型
         * @return 写出工作表对象
         */
        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write("d:\\学员信息表-write.xlsx", Student.class);
        //工作表对象
        ExcelWriterSheetBuilder sheet = excelWriterBuilder.sheet();
        //需要写出的数据
        List<Student> stduents = initData();
        //写出
        sheet.doWrite(stduents);
    }

    private List<Student> initData() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student data = new Student();
            data.setName("学员" + i);
            data.setBirthday(new Date());
            data.setGender("男");
            data.setId(String.valueOf(i));
            students.add(data);
        }
        return students;
    }

}
