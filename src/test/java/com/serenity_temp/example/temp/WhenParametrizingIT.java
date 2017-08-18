package com.serenity_temp.example.temp;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;

@RunWith(SerenityParameterizedRunner.class)
//@Concurrent
public class WhenParametrizingIT {

    @Managed(driver = "chrome")
    WebDriver driver;
    
    @Steps
    BuyerSteps buyer;

    @TestData                                               
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"wallets"},
                {"cats"},
                {"art"},
                {"soccer"},
        });
    }

    private final String searchTerm;  
    
    public WhenParametrizingIT(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    
    @Test
    @Title("Should search for specified keywords")
    public void searchTest(){
    	
    	buyer.opens_etsy_home_page();
    	
    	buyer.searches_for_items_containing(searchTerm);
    	
    	buyer.should_see_items_related_to(searchTerm);
    }
    
}