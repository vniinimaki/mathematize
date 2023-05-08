import java.util.Arrays;
public class Operations {
    
    
    public static double addition(double number1, double number2) {
        return number1 + number2;
    }

    public static double subtraction(double number1, double number2) {
        return number1 - number2;
    }

    public static double division(double number1, double number2) {
        return number1 / number2;
    }

    public static double multiplication(double number1, double number2) {
        return number1 * number2;
    }

    public static double median(double[] numbers) {
        Arrays.sort(numbers);
        int lenght = numbers.length;
        if (lenght % 2 == 0) {
            return ((numbers[lenght / 2 - 1] + numbers[lenght / 2]) / 2);
        }
        else {
            return numbers[lenght / 2];

        }
    }

    public static double mean(double[] numbers) {
        int lenght = numbers.length;
        double result = 0;     
        for (int i = 0; i < lenght; i++) {
            result = result + numbers[i];
        }
        result = result / lenght;
        return result;
    }

    public static double degToRad(double number) {
        return number * (3.14159 / 180);
    }

    public static double radToDeg(double number) {
        return number * (180 / 3.14159 );
    }

    public static double fahrToCelc(double number) {
        return (number - 32) * 5 / 9;
    }

    public static double celcToFahr(double number) {
        return (number * 9/5) + 32;
    }
}
