#!/bin/bash

APP_NAME=blue-world-app
BASE=src/main

mkdir -p $APP_NAME/$BASE/java/com/blueworld/{config,controller,model,repository,service}
mkdir -p $APP_NAME/$BASE/resources/{templates,static/css}
mkdir -p $APP_NAME/$BASE/webapp/META-INF

touch $APP_NAME/pom.xml
touch $APP_NAME/$BASE/java/com/blueworld/BlueWorldApplication.java
touch $APP_NAME/$BASE/java/com/blueworld/config/DynamoDBConfig.java
touch $APP_NAME/$BASE/java/com/blueworld/controller/AuthController.java
touch $APP_NAME/$BASE/java/com/blueworld/model/User.java
touch $APP_NAME/$BASE/java/com/blueworld/repository/UserRepository.java
touch $APP_NAME/$BASE/java/com/blueworld/service/UserService.java
touch $APP_NAME/$BASE/resources/application.properties
touch $APP_NAME/$BASE/resources/templates/{login.html,register.html,welcome.html}
touch $APP_NAME/$BASE/resources/static/css/style.css
touch $APP_NAME/$BASE/webapp/META-INF/context.xml

echo "✅ Project structure created successfully"

