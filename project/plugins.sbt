addSbtPlugin("com.waioeka.sbt" % "cucumber-plugin" % "0.1.7")
addSbtPlugin("org.scalatra.sbt" % "sbt-scalatra" % "1.0.1")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
