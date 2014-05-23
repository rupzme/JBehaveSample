Scenario:  service should return default service info
 
Given a RESTFul web service located at http://localhost:8080/SalesOrderEntityService/RestIdUtilityServiceV1/identityservice/
When a GET request is made to resource info for application/xml
Then the expected response is <?xml version="1.0" encoding="UTF-8" standalone="yes"?><ns2:StructureServiceInformation xmlns:ns2="http://schemas.tpplc.com"><ns2:Name>IDENTITY_SERVICE</ns2:Name><ns2:Version>V1</ns2:Version><ns2:Description>Use me to get unique ID's by the bucketload.</ns2:Description></ns2:StructureServiceInformation>