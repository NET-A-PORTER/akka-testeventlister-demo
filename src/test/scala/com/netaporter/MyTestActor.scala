package com.netaporter

import akka.actor.{ActorLogging, Actor}
import scala.concurrent.duration._

class MyTestActor extends Actor with ActorLogging {

  import context.dispatcher

  def receive = {
    case 'Crash => scheduler.scheduleOnce(100.millis)(log.error("Crash"))
  }

  def scheduler = context.system.scheduler
}