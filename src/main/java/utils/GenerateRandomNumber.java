package utils;

public class GenerateRandomNumber {

    public int getNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
