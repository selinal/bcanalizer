package ru.home;

import java.util.Arrays;

public class ClassFileMathod {

    private String name;
    private String[] inputParamNames;
    private String returnParamName;

    public ClassFileMathod(String name, String[] inputParamNames, String returnParamName) {
        this.name = name;
        this.inputParamNames = inputParamNames;
        this.returnParamName = returnParamName;
    }

    public String getName() {
        return name;
    }

    public String[] getInputParamNames() {
        return inputParamNames;
    }

    public String getReturnParamName() {
        return returnParamName;
    }

    @Override
    public String toString() {
        return "{MethodName='" + name + '\'' +
                ", inputParamNames=" + Arrays.toString(inputParamNames) +
                ", returnParamName='" + returnParamName + '\'' +
                '}';
    }
}
