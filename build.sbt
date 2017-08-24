name := "modelwyn"
scalaVersion := "2.12.3"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
updateOptions := updateOptions.value.withCachedResolution(true)

libraryDependencies ++= {
  val ngVersion = "4.2.5"
  Seq(
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

(rulesDirectories in tslint) := Some(List(
  tslintEslintRulesDir.value
))

pipelineStages := Seq(digest, gzip)

StylusKeys.compress in Assets := true

(projectTestFile in typescript) := Some("tsconfig.test.json")

jasmineFilter in jasmine := GlobFilter("*.spec.js")

logLevel in jasmine := Level.Info
logLevel in tslint := Level.Info
