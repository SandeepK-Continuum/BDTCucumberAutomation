Feature: As a user I can check server information for Sites on QuickAccess Page 
so that I can monitor server health
 
@Quick_Access
Scenario Outline: Verify Server information on Quick Access Page

 Given User can Login to ITS portal "<EmailId>" and  "<Password>"
 And   User can navigate to Quick Access Page
 When  User should navigate to QuickAccess->Site -> Server
 Then  Validate total server count
 And   Validate details of server table from Datasheet "<DataSheet>"

  Examples: 
 |      EmailId                |  Password  |DataSheet     |
 | automationBDD@continuum.net |  Abc@12345 |ServerInfo.xls|