# Motive-Team-A-Group-Exercise

Group GitHub Exercise for COSC499
---

---
<h3>Dependencies</h3>

* Java 17
* [Docker](https://docs.docker.com/engine/install/)
* [Docker Compose](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04)
* Maven `sudo apt-get install maven`

If I missed anything during the set-up and you required something else to run it - add it here!

---

<h3>Local Development</h3>

Run
```
mvn spring-boot:run 
```

Run Tests
```
mvn clean test
```

---
I've added basic docker-compose.yml if we want to add some other containers for fun to use in local dev for the exercise.
```
mvn clean package
docker-compose up --build

# or
./app.sh run
```
Check if it is up
```
curl --location --request GET 'http://localhost:8010/actuator/health'
```

---

<h3>A note about local Dev</h3>

Master is protected, but to prevent further commits locally I added a hook to be tracked that enables some custom hooks
like preventing commits to master.

Run the following to enable.
```
./app.sh setup-hooks
```

If anyone wants to combine it all into a set-up script and simplify this, feel free!
