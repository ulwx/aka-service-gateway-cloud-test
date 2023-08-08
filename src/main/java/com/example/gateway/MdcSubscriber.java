//package com.example.gateway;
//
//import com.ulwx.tool.ObjectUtils;
//import com.ulwx.tool.StringUtils;
//import org.reactivestreams.Subscription;
//import org.slf4j.MDC;
//import reactor.core.CoreSubscriber;
//import reactor.util.context.Context;
//
//import java.util.Optional;
//
//public class MdcSubscriber implements CoreSubscriber {
//
//    private static final String TRACE_ID = "traceId";
//
//    private static final String SKYWALKING_CTX_SNAPSHOT = "SKYWALKING_CONTEXT_SNAPSHOT";
//
//    private final CoreSubscriber<Object> actual;
//
//    public MdcSubscriber(CoreSubscriber<Object> actual) {
//        this.actual = actual;
//    }
//
//    @Override
//    public void onSubscribe(Subscription s) {
//        actual.onSubscribe(s);
//    }
//
//    @Override
//    public void onNext(Object o) {
//        Context c = actual.currentContext();
//        Optional<String> traceIdOptional = Optional.empty();
//        if (!c.isEmpty() && c.hasKey(SKYWALKING_CTX_SNAPSHOT)) {
//            Object snapshot=c.get(SKYWALKING_CTX_SNAPSHOT);
//            String traceId= StringUtils.trim(ObjectUtils.fromJavaBeanToMap2(snapshot).get(TRACE_ID));
//            traceIdOptional=Optional.ofNullable(traceId);
//            MDC.put("tid",traceIdOptional.orElse("N/A"));
//
//
//        }
//        actual.onNext(o);
//    }
//
//    @Override
//    public void onError(Throwable throwable) {
//        actual.onError(throwable);
//    }
//
//    @Override
//    public void onComplete() {
//        actual.onComplete();
//    }
//
//    @Override
//    public Context currentContext() {
//        return actual.currentContext();
//    }
//}
