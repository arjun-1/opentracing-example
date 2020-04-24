package example

import io.jaegertracing.Configuration
import io.opentracing.mock.MockTracer
import io.opentracing.noop.NoopSpan
import io.opentracing.propagation.{Format, TextMapAdapter}
import io.opentracing.Span

import scala.collection.mutable
import scala.jdk.CollectionConverters._


//[error] java.lang.ClassCastException: class io.opentracing.noop.NoopSpanContextImpl cannot be cast to class io.opentracing.mock.MockSpan$MockContext (io.opentracing.noop.NoopSpanContextImpl and io.opentracing.mock.MockSpan$MockContext are in unnamed module of loader sbt.internal.LayeredClassLoader @467d22f3)
//[error]         at io.opentracing.mock.MockTracer$SpanBuilder.addReference(MockTracer.java:340)
//[error]         at io.opentracing.mock.MockTracer$SpanBuilder.asChildOf(MockTracer.java:328)
//[error] 	at example.Example$.delayedEndpoint$example$Example$1(Example.scala:17)
object Example extends App {
  val mockTracer = new MockTracer()

  val span: Span = NoopSpan.INSTANCE

  mockTracer.buildSpan("operationName").asChildOf(span).start()
}

//[error] java.lang.ClassCastException: class io.opentracing.noop.NoopSpanContextImpl cannot be cast to class io.jaegertracing.internal.JaegerSpanContext (io.opentracing.noop.NoopSpanContextImpl and io.jaegertracing.internal.JaegerSpanContext are in unnamed module of loader sbt.internal.LayeredClassLoader @2d1191ec)
//[error] 	at io.jaegertracing.internal.JaegerTracer.inject(JaegerTracer.java:211)
////[error] 	at example.Example2$.delayedEndpoint$example$Example2$1(Example.scala:33)
//object Example2 extends App {
//  val span: Span = NoopSpan.INSTANCE
//  val jaegerTracer = new Configuration("seviceName").getTracerBuilder.build()
//
//  val textMapAdapter = new TextMapAdapter(Map.empty.asJava)
//  jaegerTracer.inject(span.context(), Format.Builtin.TEXT_MAP, textMapAdapter)
//}
