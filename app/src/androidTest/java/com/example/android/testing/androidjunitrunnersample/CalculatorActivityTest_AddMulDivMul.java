package com.example.android.testing.androidjunitrunnersample;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CalculatorActivityTest_AddMulDivMul {

    @Rule
    public ActivityTestRule<CalculatorActivity> mActivityTestRule = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void calculatorActivityTest_AddMulDivMul() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.operand_one_edit_text), isDisplayed()));
        editText.perform(click());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.operand_one_edit_text), isDisplayed()));
        editText2.perform(replaceText("8"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.operand_two_edit_text), isDisplayed()));
        editText3.perform(replaceText("9"), closeSoftKeyboard());

        pressBack();

        ViewInteraction button = onView(
                allOf(withId(R.id.operation_add_btn), withText("Add"), isDisplayed()));
        button.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.operation_result_text_view), withText("17.0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        textView.check(matches(withText("17.0")));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.operand_one_edit_text), withText("8"), isDisplayed()));
        editText4.perform(replaceText("3"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.operand_two_edit_text), withText("9"), isDisplayed()));
        editText5.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.operation_mul_btn), withText("Mul"), isDisplayed()));
        button2.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.operation_result_text_view), withText("15.0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        textView2.check(matches(withText("15.0")));

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.operand_one_edit_text), withText("3"), isDisplayed()));
        editText6.perform(replaceText("8"), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.operand_two_edit_text), withText("5"), isDisplayed()));
        editText7.perform(replaceText("3"), closeSoftKeyboard());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.operation_div_btn), withText("Div"), isDisplayed()));
        button3.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.operation_result_text_view), withText("2.6666666666666665"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        textView3.check(matches(withText("2.6666666666666665")));

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.operand_one_edit_text), withText("8"), isDisplayed()));
        editText8.perform(replaceText("4"), closeSoftKeyboard());

        ViewInteraction editText9 = onView(
                allOf(withId(R.id.operand_two_edit_text), withText("3"), isDisplayed()));
        editText9.perform(replaceText("9"), closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.operation_mul_btn), withText("Mul"), isDisplayed()));
        button4.perform(click());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.operation_result_text_view), withText("36.0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        textView4.check(matches(withText("36.0")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
