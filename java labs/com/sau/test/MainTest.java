package com.sau.test;

import com.sau.realestate.RealEstateListing;

public class MainTest {

    public static void main(String[] args) {

        RealEstateListing r1 = new RealEstateListing(
                303,
                6200000,
                "Connaught Place, New Delhi",
                2000
        );

        r1.display();
    }
}
