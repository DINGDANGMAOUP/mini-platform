description = "mini-domain"
dependencies {
    //cola start
    implementation("com.alibaba.cola:cola-component-domain-starter")
    implementation("com.alibaba.cola:cola-component-exception")
    implementation( "com.alibaba.cola:cola-component-dto")
    implementation("com.alibaba.cola:cola-component-catchlog-starter")
    //cola end
    runtimeOnly("com.mysql:mysql-connector-j")



}