package com.company.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Viktoriia_Marynchak on 9/26/2016.
 */
public class GasolineCarTest {
    @Test
    public void testTransmissionPositive(){
        String transmission = "MECHANICAL";

        Assert.assertTrue(transmission.equals("MECHANICAL") || transmission.equals("AUTOMATIC"));
    }

    @Test
    public void testTransmissionNegative(){
        String transmission = "HALF-AUTOMATIC";

        Assert.assertFalse(transmission.equals("MECHANICAL") || transmission.equals("AUTOMATIC"));
    }

}