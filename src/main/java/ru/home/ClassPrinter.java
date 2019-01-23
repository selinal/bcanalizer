package ru.home;

import jdk.internal.org.objectweb.asm.*;

import java.util.Arrays;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class ClassPrinter extends ClassVisitor {
    private ClassFileInfo cfi = new ClassFileInfo();

    public ClassPrinter() {
        super(ASM5);

    }

    public void visit(int version, int access, String name,
                      String signature, String superName,
                      String[] interfaces) {
        if (access == ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE) {
            //if class file is interface
            cfi.setInterface(true);
        }
//        System.out.println(name);
        cfi.setName(name.replaceAll("/", "."));
    }

    public AnnotationVisitor visitAnnotation(String desc,
                                             boolean visible) {
        if (cfi != null) {
            cfi.setAnnotationName(desc.substring(1, desc.length() - 1).replaceAll("/", "."));
        }
        return null;
    }

    public MethodVisitor visitMethod(int access, String name,
                                     String desc, String signature, String[] exceptions) {
        if (cfi != null) {
            ClassFileMathod cfm = new ClassFileMathod(name, new String[]{signature}, desc);

//            System.out.println("->");
//            System.out.println(name);
//            System.out.println(desc);
//            System.out.println(signature);
//            System.out.println("->");

            cfi.addMethod(cfm);
        }
        return null;
    }


    public ClassFileInfo getClassFileInfo() {
        return cfi;
    }
}
