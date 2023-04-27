description = "mini-infrastructure"
dependencies{
    api(project(":mini-domain"))
    api(project(":mini-client"))
    implementation("com.baomidou:mybatis-plus-boot-starter")
}