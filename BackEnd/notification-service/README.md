## Instructions for Kafka Listener ##

    - Endpoint: localhost:8100/api/v1/producer

    - JSON Object:

    {
    "customerName": "Samuel",
    "customerPhoneNumber": "675-3456-2456",
    "email": "samuel@outlook.com",
    "typeOfPayment": "Credit Card",
    "address": "1000 North 4St, MIU",
    "roomType": "Double",
    "price": "$34.50"
    }

    - If everything goes fine you should see this output:

    2022-06-11 01:34:34.593  INFO 33060 --- [ntainer#0-0-C-1] c.m.e.c.p.n.messaging.KafkaTestListener  : The Payment has been made successfully!
    2022-06-11 01:34:34.594  INFO 33060 --- [ntainer#0-0-C-1] c.m.e.c.p.n.messaging.KafkaTestListener  : Information of the customer is:
    Name: Samuel
    Phone Number: 675-3456-2456
    Email: samuel@outlook.com
    Type of Payment: Credit Card
    Address: 1000 North 4St, MIU
    Type of room: Double
    Price $34.50
    Booking Date: 2022-06-11

## Requirements ##

    - To test it out, follow the steps of this link: https://kafka.apache.org/quickstart