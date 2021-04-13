package cat.itb.testingespresso;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private final String USER_TO_BE_TYPED = "miquel";
    private final String PASS_TO_BE_TYPED = "123";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void elements_on_activityMain_are_displayed() {
        onView(withId(R.id.textviewTtile)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void elements_have_the_correct_text() {
        onView(withId(R.id.textviewTtile)).check(matches(withText(R.string.main_activity_title)));
        onView(withId(R.id.button)).check(matches(withText(R.string.next)));
    }

    @Test
    public void next_button_is_clickable_and_change_text_to_back_when_clicked() {
        onView(withId(R.id.button)).
                check(matches(isClickable()));

        onView(withId(R.id.button)).
                perform(click()).
                check(matches(withText(R.string.back)));
    }

    @Test
    public void edit_text_username_is_typed_and_kayboard_is_closed() {
        onView(withId(R.id.editTextTextUsername)).perform(typeText(USER_TO_BE_TYPED), closeSoftKeyboard());
    }
    @Test
    public void edi_text_password_is_typed_and_keyboard_is_closed(){
        onView(withId(R.id.editTextTextPassword)).perform(typeText(PASS_TO_BE_TYPED), closeSoftKeyboard());
    }

    @Test
    public void next_button_change_text_to_logged_when_clicked(){
        onView(withId(R.id.button)).perform(click()).check(matches(withText(R.string.logged)));
    }

    @Test
    public void go_to_second_activity_when_next_button_clicked(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.secondActvity)).check(matches(isDisplayed()));
    }

    @Test
    public void go_to_second_activity_when_next_button_clicked_and_go_to_main_activity_when_back_button_clicked(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.secondActvity)).check(matches(isDisplayed()));


        onView(withId(R.id.buttonBack)).perform(click());
        onView(withId(R.id.activityMain)).check(matches(isDisplayed()));
    }

    @Test
    public void go_to_mian_activity_when_android_back_button_clicked(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.secondActvity)).check(matches(isDisplayed()));


        onView(withId(R.id.secondActvity)).perform(pressBack());
        onView(withId(R.id.activityMain)).check(matches(isDisplayed()));
    }

    @Test
    public void exercici5(){
        edit_text_username_is_typed_and_kayboard_is_closed();
        edi_text_password_is_typed_and_keyboard_is_closed();

        go_to_second_activity_when_next_button_clicked_and_go_to_main_activity_when_back_button_clicked();

        onView(withId(R.id.textViewSecondActivity)).check(matches(withText(R.string.welcomeBack+USER_TO_BE_TYPED)));

        go_to_mian_activity_when_android_back_button_clicked();

        onView(withId(R.id.editTextTextPassword)).check(matches(withText("")));
        onView(withId(R.id.editTextTextUsername)).check(matches(withText("")));
    }
}
