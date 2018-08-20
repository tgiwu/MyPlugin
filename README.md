# MyPlugin

前几天面试 被问有没有自己的强项 比如说哪些工作自己能做别人做不了，想了一下自己也不是什么技术大牛，自己会的别人也会干。
面试官还举了些例子 比如 gradle插件 编译器 热修复。感觉很受刺激 所以决定自己写一下东西

插件其实基本实现很简单

build.gradle 文件的依赖中需要加入gradleApi依赖，语言方面想使用哪种语言需要加入哪种语言的插件


需要有一个properties文件文件名的格式是group.name.properties。内容是implementation-class=具体task类


plugin类的路径可以随意，但一般习惯上按group层级建立，这个类需要实现Plugin接口

另外需要一个仓库，仓库有很多种最常用的有ivy，maven，jcenter等，这里用了最简单的一种maven库
库地址直接指向本地的一个文件夹。为了使用maven相关的任务需要引入maven插件，然后编写uploadArchives
这个任务用于编译完成后提交到maven库，如果代码没有错误，gradle同步后会在任务列表中多出upload.uploadArchives
任务，直接执行这个任务就可以编译代码并提交到maven库了


引用插件时需要在buildscript中dependencies加入classpath内容是group:name:version,
并且在repositories中加入maven地址再在需要引入的模块中加入代码apply plugin: properties文件名称，不要扩展名。
gradle同步后就可以在任务列表的other中找到插件中定义的任务


添加重命名apk包功能只需引入插件，编译完成时会自动调用重命名方法格式为   
{modelName}\_v{Version}\_{buildType}\_{buildTime}.apk