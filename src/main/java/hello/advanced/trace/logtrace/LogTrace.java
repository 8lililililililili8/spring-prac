package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

//추후 다양한 구현체를 만들기 위핸 interface 생성
public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
