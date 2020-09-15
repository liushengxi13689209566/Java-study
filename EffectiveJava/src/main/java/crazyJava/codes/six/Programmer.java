package crazyJava.codes.six;

import javax.sound.midi.Soundbank;

interface TeachAble {
    void work();
}

public class Programmer {
    private String name;

    public Programmer() {
    }

    public Programmer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println(name + "写代码");
    }
}
