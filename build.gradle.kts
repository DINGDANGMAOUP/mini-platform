import org.gradle.api.internal.project.DefaultProject
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    `java-library`
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
}
group = "com.dingdangmaoup"
version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

var springBootVersion = "3.0.6"
var colaVersion = "4.3.1"
var fastjson2Version = "2.0.24"
var okhttp3Version = "4.10.0"
var mysqlVersion = "8.0.33"
var mybatisPlusVersion = "3.5.3.1"
var bootstrapProject = project(":mini-bootstrap") as DefaultProject




allprojects {
    apply {
        plugin("java-library")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }
    if (project != bootstrapProject) {
        tasks.getByName<BootJar>("bootJar") {
            enabled = false
        }

        tasks.getByName<Jar>("jar") {
            enabled = true
        }
    }


    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.register<Copy>("copyJar") {
        from("${buildDir}/libs")
        into("${rootProject.buildDir}/output")
        include("*.jar")
    }

    tasks.named("build").configure {
        dependsOn("copyJar")
    }
}
subprojects {
    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
        configureEach {
            exclude(module = "spring-boot-starter-tomcat")
            exclude(module = "undertow-websockets-jsr")
        }
    }
    dependencies {
        api(platform("org.springframework.boot:spring-boot-dependencies:${springBootVersion}"))
        api(platform("com.alibaba.cola:cola-components-bom:${colaVersion}"))
        api(platform("com.alibaba.fastjson2:fastjson2:${fastjson2Version}"))
        api(platform("com.alibaba.fastjson2:fastjson2-extension-spring6:${fastjson2Version}"))
        api(platform("com.squareup.okhttp3:okhttp-bom:${okhttp3Version}"))
        api(platform("com.mysql:mysql-connector-j:${mysqlVersion}"))
        api(platform("com.baomidou:mybatis-plus-boot-starter:${mybatisPlusVersion}"))
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")

    }



}

