
package homeWork.hw3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LastHW {
    public static void main(String[] args) {
        System.out.println("Введите через пробел: Фамилия, Имя, Отчество, Дата Рождения(dd.mm.yyyy), Номер Телефона, Пол(f/m)");
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.nextLine();
        sc.close();

        String[] userAnsw = userAnswer(userAnswer);
        checkBDay(userAnsw[3]);
        checkPhone(userAnsw[4]);
        checkGender(userAnsw[5]);
        writeFile(userAnsw);



        for (String item:userAnsw) {
            System.out.print(item + " ");
        }
//        koneva elena ivanovna 05.07.1990 89601238818 f
    }
    public static String[] userAnswer(String userAnswer){
        String[] arrAnswer = userAnswer.split(" +");
        if((userAnswer.isEmpty())||(userAnswer.isBlank())){
            System.out.println("Вы не ввели данные");
            throw new RuntimeException("Данные не введены");
        }
        if(arrAnswer.length < 6){
            System.out.println("Вы ввели не все данные");
            throw new RuntimeException("Данные введены не полностью");
        }
        else if (arrAnswer.length > 6){
            System.out.println("Вы ввели больше данных, чем нужно");
            throw new RuntimeException("Введены лишние данные");
        }
        return arrAnswer;
    }
    public static void checkBDay(String check){
        try {
            LocalDate.parse(check, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            System.out.println("Дата не соответствует формату");
            throw new RuntimeException("Дата не соответствует формату");
        }
    }
    public static void checkPhone(String check){
        try {
            Long.parseLong(check);
        } catch (NumberFormatException e) {
            System.out.println("Номер телефона введен не верно");
            throw new RuntimeException("Номер телефона введен не верно");
        }
    }
    public static void checkGender(String check){
        if(!(check.equals("f"))&&!(check.equals("m"))){
            System.out.println("Пол введен не верно: m - male, f - female");
            throw new RuntimeException("Пол введен не верно");
        }
    }
    public static void writeFile(String[] arr){
        String name = arr[0] + ".txt";
        File file = new File("C://Users//sasha//IdeaProjects//JavaExceptions//src//homeWork//hw3//" + name);
            try(FileWriter fw = new FileWriter(file, true)){
                for (String item:arr) {
                    fw.write(item + " ");
                }
                fw.write("\n");
            } catch (IOException e) {
                throw new RuntimeException("Файл не записан");
            }
    }
}