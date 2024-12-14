package hello.advanced.app.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

  private final OrderServiceV3 orderService;
  private final LogTrace trace;

  @GetMapping("/v3/request")
    public String request(@RequestParam("itemId") String itemId) {

      TraceStatus status = null;
      try{
        status = trace.begin("OrderController.request()"); //컨트롤러 이름 + 메서드 이름
        orderService.orderItem(itemId);
        trace.end(status);
        return "ok";
      }catch(Exception e){
        trace.exception(status, e);
        throw e; //예외를 꼭 다시 던져주어야 한다. LogTrace 때문에 어플리케이션의 정상 흐름에 방해 받으면 안된다.
      }
    }

}
