include ("mini-adapter")
include ("mini-app")
include ("mini-bootstrap")
include ("mini-client")
include ("mini-domain")
include ("mini-infrastructure")
rootProject.name = "mini-platform"
rootProject.children.forEach {
    it.buildFileName = "${it.name}.gradle.kts"
    it.children.forEach {
        it.buildFileName = "${it.name}.gradle.kts"
    }
}