import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ChemReaction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the chemical reaction (e.g., H2 + O2 = H2O): ");
        String reaction = sc.nextLine();
        sc.close();

        String[] sides = reaction.split("=");
        if (sides.length != 2) {
            System.out.println("Invalid chemical reaction format.");
            return;
        }

        String[] reactants = sides[0].split("\\+");
        String[] products = sides[1].split("\\+");

        Map<String, Integer> reactantAtoms = countAtoms(reactants);
        Map<String, Integer> productAtoms = countAtoms(products);

        System.out.println("Number of atoms on the reactant side:");
        reactantAtoms.forEach((element, count) -> System.out.println(element + ": " + count));

        System.out.println("Number of atoms on the product side:");
        productAtoms.forEach((element, count) -> System.out.println(element + ": " + count));
    }

    private static Map<String, Integer> countAtoms(String[] comps) {
        Map<String, Integer> atomCount = new HashMap<>();
        for (String comp : comps) {
            comp = comp.replaceAll("\\s+", ""); // Remove all spaces
            Map<String, Integer> compAtoms = parseCompound(comp);
            for (Map.Entry<String, Integer> entry : compAtoms.entrySet()) {
                atomCount.put(entry.getKey(), atomCount.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        return atomCount;
    }

private static Map<String, Integer> parseCompound(String comp) {
    Map<String, Integer> atoms = new HashMap<>();
    String element = "";
    String count = "";
    Stack<Integer> counts = new Stack<>();
    counts.push(1); // Initialize with 1 for cases without explicit counts

    for (int i = 0; i < comp.length(); i++) {
        char ch = comp.charAt(i);

        if (Character.isUpperCase(ch)) {
            if (!element.isEmpty()) {
                int atomCount = Integer.parseInt(count.isEmpty() ? "1" : count);
                atoms.put(element, atoms.getOrDefault(element, 0) + atomCount * counts.peek());
            }
            element = "" + ch;
            count = "";
        } else if (Character.isLowerCase(ch)) {
            element += ch;
        } else if (Character.isDigit(ch)) {
            count += ch;
        } else if (ch == '(') {
            counts.push(Integer.parseInt(count.isEmpty() ? "1" : count));
            count = ""; // Reset count for the atoms inside parentheses
        } else if (ch == ')') {
            // Multiply all counts inside parentheses by the multiplier
            int multiplier = counts.pop(); // Get the multiplier
            for (Map.Entry<String, Integer> entry : atoms.entrySet()) {
                atoms.put(entry.getKey(), entry.getValue() * multiplier);
            }
        }
    }

    if (!element.isEmpty()) {
        int atomCount = Integer.parseInt(count.isEmpty() ? "1" : count);
        atoms.put(element, atoms.getOrDefault(element, 0) + atomCount * counts.peek());
    }

    return atoms;
}


}
