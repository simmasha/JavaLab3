import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ФИО и дату рождения в формате ДД.ММ.ГГГГ");
        String str = in.nextLine();
        String[] info = str.split(" ");
        if (info.length != 4) throw new ArrayIndexOutOfBoundsException("ОШИБКА: Неверный формат!");

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate bDate = LocalDate.of(1, 1, 1);
        try {
            bDate = LocalDate.parse(info[3], format);
        }
        catch (DateTimeParseException e){
            System.out.println("ОШИБКА: Неверный формат даты рождения!");
        }

        String initials = info[1].substring(0, 1) + "." + info[2].substring(0, 1) + ".";
        String gender = (info[2].endsWith("ич") ? "М" : "Ж");
        int age = Period.between(bDate, LocalDate.now()).getYears();

        String ageStr = age + " ";
        if (age % 10 == 1 && age != 11) {
            ageStr += "год";
        } else if (age % 10 >= 2 && age % 10 <= 4 && (age < 10 || age > 20)) {
            ageStr += "года";
        } else {
            ageStr += "лет";
        }

        System.out.println(info[0] + " " + initials + " " + gender + " " + ageStr);
    }
}