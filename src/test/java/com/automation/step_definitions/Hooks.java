package com.automation.step_definitions;

import com.automation.utils.Driver;
import org.junit.After;

public class Hooks {
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
