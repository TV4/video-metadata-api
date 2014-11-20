# Video Metadata API

Video Metadata API is and XML/REST'ish API to communicate video metadata to and from the EMP platform.
Louise/Metabanken (or other sources) send metadata to EMP. Metadata is enriched in EMP and sent to other following systems. E.g., search engine.

Key concept is the separation between content and the publish/schedule. 
Content is detached and independent from the publication and scheduling of the content.

Request **MUST** be over **HTTPS** (strict HTTPS).
Authentication/authorisation is communicated via the `x-api-key` header. (Format of x-api-key to be defined. Alternativees are: basic auth, simple random nonce, or JWT token)

The api will support versioning and multiple versions can co-exsist on the same host. THus the version is in the URL path.
E.g., test URL: https://emp-test.tv4.se/video-metadta-api/v1/contents

# Receiver API Endpoints

## Content [/contents]

### POST

The request body **MUST** be a valid [XML] according to the schemas defined: api-message.xsd(which contains the data: content.xsd, schedule.xsd, publish.xsd).

+ Request (application/xml)
  + Headers
    X-Api-Key: topsecret123
  + Body
    <code>&lt;content-metadata&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd)
	
+ Responses (All responses are returned with Content-Type application/xml and a <code>&lt;response&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd))
  + 202 If everything went well
  + 400 If the XML in the request body is malformed
  + 401 If the user making the request is unathorized
  + 403 If the user making the request lacks sufficient rights to perform the action

### DELETE
Not supported in first version, no requirement

## Publish [/schedule]

### POST

+ Request (application/xml)
  + Headers
    X-Api-Key: topsecret123
  + Body
  <code>&lt;schedule-metadata&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd)

+ Responses (All responses are returned with Content-Type application/xml and a <code>&lt;response&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd))
  + 202 If everything went well
  + 400 If the XML in the request body is malformed
  + 401 If the user making the request is unathorized
  + 403 If the user making the request lacks sufficient rights to perform the action
	
### DELETE
Not supported, no requirement
	
## Publish [/publish]

### POST

+ Request (application/xml)
  + Headers
    X-Api-Key: topsecret123
  + Body
  <code>&lt;publish-metadata&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd)

+ Responses (All responses are returned with Content-Type application/xml and a <code>&lt;response&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd))
  + 202 If everything went well
  + 400 If the XML in the request body is malformed
  + 401 If the user making the request is unathorized
  + 403 If the user making the request lacks sufficient rights to perform the action
	
### DELETE
Not supported, in first version.
Current version of Louise can not make a differense between a delete and change of publication from/to date/time.

# Sender API Endpoints (optional)

## Query [/query]

### POST

+ Request (application/xml)
  + Headers
    X-Api-Key: topsecret123
  + Body
      <code>&lt;querya&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd)

	
+ Response 200 (application/xml)
 	<code>
	&lt;response&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd)
	</code>
	
# General internal endpoints

## Content [/__status] 

General method that will report that the service is alive and kicking and the status of dependencies. E.g., other services, database, ...

### GET

+ Request (application/xml)
  + Headers
    X-Api-Key: topsecret123
  + Body
	To be defined... *<xsd:anyType>* _or_ any JSON 
	
+ Response 200 (application/xml)
	<code>
	&lt;status-response&gt;</code> message as defined in [api-messages.xsd](../src/main/xsd/api-messages.xsd)
	</code>
	