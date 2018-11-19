package com.example.yzeng.intentexpresso;

import android.content.Intent;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static org.hamcrest.Matchers.allOf;

import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
public class DialerActivityTest {
    @Test
    public void typeNumber_ValidInput_InitiatesCall() {
        // Types a phone number into the dialer edit text field and presses the call button.
        onView(withId(R.id.et))
                .perform(typeText("3314729980"), closeSoftKeyboard());
        onView(withId(R.id.btn)).perform(click());
        //on click of this button was this intent raised or not ??

        // Verify that an intent to the dialer was sent with the correct action, phone
        // number and package. Think of Intents intended API as the equivalent to Mockito's verify.
        intended(allOf(
                hasAction(Intent.ACTION_CALL),
                hasData("3314729980"),
                toPackage("com.android.phone")));
    }
}
