package other.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamExamples {
    public static void main(String[] args) {
        List<Boolean> booleanList = new ArrayList<>();
        booleanList.add(false);
        booleanList.add(true);
        booleanList.add(true);
        booleanList.add(false);
        booleanList.add(true);
        booleanList.add(true);
        booleanList.add(false);
        System.out.println(booleanList);
        int result = countTrueV1(booleanList);
        System.out.println(result);

        long result2 = countTrueV2(booleanList);
        System.out.println(result2);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(50);
        integerList.add(5);
        long result3 = countAbove15(integerList);
        System.out.println(result3);

        List<User> userList = new ArrayList<>();
        userList.add(new User("Ioannis", "Daniil", true));
        userList.add(new User("Manolis", "Daniel", false));
        userList.add(new User("Nikos", "Nikakis", true));
        userList.add(new User("Simos", "Simakis", false));
        userList.add(new User("Petros", "Petrakis", true));
        userList.add(new User("Maria", "Maria", false));
        long result4 = countPremiumUsers(userList);
        System.out.println(result4);

        List<User> premiumUsers = getPremiumUsers(userList);
        System.out.println(premiumUsers);

        List<String> premiumUsersSurnames = getPremiumUsersSurnames(userList);
        System.out.println(premiumUsersSurnames);
    }

    private static int countTrueV1(List<Boolean> booleanList){
        var count = 0;
        for (Boolean aBoolean : booleanList) {
         if(aBoolean){
           count++;
         }
        }
        return count;
    }

    private static long countTrueV2(List<Boolean> booleanList){
        return booleanList.stream().filter(aBoolean -> aBoolean).count();
    }

    private static long countAbove15(List<Integer> integerList){
        return integerList.stream().filter(number -> number > 15).count();
    }

    private static long countPremiumUsers(List<User> userList){
       return userList.stream().filter(user -> user.isPremium()).count();
    }

    private static List<User> getPremiumUsers(List<User> userList){
        return userList.stream().filter(user -> user.isPremium()).toList();
    }

    private static List<String> getPremiumUsersSurnames(List<User> userList){
        return userList.stream().filter(user -> user.isPremium()).map(user -> user.getLastname()).toList();
    }
}
