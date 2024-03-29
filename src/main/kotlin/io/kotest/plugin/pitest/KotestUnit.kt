package io.kotest.plugin.pitest

import io.kotest.core.descriptors.toDescriptor
import io.kotest.core.spec.Spec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.engine.TestEngineLauncher
import io.kotest.engine.listener.AbstractTestEngineListener
import kotlinx.coroutines.runBlocking
import org.pitest.testapi.Description
import org.pitest.testapi.ResultCollector
import org.pitest.testapi.TestUnit
import kotlin.reflect.KClass

class KotestUnit(val klass: KClass<out Spec>) : TestUnit {

   override fun getDescription(): Description = Description(klass.toDescriptor().path().value, klass.java)

   override fun execute(rc: ResultCollector) = runBlocking<Unit> {
      val listener = object : AbstractTestEngineListener() {

         private val started = mutableSetOf<io.kotest.core.descriptors.Descriptor.TestDescriptor>()
         private val completed = mutableSetOf<io.kotest.core.descriptors.Descriptor.TestDescriptor>()

         override suspend fun testStarted(testCase: TestCase) {
            if (started.add(testCase.descriptor)) {
               rc.notifyStart(Description(testCase.descriptor.path().value, klass.java))
            }
         }

         override suspend fun testFinished(testCase: TestCase, result: TestResult) {
            val desc = Description(testCase.descriptor.path().value, klass.java)
            if (completed.add(testCase.descriptor)) {
               when (result.errorOrNull) {
                  null -> rc.notifyEnd(desc)
                  else -> rc.notifyEnd(desc, result.errorOrNull)
               }
            }
         }
      }

      TestEngineLauncher()
         .withListener(listener)
         .withClasses(klass)
         .launch()
   }
}
