package net.sasu.lib.stopwatch.ext.test;

import java.time.InstantSource;

public class InstantSourceTest {

    public static void main(String[] args) throws InterruptedException {
        InstantSource instantSource = InstantSource.system();

        System.out.println(instantSource.instant().toString());
        Thread.sleep(1000);
        System.out.println(instantSource.instant().toString());
        Thread.sleep(1000);
        System.out.println(instantSource.instant().toString());
    }
}
