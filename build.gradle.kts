plugins {
    kotlin("jvm") version "2.0.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "co"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.3")
    implementation("com.amazonaws:aws-lambda-java-events:3.11.1")

    implementation("io.ktor:ktor-client-core:3.0.3")
    implementation("io.ktor:ktor-client-cio:3.0.3")

    implementation("io.github.cdimascio:dotenv-kotlin:6.5.0")

    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.14")
}

kotlin {
    jvmToolchain(17)
}

tasks {
    test {
        useJUnitPlatform()
    }

    shadowJar {
        archiveBaseName.set("yappu-world-server-lambda") // JAR 기본 이름
        archiveVersion.set("")                    // 버전 제거
        archiveClassifier.set("shadow")          // 기본 bootJar와 구분
    }
}
