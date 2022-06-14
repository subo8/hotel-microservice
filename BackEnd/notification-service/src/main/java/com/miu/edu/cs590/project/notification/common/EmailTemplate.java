package com.miu.edu.cs590.project.notification.common;

public class EmailTemplate {

    private static final String NEWLINE = "<br></b>";

    public static String createTextEmail(InformationTest informationTest) {

        StringBuilder sb = new StringBuilder("Dear ").append(informationTest.getCustomerName())
                .append(" your reservation has been made successfully. The information of your reservation is the following:").append(NEWLINE)
                .append("We have added your phone number ").append(informationTest.getCustomerPhoneNumber()).append(" and your email ").append(informationTest.getEmail())
                .append(" in our database to offer future services.").append(NEWLINE)
                .append("The information of your payment is:").append(NEWLINE)
                .append("The type of payment you have chosen is ").append(informationTest.getTypeOfPayment()).append(" with address ").append(informationTest.getAddress()).append(".").append(NEWLINE)
                .append("You have chosen a ").append(informationTest.getRoomType()).append(" room and the cost is ").append(informationTest.getPrice()).append(".").append(NEWLINE)
                .append("It is a pleasure for us to have you as a guest in out Hotel and we hope everything is to your liking.").append(NEWLINE)
                .append("If you have questions, please do not hesitate to contact us through our customer service at 641-2345-1231.")
                .append("<br><img src=\"https://www.freepnglogos.com/uploads/hotel-logo-png/download-building-hotel-clipart-png-33.png\" width=\"200\" alt=\"download building hotel clipart png\" /></a><br><b>Best Regards</b>");
        return sb.toString();
    }

}
