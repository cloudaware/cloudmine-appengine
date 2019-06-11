[![Build Status](https://jenkins.cloudaware.com/buildStatus/icon?style=plastic&job=cloudmine-appengine%20deploy)](https://jenkins.cloudaware.com/job/cloudmine-appengine%20deploy)

# Build

`mvn clean package -Dappengine.app.id=yourproject -Dendpoints.service.version=2017-04-28r0`

Optionally 

* override API name completely with `-Dendpoints.service.name=yourapi.endpoints.yourproject.cloud.goog`
* disable service management for local development with `-Ddisable-service-management=true`
* use `WEB-INF/queue.xml` from other webapp directory, e.g. `-Dqueue.xml.webapp.dir=/otherproject/src/main/webapp`

# Dev Server

You should export following environment variables:
 
* `ENDPOINTS_SERVICE_NAME` - should be the same as `endpoints.service.name`
* `ENDPOINTS_SERVICE_VERSION` - should be the same as `endpoints.service.version`
* `ENDPOINTS_PROJECT_ID` - should be the same as `appengine.app.id`. Needed for service management

Optionally you might want to supply service account credentials (JSON file):

* `GOOGLE_APPLICATION_CREDENTIALS`

To start dev server:

`mvn clean package appengine:devserver -Dappengine.app.id=yourproject -Dendpoints.service.version=2017-04-28r0`

### Cloud Tasks Local Server (Emulator)

You can use your running dev server as local Cloud Tasks emulator.

Create Cloud Tasks API client as follows:

```java
    CloudTasks cloudTasks = new CloudTasks.Builder(
            GoogleNetHttpTransport.newTrustedTransport(),
            JacksonFactory.getDefaultInstance(),
            GoogleCredential.getApplicationDefault()
    ).setRootUrl(ROOT_URL).setApplicationName("your-application").build();
```
and execute `queues.tasks.create` call
```java
    Task response = cloudTasks.projects().locations().queues().tasks()
            .create(
                    parent,
                    new CreateTaskRequest().setTask(task)
            )
            .setKey(API_KEY)
            .setPrettyPrint(false)
            .execute();
```
For production environment use following constants:
```java
    public static final String ROOT_URL = "https://cloudtasks.googleapis.com/";
    public static final String API_KEY = "";
```
For local development use:
```java
    public static final String ROOT_URL = "http://localhost:9094/_ah/api/cloudtasks/";
    public static final String API_KEY = "{VALID_API_KEY}";
```
Create valid API Key in your Google Console - API Management - Credentials

When starting dev sever you should set `queue.xml.webapp.dir` property if you're using non-default queues. 

# Client Library

Client library built using [apis-client-generator](https://github.com/google/apis-client-generator)
 
Each successful build will leave following files and directoris:

* `cloudmine-appengine.json` - OpenAPI (Swagger) definition for Cloud Endpoints service management
* `disovery/*.discovery` - discovery documents for API Explorer and library generation

To build client library:

1. Build project
2. Execute `client/generate.sh`
3. `cd target/client`
4. `mvn versions:set -DnewVersion=2017-04-28r0`
5. `mvn package` or `mvn install`

# New API Version Deployment

1. Build project - you will create/update `cloudmine-appengine.json` in root folder 
2. `gcloud endpoints services deploy cloudmine-appengine.json`
3. Receive new API Version and update your `ENDPOINTS_SERVICE_VERSION` environment variable and `endpoints.service.version` property
4. `mvn clean package appengine:deploy -Dappengine.app.id=yourproject -Dendpoints.service.version=2017-05-02r0` (`2017-05-02r0` - is your new version)

# Changelog

* 1.0.10 - added support for cloudtask v2
* 1.0.9 - added support for cloudtask v2beta3
* 1.0.8 - change appengine-maven-plugin, readme actualized
* 1.0.7 - change google-api-client version
* 1.0.6 - eta fix
* 1.0.5 - scheduleTime format fix (allow milliseconds)
* 1.0.4 - deprecated refactoring
* 1.0.3 - Updated to latest CloudTasks version
* 1.0.2 - Added property `-Ddisable-service-management=true` to disable service management for local development
* 1.0.1 - Added property `queue.xml.webapp.dir`
* 1.0.0 - Initial release