module com.jakubeeee.playground.common {

    exports com.jakubeeee.playground.common.collectors;
    exports com.jakubeeee.playground.common.durationmeasure;

    requires org.aspectj.weaver;
    requires org.slf4j;
    requires spring.context;

    requires static lombok;

}