public class LetterInOrder {

    public static void main(String[] args) {
        LetterInOrder letterInOrder = new LetterInOrder();
        System.out.println(letterInOrder.isInOrder("billowy"));
        System.out.println(letterInOrder.isInOrder("biopsy"));
        System.out.println(letterInOrder.isInOrder("chinos"));
        System.out.println(letterInOrder.isInOrder("defaced"));
        System.out.println(letterInOrder.isInOrder("chintz"));
        System.out.println(letterInOrder.isInOrder("sponged"));
        System.out.println(letterInOrder.isInOrder("bijoux"));
        System.out.println(letterInOrder.isInOrder("abhors"));
        System.out.println(letterInOrder.isInOrder("fiddle"));
        System.out.println(letterInOrder.isInOrder("begins"));
        System.out.println(letterInOrder.isInOrder("chimps"));
        System.out.println(letterInOrder.isInOrder("wronged"));
    }

    public boolean isInOrder(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) < input.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
