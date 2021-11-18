package com.wgg.sb2.ioc.xml;

public class TeacherService {

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String teach(){
        return teacher.toString();
    }
}
