package org.debz.controller;

import org.debz.utils.BCrypt;

import java.util.UUID;

/**
 * User: tarus
 * Date: 9/13/13
 * Time: 10:52 AM
 */

public class Temp {
    public static void main(String[] args) {
        System.out.println((BCrypt.hashpw("12345", BCrypt.gensalt(12))));
        UUID idOne = UUID.randomUUID();
        UUID idTwo = UUID.randomUUID();
        System.out.println("idOne "+idOne);
        System.out.println("idTwo "+idTwo);
    }


}
