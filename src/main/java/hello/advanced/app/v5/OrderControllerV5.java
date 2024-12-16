package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallBack;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

  private final OrderServiceV5 orderService;
  private final TraceTemplate template;

  public OrderControllerV5(OrderServiceV5 orderService, TraceTemplate template) {
    this.orderService = orderService;
    this.template = template;
  }

  @GetMapping("/v5/request")
  public String request(@RequestParam("itemId") String itemId) {
    return template.execute("OrderController.request()", new TraceCallBack<String>() {
      @Override
      public String call() {
        orderService.orderItem(itemId);
        return "ok";
      }
    });
  }

}
