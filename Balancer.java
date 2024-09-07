import java.util.*;
public class Balancer {
    public static String bal(String pre_reactants_String ,   String pre_products_String ) {
        StringBuilder storeString= new StringBuilder();
        for(int i=0; i<pre_reactants_String.length(); i++){
            char character=pre_reactants_String.charAt(i);
            if(Character.isLetter(character) || Character.isDigit(character) || character=='+' || character=='(' || character==')'){
                storeString.append(character);
            }
        }
        pre_reactants_String= storeString.toString();
        storeString = new StringBuilder();
        for(int i=0; i<pre_products_String.length(); i++){
            char character=pre_products_String.charAt(i);
            if(Character.isLetter(character) || Character.isDigit(character) || character=='+' || character=='(' || character==')'){
                storeString.append(character);
            }
        }
        pre_products_String= storeString.toString();
        String[] replacementArray=polyatomicReplacement(pre_reactants_String, pre_products_String);
        String reactants_String=replacementArray[0];
        String products_String=replacementArray[1];
        Hashtable<Integer, Hashtable<String, Integer>> reactants = parseString(reactants_String);
        Hashtable<Integer, Hashtable<String, Integer>> products = parseString(products_String);
        LinkedList<String> reactantsElements = getElements(reactants_String);
        Collections.sort(reactantsElements);
        LinkedList<String> productsElements = getElements(products_String);
        Collections.sort(productsElements);
        LinkedList<String> elements;
        boolean contain;
        for (Object reactantsElement : reactantsElements) {
            contain = productsElements.contains(reactantsElement);
            if (!contain) {
                System.out.println("Error: Same elements need to be on both sides of the equation.");
                System.exit(0);
            }
        }
        for (Object productsElement : productsElements) {
            contain = reactantsElements.contains(productsElement);
            if (!contain) {
                System.out.println("Error: Same elements need to be on both sides of the equation.");
                System.exit(0);
            }
        }
        elements=reactantsElements;
        boolean a_used=false;
        boolean b_used=false;
        LinkedList<Fraction> reactants_a= new LinkedList<>();
        LinkedList<Fraction> reactants_b= new LinkedList<>();
        LinkedList<Boolean> reactants_filled=new LinkedList<>();
        for(int i=0; i<reactants.size(); i++){
            reactants_a.addLast(new Fraction());
            reactants_b.addLast(new Fraction());
            reactants_filled.addLast(false);
        }
        LinkedList<Fraction> products_a= new LinkedList<>();
        LinkedList<Fraction> products_b= new LinkedList<>();
        LinkedList<Boolean> products_filled=new LinkedList<>();
        for(int i=0; i<products.size(); i++){
            products_a.addLast(new Fraction());
            products_b.addLast(new Fraction());
            products_filled.addLast(false);
        }
        LinkedList<String> elementsUsed=new LinkedList<>();
        for (String currentElement : elements) {
            Integer reactantIndex = null;
            Integer productIndex = null;
            int counter = 0;
            for (int j = 0; j < reactants.size(); j++) {
                Hashtable<String, Integer> compoundTable = reactants.get(j);
                if (compoundTable.containsKey(currentElement)) {
                    counter++;
                    reactantIndex = j;
                }
            }
            if (counter > 1) {
                continue;
            }
            counter = 0;
            for (int j = 0; j < products.size(); j++) {
                Hashtable<String, Integer> compoundTable = products.get(j);
                if (compoundTable.containsKey(currentElement)) {
                    counter++;
                    productIndex = j;
                }
            }
            if (counter > 1) {
                continue;
            }
            if (reactantIndex != null && productIndex != null) {
                if (!reactants_filled.get(reactantIndex) && !products_filled.get(productIndex)) {
                    Integer reactantQuantity = (reactants.get(reactantIndex)).get(currentElement);
                    Integer productQuantity = (products.get(productIndex)).get(currentElement);
                    Fraction reactantCoefficient;
                    Fraction productCoefficient;
                    if (reactantQuantity > productQuantity) {
                        reactantCoefficient = new Fraction(1, 1);
                        productCoefficient = new Fraction(reactantQuantity, productQuantity);
                    } else if (reactantQuantity < productQuantity) {
                        productCoefficient = new Fraction(1, 1);
                        reactantCoefficient = new Fraction(productQuantity, reactantQuantity);
                    } else {
                        productCoefficient = new Fraction(1, 1);
                        reactantCoefficient = new Fraction(1, 1);
                    }
                    elementsUsed.addLast(currentElement);
                    reactants_filled.set(reactantIndex, true);
                    products_filled.set(productIndex, true);
                    if (!a_used) {
                        a_used = true;
                        reactants_a.set(reactantIndex, reactantCoefficient);
                        products_a.set(productIndex, productCoefficient);
                    } else if (!b_used) {
                        b_used = true;
                        reactants_b.set(reactantIndex, reactantCoefficient);
                        products_b.set(productIndex, productCoefficient);
                    } else {
                        System.out.println("This equation uses more than two variables.");
                        System.exit(0);
                    }
                }
            }
        }
        for (String value : elementsUsed) {
            elements.remove(value);
        }
        elementsUsed=new LinkedList<>();
        for (String currentElement : elements) {
            Integer reactantIndex = null;
            Integer productIndex = null;
            int counter = 0;
            for (int j = 0; j < reactants.size(); j++) {
                Hashtable<String, Integer> compoundTable = reactants.get(j);
                if (compoundTable.containsKey(currentElement)) {
                    counter++;
                    reactantIndex = j;
                }
            }
            if (counter > 1) {
                continue;
            }
            counter = 0;
            for (int j = 0; j < products.size(); j++) {
                Hashtable<String, Integer> compoundTable = products.get(j);
                if (compoundTable.containsKey(currentElement)) {
                    counter++;
                    productIndex = j;
                }
            }
            if (counter > 1) {
                continue;
            }
            if (reactantIndex != null && productIndex != null) {
                if (!reactants_filled.get(reactantIndex) ^ !products_filled.get(productIndex)) {
                    elementsUsed.addLast(currentElement);
                    Integer reactantQuantity = (reactants.get(reactantIndex)).get(currentElement);
                    Integer productQuantity = (products.get(productIndex)).get(currentElement);
                    Fraction filledCoefficient;
                    Fraction unfilledCoefficient;
                    if (reactants_filled.get(reactantIndex)) {
                        if (reactants_a.get(reactantIndex).active) {
                            filledCoefficient = reactants_a.get(reactantIndex);
                        } else {
                            filledCoefficient = reactants_b.get(reactantIndex);
                        }
                        unfilledCoefficient = Fraction.multiply(filledCoefficient, new Fraction(reactantQuantity, productQuantity));
                        products_filled.set(productIndex, true);
                        if (reactants_a.get(reactantIndex).active) {
                            products_a.set(productIndex, unfilledCoefficient);
                        } else {
                            products_b.set(productIndex, unfilledCoefficient);
                        }
                    } else {
                        if (products_a.get(productIndex).active) {
                            filledCoefficient = products_a.get(productIndex);
                        } else {
                            filledCoefficient = products_b.get(productIndex);
                        }
                        unfilledCoefficient = Fraction.multiply(filledCoefficient, new Fraction(productQuantity, reactantQuantity));
                        reactants_filled.set(reactantIndex, true);
                        if (products_a.get(productIndex).active) {
                            reactants_a.set(reactantIndex, unfilledCoefficient);
                        } else {
                            reactants_b.set(reactantIndex, unfilledCoefficient);
                        }
                    }
                }
            }
        }
        for (String value : elementsUsed) {
            elements.remove(value);
        }
        int sizeOfElementsList=elements.size();
        for(int k=0; k<sizeOfElementsList; k++){
            if(!reactants_filled.contains(false) && !products_filled.contains(false)){
                break;
            }
            for (String currentElement : elements) {
                Boolean unfilledIndexOnProduct = null;
                Integer unfilledIndex = null;
                LinkedList<Integer> reactantFilledIndexes = new LinkedList<>();
                LinkedList<Integer> productFilledIndexes = new LinkedList<>();
                int totalOccurrences = 0;
                for (int j = 0; j < reactants.size(); j++) {
                    Hashtable<String, Integer> compoundTable = reactants.get(j);
                    if (compoundTable.containsKey(currentElement)) {
                        totalOccurrences++;
                        if (reactants_filled.get(j))
                            reactantFilledIndexes.addLast(j);
                        else {
                            unfilledIndex = j;
                            unfilledIndexOnProduct = false;
                        }
                    }
                }
                for (int j = 0; j < products.size(); j++) {
                    Hashtable<String, Integer> compoundTable = products.get(j);
                    if (compoundTable.containsKey(currentElement)) {
                        totalOccurrences++;
                        if (products_filled.get(j))
                            productFilledIndexes.addLast(j);
                        else {
                            unfilledIndex = j;
                            unfilledIndexOnProduct = true;
                        }
                    }
                }
                if (unfilledIndex != null && totalOccurrences == reactantFilledIndexes.size() + productFilledIndexes.size() + 1) {
                    Fraction reactantASum = new Fraction(0, 1);
                    Fraction reactantBSum = new Fraction(0, 1);
                    for (int s : reactantFilledIndexes) {
                        int quantity = reactants.get(s).get(currentElement);
                        reactantASum = Fraction.add(reactantASum, Fraction.multiply(reactants_a.get(s), new Fraction(quantity, 1)));
                        reactantBSum = Fraction.add(reactantBSum, Fraction.multiply(reactants_b.get(s), new Fraction(quantity, 1)));
                    }
                    Fraction productASum = new Fraction(0, 1);
                    Fraction productBSum = new Fraction(0, 1);
                    for (int s : productFilledIndexes) {
                        int quantity = (products.get(s)).get(currentElement);
                        productASum = Fraction.add(productASum, Fraction.multiply(products_a.get(s), new Fraction(quantity, 1)));
                        productBSum = Fraction.add(productBSum, Fraction.multiply(products_b.get(s), new Fraction(quantity, 1)));
                    }
                    if (unfilledIndexOnProduct) {
                        products_filled.set(unfilledIndex, true);
                        int unfilledQuantity = (products.get(unfilledIndex)).get(currentElement);
                        Fraction aCoefficient=Fraction.multiply( Fraction.subtract(reactantASum, productASum),new Fraction(1, unfilledQuantity));
                        Fraction bCoefficient=Fraction.multiply( Fraction.subtract(reactantBSum, productBSum),new Fraction(1, unfilledQuantity));
                        products_a.set(unfilledIndex, aCoefficient);
                        products_b.set(unfilledIndex, bCoefficient);
                    } else {
                        reactants_filled.set(unfilledIndex, true);
                        int unfilledQuantity = (reactants.get(unfilledIndex)).get(currentElement);
                        Fraction aCoefficient=Fraction.multiply( Fraction.subtract(productASum, reactantASum),new Fraction(1, unfilledQuantity));
                        Fraction bCoefficient=Fraction.multiply( Fraction.subtract(productBSum, reactantBSum),new Fraction(1, unfilledQuantity));
                        reactants_a.set(unfilledIndex, aCoefficient);
                        reactants_b.set(unfilledIndex, bCoefficient);
                    }
                    elements.remove(currentElement);
                    break;
                }
            }
        }
        LinkedList<Integer> reactantCoefficients;
        LinkedList<Integer> productCoefficients;
        if(b_used) {
            String elementToUse = elements.get(0);
            Fraction reactantASum = new Fraction(0, 1);
            for (int i = 0; i < reactants.size(); i++) {
                if (reactants.get(i).containsKey(elementToUse)) {
                    reactantASum = Fraction.add(reactantASum, Fraction.multiply(reactants_a.get(i), new Fraction(reactants.get(i).get(elementToUse), 1)));
                }
            }
            Fraction reactantBSum = new Fraction(0, 1);
            for (int i = 0; i < reactants.size(); i++) {
                if (reactants.get(i).containsKey(elementToUse)) {
                    reactantBSum = Fraction.add(reactantBSum, Fraction.multiply(reactants_b.get(i), new Fraction(reactants.get(i).get(elementToUse), 1)));
                }
            }
            Fraction productASum = new Fraction(0, 1);
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).containsKey(elementToUse)) {
                    productASum = Fraction.add(productASum, Fraction.multiply(products_a.get(i), new Fraction(products.get(i).get(elementToUse), 1)));
                }
            }
            Fraction productBSum = new Fraction(0, 1);
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).containsKey(elementToUse)) {
                    productBSum = Fraction.add(productBSum, Fraction.multiply(products_b.get(i), new Fraction(products.get(i).get(elementToUse), 1)));
                }
            }
            Fraction sumOfA;
            Fraction sumOfB;
            if ((reactantASum.getNumerator() / reactantASum.getDenominator()) >= (productASum.getNumerator() / productASum.getDenominator())) {
                sumOfA = Fraction.subtract(reactantASum, productASum);
                sumOfB = Fraction.subtract(productBSum, reactantBSum);
            } else {
                sumOfA = Fraction.subtract(productASum, reactantASum);
                sumOfB = Fraction.subtract(reactantBSum, productBSum);
            }
            if (sumOfA.getNumerator() < 0 && sumOfB.getNumerator() < 0) {
                sumOfA = Fraction.negate(sumOfA);
                sumOfB = Fraction.negate(sumOfB);
            }
            int gcf = Fraction.gcd(sumOfA.getNumerator(), sumOfB.getNumerator());
            int lcd= Fraction.lcm(sumOfA.getDenominator(), sumOfB.getDenominator());
            sumOfA = Fraction.multiply(sumOfA, new Fraction(lcd, gcf));
            sumOfB = Fraction.multiply(sumOfB, new Fraction(lcd, gcf));
            int varA = sumOfB.getNumerator() / sumOfB.getDenominator();
            int varB = sumOfA.getNumerator() / sumOfA.getDenominator();
            int finalLcd=1;
            for (int i=0; i<reactants.size(); i++)
                finalLcd=Fraction.lcm(finalLcd, Fraction.add(Fraction.multiply(reactants_a.get(i), new Fraction(varA, 1)), Fraction.multiply(reactants_b.get(i), new Fraction(varB,1))).getDenominator());
            for (int i=0; i<products.size(); i++)
                finalLcd=Fraction.lcm(finalLcd, Fraction.add(Fraction.multiply(products_a.get(i), new Fraction(varA, 1)), Fraction.multiply(products_b.get(i), new Fraction(varB,1))).getDenominator());
            varA*=finalLcd;
            varB*=finalLcd;
            reactantCoefficients = new LinkedList<>();
            for (int i = 0; i < reactants.size(); i++) {
                Fraction coefficientSumFraction = Fraction.add(Fraction.multiply(reactants_a.get(i), new Fraction(varA, 1)), Fraction.multiply(reactants_b.get(i), new Fraction(varB, 1)));
                reactantCoefficients.addLast(coefficientSumFraction.getNumerator() / coefficientSumFraction.getDenominator());
            }
            productCoefficients = new LinkedList<>();
            for (int i = 0; i < products.size(); i++) {
                Fraction coefficientSumFraction = Fraction.add(Fraction.multiply(products_a.get(i), new Fraction(varA, 1)), Fraction.multiply(products_b.get(i), new Fraction(varB, 1)));
                productCoefficients.addLast(coefficientSumFraction.getNumerator() / coefficientSumFraction.getDenominator());
            }
        }else{
            int lcd=1;
            for(Fraction f: reactants_a){
                lcd=Fraction.lcm(lcd, f.getDenominator());
            }
            for(Fraction f: products_a){
                lcd=Fraction.lcm(lcd, f.getDenominator());
            }
            reactantCoefficients = new LinkedList<>();
            for(Fraction f: reactants_a){
                reactantCoefficients.addLast(Fraction.multiply(f, new Fraction(lcd, 1)).getNumerator());
            }
            productCoefficients = new LinkedList<>();
            for(Fraction f: products_a){
                productCoefficients.addLast(Fraction.multiply(f, new Fraction(lcd, 1)).getNumerator());
            }
        }
        System.out.println("\nBalanced Equation: ");
        StringBuilder reactantString= new StringBuilder();
        String[] reactantsArray=(pre_reactants_String.replace(" ","")).split("\\+");
        for (int i=0; i<reactants.size(); i++) {
            reactantString.append(reactantCoefficients.get(i)).append(reactantsArray[i]);
            if(i<reactants.size()-1){
                reactantString.append(" + ");
            }
        }
        StringBuilder productString= new StringBuilder();
        String[] productsArray=(pre_products_String.replace(" ","")).split("\\+");
        for (int i=0; i<products.size(); i++) {
            productString.append(productCoefficients.get(i)).append(productsArray[i]);
            if(i<products.size()-1){
                productString.append(" + ");
            }
        }
        return(reactantString+" ---> "+productString);
    }
    private static Hashtable<Integer, Hashtable<String, Integer>> parseString(String inputString){
        Hashtable<Integer, Hashtable<String, Integer>> compoundTable= new Hashtable<>();
        String storeString = "";
        Integer index=0;
        for (int j=0; j<inputString.length(); j++) {
            if (Character.toString(inputString.charAt(j)).equals("+")) {
                compoundTable.put(index, parseCompound(storeString));
                storeString="";
                index=index+1;

            }
            else {
                storeString=storeString.concat(Character.toString(inputString.charAt(j)));
            }
        }
        compoundTable.put(index, parseCompound(storeString));
        return compoundTable;
    }
    private static String[] polyatomicReplacement(String reactant_String, String product_String){
        reactant_String=reactant_String.replace(" ", "");
        product_String=product_String.replace(" ", "");
        String[] replacementNames={"A", "D", "E", "G", "J", "L", "M", "Q", "R", "X"};
        String[] commonIons={"NH4", "C2H3O2", "HCO3","HSO4", "ClO", "ClO3", "ClO2", "OCN", "CN", "H2PO4", "OH", "NO3", "NO2", "ClO4", "MnO4", "SCN", "CO3", "CrO4", "Cr2O7", "HPO4", "SO4", "SO3", "S2O3", "BO3", "PO4"};
        int index=0;
        for(String ion: commonIons){
            if(reactant_String.contains(ion) && product_String.contains(ion)){
                reactant_String=reactant_String.replace(ion, replacementNames[index]);
                product_String=product_String.replace(ion, replacementNames[index]);
                index++;
            }
        }
        return new String[] {reactant_String, product_String};
    }
    private static Hashtable<String, Integer> parseCompound(String inputString) {
        Hashtable<String, Integer> dictionary = new Hashtable<>();
        String symbol = "";
        String numString = "";
        StringBuilder paranthesesStoreString= new StringBuilder();
        boolean parenthesesOn=false;
        boolean parenthesesEnd=false;
        String parenthesesScaler = "";
        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            if (Character.isLetter(character)) {
                if (String.valueOf(character).toUpperCase().equals(String.valueOf(character))){
                    if(!parenthesesOn && !parenthesesEnd) {
                        if (!symbol.equals("")) {
                            if (!dictionary.containsKey(symbol)) {
                                try {
                                    dictionary.put(symbol, Integer.valueOf(numString));
                                } catch (NumberFormatException exception) {
                                    dictionary.put(symbol, 1);
                                }
                            } else {
                                try {
                                    dictionary.put(symbol, Integer.valueOf(numString) + dictionary.get(symbol));
                                } catch (NumberFormatException exception) {
                                    dictionary.put(symbol, 1 + dictionary.get(symbol));
                                }
                            }
                            symbol = "";
                            numString = "";
                        }
                        symbol = symbol.concat(String.valueOf(character));
                    }else if(parenthesesOn && !parenthesesEnd){
                        paranthesesStoreString.append(character);
                    }else if(parenthesesEnd){
                        Hashtable<String, Integer> parenthesesParse=parseCompound(paranthesesStoreString.toString());
                        if(parenthesesScaler.equals(""))
                            parenthesesScaler="1";
                        for(String key: parenthesesParse.keySet()){
                            if (!dictionary.containsKey(key)) {
                                dictionary.put(key, parenthesesParse.get(key)*Integer.valueOf(parenthesesScaler));
                            } else {
                                dictionary.put(key, parenthesesParse.get(key)*Integer.valueOf(parenthesesScaler) + dictionary.get(key));
                            }
                        }
                        paranthesesStoreString = new StringBuilder();
                        parenthesesEnd=false;
                        parenthesesScaler="";
                        symbol = symbol.concat(String.valueOf(character));
                    }
                }
                else{
                    if(!parenthesesOn)
                        symbol = symbol.concat(String.valueOf(character));
                    else
                        paranthesesStoreString.append(character);
                }
            } else if (Character.isDigit(character)) {
                if(!parenthesesOn && !parenthesesEnd) {
                    numString = numString.concat(String.valueOf(character));
                }else if(parenthesesEnd && !parenthesesOn){
                    parenthesesScaler+=character;
                }else if(parenthesesOn && !parenthesesEnd){
                    paranthesesStoreString.append(character);
                }
            }else if(character=='('){
                if(!parenthesesEnd) {
                    parenthesesOn = true;
                    if (!dictionary.containsKey(symbol)) {
                        try {
                            dictionary.put(symbol, Integer.valueOf(numString));
                        } catch (NumberFormatException exception) {
                            dictionary.put(symbol, 1);
                        }
                    } else {
                        try {
                            dictionary.put(symbol, Integer.valueOf(numString) + dictionary.get(symbol));
                        } catch (NumberFormatException exception) {
                            dictionary.put(symbol, 1 + dictionary.get(symbol));
                        }
                    }
                    symbol = "";
                    numString = "";
                }else{
                    Hashtable<String, Integer> parenthesesParse=parseCompound(paranthesesStoreString.toString());
                    if(parenthesesScaler.equals(""))
                        parenthesesScaler="1";
                    for(String key: parenthesesParse.keySet()){
                        if (!dictionary.containsKey(key)) {
                            dictionary.put(key, parenthesesParse.get(key)*Integer.valueOf(parenthesesScaler));
                        } else {
                            dictionary.put(key, parenthesesParse.get(key)*Integer.valueOf(parenthesesScaler) + dictionary.get(key));
                        }
                    }
                    paranthesesStoreString = new StringBuilder();
                    parenthesesOn=true;
                    parenthesesEnd=false;
                    parenthesesScaler="";
                }
            }else if(character==')'){
                parenthesesEnd=true;
                parenthesesOn=false;
            }
        }
        if(!parenthesesEnd) {
            if (numString.equals("")) {
                numString = "1";
            }
            if (!dictionary.containsKey(symbol)) {
                dictionary.put(symbol, Integer.valueOf(numString));
            } else {
                dictionary.put(symbol, Integer.valueOf(numString) + dictionary.get(symbol));
            }
        }else{
            Hashtable<String, Integer> parenthesesParse=parseCompound(paranthesesStoreString.toString());
            if(parenthesesScaler.equals(""))
                parenthesesScaler="1";
            for(String key: parenthesesParse.keySet()){
                if (!dictionary.containsKey(key)) {
                    dictionary.put(key, parenthesesParse.get(key)*Integer.valueOf(parenthesesScaler));
                } else {
                    dictionary.put(key, parenthesesParse.get(key)*Integer.valueOf(parenthesesScaler) + dictionary.get(key));
                }
            }
        }
        return dictionary;
    }
    private static LinkedList<String> getElements(String inputString){
        LinkedList<String> elements=new LinkedList<>();
        String elementString="";
        char character = 0;
        for (int i=0; i<inputString.length(); i++){
            character=inputString.charAt(i);
            if (Character.isLetter(character)){
                if (String.valueOf(character).toUpperCase().equals(String.valueOf(character))){
                    if (!elementString.equals("")){
                        if (!elements.contains(elementString)){
                            elements.add(elementString);
                        }
                        elementString="";
                    }
                }
                elementString = elementString.concat(Character.toString(character));
            }
            else if (Character.toString(character).equals("+")){
                if (!elements.contains(elementString)){
                    elements.add(elementString);
                }
                elementString="";
            }
        }
        if (!Character.toString(character).equals("")){
            if (!elements.contains(elementString)) {
                elements.add(elementString);
            }
        }
        return elements;
    }
}
class Fraction{
    boolean active;
    private int numerator;
    private int denominator;
    Fraction() {
        this.active=false;
        this.numerator=0;
        this.denominator=1;
    }
    Fraction(int numerator, int denominator){
        this.active=true;
        int gcf=gcd(numerator, denominator);
        this.numerator=numerator/gcf;
        this.denominator=denominator/gcf;
    }
    static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
    static int lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }
    int getNumerator() {
        return numerator;
    }
    int getDenominator() {
        return denominator;
    }
    @Override
    public String toString() {
        return numerator+"/"+denominator;
    }
    static Fraction multiply(Fraction firstFraction, Fraction secondFraction){
        return new Fraction(firstFraction.getNumerator()*secondFraction.getNumerator(), firstFraction.getDenominator()*secondFraction.getDenominator());
    }
    static Fraction add(Fraction firstFraction, Fraction secondFraction){
        if(firstFraction.getNumerator()!=0 || secondFraction.getNumerator()!=0) {
            int additionLCM = lcm(firstFraction.getDenominator(), secondFraction.getDenominator());
            int scaledFirstNumerator=firstFraction.getNumerator()*additionLCM/firstFraction.getDenominator();
            int scaledSecondNumerator=secondFraction.getNumerator()*additionLCM/secondFraction.getDenominator();
            return new Fraction(scaledFirstNumerator+scaledSecondNumerator, additionLCM);
        }else if(!(firstFraction.getNumerator() == 0)){
            return new Fraction(secondFraction.getNumerator(), secondFraction.getDenominator());
        }else{
            return new Fraction(firstFraction.getNumerator(), firstFraction.getDenominator());
        }
    }
    static Fraction subtract(Fraction firstFraction, Fraction secondFraction){
        return add(firstFraction, negate(secondFraction));
    }
    static Fraction negate(Fraction fraction){
        return new Fraction(-fraction.getNumerator(), fraction.getDenominator());
    }
}
