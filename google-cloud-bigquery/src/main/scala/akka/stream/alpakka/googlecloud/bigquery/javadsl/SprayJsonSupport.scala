/*
 * Copyright (C) 2016-2020 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.stream.alpakka.googlecloud.bigquery.javadsl

import akka.http.javadsl.unmarshalling.Unmarshaller
import akka.stream.alpakka.googlecloud.bigquery.client.ResponseJsonProtocol
import akka.stream.alpakka.googlecloud.bigquery.scaladsl.{SprayJsonSupport => ScalaJsonSupport}
import akka.util.ByteString
import spray.json.JsValue

object SprayJsonSupport extends {

  def jsValueUnmarshaller: Unmarshaller[ByteString, JsValue] = {
    ScalaJsonSupport.sprayJsValueUnmarshaller.asInstanceOf[Unmarshaller[ByteString, JsValue]]
  }

  def responseUnmarshaller: Unmarshaller[JsValue, ResponseJsonProtocol.Response] = {
    import ResponseJsonProtocol._
    ScalaJsonSupport.fromJsValueUnmarshaller[Response]
  }

}
