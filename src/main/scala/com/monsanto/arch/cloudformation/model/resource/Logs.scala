package com.monsanto.arch.cloudformation.model.resource

import com.monsanto.arch.cloudformation.model.{ConditionRef, Token}
import spray.json.{DefaultJsonProtocol, JsonFormat}

/**
  * Create a logs destination.
  * {
  *   "Type" : "AWS::Logs::Destination",
  *   "Properties" : {
  *     "DestinationName" : String,
  *     "DestinationPolicy" : String,
  *     "RoleArn" : String,
  *     "TargetArn" : String
  *   }
  * }
  * 
  * http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-logs-destination.html
  */
case class `AWS::Logs::Destination`(
    name: String,
    DestinationName: String,
    DestinationPolicy: Token[String],
    RoleArn: Token[String],
    TargetArn: Token[String],
    override val Condition: Option[ConditionRef] = None,
    override val DependsOn: Option[Seq[String]] = None
) extends Resource[`AWS::Logs::Destination`] {
  def when(newCondition: Option[ConditionRef] = Condition) =
    copy(Condition = newCondition)

}

object `AWS::Logs::Destination` extends DefaultJsonProtocol {
  implicit val format: JsonFormat[`AWS::Logs::Destination`] = jsonFormat7(
    `AWS::Logs::Destination`.apply)
}

/**
  * Add a logs subscription filter.
  * 
  * {
  *   "Type" : "AWS::Logs::SubscriptionFilter",
  *   "Properties" : {
  *     "DestinationArn" : String,
  *     "FilterPattern" : String,
  *     "LogGroupName" : String,
  *     "RoleArn" : String
  *   }
  * }
  * http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-logs-subscriptionfilter.html
  */
case class `AWS::Logs::SubscriptionFilter`(
                                            name: String,
                                            DestinationArn: Token[String],
                                            FilterPattern: String,
                                            LogGroupName: String,
                                            RoleArn: Option[Token[String]] = None,
                                            override val Condition: Option[ConditionRef] = None,
                                            override val DependsOn: Option[Seq[String]] = None
                                          ) extends Resource[`AWS::Logs::SubscriptionFilter`] {
  def when(newCondition: Option[ConditionRef] = Condition) =
    copy(Condition = newCondition)

}

object `AWS::Logs::SubscriptionFilter` extends DefaultJsonProtocol {
  implicit val format: JsonFormat[`AWS::Logs::SubscriptionFilter`] = jsonFormat7(
    `AWS::Logs::SubscriptionFilter`.apply)
}
