package se.enbohms.swarmasync;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;

import io.opentracing.Span;
import io.opentracing.SpanContext;
import io.opentracing.util.GlobalTracer;

@Singleton
public class AsyncService {

	@Asynchronous
	public void asyncMethod(SpanContext spanCtx) {
		Span span = GlobalTracer.get().buildSpan("async-method").asChildOf(spanCtx).startManual();
		try {
			System.out.println("Async method");
		} finally {
			span.finish();
		}
	}
}
