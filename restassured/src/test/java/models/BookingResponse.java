package models;

public class BookingResponse {

    private int bookingid;
    private Booking booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    /*
     * HTTP/1.1 200 OK
     * 
     * {
     * "bookingid": 1,
     * "booking": {
     * "firstname": "Jim",
     * "lastname": "Brown",
     * "totalprice": 111,
     * "depositpaid": true,
     * "bookingdates": {
     * "checkin": "2018-01-01",
     * "checkout": "2019-01-01"
     * },
     * "additionalneeds": "Breakfast"
     * }
     * }
     */

}
