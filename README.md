# uberjar-deploy

A Leiningen plugin to deploy uberjars, intended to be used in a `lein release` workflow.  Delegates to `lein deploy` under the hood. 

## Rationale

Whilst there are already plugins which will build and deploy uberjars (such as [this](https://github.com/TheLadders/lein-uberjar-deploy)),
the [lein release](https://github.com/relaynetwork/lein-release) plugin is hard-coded to call the `jar` and `deploy` lein tasks.  This 
is a plugin that just handles deployment of an uberjar by passing all the relevant arguments to the `lein deploy` task, which it pulls out
of the `project.clj`.

## Usage

Put `[uberjar-deploy "1.0.0"]` into the `:plugins` vector of your
`:user` profile, or if you are on Leiningen 1.x do `lein plugin install
uberjar-deploy 1.0.0`.

Use this for project-level plugins:

Put `[uberjar-deploy "1.0.0"]` into the `:plugins` vector of your project.clj.

By aliasing the `jar` and `deploy` tasks to `uberjar` and `uberjar-deploy`, you can use the 
[lein release](https://github.com/relaynetwork/lein-release) plugin to do all your version management and push your deployable uberjar 
artifacts into whatever repository you use, just like you would with your libraries.  

You'll need something like this in your `project.clj`:

    :aliases {"jar"    "uberjar"
              "deploy" "uberjar-deploy"}

Then you can just run a release as normal:

    $ lein release

## License

Copyright © 2014 Bright North Ltd.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
