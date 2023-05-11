package Models;

public class FKP {
    private String questionMath;
    private String questionPhysics;

    public FKP(String questionMath, String questionPhysics) {
        this.questionMath = questionMath;
        this.questionPhysics = questionPhysics;
    }

    public String getQuestionMath() {
        return questionMath;
    }

    public void setQuestionMath(String questionMath) {
        this.questionMath = questionMath;
    }

    public String getQuestionPhysics() {
        return questionPhysics;
    }

    public void setQuestionPhysics(String questionPhysics) {
        this.questionPhysics = questionPhysics;
    }

    @Override
    public String toString() {
        return "Задание: 5 + 5 ?\n" +
                "Ответ: " + getQuestionMath() + "\n" +
                "Температура, при которой закипает вода ?\n" +
                "Ответ: " + getQuestionPhysics();
    }
}
