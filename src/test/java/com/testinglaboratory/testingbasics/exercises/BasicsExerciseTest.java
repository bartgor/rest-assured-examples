package com.testinglaboratory.testingbasics.exercises;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*TODO EXERCISE create tests checking:
   - number of letters in your first name
   - equality of length of your first and last name
   - equality of your first and last name
   - your first name having more than 3 letters
 */
public class BasicsExerciseTest implements WithAssertions {

    private static Human human;

    @BeforeEach
    public static void setHuman() {
        human = Human.getBartosz();
    }

    @Test
    public void checkNumberOfLettersInFirstName() {
        setHuman();
        assertEquals(7, human.getName().length(), "Bartek have 6 letters in his name");
    }

    @Test
    public void checkEqualityOfLengthOfYourFirstAndLastName() {
        setHuman();
        assertNotEquals(human.getName().length(), human.getSurname()
                .length(), "Name should not be equal to surname");
    }

    @Test
    public void equalityOfYourFirstAndLastName() {
        setHuman();
        assertThat(human.getName()).as("Name is not equal object to Surname ")
                .isNotEqualTo(human.getSurname());
    }

    @Test
    public void firstNameHavingMoreThan3Letters() {
        setHuman();
        assertTrue(human.getName().length() > 3, "name is Longer than 3 letters");
    }
}
