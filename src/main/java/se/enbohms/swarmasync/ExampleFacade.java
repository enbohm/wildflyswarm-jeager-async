package se.enbohms.swarmasync;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import io.opentracing.util.GlobalTracer;

@Path("/")
@ApplicationScoped
public class ExampleFacade {

	@Inject
	private AsyncService asyncService;

	@GET
	@Path("async")
	public Response traceAsync() {
		asyncService.asyncMethod(GlobalTracer.get().activeSpan().context());
		return Response.ok("Async service method called").build();
	}
}
