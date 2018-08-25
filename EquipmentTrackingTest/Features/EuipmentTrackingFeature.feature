Feature: Equipment Tracking Feature
				 user will be able to add, update, view data using this feature
				 
Scenario: user is trying to add record in Equipment record database

#When user tries to add a new record with valid details
#Then the new record should be added to the database
@Tag
Scenario: user is trying to view all records

When user give call to '/records' service
Then user should be able to view all Equipment records

Scenario: user is trying to view records by giving Equipment tag,userId,Location

When user give call to '/recordsbyEquipmentTag' service
Then user should be able to view all Equipment records for the given Equipment tag

When user give call to '/recordsbyUserId' service
Then user should be able to view all Equipment records for the given user Id

When user give call to '/recordsbyLocation' service
Then user should be able to view all Equipment records for the given Location