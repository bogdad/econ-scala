version := "0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "com.coherentlogic.fred.client" % "fred-client-core" % "0.9.14" excludeAll(
    ExclusionRule(organization = "org.glassfish.hk2")
    ),
  "org.glassfish.hk2" % "hk2-utils" % "2.2.0-b15",
  "org.glassfish.hk2" % "hk2-locator" % "2.2.0-b15"
)