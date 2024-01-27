plugins {
    application
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

application {
    mainClass = "hexlet.code.App"
}

dependencies {
    implementation ("info.picocli:picocli:4.7.5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
}