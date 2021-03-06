# Description
Food ordering app that allows Restaurants to add and update menus, and clients to order from the menu and track their orders for delivery and/or collection. Additionally, the app should allow clients to make a pre-booking for when they want to dine at the restaurant, so that the restaurant start to cook the food in time in anticipation of the arrival of client. Key outputs/requirements: Source Code and Design for the Backend, Rider App, Web app, and Client App in Ionic Web Framework using Capacitor to generate the mobile artefacts. Also a cloud deployment strategy for this app and the publishing to Google Play Store and iOS.

# General representation
this project will have 3 main classes:
*   client : for all the authentication - authorization 
*   menu : regroups the food of the restaurent
*   orders : to make orders
![alt text](https://github.com/WalidRH/foodOrdering/blob/workingBranch/src/main/resources/GeneralRepresentation.jpg)

# layers of the project
the project will be devided into 5 layers.
![alt text](https://github.com/WalidRH/foodOrdering/blob/workingBranch/src/main/resources/layers.png)

# Environement Setup
After a git clone, 
* create a database with a name " food_ordering " and import the " database.sql " file.
* check the propertie file; your environment should be pointed to localhost at first. Something like:
```properties

 spring.datasource.url=jdbc:mysql://localhost:3306/food_ordering?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

```

 
