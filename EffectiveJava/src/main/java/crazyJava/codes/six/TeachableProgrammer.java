package crazyJava.codes.six;

public class TeachableProgrammer extends Programmer {
    public TeachableProgrammer() {
    }

    public TeachableProgrammer(String name) {
        super(name);
    }

    private void teach() {
        System.out.println(super.getName() + "教师在讲课");
    }

    private class Closure implements TeachAble {
        public void work() {
            teach();
        }
    }

    public TeachAble getCallBackRefence() {
        return new Closure();
    }
}
