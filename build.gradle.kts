plugins {
    id("java")
}

group = "com.crafted"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

/* EDIT THIS TASK FOR EASIER COMPILE+DEPLOY
tasks.register<Copy>("moveJar") {
    dependsOn(tasks.withType<Jar>())
    println("Copying Build Artifacts!!!")
    from(layout.buildDirectory.dir("libs"))
    include("*.jar")
    into("F:\\Projects\\Minecraft\\plugins\\")
}
*/

tasks.test {
    useJUnitPlatform()
}