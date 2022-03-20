package com.wbw.study;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-2-24 0:06
 */
public class AbTest {


    @Test
    public void testFunc() {
        List<String> list = Arrays.asList("abcdefg".split(""));
        list.stream()
                .flatMap(s -> list.stream().map(s::concat))
                .flatMap(s -> list.stream().map(s::concat))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
    @Test
    public void testFunc1(){
        List<String> list = Arrays.asList("1234".split(""));
        System.out.println(permutation(list, 3));
        System.out.println(permutationNoRepeat(list, 3));
        //System.out.println(combinations(list, 3));
    }
    public static List<String> permutation(List<String> list, int length) {
        Stream<String> stream = list.stream();
        for (int n = 1; n < length; n++) {
            stream = stream.flatMap(str -> list.stream().map(str::concat));
        }
        return stream.collect(Collectors.toList());
    }

    public static List<String> permutationNoRepeat(List<String> list, int length) {
        Stream<String> stream = list.stream().distinct();
        for (int n = 1; n < length; n++) {
            stream = stream.flatMap(str -> list.stream()
                    .filter(temp -> !str.contains(temp))
                    .map(str::concat));
        }
        return stream.collect(Collectors.toList());
    }
    public static List<String> combinations(List<String> list, int length) {
        return null;
    }


}
