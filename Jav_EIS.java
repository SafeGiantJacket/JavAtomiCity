import java.util.*;
class Jav_EIS {
    static ArrayList<String> collectedElements = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("     | |              /\\  | |                (_)/ ____| (_) |         ");
        System.out.println("     | | __ ___   __ /  \\ | |_ ___  _ __ ___  _| |      _| |_ _   _  ");
        System.out.println(" _   | |/ _` \\    // /\\\\| __/ _ \\| '_ ` _ \\| | |     | | __| | | | ");
        System.out.println("| |__| | (_| |\\  // ____ \\ || (_) | | | | | | | |____ | | |_| |_| | |");
        System.out.println(" \\___/ \\_,_| \\//_/    \\_\\_\\__/|_| |_| |_|_|\\____||_|\\_| \\___ | ");
        System.out.println("                                                                  __/ | ");
        System.out.println("                                                                  |___/ ");
        while (true) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1) Select Element");
            System.out.println("2) Show Inventory");
            System.out.println("3) Perform Reaction");
            System.out.println("4) Chemical Reaction Balancer");
            System.out.println("5) Chemistry Doubt System");
            System.out.println("6) Search Reaction");
            System.out.println("7) Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    select();
                    break;                
                case 2:
                    showInventory();
                    break;
                case 3:
                    performReaction();
                    break;
                case 4:
                    balance();
                case 5:
                    DoubtAnsweringSystem.ds();
                    break;
                case 6:
                    search();
                    return;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    public static void search() {
        Scanner sc = new Scanner (System.in);
        System.out.print('\u000C');
        System.out.println("Search Reaction with Element:");
        String s = sc.next();
        List<String> rf = findAllReactionsWithElement(s);
        System.out.println("Reactions with "+s+" :");
        for (String reaction : rf) {
            System.out.println(reaction);
        }
    }
    public static void balance() {
        Scanner sc = new Scanner(System.in);
        System.out.print('\u000C');
        System.out.println("Enter Reactant Side :");
        String rs = sc.nextLine();
        System.out.println("Enter Product Side :");
        String ps = sc.nextLine();
        System.out.println(Balancer.bal(rs,ps));
    }
    public static void find() {
        Scanner sc = new Scanner(System.in);
        System.out.print('\u000C');
        System.out.println("Enter Atomic Number");
        int an = sc.nextInt();
        System.out.println("Enter Mass Number");
        int mn = sc.nextInt();
    }
    public static void select() {
        Scanner sc = new Scanner(System.in);
        System.out.print('\u000C');
        System.out.println("Enter the number for the element");
System.out.println("1) Hydrogen (H+) - Ion: H+");
System.out.println("3) Lithium - Ion: Li+");
System.out.println("4) Beryllium - Ion: Be2+");
System.out.println("5) Boron - Elemental: B");
System.out.println("6) Carbon - Elemental: C");
System.out.println("7) Nitrogen - Molecular: N2");
System.out.println("8) Oxygen - Molecular: O2");
System.out.println("9) Fluorine - Molecular: F2");
System.out.println("10) Neon - Elemental: Ne");
System.out.println("11) Sodium - Ion: Na+");
System.out.println("12) Magnesium - Ion: Mg2+");
System.out.println("13) Aluminium - Ion: Al3+");
System.out.println("14) Silicon - Elemental: Si");
System.out.println("15) Phosphorus - Molecular: P4");
System.out.println("16) Sulphur - Molecular: S8");
System.out.println("17) Chlorine - Molecular: Cl2");
System.out.println("18) Argon - Elemental: Ar");
System.out.println("19) Potassium - Ion: K+");
System.out.println("20) Calcium - Ion: Ca2+");
System.out.println("21) Iron(II) - Ion: Fe2+");
System.out.println("22) Iron(III) - Ion: Fe3+");
System.out.println("23) Zinc - Ion: Zn2+");
System.out.println("24) Lead(I) - Ion: Pb+");
System.out.println("25) Lead(II) - Ion: Pb2+");
System.out.println("26) Copper(I) - Ion: Cu+");
System.out.println("27) Copper(II) - Ion: Cu2+");
System.out.println("28) Carbonate - Ion: CO3^2-");
System.out.println("29) Sulphate - Ion: SO4^2-");
System.out.println("30) Sulphite - Ion: SO3^2-");
System.out.println("31) Hydroxide - Ion: OH-");
System.out.println("32) Nitric acid - Molecular: HNO3");
System.out.println("33) Nitrite - Ion: NO2-");
System.out.println("34) Nitrate - Ion: NO3-");
System.out.println("35) Heat - Energy: Heat");
System.out.println("36) Ice - Solid: H2O(s)");

        System.out.println("Enter your choice: ");
        int se = sc.nextInt();
        int an = 0, mn = 0;
        if (se == 1) {
            an = 1;
            mn = 1;
        } else if (se == 2) {
            an = 2;
            mn = 4;
        } else if (se == 3) {
            an = 3;
            mn = 7;
        } else if (se == 4) {
            an = 4;
            mn = 9;
        } else if (se == 5) {
            an = 5;
            mn = 11;
        } else if (se == 6) {
            an = 6;
            mn = 12;
        } else if (se == 7) {
            an = 7;
            mn = 14;
        } else if (se == 8) {
            an = 8;
            mn = 16;
        } else if (se == 9) {
            an = 9;
            mn = 19;
        } else if (se == 10) {
            an = 10;
            mn = 20;
        } else if (se == 11) {
            an = 11;
            mn = 23;
        } else if (se == 12) {
            an = 12;
            mn = 24;
        } else if (se == 13) {
            an = 13;
            mn = 27;
        } else if (se == 14) {
            an = 14;
            mn = 28;
        } else if (se == 15) {
            an = 15;
            mn = 31;
        } else if (se == 16) {
            an = 16;
            mn = 32;
        } else if (se == 17) {
            an = 17;
            mn = 35;
        } else if (se == 18) {
            an = 18;
            mn = 40;
        } else if (se == 19) {
            an = 19;
            mn = 39;
        } else if (se == 20) {
            an = 20;
            mn = 40;
        } else if (se == 21) {
            an = 999;
            mn = 999;
        } else if (se == 22) {
            an = 998;
            mn = 998;
        } else if (se == 23) {
            an = 997;
            mn = 997;
        } else if (se == 24) {
            an = 996;
            mn = 996;
        } else if (se == 25) {
            an = 995;
            mn = 995;
        } else if (se == 26) {
            an = 994;
            mn = 994;
        } else if (se == 27) {
            an = 993;
            mn = 993;
        } else if (se == 28) {
            an = 992;
            mn = 992;
        } else if (se == 29) {
            an = 991;
            mn = 991;
        } else if (se == 30) {
            an = 990;
            mn = 990;
        } else if (se == 31) {
            an = 989;
            mn = 989;
        } else if (se == 32) {
            an = 988;
            mn = 988;
        } else if (se == 33) {
            an = 987;
            mn = 987;
        } else if (se == 34) {
            an = 986;
            mn = 986;
        } else if (se == 35) {
            an = 985;
            mn = 985;
        } else if (se == 36) {
            an = 984;
            mn = 984;
        } else if (se == 37) {
            an = 983;
            mn = 983;
        }
        collectedElements.add(getElementName(an,mn));
    }
    public static void showInventory() {
        if (!collectedElements.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print('\u000C');
            System.out.println("Your Inventory:");
            int index = 1;
            for (String element : collectedElements) {
                System.out.println(index + ") " + element);
                index++;
            }
            System.out.println("Enter the number of the element to view facts or 0 to go back: ");
            int selectedElement = sc.nextInt();
            if (selectedElement > 0 && selectedElement <= collectedElements.size()) {
                displayElementFacts(collectedElements.get(selectedElement - 1));
            }
        } else {
            System.out.println("Your inventory is empty.");
        }
    }
    public static void performReaction() {
        if (collectedElements.size() >= 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print('\u000C');
            System.out.println("Select elements to perform a reaction (enter their numbers): ");
            for (int i = 0; i < collectedElements.size(); i++) {
                System.out.println((i + 1) + ") " + collectedElements.get(i));
            }
            int element1Index = sc.nextInt();
            int element2Index = sc.nextInt();
            if (element1Index >= 1 && element1Index <= collectedElements.size() &&
                element2Index >= 1 && element2Index <= collectedElements.size() &&
                element1Index != element2Index) {
                String element1 = collectedElements.get(element1Index - 1);
                String element2 = collectedElements.get(element2Index - 1);
                String reactionResult = createCompound(element1, element2);
                if (reactionResult != null && !getFirstWord(reactionResult).equals("No")) {
                    System.out.println("Performing reaction between " + element1 + " and " + element2);
                    System.out.println("Reaction result: " + reactionResult);            
                    collectedElements.remove(element1);
                    collectedElements.remove(element2);
                    collectedElements.add(getFirstWord(reactionResult));
                } else {
                    System.out.println("The selected elements cannot react to form a compound.");
                }
                String reactionByProductResult = createByProduct1(element1, element2);
                String reactionByProductResult2 = createByProduct2(element1, element2);
                if (reactionByProductResult != null && reactionByProductResult2 == null) {
                    System.out.println("By product: " + reactionByProductResult);             
                    collectedElements.add(getFirstWord(reactionByProductResult));
                } else if (reactionByProductResult2 != null) {
                    System.out.println("By products: " + reactionByProductResult + ", " + reactionByProductResult2 + ".");             
                    collectedElements.add(getFirstWord(reactionByProductResult));
                }
            } else {
                System.out.println("Invalid element selection.");
            }
        } else {
            System.out.println("You need at least 2 elements in your inventory to perform a reaction.");
        }
    }
    public static String getFirstWord(String sentence) {
        String[] words = sentence.split("-");
        return words[0];
    }
    public static String createCompound(String element1, String element2) {
    if ((element1.equals("Hydrogen") && element2.equals("Oxygen")) || (element1.equals("Oxygen") && element2.equals("Hydrogen"))) {
        return "Water - Covalent 2H₂ + O₂ -> 2H₂O";
    } else if ((element1.equals("Hot water") && element2.equals("Heat")) || (element1.equals("Heat") && element2.equals("Hot water"))) {
        return "Steam - Covalent H₂O(l) + Heat -> H₂O(g)";
    } else if ((element1.equals("Water") && element2.equals("Heat")) || (element1.equals("Heat") && element2.equals("Water"))) {
        return "Hot water - Covalent H₂O(l) + Heat -> H₂O(l)";
    } else if ((element1.equals("Water") && element2.equals("Ice")) || (element1.equals("Ice") && element2.equals("Water"))) {
        return "Cold water - Covalent H₂O(s) + H₂O(l) -> H₂O(l)";
    } else if ((element1.equals("Hydrogen") && element2.equals("Nitrogen")) || (element1.equals("Nitrogen") && element2.equals("Hydrogen"))) {
        return "Ammonia - Covalent 3H₂ + N₂ -> 2NH₃";
    } else if ((element1.equals("Carbon") && element2.equals("Oxygen")) || (element1.equals("Oxygen") && element2.equals("Carbon"))) {
        return "Carbon Dioxide - Covalent C + O₂ -> CO₂";
    } else if ((element1.equals("Carbon Dioxide") && element2.equals("Water")) || (element1.equals("Water") && element2.equals("Carbon Dioxide"))) {
        return "Glucose - Covalent 6CO₂ + 6H₂O -> C₆H₁₂O₆";
    } else if ((element1.equals("Cold water") && element2.equals("Sodium")) || (element1.equals("Sodium") && element2.equals("Cold water"))) {
        return "Sodium hydroxide - Ionic Na + H₂O -> NaOH + H₂";
    } else if ((element1.equals("Hydroxide") && element2.equals("Sodium")) || (element1.equals("Sodium") && element2.equals("Hydroxide"))) {
        return "Sodium hydroxide - Ionic Na + OH -> NaOH";
    } else if ((element1.equals("Cold water") && element2.equals("Potassium")) || (element1.equals("Potassium") && element2.equals("Cold water"))) {
        return "Potassium hydroxide - Ionic K + H₂O -> KOH + H₂";
    } else if ((element1.equals("Hydroxide") && element2.equals("Potassium")) || (element1.equals("Potassium") && element2.equals("Hydroxide"))) {
        return "Potassium hydroxide - Ionic K + OH -> KOH";
    } else if ((element1.equals("Cold water") && element2.equals("Calcium")) || (element1.equals("Calcium") && element2.equals("Cold water"))) {
        return "Calcium hydroxide - Ionic Ca + 2H₂O -> Ca(OH)₂ + H₂";
    } else if ((element1.equals("Oxygen") && element2.equals("Calcium")) || (element1.equals("Calcium") && element2.equals("Oxygen"))) {
        return "Calcium oxide - Ionic 2Ca + O₂ -> 2CaO";
    } else if ((element1.equals("Calcium oxide") && element2.equals("Water")) || (element1.equals("Water") && element2.equals("Calcium oxide"))) {
        return "Calcium hydroxide - Ionic CaO + H₂O -> Ca(OH)₂";
    } else if ((element1.equals("Hot water") && element2.equals("Magnesium")) || (element1.equals("Magnesium") && element2.equals("Hot water"))) {
        return "Magnesium hydroxide - Ionic Mg + 2H₂O -> Mg(OH)₂ + H₂";
    } else if ((element1.equals("Oxygen") && element2.equals("Aluminium")) || (element1.equals("Aluminium") && element2.equals("Oxygen"))) {
        return "Aluminium oxide - Ionic 4Al + 3O₂ -> 2Al₂O₃";
    } else if ((element1.equals("Steam") && element2.equals("Aluminium")) || (element1.equals("Aluminium") && element2.equals("Steam"))) {
        return "Aluminium oxide - Ionic 2Al + 3H₂O -> Al₂O₃ + 3H₂";
    } else if ((element1.equals("Steam") && element2.equals("Iron(III)")) || (element1.equals("Iron(III)") && element2.equals("Steam"))) {
        return "Iron(III) oxide - Ionic 2Fe + 3H₂O -> Fe₂O₃ + 3H₂";
    } else if ((element1.equals("Carbon") && element2.equals("Hydrogen")) || (element1.equals("Hydrogen") && element2.equals("Carbon"))) {
        return "Methane - Covalent C + 2H₂ -> CH₄";
    } else if ((element1.equals("Magnesium") && element2.equals("Steam")) || (element1.equals("Steam") && element2.equals("Magnesium"))) {
        return "Magnesium oxide - Ionic Mg + H₂O -> MgO + H₂";
    } else if ((element1.equals("Magnesium") && element2.equals("Oxygen")) || (element1.equals("Oxygen") && element2.equals("Magnesium"))) {
        return "Magnesium oxide - Ionic 2Mg + O₂ -> 2MgO";
    } else if ((element1.equals("Phosphorus") && element2.equals("Oxygen")) || (element1.equals("Oxygen") && element2.equals("Phosphorus"))) {
        return "Phosphorus pentoxide - Covalent 4P + 5O₂ -> 2P₂O₅";
    } else if ((element1.equals("Calcium") && element2.equals("Oxygen")) || (element1.equals("Oxygen") && element2.equals("Calcium"))) {
        return "Calcium oxide - Ionic 2Ca + O₂ -> 2CaO";
    } else if ((element1.equals("Hydrogen") && element2.equals("Chlorine")) || (element1.equals("Chlorine") && element2.equals("Hydrogen"))) {
        return "Hydrochloric acid - Covalent H₂ + Cl₂ -> 2HCl";
    } else if ((element1.equals("Hydrogen") && element2.equals("Sulphate")) || (element1.equals("Sulphate") && element2.equals("Hydrogen"))) {
        return "Sulphuric acid - Covalent H₂ + SO₄ -> H₂SO₄";
    } else if ((element1.equals("Iron(II)") && element2.equals("Hydroxide")) || (element1.equals("Hydroxide") && element2.equals("Iron(II)"))) {
        return "Iron(II) hydroxide - Ionic Fe + 2OH -> Fe(OH)₂";
    } else if ((element1.equals("Iron(III)") && element2.equals("Hydroxide")) || (element1.equals("Hydroxide") && element2.equals("Iron(III)"))) {
        return "Iron(III) hydroxide - Ionic Fe + 3OH -> Fe(OH)₃";
    } else if ((element1.equals("Iron(III)") && element2.equals("Chloride")) || (element1.equals("Chloride") && element2.equals("Iron(III)"))) {
        return "Iron(III) chloride - Ionic Fe + 3Cl -> FeCl₃";
    } else if ((element1.equals("Iron(II)") && element2.equals("Chloride")) || (element1.equals("Chloride") && element2.equals("Iron(II)"))) {
        return "Iron(II) chloride - Ionic Fe + 2Cl -> FeCl₂";
    } else if ((element1.equals("Copper") && element2.equals("Sulphate")) || (element1.equals("Sulphate") && element2.equals("Copper"))) {
        return "Copper(II) sulphate - Ionic Cu + SO₄ -> CuSO₄";
    } else if ((element1.equals("Sodium") && element2.equals("Chlorine")) || (element1.equals("Chlorine") && element2.equals("Sodium"))) {
        return "Sodium chloride - Ionic 2Na + Cl₂ -> 2NaCl";
    } else if ((element1.equals("Barium") && element2.equals("Sulphate")) || (element1.equals("Sulphate") && element2.equals("Barium"))) {
        return "Barium sulphate - Ionic Ba + SO₄ -> BaSO₄";
    } else if ((element1.equals("Ammonium") && element2.equals("Nitrate")) || (element1.equals("Nitrate") && element2.equals("Ammonium"))) {
        return "Ammonium nitrate - Ionic NH₄ + NO₃ -> NH₄NO₃";
    } else if ((element1.equals("Lithium") && element2.equals("Hydrogen")) || (element1.equals("Hydrogen") && element2.equals("Lithium"))) {
        return "Lithium hydride - Ionic 2Li + H₂ -> 2LiH";
    } else if ((element1.equals("Sulphur") && element2.equals("Oxygen")) || (element1.equals("Oxygen") && element2.equals("Sulphur"))) {
        return "Sulphur dioxide - Covalent S + O₂ -> SO₂";
    } else {
        return "No result found - Unknown No reaction available";
    }

    }
    
    public static String createByProduct1(String element1, String element2) {
        if ((element1.equals("Cold water") && element2.equals("Sodium")) || (element1.equals("Sodium") && element2.equals("Cold water"))) {
            return "Hydrogen";
        } else if ((element1.equals("Calcium oxide") && element2.equals("Hydrochloric acid")) || (element1.equals("Hydrochloric acid") && element2.equals("Calcium oxide"))) {
            return "Water";
        } else if ((element1.equals("Magnesium") && element2.equals("Iron(II) sulphate")) || (element1.equals("Iron(II) sulphate") && element2.equals("Magnesium"))) {
            return "Iron(II)";
        } else if ((element1.equals("Copper(II) oxide") && element2.equals("Sulphuric acid")) || (element1.equals("Sulphuric acid") && element2.equals("Copper(II) oxide"))) {
            return "Water";
        } else if ((element1.equals("Copper(II) oxide") && element2.equals("Nitric acid")) || (element1.equals("Nitric acid") && element2.equals("Copper(II) oxide"))) {
            return "Water";
        } else if ((element1.equals("Potassium hydroxide") && element2.equals("Sulphuric acid")) || (element1.equals("Sulphuric acid") && element2.equals("Potassium hydroxide"))) {
            return "Water";
        } else if ((element1.equals("Heat") && element2.equals("Lead(II) carbonate")) || (element1.equals("Lead(II) carbonate") && element2.equals("Heat"))) {
            return "Carbon dioxide";
        } else if ((element1.equals("Zinc oxide") && element2.equals("Nitric acid")) || (element1.equals("Nitric acid") && element2.equals("Zinc oxide"))) {
            return "Water";
        } else if ((element1.equals("Calcium chloride") && element2.equals("Sodium hydroxide")) || (element1.equals("Sodium hydroxide") && element2.equals("Calcium chloride"))) {
            return "Sodium chloride";
        } else if ((element1.equals("Calcium") && element2.equals("Hydrochloric acid")) || (element1.equals("Hydrochloric acid") && element2.equals("Cacium"))) {
            return "Hydrogen";
        } else if ((element1.equals("Copper(II) sulphate") && element2.equals("Sodium hydroxide")) || (element1.equals("Sodium hydroxide") && element2.equals("Copper(II) sulphate"))) {
            return "Sodium sulphate";
        } else if ((element1.equals("Lead(II) nitrate") && element2.equals("Ammonium hydroxide")) || (element1.equals("Ammonium hydroxide") && element2.equals("Lead(II) nitrate"))) {
            return "Sodium nitrate";
        } else if ((element1.equals("Barium chloride") && element2.equals("Sodium sulphate")) || (element1.equals("Sodium sulphate") && element2.equals("Barium chloride"))) {
            return "Sodium chloride";
        } else if ((element1.equals("Cold water") && element2.equals("Potassium")) || (element1.equals("Potassium") && element2.equals("Cold water"))) {
            return "Hydrogen";
        } else if ((element1.equals("Heat") && element2.equals("Copper(II) carbonate")) || (element1.equals("Copper(II) carbonate") && element2.equals("Heat"))) {
            return "Carbon dioxide";
        } else if ((element1.equals("Heat") && element2.equals("Calcium carbonate")) || (element1.equals("Calcium carbonate") && element2.equals("Heat"))) {
            return "Carbon dioxide";
        } else if ((element1.equals("Calcium oxide") && element2.equals("Water")) || (element1.equals("Water") && element2.equals("Calcium oxide"))) {
            return "Heat";
        } else if ((element1.equals("Cold water") && element2.equals("Calcium")) || (element1.equals("Calcium") && element2.equals("Cold water"))) {
            return "Water";
        } else if ((element1.equals("Potassium nitrate") && element2.equals("Heat")) || (element1.equals("Heat") && element2.equals("Potassium nitrate"))) {
            return "Oxygen";
        } else if ((element1.equals("Hydrogen") && element2.equals("Nitrogen")) || (element1.equals("Nitrogen") && element2.equals("Hydrogen"))) {
            return "Heat";
        } else if ((element1.equals("Hot water") && element2.equals("Magnesium")) || (element1.equals("Magnesium") && element2.equals("Hot water"))) {
            return "Hydrogen";
        } else if ((element1.equals("Steam") && element2.equals("Aluminium")) || (element1.equals("Aluminium") && element2.equals("Steam"))) {
            return "Hydrogen";
        } else if ((element1.equals("Carbon Dioxide") && element2.equals("Water")) || (element1.equals("Water") && element2.equals("Carbon Dioxide"))) {
            return "Oxygen";
        } else if ((element1.equals("Steam") && element2.equals("Iron(III)")) || (element1.equals("Iron(III)") && element2.equals("Steam"))) {
            return "Hydrogen";
        } else if ((element1.equals("Magnesium") && element2.equals("Steam")) || (element1.equals("Steam") && element2.equals("Magnesium"))) {
            return "Hydrogen";
        } else if ((element1.equals("Molten sodium chloride") && element2.equals("Electric current")) || (element1.equals("Electric current") && element2.equals("Molten sodium chloride"))) {
            return "Chlorine";
        } else if ((element1.equals("Water") && element2.equals("Electric current")) || (element1.equals("Electric current") && element2.equals("Water"))) {
            return "Oxygen";
        } else if ((element1.equals("Zinc") && element2.equals("Steam")) || (element1.equals("Steam") && element2.equals("Zinc"))) {
            return "Hydrogen";
        } else if ((element1.equals("Sodium hydroxide") && element2.equals("Aluminium oxide")) || (element1.equals("Aluminium oxide") && element2.equals("Sodium hydroxide"))) {
            return "Water";
        } else if ((element1.equals("Sodium hydroxide") && element2.equals("Lead oxide")) || (element1.equals("Lead oxide") && element2.equals("Sodium hydroxide"))) {
            return "Water";
        } else if ((element1.equals("Sodium hydroxide") && element2.equals("Zinc oxide")) || (element1.equals("Zinc oxide") && element2.equals("Sodium hydroxide"))) {
            return "Water";
        } else if ((element1.equals("Lead(II) nitrate") && element2.equals("Heat")) || (element1.equals("Heat") && element2.equals("Lead(II) nitrate"))) {
            return "Nitrite";
        } else if ((element1.equals("Zinc") && element2.equals("Sulphuric acid")) || (element1.equals("Sulphuric acid") && element2.equals("Zinc"))) {
            return "Hydrogen";
        } else if ((element1.equals("Sodium hydroxide") && element2.equals("Hydrochloric acid")) || (element1.equals("Hydrochloric acid") && element2.equals("Sodium hydroxide"))) {
            return "Water";
        } else if ((element1.equals("Sodium sulphite") && element2.equals("Hydrochloric acid")) || (element1.equals("Hydrochloric acid") && element2.equals("Sodium sulphite"))) {
            return "Water";
        } else if ((element1.equals("Copper(II)") && element2.equals("Sulphuric acid")) || (element1.equals("Sulphuric acid") && element2.equals("Copper(II)"))) {
            return "Hydrogen";
        } else if ((element1.equals("Iron(II)") && element2.equals("Copper(II) sulphate")) || (element1.equals("Copper(II) sulphate") && element2.equals("Iron(II)"))) {
            return "Copper(II)";
        } else if ((element1.equals("Copper(II)") && element2.equals("Hydrogen suphide")) || (element1.equals("Hydrogen suphide") && element2.equals("Copper(II)"))) {
            return "Sulphuric acid";
        } else if ((element1.equals("Iron(II) sulphate") && element2.equals("Sodium hydroxide")) || (element1.equals("Sodium hydroxide") && element2.equals("Iron(II) sulphate"))) {
            return "Sodium sulphate";
        } else if ((element1.equals("Barium chloride") && element2.equals("Sulphuric acid")) || (element1.equals("Sulphuric acid") && element2.equals("Barium chloride"))) {
            return "Hydrochloric acid";
        } else if ((element1.equals("Hydrogen suphide") && element2.equals("Chlorine")) || (element1.equals("Chlorine") && element2.equals("Hydrogen suphide"))) {
            return "Sulphur";
        } else {
            return null;
        }
    }
    public static String createByProduct2(String element1, String element2) {
        if ((element1.equals("Lead(II) nitrate") && element2.equals("Heat")) || (element1.equals("Heat") && element2.equals("Lead(II) nitrate"))) {
            return "Oxygen";
        } else if ((element1.equals("Sodium sulphite") && element2.equals("Hydrochloric acid")) || (element1.equals("Hydrochloric acid") && element2.equals("Sodium sulphite"))) {
            return "Sulphur dioxide";
        } else {
            return null;
        }
    }
       
    public static void displayElementFacts(String element) {
        switch (element) {
            case "Hydrogen":
                System.out.println("Hydrogen is the lightest and most abundant element in the universe.");
                break;
            case "Helium":
                System.out.println("Helium is a noble gas and has the lowest boiling point of all elements.");                
                break;
            case "Lithium":
                System.out.println("Used in rechargeable batteries and for treating bipolar disorder.");
                break;
            case "Beryllium":
                System.out.println("Used in aerospace applications due to its strength-to-weight ratio.");                
                break;
            case "Boron":
                System.out.println("Used in a variety of industries, including glass and ceramics.");
                break;
            case "Carbon":
                System.out.println("Basis of all organic compounds and essential for life.");                
                break;
            case "Nitrogen":
                System.out.println("Makes up about 78% of Earth's atmosphere.");
                break;
            case "Oxygen":
                System.out.println("Vital for respiration and combustion, making up about 21% of the atmosphere.");                
                break;
            case "Fluorine":
                System.out.println("Highly reactive element, often used in toothpaste and water fluoridation.");
                break;
            case "Neon":
                System.out.println("Used in neon signs due to its distinctive bright red-orange glow.");                
                break;
            case "Sodium":
                System.out.println("Lighter than water, sodium can be cut with a knife at room temperature but is brittle at low temperatures.");
                break;
            case "Magnesium":
                System.out.println("Magnesium is the eighth-most abundant element in the Earth's crust.");                
                break;
            case "Aluminium":
                System.out.println("Aluminium is the planet's most abundant metallic element.");
                break;
            case "Silicon":
                System.out.println("Silicon is the second most abundant element on Earth by mass, making up over 27% of the crust.");                
                break;
            case "Phosphorus":
                System.out.println("It is the second most abundant mineral in the body.");
                break;
            case "Sulphur":
                System.out.println("Sulfur is an element that exists in nature and can be found in soil, plants, foods, and water.");                
                break;
            case "Chlorine":
                System.out.println("Chlorine is a yellow-green gas at room temperature.");
                break;
            case "Argon":
                System.out.println("It remains colorless even in liquid and solid form.");                
                break;
            case "Potassium":
                System.out.println("Potassium metal is soft and white with a silvery lustre, has a low melting point, and is a good conductor of heat and electricity.");
                break;
            case "Calcium":
                System.out.println("The average human contains approximately 1kg of calcium, of which 99% is stored in our bones.");                
                break;
            case "Iron(II)":
                System.out.println("Iron is the main component of meteorites.");
                break;
            case "Iron(III)":
                System.out.println("Iron is the main component of meteorites.");                
                break;
            case "Zinc":
                System.out.println("It is the second most common trace metal, after iron, naturally found in the body.");
                break;
            case "Lead(I)":
                System.out.println("Lead is very malleable, ductile, and dense and is a poor conductor of electricity.");                
                break;
            case "Lead(II)":
                System.out.println("Lead is very malleable, ductile, and dense and is a poor conductor of electricity.");
                break;
            case "Nitrite":
                System.out.println("Nitrite is an intermediate product of the oxidation of ammonia to nitrate.");                
                break;
            case "Nitrate":
                System.out.println("Nitrates are chemical compounds formed from the combination of nitrogen and oxygen or ozone.");
                break;
            case "Sulphite":
                System.out.println("Sulphites are preservatives which keep food from spoiling and prevent discoloration.");                
                break;
            case "Sulphate":
                System.out.println("Sulfates can form during the decay of plant and animal matter, but they can also form as byproducts from the textile, mining, steel mill, and tannery industries.");
                break;
            case "Hydroxide":
                System.out.println("Hydroxide is a diatomic anion with chemical formula OH−.");                
                break;
            case "Copper(I)":
                System.out.println("Copper is element number 29 on the Periodic Table of Elements.");
                break;
            case "Copper(II)":
                System.out.println("Copper is element number 29 on the Periodic Table of Elements.");                
                break;
            case "Carbonate":
                System.out.println("Aluminium is the planet's most abundant metallic element.");
                break;
            case "Nitric acid":
                System.out.println("Nitric acid (HNO₃) is a colorless liquid with yellow or red fumes with an acrid odor.");                
                break;
            default:
                System.out.println("No facts available for this element.");
        }
    }
    public static String getElementName(int an, int mn) {
        if (an == 1 && mn == 1) {
            return "Hydrogen";
        } else if (an == 2 && mn == 4) {
            return "Helium";
        } else if (an == 3 && mn == 7) {
            return "Lithium";
        } else if (an == 4 && mn == 9) {
            return "Beryllium";
        } else if (an == 5 && mn == 11) {
            return "Boron";
        } else if (an == 6 && mn == 12) {
            return "Carbon";
        } else if (an == 7 && mn == 14) {
            return "Nitrogen";
        } else if (an == 8 && mn == 16) {
            return "Oxygen";
        } else if (an == 9 && mn == 19) {
            return "Fluorine";
        } else if (an == 10 && mn == 20) {
            return "Neon";
        } else if (an == 11 && mn == 23) {
            return "Sodium";
        } else if (an == 12 && mn == 24) {
            return "Magnesium";
        } else if (an == 13 && mn == 27) {
            return "Aluminium";
        } else if (an == 14 && mn == 28) {
            return "Silicon";
        } else if (an == 15 && mn == 31) {
            return "Phosphorus";
        } else if (an == 16 && mn == 32) {
            return "Sulphur";
        } else if (an == 17 && mn == 35) {
            return "Chlorine";
        } else if (an == 18 && mn == 40) {
            return "Argon";
        } else if (an == 19 && mn == 39) {
            return "Potassium";
        } else if (an == 20 && mn == 40) {
            return "Calcium";
        } else if (an == 999 && mn == 999) {
            return "Iron(II)";
        } else if (an == 998 && mn == 998) {
            return "Iron(III)";
        } else if (an == 997 && mn == 997) {
            return "Zinc";
        } else if (an == 996 && mn == 996) {
            return "Lead(I)";
        } else if (an == 995 && mn == 995) {
            return "Lead(II)";
        } else if (an == 994 && mn == 994) {
            return "Copper(I)";
        } else if (an == 993 && mn == 993) {
            return "Copper(II)";
        } else if (an == 992 && mn == 992) {
            return "Carbonate";
        } else if (an == 991 && mn == 991) {
            return "Sulphate";
        } else if (an == 990 && mn == 990) {
            return "Suphite";
        } else if (an == 989 && mn == 989) {
            return "Hydroxide";
        } else if (an == 988 && mn == 988) {
            return "Nitric acid";
        } else if (an == 987 && mn == 987) {
            return "Nitrite";
        } else if (an == 986 && mn == 986) {
            return "Nitrate";
        } else if (an == 985 && mn == 985) {
            return "Heat";
        } else if (an == 984 && mn == 984) {
            return "Ice";
        } else if (an == 983 && mn == 983) {
            return "Electric current";
        }
        return null; 
    }
    static class Reaction {
        String reactionType;
        String reactants;
        String products;

        Reaction(String reactionType, String reactants, String products) {
            this.reactionType = reactionType;
            this.reactants = reactants;
            this.products = products;
        }

        @Override
        public String toString() {
            return String.format("Reaction Type: %s\nReactants: %s\nProducts: %s\n", reactionType, reactants, products);
        }
    }

    private static final Map<String, Reaction> reactions = new HashMap<>();

    static {
        reactions.put("Hydrogen_Oxygen", new Reaction("Covalent", "2H₂ + O₂", "2H₂O"));
        reactions.put("Hot water_Heat", new Reaction("Covalent", "H₂O(l) + Heat", "H₂O(g)"));
        reactions.put("Water_Heat", new Reaction("Covalent", "H₂O(l) + Heat", "H₂O(l)"));
        reactions.put("Water_Ice", new Reaction("Covalent", "H₂O(s) + H₂O(l)", "H₂O(l)"));
        reactions.put("Hydrogen_Nitrogen", new Reaction("Covalent", "3H₂ + N₂", "2NH₃"));
        reactions.put("Carbon_Oxygen", new Reaction("Covalent", "C + O₂", "CO₂"));
        reactions.put("Carbon Dioxide_Water", new Reaction("Covalent", "6CO₂ + 6H₂O", "C₆H₁₂O₆"));
        reactions.put("Cold water_Sodium", new Reaction("Ionic", "Na + H₂O", "NaOH + H₂"));
        reactions.put("Hydroxide_Sodium", new Reaction("Ionic", "Na + OH", "NaOH"));
        reactions.put("Cold water_Potassium", new Reaction("Ionic", "K + H₂O", "KOH + H₂"));
        reactions.put("Hydroxide_Potassium", new Reaction("Ionic", "K + OH", "KOH"));
        reactions.put("Cold water_Calcium", new Reaction("Ionic", "Ca + 2H₂O", "Ca(OH)₂ + H₂"));
        reactions.put("Oxygen_Calcium", new Reaction("Ionic", "2Ca + O₂", "2CaO"));
        reactions.put("Calcium oxide_Water", new Reaction("Ionic", "CaO + H₂O", "Ca(OH)₂"));
        reactions.put("Hot water_Magnesium", new Reaction("Ionic", "Mg + 2H₂O", "Mg(OH)₂ + H₂"));
        reactions.put("Oxygen_Aluminium", new Reaction("Ionic", "4Al + 3O₂", "2Al₂O₃"));
        reactions.put("Steam_Aluminium", new Reaction("Ionic", "2Al + 3H₂O", "Al₂O₃ + 3H₂"));
        reactions.put("Steam_Iron(III)", new Reaction("Ionic", "2Fe + 3H₂O", "Fe₂O₃ + 3H₂"));
        reactions.put("Carbon_Hydrogen", new Reaction("Covalent", "C + 2H₂", "CH₄"));
        reactions.put("Magnesium_Steam", new Reaction("Ionic", "Mg + H₂O", "MgO + H₂"));
        reactions.put("Magnesium_Oxygen", new Reaction("Ionic", "2Mg + O₂", "2MgO"));
        reactions.put("Phosphorus_Oxygen", new Reaction("Covalent", "4P + 5O₂", "2P₂O₅"));
        reactions.put("Calcium_Oxygen", new Reaction("Ionic", "2Ca + O₂", "2CaO"));
        reactions.put("Hydrogen_Chlorine", new Reaction("Covalent", "H₂ + Cl₂", "2HCl"));
        reactions.put("Hydrogen_Sulphate", new Reaction("Covalent", "H₂ + SO₄", "H₂SO₄"));
        reactions.put("Iron(II)_Hydroxide", new Reaction("Ionic", "Fe + 2OH", "Fe(OH)₂"));
        reactions.put("Iron(III)_Hydroxide", new Reaction("Ionic", "Fe + 3OH", "Fe(OH)₃"));
        reactions.put("Iron(III)_Chloride", new Reaction("Ionic", "Fe + 3Cl", "FeCl₃"));
        reactions.put("Iron(II)_Chloride", new Reaction("Ionic", "Fe + 2Cl", "FeCl₂"));
        reactions.put("Copper_Sulphate", new Reaction("Ionic", "Cu + SO₄", "CuSO₄"));
    }

    public static String findReaction(String element1, String element2) {
        String key1 = element1 + "_" + element2;
        String key2 = element2 + "_" + element1;

        if (reactions.containsKey(key1)) {
            return reactions.get(key1).toString();
        } else if (reactions.containsKey(key2)) {
            return reactions.get(key2).toString();
        } else {
            return "No result found. Unknown reaction.";
        }
    }

    public static List<String> findAllReactionsWithElement(String element) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Reaction> entry : reactions.entrySet()) {
            String[] elements = entry.getKey().split("_");
            if (elements[0].equals(element) || elements[1].equals(element)) {
                result.add(entry.getValue().toString());
            }
        }
        return result;
    }
}
