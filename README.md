# Spring Boot todo 

#### REST API with Spring Security OAuth2

To run this repo, please follow these command :

1. Paste this command to your terminal

    `mvn clean spring-boot:run`
2. Launch POSTMAN to generate TOKEN
   curl --location --request POST 'http://localhost:8081/oauth/token' <br />
	--header 'Content-Type: application/x-www-form-urlencoded' <br />
	--header 'Accept: application/json' <br />
	--header 'Authorization: Basic YWZmYW4tY2xpZW50OmFmZmFuLXNlY3JldHM=' <br />
	--data-urlencode 'username=dummy' <br />
	--data-urlencode 'password=password' <br />
	--data-urlencode 'grant_type=password'<br />

    ![Authorization Tab](image/get_token_auth.png "Authorization Tab")

    ![Header Tab](image/get_token_header.png "Header Tab")

    ![Body Tab](image/get_token_body.png "Body Tab")

3. Accessing without Token
   curl --location --request GET 'http://localhost:8081/notes/list'<br />
    ![Accessing without Token](image/noauth.png "Accessing without Token")

4. Accessing Resource With Token

	curl --location --request POST 'http://localhost:8081/notes/create' <br />
	curl --location --request GET 'http://localhost:8081/notes/list' <br />
	curl --location --request PUT 'http://localhost:8081/notes/update/{id}'<br />
	curl --location --request DELETE 'http://localhost:8081/notes/delete/{id}'<br />
	--header 'Authorization: Bearer {token}'<br />
    ![Accessing Resource with Token](image/list.png "Accessing Resource with Token")