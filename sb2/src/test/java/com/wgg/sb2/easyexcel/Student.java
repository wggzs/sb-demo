package com.wgg.sb2.easyexcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ColumnWidth(20) // 列宽
@HeadRowHeight(30) // 列头行高
//@ContentRowHeight //内容行高
public class Student {
    /**
     * id
     */
    @ExcelProperty(value = "学生编号")
    private String id;

    /**
     * 学生姓名
     */
    @ExcelProperty(value = "学生姓名",index = 3)//index是表格的索引地址
    private String name;

    /**
     * 学生出生日期
     */
    //@ColumnWidth(20)  //单独设置列宽
    @DateTimeFormat("yyyy-MM-dd")  //设置日期格式
    @ExcelProperty(value = "出生日期", index = 1)
    @ColumnWidth(20) //列宽
    private Date birthday;

    /**
     * 学生性别
     */
    private String gender;

    /**
     * 忽略的字段
     *
     */
    @ExcelIgnore
    private String ignore;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

