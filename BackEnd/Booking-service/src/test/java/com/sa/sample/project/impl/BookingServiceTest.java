package com.sa.sample.project.impl;

import com.sa.sample.project.AbstractELibraryComponentTest;
import com.sa.sample.project.model.Booking;
import com.sa.sample.project.service.BookingHotelService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

//@Transactional // Enables any database operations to rollback after each testing
public class BookingServiceTest extends AbstractELibraryComponentTest {

    @Autowired
    private BookingHotelService bookingHotelService;

    @Before
    public void setUp() {
        logger.info("Booking Service Test started");
    }

    @After
    public void tearDown() {
        logger.info("Booking Service Test completed");
    }

    @Test
    public void testGetAllBookings() {
        List<Booking> bookings = bookingHotelService.findAll();
       // int expectedOutput = 0;
        Assert.assertNotNull("Failure: expected books to be not null", bookings);
        Assert.assertEquals("Failure: expected size", bookings.size(), bookings.size());
        logger.info("Booking list data: " + Arrays.toString(bookings.toArray()));
    }

    @Test
    public void testGetBookingById() {
        String bookId = "62a59e285e30d468b7223032";
        Booking booking = bookingHotelService.findById(bookId);
        Assert.assertNotNull("Failure: expected book to be not null", bookId);
        Assert.assertEquals("Failure: expected bookId to match", bookId, booking.getBookingId());
        logger.info("Booking data: " + booking);
    }
/*
    @Test
    public void testGetBookByIdForInvalidId() {
        Integer bookId = Integer.MAX_VALUE;
        Book book = bookService.getBookById(bookId);
        Assert.assertNull("Failure: expected null", book);
        logger.info("Book data: " + book);
    }

    @Test
    public void testSaveBook() {
        Book newBook = new Book("978-0000000002", "New Book Title",
                1.05, "Apress",
                LocalDate.of(2011,9,13));
        Book savedBook = bookService.saveBook(newBook);
        Assert.assertNotNull("Failure: expected not null", savedBook);
        Assert.assertNotNull("Failure: expected bookId to be not null", savedBook.getBookId());
        Assert.assertEquals("Failure: expected book title match", "New Book Title", savedBook.getTitle());
        List<Book> books = (List<Book>)bookService.getAllBooks();
        Assert.assertEquals("Failure: expected size", 7, books.size());
        logger.info("Books list data: " + Arrays.toString(books.toArray()));
    }

    @Test
    public void testDeleteBookById() {
        Integer bookId = new Integer(1);
        Book book = bookService.getBookById(bookId);
        Assert.assertNotNull("Failure: expected book to be not null", book);
        bookService.deleteBookById(bookId);
        List<Book> books = (List<Book>)bookService.getAllBooks();
        Assert.assertEquals("Failure: expected size", 5, books.size());
        Book deletedBook = bookService.getBookById(bookId);
        Assert.assertNull("Failure: expected deletedbook to be null since is supposed to have been deleted", deletedBook);
    }
*/
    /* Execute unit-tests via maven on cmdline: mvn clean package */
    /* Execute package only without unit-tests via maven on cmdline:
    /* mvn clean package -DskipTests */
}
