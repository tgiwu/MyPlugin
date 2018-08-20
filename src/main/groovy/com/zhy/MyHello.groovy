package com.zhy

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyHello implements Plugin<Project> {

    @Override
    void apply(Project project) {
//        project.container(HelloData.class)
//        project.tasks.create('HelloTest', HelloTestTask.class)
        changeAPKName(project.name, project.android.applicationVariants)
    }

    static def changeAPKName(name, applicationVariants) {
        applicationVariants.all { variant ->
            variant.outputs.all { output ->
                def file = output.outputFile
                System.out.println("++ ${output.name} ++ ${variant.buildType.name} ++ ${file.name} ++")
                if (outputFileName.endsWith('.apk')) {
                    System.out.println("${outputFileName}")
                    outputFileName = "${name}_v${variant.versionName}_${variant.buildType.name}_${buildTime()}.apk"
                    System.out.println("rename to ${outputFileName}")
                }
            }
        }
    }

    static def buildTime() {
        def date = new Date()
        def formattedDate = date.format('yyyyMMdd')
        return formattedDate
    }
}
