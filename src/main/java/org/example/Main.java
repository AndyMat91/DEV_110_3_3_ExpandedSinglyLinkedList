package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ExpandedLinkedList list = new ExpandedLinkedList();
        System.out.println("1). Проверим добавление значений в начало списка и в конец, а также вывод всех значений на печать:");
        list.addInEnd("1");
        list.addInEnd("2");
        list.addInEnd("3");
        list.addInEnd("4");
        list.addInEnd("5");
        list.addInEnd("6");
        list.addInEnd("7");
        list.addInEnd("8");
        list.addInEnd("9");
        list.addInEnd("10");
        list.addInEnd("11");
        list.addInBeginning("START");
        list.addInEnd("END");
        list.printAll();

        System.out.println("2). Извлечение значения из начала списка без его удаления из списка:");
        String i = list.extValueFromTheBeginningWithoutDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную");
        System.out.println("Значение осталось в списке:");
        list.printAll();

        System.out.println("3). Извлечение значения из начала списка с удалением его из списка:");
        i = list.extValueFromTheBeginningWithDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение удалилось из списка:");
        list.printAll();

        System.out.println("4). Извлечение значения c конца списка без его удаления:");
        i = list.extValueFromTheEndWithoutDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение осталось в списке:");
        list.printAll();

        System.out.println();
        System.out.println("5). Извлечение значения с конца списка с удалением его из списка:");
        i = list.extValueFromTheEndWithDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение удалилось из списка:");
        list.printAll();

        System.out.println("6). Определим, является ли список пустым, или нет:");
        System.out.println("Список пуст? - " + (list.empty()? "Да!":"Нет!" ));
        System.out.println();

        System.out.println("7). Определим, содержит ли список заданное значение, или нет:");
        System.out.println("Содержит ли список значенеие 245? - " + (list.searchValue("245")? "Да!\n":"Нет!\n") +
                "А значение 7? - " + (list.searchValue("7")? "Да!":"Нет!"));

        System.out.println("8). Удалим заданное значение из списка, например 2: ");
        list.remove("2");
        list.printAll();
        System.out.println("Удалим несуществующее значение из списка, например 7776: ");
        list.remove("7776");
        System.out.println("Ничего не произошло.");

        System.out.println("9). Проверим метод, который добавляет все значения (100,200,300) заданного массива в начало списка. Порядок значений дол-\n" +
                "жен сохраняться — первое значение массива должно стать первым значением списка:");
        list.addAllArrayValuesToTheBeginning("100","200","300");
        list.printAll();

        System.out.println("10). Проверим метод, который добавляет все значения (1t,2t,3t) заданной коллекции в начало списка с сохранением порядка:");
        List<String> test = new ArrayList<>();
        Collections.addAll(test,"1t","2t","3t");
        list.addAllCollectionValuesToTheBeginning(test);
        list.printAll();

        System.out.println("11). Проверим метод, который добавляет все значения (Java1,Java2,Java3) заданного массива в конец списка с сохранением порядка:");
        list.addAllArrayValuesToTheEnd("Java1","Java2","Java3");
        list.printAll();

        System.out.println("12). Проверим метод, который добавляет все значения (11t,22t,33t) заданной коллекции в конец списка с сохранением порядка:");
        List<String> test2 = new ArrayList<>();
        Collections.addAll(test2,"11t","22t","33t");
        list.addAllCollectionValuesToTheEnd(test2);
        list.printAll();

        System.out.println("13). Проверим метод, который поглощает список другим списком с добавлением значений второго в начало\n" +
                "первого списка; после поглощения второй список очистится:");
        System.out.println("Создадим и заполним новый список, выведем значение нового списка:");
        ExpandedLinkedList list2 = new ExpandedLinkedList();
        list2.addInBeginning("Hello!");
        list2.printAll();
        System.out.println("Теперь поглотим новым списком старый список и выведем новый список на печать:");
        list2.absorbingTheListToTheTop(list);
        list2.printAll();
        System.out.println("Проверим осталось ли что то в старом списке.Список пуст? - " + (list.empty()? "Да!":"Нет!"));
        System.out.println();

        System.out.println("14). Проверим метод, который поглощает список другим списком с добавлением значений второго в конец\n" +
                "первого списка, после поглощения второй список очистится:");
        System.out.println("Добавим START!!! в наш пустой список:");
        list.addInBeginning("START!!!");
        list.printAll();
        System.out.println("Поглотим предыдущим, оставшимся пустым, списком второй список и выведем на печать:");
        list.absorbingTheListToTheEnd(list2);
        list.printAll();
        System.out.println("Проверим осталось ли что то в старом списке.Список пуст? - " + (list2.empty()? "Да!":"Нет!"));
        System.out.println();

        System.out.println("15). Бонус - метод, который будет обрезать узлы, если они не содержат никаких значений. Голову, даже если " +
                "в ней нет значений, я отрезать не стал. Сперва выведем на печать списк list2 со всеми null:");
        list2.addInBeginning("222");
        list2.printAllWithNull(); // метод, печатающий значения с null
        System.out.println("Обрежем и снова выведем на печать:");
        list2.compression();
        System.out.println();
        list2.printAllWithNull();
        System.out.println("Остался только 1 узел - голова");
    }
}