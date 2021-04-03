# Notifyman

[Java Docs](https://notifyman.tarsolution.com/javadoc) | [Source Code](https://github.com/tarsolution/notifyman) | [Issues](https://github.com/tarsolution/notifyman/issues) | [Plugin Development](https://shared-lib.notifyman.tarsolution.com/)

## Purpose

Our goal is to create a notification service that you can use with any project, the service will provide send your notifications to a lot of target protocols for you and create a detailed report for these. Generates metrics from a lot of points for monitorings when it does the tasks, provide customization for user self about take notification types and a lot of features.

## Intended Use

Big project ecosystems or companies need to send a notification to clients but this is a hard and complex job. Because we have to request a permit from our clients for these notification types and our clients should be able to easily change their permits. Also, there is our need for monitoring these notifications, for example, did our notification arrive? or what are notifications counts or state? we develop this project for solutions to all these problems.

# Overall Description

## User Needs
* Easy setup 
* Simple and useful
* Full integration with standard protocols
* Modularity
* Scalability
* Customizable
* Support plugin
* Support different target channel
* Support different source channel
* Quickly configurable
* Support more than one different configuration same time
* Configurations activate  instant for without restart
* Minimum source needs

# Requirements

* Have a Rest API Interface for all features
* Support Kafka, MQTT, AMQP, Websocket, HTTP for notification send
* Administration of notification channel permit  for clients
* Support OAuth2 protocol for SSO
* Embed page for client manage its permit
* Support Email, Telegram Bot, Whatsapp Bot, Internal Notification, Webhook, Skype, Discord
* Ability to save notification
* Prometheus metrics are grouped by notification channel and receiver, these metrics are number of notification, number of error, number of success
* Support more than one notification type and dynamically generate from UI
* Each user can customize the access channels according to the notification types for itself
* Customize notification template on the UI for each type and channels
* default a configuration for all users
* Generate a temporary link of accepting for notification private for the user
* Generate a temporary link of dismissing for notification private for the user
* Use PostgreSQL as a database
* It supports third-party extensions for UI theme, Outbound, Inbound, Metrics
* It has the following built-in extensions

### Extensions 
#### Theme
 * Default
#### Inbound
 * Kafka 
 * MQTT
 * AMQP
 * WebSocket
 * HTTP
 * WebHook
#### Outbound
 * Email
 * Telegram
 * Skype
 * Whatsapp
 * WebHook
 * Internal Notifcation
 * Discord
#### Metrics
 * Prometheus
 * Postgresql
