description = "mini-bootstrap"
dependencies {
    api(project(":mini-adapter"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
}