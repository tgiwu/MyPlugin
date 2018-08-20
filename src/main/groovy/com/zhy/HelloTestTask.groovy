package com.zhy

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class HelloTestTask extends DefaultTask{

    @TaskAction
    testHello() {
        System.out.println("+++++++++++++++++++++++++++")
        System.out.println("Test Hello Task")
        System.out.println("+++++++++++++++++++++++++++")
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/yangzhang/IdeaProjects/", "HelloWorld.txt"))
//            byte[] bytes = new HelloData("jim").toString().getBytes()
//            fileOutputStream.write(bytes)
//            fileOutputStream.flush()
//        } catch (FileNotFoundException e) {
//            e.printStackTrace()
//        } catch (IOException e) {
//            e.printStackTrace()
//        }
    }
}
