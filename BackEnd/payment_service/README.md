#About Payment Service
-we have added three payment services as a dummy services(bankAccount,credit card and paypal)
-if we want to pay money from any of the payment methods first it will validate that the given payment information is valid or not(like whether sufficient balance or not,expiry date,information)
-if information is not valid then it will show error message with status failure
-if it is valid then it will give transaction information with status success

#To verify and pay money from creditcard
--------------------------------------
POST: localhost:9004/api/v1/payments/creditcard

{
"customerId":8,
"cardNumber":"11111111",
"ccv":"1111",
"expiryDate":"2024-04-04",
"balance":30.0
}


#To verify and pay money from Paypal
--------------------------------------
POST: localhost:9004/api/v1/payments/paypal

{
"customerId":8,
"emailAddress":"giripriya@gmail.com",
"secureKey":"1111",
"balance":30.0

}

#To verify and pay money from bank account
--------------------------------------
POST: localhost:9004/api/v1/payments/bankaccount

{
"customerId":8,
"routingNumber":1111,
"bankAccountNumber":"11111111",
"emailAddress":"giripriya@gmail.com",
"balance":30.0,
"type":"CHECKING"
}

#To find information with transaction code
--------------------------------------
GET: localhost:9004/api/v1/payments/{transaction code}
eg//
GET: localhost:9004/api/v1/payments/P110

-if there is information with request transaction code then it will show data relate to that transaciton code
-if there is no information then it will show error message

#To delete all the data from the table
--------------------------------------
DELETE: localhost:9004/api/v1/payments

