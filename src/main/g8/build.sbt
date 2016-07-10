import sbt.Keys._
import DockerPackage._

lazy val buildSettings = Seq(
  name := "$name;format="norm"$",
  organization := "$organization$",
  version := "0.0.1",
  scalaVersion := "2.11.8",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")
)

lazy val service = (project in file("."))
  .settings(buildSettings: _*)
  .settings(libraryDependencies ++= Dependencies.all)
  .withDocker
  .settings(Revolver.settings)