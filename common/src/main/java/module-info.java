module com.jakubeeee.playground.common {

    exports com.jakubeeee.playground.common.collectors;
    exports com.jakubeeee.playground.common.durationmeasure;
    exports com.jakubeeee.playground.common.jpa;

    requires java.persistence;
    requires org.aspectj.weaver;
    requires org.slf4j;
    requires spring.boot;
    requires spring.context;
    requires spring.data.jpa;

    requires static lombok;

}