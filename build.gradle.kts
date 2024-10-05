import org.gradle.internal.impldep.bsh.commands.dir

plugins {
    id("java")
    id("jacoco")  // Plugin JaCoCo
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Dependências do Spring Boot
    implementation("org.springframework.boot:spring-boot:3.3.4")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    // Dependências de Teste
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    // Mockito
    testImplementation("org.mockito:mockito-junit-jupiter:5.5.0")

    // Atualização do Byte Buddy para maior compatibilidade com Mockito
    testImplementation("net.bytebuddy:byte-buddy:1.14.3")
    testImplementation("net.bytebuddy:byte-buddy-agent:1.14.3")

    // Lombok para testes
    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs ("-XX:+EnableDynamicAgentLoading")
    finalizedBy ("jacocoTestReport")
}

jacoco {
    toolVersion = "0.8.12"
}

tasks.jacocoTestReport{
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.required.set(true)
    }
    classDirectories.setFrom(files(sourceSets.main.get().output).filter {
        !it.path.contains("org/example/docs/") &&
        !it.path.contains("org/example/utils/")
    })
}



