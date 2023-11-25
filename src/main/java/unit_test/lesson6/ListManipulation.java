package unit_test.lesson6;

import java.util.List;

public class ListManipulation {

    public double averageList(List<Double> numberList) {
        double average = 0;
        for (double i : numberList) average += i;
        return average / numberList.size();
    }

    public String compareAverageNumberList(List<Double> list1, List<Double> list2) {
        double averageList1 = averageList(list1);
        double averageList2 = averageList(list2);

        if (averageList1 > averageList2) return "Первый список имеет большее среднее значение";
        else if (averageList1 < averageList2) return "Второй список имеет большее среднее значение";
        else return "Средние значения равны";
    }



}
