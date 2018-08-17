package com.zhy

import org.gradle.api.tasks.Input

class HelloData {
    private String name

    HelloData(String name) {
        this.name = name
    }

    @Input
    String getName() {
        return name
    }

}
