package com.company.entities;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.company.entities.DriverLicense.Category.A;
import static com.company.entities.DriverLicense.Category.B;
import static org.junit.Assert.*;

/**
 * Created by Viktoriia_Marynchak on 9/26/2016.
 */
public class RouteTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNegative() {
        GasolineCar gasolineCar = new GasolineCar("BMW", "7", "123", A, 20, 200, GasolineCar.Transmission.AUTOMATIC);

        Calendar calendar = Calendar.getInstance();
        calendar.set(1996, Calendar.DECEMBER, 10);
        Date birthDate = calendar.getTime();
        Human human = new Human("John", birthDate, Human.Gender.MALE, Human.BloodGroup.FIRST);
        List<DriverLicense.Category> categories = new ArrayList<DriverLicense.Category>(){{add(B); }};
        calendar.set(2000, Calendar.DECEMBER, 10);
        Date fromDate = calendar.getTime();
        calendar.set(2020, Calendar.DECEMBER, 10);
        Date expires = calendar.getTime();
        DriverLicense driverLicense = new DriverLicense(expires, categories, fromDate);
        Driver driver = new Driver(human, driverLicense);

        String from = "N";
        String where = "M";

        Route route = new Route(gasolineCar, driver, from, where);

    }

}