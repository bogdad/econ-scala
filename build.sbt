version := "0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.springframework" % "spring-core" % "3.2.8.RELEASE",
  "org.springframework" % "spring-context" % "3.2.8.RELEASE",
  "com.coherentlogic.fred.client" % "fred-client-core" % "0.9.14" excludeAll(
    ExclusionRule(organization = "org.glassfish.hk2")
    ),
  "org.glassfish.hk2" % "hk2-utils" % "2.2.0-b15",
  "org.glassfish.hk2" % "hk2-locator" % "2.2.0-b15",
  "javax.inject" % "javax.inject" % "1",
  "joda-time" % "joda-time" % "2.0",
  "com.google.code.findbugs" % "jsr305" % "2.0.2"
)
