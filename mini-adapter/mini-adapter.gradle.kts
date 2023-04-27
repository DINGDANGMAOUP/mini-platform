description = "mini-adapter"

dependencies {
    api(project(":mini-app"))
    api("org.springframework.boot:spring-boot-starter-web")
    implementation("com.alibaba.cola:cola-component-dto")
}