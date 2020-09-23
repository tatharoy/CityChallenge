package com.mastercard.citychallenge;

import com.mastercard.citychallenge.service.CityConnectionService;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDistanceServiceTest {

    @Autowired
    private CityConnectionService cityConnectionService;

    @Test
    public void testValid() {
        Assert.assertTrue(cityConnectionService.routeExists("Newark", "Boston"));
        Assert.assertTrue(cityConnectionService.routeExists("trenton", "AlBANy"));
        Assert.assertFalse(cityConnectionService.routeExists("Newark", "AlBANy"));
    }

    @Test
    public void testInValid() {
        Assert.assertFalse(cityConnectionService.routeExists("Newark", ""));
        Assert.assertFalse(cityConnectionService.routeExists("", "AlBANy"));
    }

}
