plugins {
    kotlin("jvm") version "1.4.10"
    war
}

group = "dd.oliver"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(group = "javax", name = "javaee-api", version = "7.0")
    implementation("redis.clients:jedis:3.3.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.register<Delete>("remove") {
    delete(
        "${System.getenv("CATALINA_HOME")}/webapps/${project.name}.war",
        "${System.getenv("CATALINA_HOME")}/webapps/${project.name}/"
    )
}

tasks.register<Copy>("deploy") {
    dependsOn("war", "remove")
    from("build/libs")
    into("${System.getenv("CATALINA_HOME")}/webapps")
    rename {
        project.name + ".war"
    }
}

tasks.register<Exec>("showing") {
    dependsOn("deploy")
    val file = File("./build/browser/")
    if (!file.exists()) {
        file.mkdirs()
    }
    workingDir = file
    commandLine("cmd", "/c", "start http://localhost:8080/${project.name}/")
}

