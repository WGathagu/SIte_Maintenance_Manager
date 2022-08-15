# Site_Maintenance_Manager
#### Site_Maintenance_Manager Independent Project, 15/08/2022.
#### By **Wangari Gathagu**
## Description
Welcome to my Site Maintenance Manager Project.

You can access the repository here:
https://github.com/WGathagu/Site_Maintenance_Manager

The functionalities include;
* Register Engineers
* View Engineers and Sites
* Add/Remove Sites to Engineer
* Update Engineer records

## Setup/Installation Requirements
* Clone the project and open it using IntelliJ IDEA
* Below are the database details
In PSQL:
CREATE DATABASE site_maintenance;
CREATE TABLE engineer (id serial PRIMARY KEY, name varchar, email varchar, site_name varchar, hire_date timestamp);
CREATE TABLE sites (id serial PRIMARY KEY, name varchar, engineerID int);
## Known Bugs
No Known Bugs
## Technologies Used
Java, Gradle, IntelliJ IDEA, Postgres
## Support and contact details
Contact rachealkari@gmail.com if you run into any issues or have questions, ideas or queries or if you want to or make a contribution to the code
### License
*This project is licensed under the terms of the MIT license.*
Copyright (c) 2022 **WGathagu**
