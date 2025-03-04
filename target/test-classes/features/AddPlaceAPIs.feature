Feature: Validating Place API's
@AddPlace
Scenario Outline:
Given Add place payload with "<name>" "<address>" "<language>"
When User calls "AddplaceAPI" with "POST" Http request
Then Status code is 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And  User calls "GetplaceAPI" with "GET" Http request
And  Using placeid verify the "name" is equals to "<name>"
Examples:
|name|address|language|
|Jesus|address1|English|
|Mathi|address2|Tamil|
#|Madhu|address3|Telugu|

@DeletePlace
Scenario: Verify DeleteplaceAPI

Given Setup Delete Payload
When User calls "DeleteplaceAPI" with "POST" Http request
Then Status code is 200
And "status" in response body is "OK"
And  User calls "GetplaceAPI" with "POST" Http request
#And  Using placeid verify the "msg" is equals to message"Get operation failed, looks like place_id  doesn't exists"

