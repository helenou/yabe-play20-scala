// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Maven repo
resolvers += "Maven central repository" at "http://repo1.maven.org/maven2/"

resolvers += "jahia org repository" at "http://maven.jahia.org/maven2/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.6")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")
// libraryDependencies += "com.octo.captcha" % "jcaptcha" % "1.0"