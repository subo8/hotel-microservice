~## User service

### Signup and Signin user with different roles, after successfully sign in with registered user, system response will be session contains JWT tokens

#### First you need to create roles collection in mongodb

```
Open you terminal type following command:

1. mongosh
2. use user_DB
3. db.roles.insertMany([
   { name: "ROLE_USER" },
   { name: "ROLE_MODERATOR" },
   { name: "ROLE_ADMIN" },
])
```

### Endpoints

#### You can use Swagger or Postman
##### http://localhost:8080/swagger-ui/index.html#/

### Sign up
##### Role field is not mandatory you can leave it as a blank default will be User role or choose more than one roles
~~~
POST http://localhost:8080/api/v1/auth/signup
Content-Type: application/json

Roles: ["admin", "mod", "user"]

{
    "username": "super",
    "password": "test123",
    "email": "super@gmail.com",
    "roles": ["admin", "mod", "user"]
}
{
    "username": "user",
    "password": "test123",
    "email": "user@gmail.com",
    "roles": ["user"]
}
{
    "username": "moderator",
    "password": "test123",
    "email": "moderator@gmail.com",
    "roles": ["mod"]
}
~~~

### Sign in
~~~
POST http://localhost:8080/api/v1/auth/signin
Content-Type: application/json

{
    "username": "user",
    "password": "test123"
}
~~~

## Test authorization
### Allowed for all users

~~~
GET http://localhost:8080/api/test/all
Content-Type: application/json
~~~
### Allowed for only users
~~~
GET http://localhost:8080/api/test/user
Content-Type: application/json
~~~
### Allowed for only admin
~~~
GET http://localhost:8080/api/test/admin
Content-Type: application/json
~~~
### Allowed for only moderator
~~~
GET http://localhost:8080/api/test/mod
Content-Type: application/json
~~~


