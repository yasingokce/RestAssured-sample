package models;

public class Booking {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDates bookingdates,
            String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    // for De-Serilization
    public Booking() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    /*
     * curl -X POST \
     * https://restful-booker.herokuapp.com/booking \
     * -H 'Content-Type: application/json' \
     * -d '{
     * "firstname" : "Jim",
     * "lastname" : "Brown",
     * "totalprice" : 111,
     * "depositpaid" : true,
     * "bookingdates" : {
     * "checkin" : "2018-01-01",
     * "checkout" : "2019-01-01"
     * },
     * "additionalneeds" : "Breakfast"
     * }'
     */

}
