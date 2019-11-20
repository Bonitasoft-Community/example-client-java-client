plugins {
    java
}

group = "org.bonitasoft.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
//    flatDir {
//        dirs '~/studio/BonitaStudioCommunity-7.9.4/workspace/project-redirect/lib', '~/studio/BonitaStudioCommunity-7.9.4/workspace/tomcat/server/temp/bonita_engine_2489@debamo3/platform/classloaders/local/TENANT/1/0349c'
//    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation("org.bonitasoft.engine:bonita-client:7+")
    testImplementation("junit:junit:4.12")
//    implementation name: 'bdm-client-pojo'
//    implementation name: 'bdm-dao'
//    implementation name: 'javassist-3.18.1-GA'
//    implementation group: 'com.company.model', name: 'bdm-client', version: '1.0.0'
//    implementation group: 'com.company.model', name: 'bdm-dao', version: '1.0.0'
//    implementation files('/home/antoine/studio/BonitaStudioCommunity-7.8.4/workspace/repositories/test-dao-groovy-script/lib/bdm-client-pojo.jar')
}
