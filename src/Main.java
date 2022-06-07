import jdk.jshell.execution.Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File[] dir = {
                new File("E:/Idea//Netology//JavaCore//Games//src"),
                new File("E:/Idea//Netology//JavaCore//Games//res"),
                new File("E:/Idea//Netology//JavaCore//Games//savegames"),
                new File("E:/Idea//Netology//JavaCore//Games//temp"),
                new File("E:/Idea//Netology//JavaCore//Games//src//main"),
                new File("E:/Idea//Netology//JavaCore//Games//src//test")
        };

        StringBuilder log = new StringBuilder();

        for(int i = 0; i < dir.length; i++) {
            if (dir[i].mkdir()) {
                log.append("Catalog " + dir[i].getName() + "has been created\n");
            } else {
                log.append("Catalog " + dir[i].getName() + "was not created\n");
            }
        }

        File[] file = {
                new File(dir[4], "Main.java"),
                new File(dir[4], "Utils.java")
        };

        for(int i = 0; i < file.length; i++) {
            try {
                if (file[i].createNewFile()) {
                    log.append("File " + file[i].getName() + "has been created\n");
                } else {
                    log.append("File " + file[i].getName() + "was not created\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        File[] dir2 = {
                new File(dir[1].getAbsolutePath() + "//drawables"),
                new File(dir[1].getAbsolutePath() + "//vectors"),
                new File(dir[1].getAbsolutePath() + "//icons"),
        };

        for(int i = 0; i < dir2.length; i++) {
            if (dir2[i].mkdir()) {
                log.append("Catalog " + dir2[i].getName() + "has been created\n");
            } else {
                log.append("Catalog " + dir2[i].getName() + "was not created\n");
            }
        }

        File file2 = new File(dir[3], "temp.txt");

        try {
            if (file2.createNewFile()) {
                log.append("File " + file2.getName() + "has been created\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (file2.canWrite()) {
            log.append("The file " + file2.getName() + " can be written\n");
        } else {
            log.append("The file " + file2.getName() + " can't be written\n");
        }
        String logText = log.toString();

        try (FileWriter writer = new FileWriter(file2.getAbsolutePath())){
            writer.write(logText);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Directories and catalogs has been created. See temp.txt");
    }
}