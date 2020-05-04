# 📧 mailService

This is a simple PoC application to send emails without any hassle. It is written in Kotlin.

The templates are written in MJML (a framework that makes writing emails easy).
To bring logic and data in the emails, Thymeleaf is used.
The MJML.io API is used to convert the populated MJML templates to HTML.
Postmark is used to send them out.

## Technologies used
* Kotlin
* Spring Boot
* Thymeleaf


## How to use it
1. Clone this repository `git clone https://github.com/c0dr/mailService.git`
2. Get API tokens from https://mjml.io/api and https://postmarkapp.com/ and put them in the `application.properties`
3. With Java and maven installed, start the application with 
```terminal
mvn spring-boot:run
```
4 . Send a POST request to the application.

```json
curl -X POST \
  http://localhost:8080/send \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
	"recipient": "info@simon-schraeder.de",
	"templateName": "orderconfirmation",
	"subject": "Thank you for your order",
	"variables": {
		"firstname": "Simon",
		"lastname": "Schraeder"
	}
}'
```


## License
MIT 

