description = "mini-infrastructure"
var springAuthorizationServer = "1.0.2"
dependencies{
    api(project(":mini-domain"))
    implementation("com.baomidou:mybatis-plus-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.security:spring-security-oauth2-authorization-server:${springAuthorizationServer}")
}