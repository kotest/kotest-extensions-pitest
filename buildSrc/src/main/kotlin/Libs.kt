object Libs {

   const val kotlinVersion = "1.4.31"
   const val org = "io.kotest.extensions"

   object Kotest {
      private const val version = "4.4.3"
      const val api = "io.kotest:kotest-framework-api:$version"
      const val engine = "io.kotest:kotest-framework-engine:$version"
      const val junit5 = "io.kotest:kotest-runner-junit5-jvm:$version"
   }

   object Pitest {
      const val pitest = "org.pitest:pitest:1.6.4"
   }

   object Coroutines {
      private const val version = "1.4.3"
      const val coreCommon = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
      const val coreJvm = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$version"
   }
}
