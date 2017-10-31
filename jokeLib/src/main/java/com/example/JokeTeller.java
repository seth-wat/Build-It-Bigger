package com.example;

import java.util.Random;

public class JokeTeller {
    String[] setUp = {
            "Why did the chewing gum cross the road?",
            "What do you call an alligator in a vest?",
            "What do you call a fake noodle?"
    };

    String[] punchline = {
            "It was stuck to the chicken's foot.",
            "An investigator.",
            "An impasta."
    };

    public String getJoke() {
        Random r = new Random();
        int index = r.nextInt(setUp.length);
        return setUp[index] + "\n" + punchline[index];
    }

}
