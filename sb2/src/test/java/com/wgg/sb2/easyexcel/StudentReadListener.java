package com.wgg.sb2.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StudentReadListener extends AnalysisEventListener<Student> {

    private static final Logger log = LoggerFactory.getLogger(StudentReadListener.class);

    /**
     * 每读一样会自动调用这个方法
     * @param student 读取的内容自动封装成了一个对象
     * @param context
     */
    @Override
    public void invoke(Student student, AnalysisContext context) {
        log.info("解析到的数据：{}", JSON.toJSONString(student));
        System.out.println("Student = " + student);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}
