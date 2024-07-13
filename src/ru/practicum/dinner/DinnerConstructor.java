package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DinnerConstructor {
    private Map<String, List<String>> dishesByType;
    private Random random;

    public DinnerConstructor() {
        dishesByType = new HashMap<>();
        random = new Random();
    }

    public void addDish(String type, String name) {
        dishesByType.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
    }

    public boolean checkType(String type) {
        return dishesByType.containsKey(type);
    }

    public List<List<String>> generateCombos(List<String> dishTypes, int numberOfCombos) {
        List<List<String>> combos = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            List<String> combo = new ArrayList<>();
            for (String type : dishTypes) {
                List<String> dishes = dishesByType.get(type);
                if (dishes != null && !dishes.isEmpty()) {
                    int randomIndex = random.nextInt(dishes.size());
                    combo.add(dishes.get(randomIndex));
                } else {
                    combo.add("Нет доступных блюд для типа: " + type);
                }
            }
            combos.add(combo);
        }
        return combos;
    }

}
