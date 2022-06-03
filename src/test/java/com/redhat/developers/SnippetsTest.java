package com.redhat.developers;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.function.ToDoubleFunction;

public class SnippetsTest {

    @Test
    public void test() {
        System.out.println(Instant.now().getEpochSecond());

        long epoch = Instant.now().getEpochSecond();

        ToDoubleFunction d = x -> (double) x;



    }

}
