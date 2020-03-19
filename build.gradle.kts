import io.kotless.plugin.gradle.dsl.kotless

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.61"
    id("io.kotless") version "0.1.3" apply true
}

repositories {
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("io.kotless", "ktor-lang", "0.1.3")
}

kotless {
    config {
        bucket = "kotless-test  "

        terraform {
            profile = "xpeppers-develop"
            region = "us-east-1"
        }
    }

    webapp {
        lambda {
            kotless {
                //Define packages in which scan for routes should be performed
                //By default, will be set to gradle module group
                packages = setOf("kotless")
            }
        }
    }

    extensions {
        local {
            useAWSEmulation = true
        }
    }
}