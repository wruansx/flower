package com.ly.train.flower.common.sample.condition;

import com.ly.train.flower.common.actor.ServiceFacade;
import com.ly.train.flower.common.service.ServiceFlow;
import com.ly.train.flower.common.service.containe.ServiceFactory;
import com.ly.train.flower.common.service.containe.ServiceLoader;

public class Sample {

  public static void main(String[] args) throws Exception {
    buildServiceEnv();

    ServiceFacade.asyncCallService("sample", "serviceA", "c");
  }

  public static void buildServiceEnv() {
    ServiceFactory.registerService("serviceA",
        "com.ly.train.flower.common.sample.condition.ServiceA");
    ServiceFactory.registerService("serviceB",
        "com.ly.train.flower.common.sample.condition.ServiceB");
    ServiceFactory.registerService("serviceC",
        "com.ly.train.flower.common.sample.condition.ServiceC");
    ServiceFactory.registerService("serviceE",
        "com.ly.train.flower.common.sample.condition.ServiceE");
    ServiceFactory.registerService("serviceD",
        "com.ly.train.flower.common.sample.condition.ServiceD");
    ServiceFactory.registerService("serviceF",
        "com.ly.train.flower.common.sample.condition.ServiceF");
    ServiceFactory.registerService("serviceG",
        "com.ly.train.flower.common.sample.condition.ServiceG");
    ServiceFactory.registerService("serviceCondition",
        "com.ly.train.flower.common.service.ConditionService;serviceF,serviceG");

    ServiceFlow.buildFlow("sample", "serviceA", "serviceB");
    ServiceFlow.buildFlow("sample", "serviceA", "serviceC");
    ServiceFlow.buildFlow("sample", "serviceC", "serviceD");
    ServiceFlow.buildFlow("sample", "serviceC", "serviceE");
    ServiceFlow.buildFlow("sample", "serviceE", "serviceCondition");
    ServiceFlow.buildFlow("sample", "serviceCondition", "serviceF");
    ServiceFlow.buildFlow("sample", "serviceCondition", "serviceG");

  }

}
