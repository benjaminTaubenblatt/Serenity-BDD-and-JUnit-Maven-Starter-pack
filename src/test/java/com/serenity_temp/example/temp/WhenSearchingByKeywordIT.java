package com.serenity_temp.example.temp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)                                                   
public class WhenSearchingByKeywordIT {

    @Managed(driver="chrome", uniqueSession = true)                              
    WebDriver driver;

    @Steps                                                                  
    BuyerSteps buyer;
    
    @Test
    public void should_see_a_list_of_items_related_to_the_specified_keyword() {  
        // GIVEN
        buyer.opens_etsy_home_page();
        // WHEN
        buyer.searches_for_items_containing("wool");
        // THEN.
        buyer.should_see_items_related_to("wool");
    }
    
    
}