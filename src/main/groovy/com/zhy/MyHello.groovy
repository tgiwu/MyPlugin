package com.zhy

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyHello implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.container(HelloData.class)
        project.tasks.create('HelloTest', HelloTestTask.class)
    }
}
