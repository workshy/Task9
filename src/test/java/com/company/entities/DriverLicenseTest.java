package com.company.entities;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.company.entities.DriverLicense.*;
import static com.company.entities.DriverLicense.Category.*;
import static org.junit.Assert.*;

/**
 * Created by Viktoriia_Marynchak on 9/26/2016.
 */
public class DriverLicenseTest {
    private static List<DriverLicense.Category> categories =
            new ArrayList<DriverLicense.Category>() {{ add(A); add(B); add(C); add(D); add(E);}};
    private static List<Category> cat = new ArrayList<Category>();
    private static Calendar cal = Calendar.getInstance();


    @Test
    public void testCategoriesPositive(){
        cat.add(A);
        cat.add(B);

        Assert.assertTrue(categories.retainAll(cat));

    }

    @Test
    public void testCategoriesNegative(){
        cat = new ArrayList<Category>();
        Assert.assertTrue(cat.isEmpty());
    }

    @Test
    public void testFromDatePositive(){
        cal.set(2010, Calendar.DECEMBER, 10);
        cal.add(Calendar.YEAR, 10);

        Date fromDate = cal.getTime();
        Date currentDate = new Date();

        Assert.assertTrue(fromDate.after(currentDate));
    }

    @Test
    public void testFromDateNegative(){
        cal.set(2000, Calendar.DECEMBER, 10);
        cal.add(Calendar.YEAR, 10);

        Date fromDate = cal.getTime();
        Date currentDate = new Date();

        Assert.assertTrue(fromDate.before(currentDate));
    }

    @Test
    public void testExpiresPositive(){
        cal.set(2000, Calendar.DECEMBER, 10);
        cal.add(Calendar.YEAR, 10);

        Date fromDate = cal.getTime();

        cal.set(2020, Calendar.DECEMBER, 10);
        cal.add(Calendar.YEAR, 10);

        Date expires = cal.getTime();

        Date currentDate = new Date();

        Assert.assertTrue(expires.after(fromDate));
    }

    @Test
    public void testExpiresNegative(){
        cal.set(2010, Calendar.DECEMBER, 10);
        cal.add(Calendar.YEAR, 10);

        Date fromDate = cal.getTime();

        cal.set(1999, Calendar.DECEMBER, 10);
        cal.add(Calendar.YEAR, 10);

        Date expires = cal.getTime();

        Date currentDate = new Date();

        Assert.assertFalse(expires.after(fromDate));
    }

}