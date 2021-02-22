name := "hackerrank"

version := "1.0"

scalaVersion := "2.12.8"

lazy val catsVersion = "2.1.0"
val monocleVersion = "2.0.0" // depends on cats 2.x

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1",
  "org.apache.olingo" % "olingo-odata2-api" % "2.0.10",
  "org.apache.olingo" % "olingo-odata2-core" % "2.0.10",
  // monocle

  // monocle for lenses
  "org.typelevel" %% "cats-core" % "2.1.0",
  "com.github.julien-truffaut" %%  "monocle-core"  % monocleVersion,
  "com.github.julien-truffaut" %%  "monocle-macro" % monocleVersion

)