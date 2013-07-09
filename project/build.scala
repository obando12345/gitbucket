import sbt._
import Keys._
import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import twirl.sbt.TwirlPlugin._
import com.typesafe.sbteclipse.plugin.EclipsePlugin.EclipseKeys
import com.typesafe.sbt.SbtStartScript

object MyBuild extends Build {
  val Organization = "jp.sf.amateras"
  val Name = "gitbucket"
  val Version = "0.0.1"
  val ScalaVersion = "2.10.1"
  val ScalatraVersion = "2.2.0"

  lazy val project = Project (
    "gitbucket",
    file("."),
    settings = Defaults.defaultSettings ++ ScalatraPlugin.scalatraWithJRebel ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.eclipse.jgit" % "org.eclipse.jgit.http.server" % "3.0.0.201306101825-r",
        "org.apache.commons" % "commons-io" % "1.3.2",
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
        "org.scalatra" %% "scalatra-json" % ScalatraVersion,
        "org.json4s" %% "json4s-jackson" % "3.2.4",
        "commons-io" % "commons-io" % "2.4",
        "org.pegdown" % "pegdown" % "1.3.0",
        "org.apache.commons" % "commons-compress" % "1.5",
        "com.typesafe.slick" %% "slick" % "1.0.1",
        "com.h2database" % "h2" % "1.3.171",
        "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
        "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "compile;container",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "compile;container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
      ),
      EclipseKeys.withSource := true
    ) ++ Twirl.settings ++ SbtStartScript.startScriptForClassesSettings
  )
}
