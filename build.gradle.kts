import org.gradle.api.internal.project.DefaultProject
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    `java-library`
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
}
var properties: MutableMap<String, *> = project.properties
fun getProp(key: String): String {
    return properties[key] as String
}
group = getProp("projectGroup")
version = getProp("projectVersion")
java.sourceCompatibility = JavaVersion.VERSION_17

var bootstrapProject = project(":mini-bootstrap") as DefaultProject
var springBootVersion = "3.0.6"
var colaVersion = "4.3.1"
var fastjson2Version = "2.0.24"
var okhttp3Version = "4.10.0"
var mysqlVersion = "8.0.33"
var mybatisPlusVersion = "3.5.3.1"
var flywayVersion = "9.8.1"
var guavaVersion = "31.1-jre"
var mapstructVersion="1.5.5.Final"

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
        api(platform("com.baomidou:mybatis-plus-annotation:${mybatisPlusVersion}"))
        api(platform("org.flywaydb:flyway-core:${flywayVersion}"))
//        api(platform("org.springframework.security:spring-security-oauth2-authorization-server:${springAuthorizationServer}"))
        api(platform("com.google.guava:guava:${guavaVersion}"))
        compileOnly("org.mapstruct:mapstruct:${mapstructVersion}")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.projectlombok:lombok")
        annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
        testImplementation("org.springframework.boot:spring-boot-starter-test")

    }



}

