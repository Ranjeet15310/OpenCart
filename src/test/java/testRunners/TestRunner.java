package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		// features= {".//Features/"},
           features= {".//Features//Login.feature"},
      //   features= {".//Features//LoginDDT.feature"},
       //  features= {".//Features//LoginDDTExcel.feature"},
    //     features= {".//Features//Login.feature",".//Features//LoginDDTExcel.feature"},   // if want to run two feature
       //  features= {"@target/return.txt"}  // run only failure
        
        glue="stepDefinitions",
        plugin= {
        	    "pretty", "html:reports/myreport.html", 
        		"json:reports/myreport.json",
        		"rerun:target/return.txt", //Mandatory to capture failures
        		},   
        dryRun=false,
        monochrome=false,
        tags = "@sanity"	//Scenarios tagged with @sanity,
      //  tags = "@sanity and regression"  // for sanity and regression both
   //     tags = "@sanity or regression" // for either sanity or regression 
     //   tags = "@sanity and not regression" // for either sanity or regression 
        
        
      )
public class TestRunner 
{

}

