package com.netaporter

import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, EventFilter, TestKit}
import org.scalatest.{OneInstancePerTest, BeforeAndAfterAll, WordSpecLike}

class PassingTest
  extends TestKit(ActorSystem("MyActorTest"))
  with WordSpecLike
  with BeforeAndAfterAll
  with OneInstancePerTest {

  override def afterAll() {
    system.shutdown()
  }

  "MyActor" should {
    "crash twice" in {
      val actor = TestActorRef(new MyTestActor)
      actor ! 'Crash
      actor ! 'Crash
    }

    "crash once" in {
      val actor = TestActorRef(new MyTestActor)
      EventFilter.error(message = "Crash", occurrences = 1) intercept {
        actor ! 'Crash
      }
    }
  }
}
