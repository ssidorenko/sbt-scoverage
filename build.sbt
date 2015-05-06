import bintray.Keys._

name := "sbt-scoverage"

organization := "ch.sidorenko.scoverage"

version := "1.0.5"

scalaVersion := "2.10.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

sbtPlugin := true

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "ch.sidorenko.scoverage" %% "scalac-scoverage-plugin" % "1.0.5-JS"
)

publishMavenStyle := false

bintrayPublishSettings

repository in bintray := "sbt-plugins"

bintrayOrganization in bintray := None


publishArtifact in Test := false

licenses +=("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

ScriptedPlugin.scriptedSettings

scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + version.value)
}
