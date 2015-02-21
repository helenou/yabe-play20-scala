lazy val app = project.in(file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "com.octo.captcha" % "jcaptcha" % "1.0",
  anorm,
  cache,
  jdbc
)
