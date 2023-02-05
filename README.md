# kotest-extensions-pitest

Kotest extension for mutation testing using [Pitest](https://pitest.org/).

See [docs](https://kotest.io/docs/extensions/pitest.html).

Please create issues on the main kotest [board](https://github.com/kotest/kotest/issues).

[![Build Status](https://github.com/kotest/kotest-extensions-pitest/workflows/master/badge.svg)](https://github.com/kotest/kotest-extensions-pitest/actions)
[<img src="https://img.shields.io/maven-central/v/io.kotest.extensions/kotest-extensions-pitest.svg?label=latest%20release"/>](http://search.maven.org/#search|ga|1|kotest-extensions-pitest)
![GitHub](https://img.shields.io/github/license/kotest/kotest-extensions-pitest)
[![kotest @ kotlinlang.slack.com](https://img.shields.io/static/v1?label=kotlinlang&message=kotest&color=blue&logo=slack)](https://kotlinlang.slack.com/archives/CT0G9SD7Z)
[<img src="https://img.shields.io/nexus/s/https/s01.oss.sonatype.org/io.kotest.extensions/kotest-extensions-pitest.svg?label=latest%20snapshot"/>](https://oss.sonatype.org/content/repositories/snapshots/io/kotest/extensions/kotest-extensions-pitest/)

## Changelog

### 1.2.0

* Minimum Pitest version is now 1.9.0.
* Confirmed to work with Pitest versions up to and including 1.11.0

### 1.1.0

* Updated for Kotest 5.x. Now requires Kotlin 1.6

### 1.0.1

* Pitest dependency is now compileOnly. It must be added by the user.

### 1.0.0

* Migrated from the main Kotest repo into a standalone top level repo.
