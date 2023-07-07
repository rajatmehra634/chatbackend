# chatbackend
Steps to run the SpringBoot Application:

1. Clone the code in your local system with below command:
  - git clone https://github.com/rajatmehra634/chatbackend.git

2. Sign in to https://openai.com/ and create API reference key.

3. Save that OPENAI key to be used in springboot applications.properties file.

4. After updating the OPENAI key in application.properties file, run the maven build command as below:
     - mvn clean install

5. Check the target folder and run the jar file from your local machine with below command:
     - java -jar demo-0.0.1-SNAPSHOT.jar

6. Try to access http://localhost:8080/app/turboModelData link to see if the server is up and fetching the data.

