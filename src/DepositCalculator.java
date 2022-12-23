import java.util.Scanner;

public class DepositCalculator {

    double CalculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return roundResult(pay, 2);
    }

    double CalculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundResult(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundResult(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void countDeposit() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double item = 0;

        if (action == 1) {
            item = CalculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            item = CalculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + item);
    }

    public static void main(String[] args) {
        new DepositCalculator().countDeposit();
    }
}
