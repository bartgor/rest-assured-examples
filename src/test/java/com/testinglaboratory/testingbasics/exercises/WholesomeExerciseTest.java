package com.testinglaboratory.testingbasics.exercises;

import java.util.Locale;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.assertj.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

/*TODO EXERCISE
 * - Create class Toy having fields: make, name, colour, material
 *  - having methods returning greeting (including name, colour and material)
 *  - create getters and setters
 *  - write tests that put a text file with toy data to a text file in a folder
 *  - use FileManager to operate on files
 *  - remember to prepare data
 *  - remember to clean up after tests
 */
@Getter
public class WholesomeExerciseTest {

    private static Toy toy;

    @BeforeAll
    public void makeToy() {

        toy = new Toy("Hasbro", "Potato Head", "brown", "plastic");
        System.out.println(toy.toString());
    }

    @Test
    public void createDirectoryTest() {
        FileManager.createDirectory("ToyStore");
    }

    @Test
    public void createFileTest() {
        FileManager.createFile("ToyStore/toys.txt");
    }

    @Test
    public void fillFileTest() {
        Toy secondToy = new Toy("Hasbro", "Buzz Astral", "white", "plastic");
        FileManager.writeToFileFile("ToyStore/toys.txt", secondToy.toString());
        String readFile = FileManager.readFile("ToyStore/toys.txt");
        assertEquals(readFile, secondToy.toString());
    }

    @AfterEach
    public void cleanFile() {
        FileManager.deleteFile("ToyStore/toys.txt");
    }

}
