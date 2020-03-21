package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> dictionary = new HashMap<>();
        dictionary.put("красивый", new String[]{"симпатичный", "румяный", "привлекательный", "прекрасный"});
        dictionary.put("человек", new String[]{"существо", "личность", "персона", "индивидум"});
        dictionary.put("дом", new String[]{"жилище", "помещение", "логово", "кров"});
        dictionary.put("большой", new String[]{"огромный", "массивный", "крупный", "громадный"});

        HashMap<String, String[]> newDictionary = new HashMap<>(dictionary);

        Set<String> stringSet = dictionary.keySet();
        Iterator<String> iterator = stringSet.iterator();

        while (iterator.hasNext()) {
            try {
                String key = iterator.next();
                String[] arr = newDictionary.get(key);
                newDictionary.put(key, arr);

                for (String string : arr) {
                    ArrayList<String> arrayList = new ArrayList<>(arr.length);
                    arrayList.addAll(Arrays.asList(arr));
                    arrayList.add(key);
                    arrayList.remove(string);
                    String[] arr1 = new String[arrayList.size()];
                    arr1 = arrayList.toArray(arr1);
                    newDictionary.put(string, arr1);
                }
            } catch (Exception ex) {
            }
        }

        while (true) {
            System.err.println("Введите слово: ");
            Scanner scanner = new Scanner(System.in);
            String sentences = scanner.nextLine();
            String[] words = sentences.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (newDictionary.get(words[i]) == null) {
                    System.out.println("Такого слова нет");
                } else {
                    Random random = new Random();
                    String[] sinonyms = newDictionary.get(words[i]);
                    int randomWord = random.nextInt(sinonyms.length);
                    System.out.println(sinonyms[randomWord] + " ");
                }
            }
        }
    }
}
