package ru.home;

import java.util.ArrayList;
import java.util.List;

public class ClassFileInfo {

    private String name;
    private List<ClassFileMathod> methods;
    private String annotationName;
    private boolean intf = false;

    public void addMethod(ClassFileMathod method){
        if(methods == null){
            methods = new ArrayList<>();
        }
        methods.add(method);
    }

    public String getName() {
        return name;
    }

    public List<ClassFileMathod> getMethods() {
        return methods;
    }

    public String getAnnotationName() {
        return annotationName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnnotationName(String annotationName) {
        this.annotationName = annotationName;
    }

    public void setInterface(boolean b) {
        intf = b;
    }

    public boolean isInterface(){
        return intf;
    }
}
