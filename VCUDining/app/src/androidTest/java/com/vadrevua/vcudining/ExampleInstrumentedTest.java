package com.vadrevua.vcudining;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {



    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.vadrevua.vcudining", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> menuActivityTestRule = new ActivityTestRule<>(MainActivity.class, true, true);


    @Test
    public void checkTimingButton() {

        Intent buttonSomething = new Intent();
        String title = "VCU Dining Services";
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, buttonSomething);
        onView(withId(R.id.timingButton)).perform(click());
        onView(withId(R.id.textView5)).check(matches(withText(title)));
    }

    @Test
    public void checkAddressButton() {

        Intent buttonSomething = new Intent();
        String title = "VCU Dining Services Locations";
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, buttonSomething);
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.textView5)).check(matches(withText(title)));
    }

    @Test//testing to see if Chilis works
    public void searchTest_ChiliHandledProperly() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Chili's"));
        String restaurantName = "Chili's";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//test for alternate chilis title
    public void searchTest_ChiliHandledProperly2() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Chilis"));
        String restaurantName = "Chili's";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//test for alternate chilis title
    public void searchTest_ChiliHandledProperly3() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("chilis"));
        String restaurantName = "Chili's";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//test for alternate chilis title
    public void searchTest_ChiliHandledProperly4() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("chili's"));
        String restaurantName = "Chili's";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//testing to see if chick-fil-a works
    public void searchTest_ChickFilAHandledProperly() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Chick-Fil-A"));
        String restaurantName = "Chick-fil-A";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//to see if chick-fil-a alt title works
    public void searchTest_ChickFilAHandledProperly2() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("chick-fil-a"));
        String restaurantName = "Chick-fil-A";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//to see if chick-fil-a alt title works
    public void searchTest_ChickFilAHandledProperly3() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Chick-fil-a"));
        String restaurantName = "Chick-fil-A";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//to see if chick-fil-a alt title works
    public void searchTest_ChickFilAHandledProperly4() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("chickfila"));
        String restaurantName = "Chick-fil-A";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//testing to see if einsteins works
    public void searchTest_EinsteinsHandledProperly() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Einstein Bros. Bagels"));
        String restaurantName = "Einstein Bros. Bagels";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//to see if einsteins alt title works
    public void searchTest_EinsteinsHandledProperly2() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Einstein"));
        String restaurantName = "Einstein Bros. Bagels";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//to see if einsteins alt title works
    public void searchTest_EinsteinsHandledProperly3() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("bagels"));
        String restaurantName = "Einstein Bros. Bagels";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }

    @Test//to see if einsteins alt title works
    public void searchTest_EinsteinsHandledProperly4() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("einstein bros bagels"));
        String restaurantName = "Einstein Bros. Bagels";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }
    @Test//to see if einsteins alt title works
    public void searchTest_tacoHandledProperly() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Taco Bell"));
        String restaurantName = "Taco Bell";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }
    public void searchTest_tacoHandledProperly2() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("taco bell"));
        String restaurantName = "Taco Bell";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }
    public void searchTest_tacoHandledProperly3() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("taco"));
        String restaurantName = "Taco Bell";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }
    public void searchTest_pandaHandledProperly() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Panda Express"));
        String restaurantName = "Panda Express";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }
    public void searchTest_pandaHandledProperly2() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("Panda"));
        String restaurantName = "Panda Express";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }
    public void searchTest_pandaHandledProperly3() {

        Intent resultData = new Intent();
        onView(withId(R.id.restaurantSearch)).perform(typeText("panda express"));
        String restaurantName = "Panda Express";
        resultData.putExtra("restaurant", restaurantName);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        onView(withId(R.id.browseButton)).perform(click());
        onView(withId(R.id.restTitle)).check(matches(withText(restaurantName)));
    }
}
