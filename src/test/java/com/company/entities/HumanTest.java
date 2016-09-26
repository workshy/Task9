package com.company.entities;

import org.junit.Assert;
import org.junit.Test;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import static java.sql.Date.valueOf;
import static org.junit.Assert.*;

/**
 * Created by Viktoriia_Marynchak on 9/26/2016.
 */
public class HumanTest {
    private static Date birthDate;
    private static Calendar cal = Calendar.getInstance();
    private static String gender;
    private String bloodGroup;
    private String name;
    private final String NAME = "^[A-Z][a-z]+$";


    @Test
    public void testNamePositive(){
        name = "John";

        Assert.assertTrue(name.matches(NAME));
    }

    @Test
    public void testNameNegative(){
        name = "John2";

        Assert.assertFalse(name.matches(NAME));
    }

    @Test //водитель совершеннолетний
    public void testBirthDatePositive(){
        cal.set(1996, Calendar.DECEMBER, 10);
        cal.add(Calendar.YEAR, 18);

        birthDate = cal.getTime();

        Date currentDate = new Date();

        Assert.assertTrue(birthDate.before(currentDate));
    }

    @Test //водитель не совершеннолетний
    public void testBirthDateNegative(){
        cal.set(2006, Calendar.DECEMBER, 10);
        cal.add(Calendar.YEAR, 18);

        birthDate = cal.getTime();

        Date currentDate = new Date();

        Assert.assertTrue(birthDate.after(currentDate));
    }

    @Test
    public void testGenderPositive(){
        gender = "MALE";

        Assert.assertTrue(gender.equals("MALE") || gender.equals("FEMALE"));
    }

    @Test
    public void testGenderNegative(){
        gender = "FISH";

        Assert.assertFalse(gender.equals("MALE") || gender.equals("FEMALE"));
    }

    @Test
    public void testBloodGroupPositive(){
        bloodGroup = "FIRST";

        Assert.assertTrue(bloodGroup.equals("FIRST") || bloodGroup.equals("SECOND") ||
                bloodGroup.equals("THIRD") || bloodGroup.equals("FOURTH"));
    }

    @Test
    public void testBloodGroupNegative(){
        bloodGroup = "FIFTH";

        Assert.assertFalse(bloodGroup.equals("FIRST") || bloodGroup.equals("SECOND") ||
                bloodGroup.equals("THIRD") || bloodGroup.equals("FOURTH"));
    }
}