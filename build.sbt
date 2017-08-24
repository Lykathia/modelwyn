name := "modelwyn"
organization := "com.modelwyn"
scalaVersion := "2.12.3"

fork in run := true
fork in test := true

// From the wonderful https://tpolecat.github.io/2017/04/25/scalac-flags.html
scalacOptions ++= Seq(
  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",                // Specify character encoding used by source files.
  "-explaintypes",                     // Explain type errors in more detail.
  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials",            // Existential types (besides wildcard types) can be written and inferred
  "-language:experimental.macros",     // Allow macro definition (besides implementation and application)
  "-language:higherKinds",             // Allow higher-kinded types
  "-language:implicitConversions",     // Allow definition of implicit functions called views
  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings",                  // Fail the compilation if there are any warnings.
  "-Xfuture",                          // Turn on future language features.
  "-Xlint:adapted-args",               // Warn if an argument list is modified to match the receiver.
  "-Xlint:by-name-right-associative",  // By-name parameter of right associative operator.
  "-Xlint:constant",                   // Evaluation of a constant arithmetic expression results in an error.
  "-Xlint:delayedinit-select",         // Selecting member of DelayedInit.
  "-Xlint:doc-detached",               // A Scaladoc comment appears to be detached from its element.
  "-Xlint:inaccessible",               // Warn about inaccessible types in method signatures.
  "-Xlint:infer-any",                  // Warn when a type argument is inferred to be `Any`.
  "-Xlint:missing-interpolator",       // A string literal appears to be missing an interpolator id.
  "-Xlint:nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
  "-Xlint:nullary-unit",               // Warn when nullary methods return Unit.
  "-Xlint:option-implicit",            // Option.apply used implicit view.
  "-Xlint:package-object-classes",     // Class or object defined in package object.
  "-Xlint:poly-implicit-overload",     // Parameterized overloaded implicit methods are not visible as view bounds.
  "-Xlint:private-shadow",             // A private field (or class parameter) shadows a superclass field.
  "-Xlint:stars-align",                // Pattern sequence wildcard must align with sequence component.
  "-Xlint:type-parameter-shadow",      // A local type parameter shadows a type already in scope.
  "-Xlint:unsound-match",              // Pattern match may not be typesafe.
  "-Yno-adapted-args",                 // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
  "-Ypartial-unification",             // Enable partial unification in type constructor inference
  "-Ywarn-dead-code",                  // Warn when dead code is identified.
  "-Ywarn-extra-implicit",             // Warn when more than one implicit parameter section is defined.
  "-Ywarn-inaccessible",               // Warn about inaccessible types in method signatures.
  "-Ywarn-infer-any",                  // Warn when a type argument is inferred to be `Any`.
  "-Ywarn-nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
  "-Ywarn-nullary-unit",               // Warn when nullary methods return Unit.
  "-Ywarn-numeric-widen",              // Warn when numerics are widened.
  "-Ywarn-unused:implicits",           // Warn if an implicit parameter is unused.
  //"-Ywarn-unused:imports",             // Warn if an import selector is not referenced. Disabled: https://github.com/playframework/twirl/issues/105
  "-Ywarn-unused:locals",              // Warn if a local definition is unused.
  //"-Ywarn-unused:params",              // Warn if a value parameter is unused. Disabled: https://github.com/playframework/playframework/issues/6302
  //"-Ywarn-unused:patvars",             // Warn if a variable bound in a pattern is unused. Disabled: https://github.com/playframework/playframework/issues/7519
  "-Ywarn-unused:privates",            // Warn if a private member is unused.
  "-Ywarn-value-discard"               // Warn when non-Unit expression results are unused.
)

scalacOptions in (Compile, console) ~= (_.filterNot(Set(
  "-Ywarn-unused:imports",
  "-Xfatal-warnings"
)))



lazy val root = (project in file(".")).enablePlugins(PlayScala)

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
updateOptions := updateOptions.value.withCachedResolution(true)
incOptions := incOptions.value.withNameHashing(true)

libraryDependencies ++= {
  val ngVersion = "4.2.5"
  Seq(
    guice,
    "org.webjars.npm" % "angular__common"                   % ngVersion,
    "org.webjars.npm" % "angular__compiler"                 % ngVersion,
    "org.webjars.npm" % "angular__core"                     % ngVersion,
    "org.webjars.npm" % "angular__http"                     % ngVersion,
    "org.webjars.npm" % "angular__forms"                    % ngVersion,
    "org.webjars.npm" % "angular__router"                   % ngVersion,
    "org.webjars.npm" % "angular__platform-browser-dynamic" % ngVersion,
    "org.webjars.npm" % "angular__platform-browser"         % ngVersion,
    "org.webjars.npm" % "systemjs"                          % "0.20.14",
    "org.webjars.npm" % "rxjs"                              % "5.4.2",
    "org.webjars.npm" % "reflect-metadata"                  % "0.1.8",
    "org.webjars.npm" % "zone.js"                           % "0.8.4",
    "org.webjars.npm" % "core-js"                           % "2.4.1",
    "org.webjars.npm" % "symbol-observable"                 % "1.0.1",

    "org.webjars.npm" % "typescript"                        % "2.4.1",
    "org.webjars.npm" % "tslint-eslint-rules"               % "3.4.0",
    "org.webjars.npm" % "types__jasmine"                    % "2.5.53" % "test",
    "org.webjars.npm" % "jasmine-core"                      % "2.6.4"
  )
}
dependencyOverrides += "org.webjars.npm" % "minimatch" % "3.0.0"

// target/web/node_modules resolution
resolveFromWebjarsNodeModulesDir := true

pipelineStages := Seq(digest, gzip)

StylusKeys.compress in Assets := true

(projectTestFile in typescript) := Some("tsconfig.test.json")

jasmineFilter in jasmine := GlobFilter("*.spec.js")

logLevel in jasmine := Level.Info
