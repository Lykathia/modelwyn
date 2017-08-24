logLevel := Level.Info

resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases"

// Build
addSbtPlugin("net.virtual-void"     % "sbt-dependency-graph"    % "0.8.2")
addSbtPlugin("com.timushev.sbt"     % "sbt-updates"             % "0.3.0")

// Test
addSbtPlugin("name.de-vries"        % "sbt-jasmine"             % "0.0.3")

// Compile
addSbtPlugin("com.typesafe.play"    % "sbt-plugin"              % "2.6.3")
addSbtPlugin("com.typesafe.sbt"     % "sbt-digest"              % "1.1.0")
addSbtPlugin("com.typesafe.sbt"     % "sbt-gzip"                % "1.0.0")
addSbtPlugin("com.typesafe.sbt"     % "sbt-stylus"              % "1.1.0")
addSbtPlugin("name.de-vries"        % "sbt-typescript"          % "2.4.1-2")
//addSbtPlugin("name.de-vries"        % "sbt-tslint"              % "5.1.0")
