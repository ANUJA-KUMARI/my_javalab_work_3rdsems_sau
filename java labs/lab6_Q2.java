public class lab6_Q2 {

    public static void main(String[] args) {

        RealEstateListing outer = new RealEstateListing(
                202,
                7500000,
                "Airport Road, Pune",
                2500
        );

        // Creating inner class object using outer object
        RealEstateListing.HouseData inner = outer.new HouseData(
                "FC Road, Pune",
                1200
        );

        // Displaying inner class manually (not allowed directly by display())
        System.out.println("Manually created Inner Class Object:");
        System.out.println("Address: " + inner.streetAddress);
        System.out.println("Square Feet: " + inner.squareFeet);
    }
}

class RealEstateListing {

    private int listingNumber;
    private double price;

    class HouseData {
        String streetAddress;
        int squareFeet;

        HouseData(String address, int sqFt) {
            streetAddress = address;
            squareFeet = sqFt;
        }
    }

    public RealEstateListing(int num, double price, String address, int sqFt) {
        this.listingNumber = num;
        this.price = price;
    }
}
