package org.example;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        //Пример ArrayList
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Василий");

        System.out.println(names);
        System.out.println(names.get(1));
        names.remove(0);
        System.out.println(names);

        //Пример LinkedList
        List<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.addFirst(5); // Добавление в начало
        numbers.addLast(30); // Добавление в конец

        System.out.println(numbers);
        numbers.removeFirst();
        System.out.println(numbers);

        //Пример PriorityQueue
        Queue<Integer> priQueue = new PriorityQueue<>();
        priQueue.add(30);
        priQueue.add(10);
        priQueue.add(100500);
        priQueue.add(20);
        priQueue.add(-10);

        System.out.println(priQueue);

        //Извлечение в отсортированном виде
        while (!priQueue.isEmpty()) {
            System.out.println(priQueue.poll());
        }

        //Пример HashSet
        Set<String> uniqueValues = new HashSet<>();
        uniqueValues.add("Иванов");
        uniqueValues.add("Петров");
        uniqueValues.add("Сидоров");
        uniqueValues.add("Иванов");
        uniqueValues.add("Петров");

        System.out.println(uniqueValues);
        System.out.println(uniqueValues.contains("Сидоров"));

        Set<String> orderedValues = new LinkedHashSet<>();
        orderedValues.add("Иванов");
        orderedValues.add("Петров");
        orderedValues.add("Сидоров");
        orderedValues.add("Иванов");
        orderedValues.add("Петров");

        System.out.println(orderedValues);

        //Пример TreeSet
        Set<Integer> sortedNumbers = new TreeSet<>();
        sortedNumbers.add(5);
        sortedNumbers.add(2);
        sortedNumbers.add(8);
        sortedNumbers.add(100500);
        sortedNumbers.add(888);
        sortedNumbers.add(-333);

        System.out.println(sortedNumbers);

        //Пример HashMap
        Map<String, Integer> keyValueExample = new HashMap<>();
        keyValueExample.put("Борщ", 60);
        keyValueExample.put("Пиво", 120);
        keyValueExample.put("БигМак", 200);

        System.out.println(keyValueExample.get("БигМак"));
        System.out.println(keyValueExample.containsKey("Борщ"));
        System.out.println(keyValueExample.containsValue(120));

        //Пример HashTable
        Map<String, String> phoneBook = new Hashtable<>();
        phoneBook.put("Дядя Вова", "123-456");
        phoneBook.put("Скрипач", "789-012");

        System.out.println(phoneBook.get("Дядя Вова"));

        //Пример LinkedHashMap
        Map<String, Integer> linkedhashmap = new LinkedHashMap<>();
        linkedhashmap.put("First", 1);
        linkedhashmap.put("Second", 2);
        linkedhashmap.put("Third", 3);
        linkedhashmap.put("Last", 99);

        System.out.println(linkedhashmap);

        //Пример TreeMap
        Map<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Kiwi", 100);
        sortedMap.put("Apple", 50);
        sortedMap.put("Banana", 75);
        sortedMap.put("Cherry", 90);

        System.out.println(sortedMap);

        //Пример WeakHashMap
        Map<Object, String> cache = new WeakHashMap<>();
        Object key = new Object();
        cache.put(key, "someValue");

        System.out.println(cache.get(key));
        key = null;
        System.gc(); // Принудительный вызов GC (не гарантирует удаление)
        System.out.println(cache.isEmpty());
    }
}