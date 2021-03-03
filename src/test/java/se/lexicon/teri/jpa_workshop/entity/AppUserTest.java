package se.lexicon.teri.jpa_workshop.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    AppUser testUser;

    @BeforeEach
    void setUp() {
        testUser = new AppUser(1, "Teri", "Sandstedt", "test@test.se");
    }

    @Test
    void getFirstName() {
        String expected = "Teri";
        String actual = testUser.getFirstName();
        assertEquals(expected,actual);
    }

    @Test
    void setFirstName() {
        testUser.setFirstName("Teresa");
        String expected = "Teresa";
        String actual = testUser.getFirstName();
        assertEquals(expected,actual);
    }

    @Test
    void getLastName() {
        String expected = "Sandstedt";
        String actual = testUser.getLastName();
        assertEquals(expected,actual);
    }

    @Test
    void setLastName() {
        testUser.setLastName("Sandstedt née Vaughan");
        String expected = "Sandstedt née Vaughan";
        String actual = testUser.getLastName();
        assertEquals(expected,actual);
    }

    @Test
    void getEmail() {
        String expected = "test@test.se";
        String actual = testUser.getEmail();
        assertEquals(expected,actual);
    }

    @Test
    void setEmail() {
        testUser.setEmail("test2@test.com");
        String expected = "test2@test.com";
        String actual = testUser.getEmail();
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        AppUser testUser2 = new AppUser(1, "Teri", "Sandstedt", "test@test.se");
         assertEquals(testUser, testUser2);
    }
}