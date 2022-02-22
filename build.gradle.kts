plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.asciidoctor.convert") version "1.5.8"
    id("java")
}

group = "com.saramin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
lateinit var asciidoctorExt: Configuration
val snippetsDir = file("build/generated-snippets")

asciidoctorj {
    asciidoctorExt = configurations.create("asciidoctorExt")
}

repositories {
    mavenCentral()
}

ext {
    set("snippetsDir", file("build/generated-snippets"))
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-validation")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("io.micrometer:micrometer-core:1.8.2")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly( "com.h2database:h2")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.springframework.restdocs:spring-restdocs-mockmvc")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootJar {
    dependsOn(tasks.asciidoctor)
    from("${tasks.asciidoctor.get().outputDir}") {
        into("static/docs")
    }
}

tasks.test {
    outputs.dir(snippetsDir)
}

tasks.asciidoctor {
    dependsOn(tasks.test)
    val snippets = file("build/generated-snippets")
    attributes["snippets"] = snippets
    inputs.dir(snippets)
}