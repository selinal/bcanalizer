package ru.home;

import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Analyzer {

    public static String zipFilePath = "D:\\Projects\\two.jar";

    public static void main(String[] args) throws IOException {

        ZipFile zipFile = new ZipFile(zipFilePath);
        Enumeration<? extends ZipEntry> e = zipFile.entries();


        zipFile.stream()
                .filter(f -> f.toString().endsWith(".class"))
//                .filter(f -> f.toString().contains("ServerListener"))
                .map(ze -> {
                    try {
                        InputStream fis = zipFile.getInputStream(ze);
                        ClassPrinter cp = new ClassPrinter();
                        ClassReader cr = new ClassReader(fis);
                        cr.accept(cp, 0);
                        return cp.getClassFileInfo();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    return new ClassFileInfo();
                })
                .filter(ClassFileInfo::isInterface)
                .forEach(c->{
                    System.out.println(c.getName());
                    System.out.println(c.getAnnotationName());
                    System.out.println(c.getMethods());
                    System.out.println("======");
                });

        zipFile.close();
    }
}
