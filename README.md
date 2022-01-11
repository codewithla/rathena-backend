# rathena-backend
### Table of Contents
1. [Prerequisites](#1-prerequisites)
2. [Installation](#2-installation)

## 1. Prerequisites
* Create the backend with spring-boot. https://start.spring.io/ 
* Dependencies: mariadb, devtools, jpa, spring web. 

### Hardware
Hardware Type | Developed On | Tested With
------|------|------|
CPU | 2 Core | N/A |
RAM | 8 GB | N/A |
Disk Space | 250 GB | N/A |

### Operating System & Preferred Compiler
Operating System | Compiler
------|------
Linux  | Java (11.0.13)
Linux  | Springboot (2.6.2)

### Required Applications
Application | Name
------|------
Database | [MariaDB 5 or newer](https://downloads.mariadb.org/)
Git | [Linux](https://git-scm.com/download/linux)

## 2. Installation 
### Full Installation Instructions

On snorlaxx-server, simply run the following:
````bash
mvnw clean install
mvnw spring-boot:run
````

Elsewhere, you will need to use maven to run your package.

# Setup steps
Databases on snorlaxx-server are locked down. Will need to tunnel.
````bash
ssh -p <ssh-port> -N -L <local-mysql-port>:localhost:<snorlaxx-mysqql-port> username@snorlaxx-server
````