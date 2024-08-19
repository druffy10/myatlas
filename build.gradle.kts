plugins {
    // Определите плагины, которые будут применяться ко всем модулям
    // Плагины будут применяться на уровне модуля, а не на уровне проекта
    kotlin("jvm") version "1.9.10" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

