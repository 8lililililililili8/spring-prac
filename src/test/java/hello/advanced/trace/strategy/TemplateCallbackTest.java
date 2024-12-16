package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.CallBack;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    @DisplayName("템플릿 콜백 패턴 - 익명 내부 클래스")
    void callBackV1() {
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비지니스 로직1 실행");
            }
        });

        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        });
    }

    @Test
    @DisplayName("템플릿 콜백 패턴 - 람다")
    void callBackV2() {
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(() -> log.info("비지니스 로직1 실행"));
        template.execute(() -> log.info("비지니스 로직2 실행"));
    }
}
