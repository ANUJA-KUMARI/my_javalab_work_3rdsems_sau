 
// Abstract Class
abstract class PhoneCall {
    protected String phoneNumber;
    protected double price;

    // Constructor
    public PhoneCall(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.price = 0.0;
    }

    // Setter
    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract methods
    public abstract String getPhoneNumber();
    public abstract double getPrice();
    public abstract void displayCallInfo();
}

// Child class: IncomingPhoneCall
class IncomingPhoneCall extends PhoneCall {
    private static final double RATE = 0.02;

    // Constructor
    public IncomingPhoneCall(String phoneNumber) {
        super(phoneNumber);
        setPrice(RATE);
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void displayCallInfo() {
        System.out.println("Incoming Phone Call");
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Rate: $" + RATE);
        System.out.println("Price: $" + price);
        System.out.println("---------------------------------");
    }
}

// Child class: OutgoingPhoneCall
class OutgoingPhoneCall extends PhoneCall {
    private static final double RATE_PER_MIN = 0.04;
    private int time; // minutes

    // Constructor
    public OutgoingPhoneCall(String phoneNumber, int time) {
        super(phoneNumber);
        this.time = time;
        setPrice(RATE_PER_MIN * time);
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void displayCallInfo() {
        System.out.println("Outgoing Phone Call");
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Rate per Minute: $" + RATE_PER_MIN);
        System.out.println("Minutes: " + time);
        System.out.println("Total Price: $" + price);
        System.out.println("---------------------------------");
    }
}

// Demo class
public class lab5 {
    public static void main(String[] args) {
        // Create Incoming call object
        PhoneCall incoming = new IncomingPhoneCall("9876543210");

        // Create Outgoing call object
        PhoneCall outgoing = new OutgoingPhoneCall("9123456780", 10);

        // Display info
        incoming.displayCallInfo();
        outgoing.displayCallInfo();
    }
}
