import java.util.Scanner;

public class ConsoleCalculator {

    // RU: Создаём один общий Scanner для чтения из консоли
    // EN: Create a single global Scanner for reading console input
    private static final Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        // RU: Главный цикл программы — меню
        // EN: Main loop of the program — menu
        while (true) {
            System.out.println("------Calculator------");
            System.out.println("1.to exit press: q");
            System.out.println("2.Continue calculation press: Enter");
            System.out.print(": ");

            String choice = scaner.nextLine(); // RU: читаем строку, EN: read user input
            if (choice.length() > 0) {
                if (choice.charAt(0) == 'q') break; // RU: выход по 'q', EN: exit if 'q'
                else calc(); // RU: иначе запускаем калькулятор, EN: otherwise run calculator
            } else calc(); // RU: если просто Enter → тоже запускаем, EN: empty input → run calculator
        }
        scaner.close(); // RU: закрываем Scanner, EN: close scanner
    }

    // RU: Метод для безопасного ввода числа
    // EN: Method for safe integer input
    public static int getInt(String text){
        System.out.print(text);
        int num;
        if(scaner.hasNextInt()){
            num = scaner.nextInt();
        } else{
            System.out.println("Enter a number, not a string / Введите число, а не строку");
            scaner.next(); // RU: пропускаем неверный ввод, EN: skip invalid input
            num = getInt(text); // RU: рекурсивно снова спрашиваем, EN: recursively retry
        }
        return num;
    }

    // RU: Метод для ввода арифметического символа
    // EN: Method for reading arithmetic symbol
    public static char getSymbol(String text){
        System.out.print(text);
        char symbol;
        if(scaner.hasNext()){
            symbol = scaner.next().charAt(0);
        } else {
            System.out.println("Invalid input / Неверный ввод");
            scaner.next();
            symbol = getSymbol(text);
        }
        return symbol;
    }

    // RU: Основной метод для выполнения вычислений
    // EN: Main method for performing calculations
    public static void calc(){
        int num1 = getInt("Enter first number: ");
        char symbol = getSymbol("Enter operation: ");
        int num2 = getInt("Enter second number: ");

        // RU: Проверка деления на ноль
        // EN: Division by zero check
        if(num2 == 0 && symbol == '/'){
            System.out.println("You can't divide by zero! / Деление на ноль запрещено!");
        } else {
            // RU: Выбираем операцию
            // EN: Perform operation
            switch (symbol) {
                case '+' -> System.out.println(num1 + num2);
                case '-' -> System.out.println(num1 - num2);
                case '*' -> System.out.println(num1 * num2);
                case '/' -> System.out.println((double) num1 / num2);
                default -> System.out.println("Such an operation does not exist / Такой операции не существует");
            }
        }
        scaner.nextLine(); // RU: очищаем буфер, EN: clear buffer
    }
}
