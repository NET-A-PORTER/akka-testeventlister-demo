package com.netaporter

import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, EventFilter, TestKit}
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

class FailingTest
  extends TestKit(ActorSystem("MyActorTest"))
  with WordSpecLike
  with BeforeAndAfterAll {

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