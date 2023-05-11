package other.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
        integerList.add(20);
        integerList.add(10);
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

        // map: Key, Value

        List<String> namesList = new ArrayList<>();
        namesList.add("John");
        namesList.add("Daniel");
        namesList.add("Mike");
        namesList.add("Nick");
        namesList.add("John");
        namesList.add("Mike");
        List<String> distinctNames = namesList.stream().distinct().toList();
        System.out.println(distinctNames);


        long result4 = countPremiumUsers(userList);
        System.out.println(result4);

        List<User> sortedUserList = sortUsersList(userList);
        System.out.println(sortedUserList);

        List<User> premiumUsers = getPremiumUsers(userList);
        System.out.println(premiumUsers);

        List<String> premiumUsersSurnames = getPremiumUsersSurnames(userList);
        System.out.println(premiumUsersSurnames);

        List<String> sortedPremiumUsersSurnames = sortStringList(premiumUsersSurnames);
        System.out.println(sortedPremiumUsersSurnames);

        List<Integer> integers = sortList(integerList);
        System.out.println(integers);

        Map<Boolean, List<User>> booleanListMap = groupByPremium(userList);
        System.out.println(booleanListMap);

        findAnyMatch(userList);
    }

    private static int countTrueV1(List<Boolean> booleanList) {
        var count = 0;
        for (Boolean aBoolean : booleanList) {
            if (aBoolean) {
                count++;
            }
        }
        return count;
    }

    private static long countTrueV2(List<Boolean> booleanList) {
        return booleanList.stream().filter(aBoolean -> aBoolean).count();
    }

    private static long countAbove15(List<Integer> integerList) {
        return integerList.stream().filter(number -> number > 15).count();
    }

    private static long countPremiumUsers(List<User> userList) {
        return userList.stream().filter(user -> user.isPremium()).count();
    }

    private static List<User> getPremiumUsers(List<User> userList) {
        return userList.stream().filter(user -> user.isPremium()).toList();
    }

    private static List<String> getPremiumUsersSurnames(List<User> userList) {
        return userList.stream().filter(user -> user.isPremium()).map(user -> user.getLastname()).toList();
    }

    private static List<Integer> sortList(List<Integer> integerList) {
        return integerList.stream().sorted(Comparator.reverseOrder()).toList();
    }

    private static List<String> sortStringList(List<String> stringList) {
        return stringList.stream().sorted(Comparator.reverseOrder()).toList();
    }

    private static List<User> sortUsersList(List<User> userList) {
        return userList.stream().sorted(Comparator.comparing(user -> user.isPremium())).toList();
    }

    private static Map<Boolean, List<User>> groupByPremium(List<User> userList){
        return userList.stream().collect(groupingBy(user -> user.isPremium()));
    }

    private static void findAnyMatch(List<User> userList){
        User user1 = userList.stream().filter(user -> user.isPremium()).findAny().get();
        System.out.println(user1);
    }

    private static void allMatch(List<User> userList){
        userList
                .stream()
                    .filter(user -> user.isPremium())
                    .filter(user -> user.isPremium())
                    .filter(user -> user.isPremium())
                    .filter(user -> user.isPremium())
                .toList();
    }

    private static void extraExample(){
        // Reduce
/*        List<Invoice> invoices = Arrays.asList(new Invoice("A01", BigDecimal.valueOf(9.85), BigDecimal.valueOf(5)),
                new Invoice("A02", BigDecimal.valueOf(24.99), BigDecimal.valueOf(3)),
                new Invoice("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(4)));

        BigDecimal summary = invoices.stream().map(x -> x.getQuantity().multiply(x.getPrice())).reduce(BigDecimal.ZERO,
                BigDecimal::add);*/
    }
}
