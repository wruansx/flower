package com.ly.train.flower.common.sample.Supervisor;

import com.ly.train.flower.common.actor.ServiceFacade;
import com.ly.train.flower.common.sample.akka.FaultHandlingTest;
import com.ly.train.flower.common.util.EnvBuilder;

import java.util.concurrent.TimeoutException;

public class Sample {

  public static void main(String[] args) throws Exception {
    EnvBuilder.buildEnv(Sample.class);
    {
      Message2 m2 = new Message2(10000, "Zhihui");
      Message1 m1 = new Message1();
      m1.setM2(m2);
      try {
        System.out.println(ServiceFacade.syncCallService("supervisor", "SupervisorService1", m1));
      } catch (TimeoutException e) {
        e.printStackTrace();
      }
    }

    Thread.sleep(2000);
    System.out.println("20000");
    {
      Message2 m2 = new Message2(10, "Zhihzzzzui");
      Message1 m1 = new Message1();
      m1.setM2(m2);

      try {
        System.out.println(ServiceFacade.syncCallService("supervisor", "SupervisorService1", m1));
      } catch (TimeoutException e) {
        e.printStackTrace();
      }    }
    System.out.println("30000");
    FaultHandlingTest.main(new String[]{""});
    ServiceFacade.shutdown();
  }

}
