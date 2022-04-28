package com.wbw.study;

import lombok.extern.log4j.Log4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-3-21 13:24
 */
public class Soll {
    public static void main(String[] args) {
        String url = "W3siaWRlbnRpdGllcyI6eyIkaWRlbnRpdHlfbG9naW5faWQiOiIxNTIyMTAxNTkwNCIsIiRpZGVudGl0eV9jb29raWVfaWQiOiIxN2Y1M2EwYWVmNjI3Ny0wMzU2NjMwNzVmZGU0OWMtNTQzNzk3MS0yNTAxMjUtMTdmNTNhMGFlZjcxYTA0In0sImRpc3RpbmN0X2lkIjoiMTUyMjEwMTU5MDQiLCJsaWIiOnsiJGxpYiI6ImpzIiwiJGxpYl9tZXRob2QiOiJjb2RlIiwiJGxpYl92ZXJzaW9uIjoiMS4yMS45In0sInByb3BlcnRpZXMiOnsiJHRpbWV6b25lX29mZnNldCI6LTQ4MCwiJHNjcmVlbl9oZWlnaHQiOjY2NywiJHNjcmVlbl93aWR0aCI6Mzc1LCIkdmlld3BvcnRfaGVpZ2h0Ijo2NjcsIiR2aWV3cG9ydF93aWR0aCI6Mzc1LCIkbGliIjoianMiLCIkbGliX3ZlcnNpb24iOiIxLjIxLjkiLCIkbGF0ZXN0X3RyYWZmaWNfc291cmNlX3R5cGUiOiJ1cmznmoRkb21haW7op6PmnpDlpLHotKUiLCIkbGF0ZXN0X3NlYXJjaF9rZXl3b3JkIjoidXJs55qEZG9tYWlu6Kej5p6Q5aSx6LSlIiwiJGxhdGVzdF9yZWZlcnJlciI6InVybOeahGRvbWFpbuino";
        byte[] decode = Base64.getDecoder().decode(url);
        System.out.println(new String(decode, StandardCharsets.UTF_8));
    }
}
