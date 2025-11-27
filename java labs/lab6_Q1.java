public class lab6_Q1 {

    public static void main(String[] args) {

        RealEstateListing r1 = new RealEstateListing(
                101,
                5500000,
                "MG Road, Bengaluru",
                1800
        );

        r1.display();
    }
}

class RealEstateListing {

    private int listingNumber;
    private double price;
    private HouseData houseData;

    public RealEstateListing(int num, double price, String address, int sqFt) {
        listingNumber = num;
        this.price = price;
        houseData = new HouseData(address, sqFt);
    }

    public void display() {
        System.out.println("Listing number #" + listingNumber +
                " Selling for ₹" + price);
        System.out.println("Address: " + houseData.streetAddress);
        System.out.println(houseData.squareFeet + " square feet");
    }

    private class HouseData {
        private String streetAddress;
        private int squareFeet;

        public HouseData(String address, int sqFt) {
            streetAddress = address;
            squareFeet = sqFt;
        }
    }
}
