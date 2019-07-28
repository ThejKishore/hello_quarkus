plugins {
    java
    id("io.quarkus") version "0.19.1"
}

repositories {
    mavenCentral()
}

dependencies {
    
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:0.19.1"))
    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-resteasy-jsonb")

    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    implementation("io.quarkus:quarkus-jdbc-postgresql")


    //
    testCompile("io.quarkus:quarkus-junit5:0.19.1")
    testCompile("io.rest-assured:rest-assured:3.3.0")
}


tasks {
    "test"(Test::class) {
        useJUnitPlatform()
    }
}