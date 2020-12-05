import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task_3_ser {

    public static void main(String[] args) {

        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14, 15));

        SetOfNumbers setOne = new SetOfNumbers(listOne);
        SetOfNumbers setTwo = new SetOfNumbers(6);

        setTwo.setNumbers(listTwo);

        System.out.println("Первое множество: ");
        System.out.println(setOne.toString());

        System.out.println("Второе множество: ");
        System.out.println(setTwo.toString());

        setOne.joinSet(setTwo);

        System.out.println("Первое множество после объединения со вторым: ");
        System.out.println(setOne.toString());

        int numberToCheck = 99;
        if (setOne.isNumberBelongToSet(numberToCheck)) {
            System.out.println(numberToCheck + " принадлежит множеству.");
        } else {
            System.out.println(numberToCheck + " не принадлежит множеству.");
        }

    }

    private static class SetOfNumbers {

        private int cardinality;
        private List<Integer> numbers;

        SetOfNumbers(int cardinality) {
            this.cardinality = cardinality;
            this.numbers = new ArrayList<>(cardinality);
        }
        SetOfNumbers(List<Integer> numbers) {
            this.numbers = numbers;
            calculateCardinality();
        }
        List<Integer> getNumbers() {
            return numbers;
        }
        void setNumbers(List<Integer> numbers) {
            this.numbers = numbers;
            calculateCardinality();
        }
        private void calculateCardinality() {
            this.cardinality = numbers.size();
        }
        public int getCardinality() {
            return cardinality;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Мощность множества: ")
                    .append(cardinality)
                    .append(". ")
                    .append("Значения: {");
            for (int i = 0; i < numbers.size(); i++) {
                sb.append(String.valueOf(numbers.get(i)));
                if (i != numbers.size() - 1) {
                    sb.append(", ");
                } else {
                    sb.append("}");
                }
            }
            return sb.toString();
        }
        boolean isNumberBelongToSet(int number) {
            return numbers.contains(number);
        }
        void joinSet(SetOfNumbers newSet) {
            this.numbers.addAll(newSet.getNumbers());
            calculateCardinality();
        }

    }

}