# Blog Test

A Blog made with Java Spring Boot, Vue and Tailwind CSS

## Requirements
Java 8
MongoDB

Vue frontend is already build, for a new build Node 16.3.1 and NPM 8.1.2 are needed.

## Installation

run mvn clean package at the project root.

```bash
mvn clean package
```
This will create a blogapp.jar file on target/ directory, with frontend files included.

if a new build for the Vue frontend is needed, go to src/front directory and run
```bash
npm run build 
``` 
this will create the static files into dist/.

## Usage
From the project root, run

```bash
java -jar target/blogapp.jar
```
The blog can then be accessed from http://localhost:8080/.

The app will try using another port if 8080 is not available. At current version, the frontend is hardcoded to make API requests into port 8080.


## License
[MIT](https://choosealicense.com/licenses/mit/)
