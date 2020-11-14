package com.tattoo.codes.nine;

import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class TestSystem {
    public static void main(String[] args) throws IOException {
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.print("name == " + entry.getKey());
            System.out.println("   value == " + entry.getValue());
        }
        System.out.println(System.getenv("JAVA_HOME"));
        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("props.txt"), "System Properties");

        System.out.println(System.getProperty("os.name"));

    }
}
