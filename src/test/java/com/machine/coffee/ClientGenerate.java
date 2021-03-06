package com.machine.coffee;

import com.machine.coffee.client.Client;
import com.machine.coffee.product.Coffee;
import com.machine.coffee.product.CoffeeType;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * Created by rado on 07.02.2016.
 */
public class ClientGenerate {

    public static Stream<Client> generateForOrder(int size) {

         return Stream.generate(() ->
                new Client(ThreadLocalRandom.current().nextInt(size),
                        new Coffee(randomCoffeeType(),
                                ThreadLocalRandom.current().nextInt(100),
                                ThreadLocalRandom.current().nextLong(400)))).limit(size);
    }

    private static CoffeeType randomCoffeeType() {
        return Arrays.asList(CoffeeType.values())
                .get(ThreadLocalRandom.current().nextInt(CoffeeType.size()));
    }
}
