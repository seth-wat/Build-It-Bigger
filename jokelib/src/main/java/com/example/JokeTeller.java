package com.example;

public class JokeTeller {
    String[] setUp = {
            "Why did the chewing gum cross the road?",
            "What do you call an alligator in a vest?",
            "What do you call a fake noodle?"
    };

    String[] punchline = {
            "He was stuck to the chicken's foot.",
            "An investigator.",
            "An impasta."
    };

    public String getJoke() {
        int random = (int) Math.random() * (setUp.length - 1) + 1;
        return setUp[random] + "\n" + punchline[random];
    }

}
