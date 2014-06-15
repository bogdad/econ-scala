version := "0.1"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.springframework" % "spring-core" % "4.0.5.RELEASE",
  "org.springframework" % "spring-context" % "4.0.5.RELEASE",
  "com.coherentlogic.fred" % "client" % "1.0.3-RELEASE" excludeAll(
    ExclusionRule(organization = "org.glassfish.hk2")),
  "com.coherentlogic.fred.client" % "fred-client-db-int" % "1.0.3-RELEASE",
  "com.coherentlogic.fred.client" % "fred-client-core" % "1.0.3-RELEASE",
  "org.glassfish.hk2" % "hk2-utils" % "2.2.0-b15",
  "org.glassfish.hk2" % "hk2-locator" % "2.2.0-b15",
  "javax.inject" % "javax.inject" % "1",
  "joda-time" % "joda-time" % "2.3",
  "com.google.code.findbugs" % "jsr305" % "1.3.+",
  "org.joda" % "joda-convert" % "1.2",
  "com.h2database" % "h2" % "1.4.178",
  "org.scalatest" % "scalatest_2.11" % "2.2.0",
  "junit" % "junit" % "4.11"
)
