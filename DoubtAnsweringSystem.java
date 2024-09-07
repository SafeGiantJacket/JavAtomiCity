import java.util.Scanner;

public class DoubtAnsweringSystem {
    public static void ds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chemistry Doubt Answering System");
        
        while (true) {
            System.out.print("Enter your doubt (or type 'exit' to quit): ");
            String doubt = scanner.nextLine();
            
            if (doubt.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the system.");
                break;
            }
            
            String answer = processDoubt(doubt);
            System.out.println("Answer: " + answer);
        }
        
        scanner.close();
    }

    private static String processDoubt(String doubt) {
        if (doubt.contains("atom")) {
            return "An atom is the basic unit of a chemical element.";
        }  else if (doubt.contains("hi")) {
            return "Hello how can i help you today";
        }else if (doubt.contains("molecule")) {
            return "A molecule is a group of atoms bonded together.";
        } else if (doubt.contains("acid")) {
            return "An acid is a substance that donates protons.";
        } else if (doubt.contains("base")) {
            return "A base is a substance that accepts protons.";
        } else if (doubt.contains("valency")) {
            return "Valency is the combining capacity of an element.";
        } else if (doubt.contains("atomicity")) {
            return "Atomicity refers to the number of atoms in a molecule.";
        } else if (doubt.contains("radical")) {
            return "A radical is a group of atoms behaving as a single unit.";
        } else if (doubt.contains("chemical reactions")) {
            return "Chemical reactions involve the breaking and forming of bonds between atoms.";
        } else if (doubt.contains("properties of chemical reactions")) {
            return "Properties include changes in energy, color, odor, and formation of new substances.";
        } else if (doubt.contains("element")) {
            return "An element is a pure substance composed of atoms with the same number of protons.";
        } else if (doubt.contains("compound")) {
            return "A compound is a substance composed of two or more different elements.";
        } else if (doubt.contains("types of chemical reactions")) {
            return "There are various types, including synthesis, decomposition, combustion, and more.";
        } else if (doubt.contains("chemical equation")) {
            return "A chemical equation represents a balanced chemical reaction.";
        } else if (doubt.contains("periodic table")) {
            return "The periodic table organizes elements by increasing atomic number and similar properties.";
        } else if (doubt.contains("noble gases")) {
            return "Noble gases are group 18 elements with full valence electron shells.";
        } else if (doubt.contains("covalent bond")) {
            return "A covalent bond involves sharing electrons between atoms.";
        } else if (doubt.contains("ionic bond")) {
            return "An ionic bond forms when atoms transfer electrons to achieve stability.";
        } else if (doubt.contains("catalyst")) {
            return "A catalyst speeds up a chemical reaction without being consumed.";
        } else if (doubt.contains("exothermic reaction")) {
            return "An exothermic reaction releases heat to the surroundings.";
        } else if (doubt.contains("endothermic reaction")) {
            return "An endothermic reaction absorbs heat from the surroundings.";
        } else if (doubt.contains("oxidation")) {
            return "Oxidation involves the loss of electrons by an atom or molecule.";
        } else if (doubt.contains("reduction")) {
            return "Reduction involves the gain of electrons by an atom or molecule.";
        } else if (doubt.contains("metal")) {
            return "Metals are elements that tend to lose electrons and form positive ions.";
        } else if (doubt.contains("non-metal")) {
            return "Non-metals are elements that tend to gain electrons and form negative ions.";
        } else if (doubt.contains("metalloid")) {
            return "Metalloids have properties intermediate between metals and non-metals.";
        } else if (doubt.contains("alkali metal")) {
            return "Alkali metals are highly reactive metals found in Group 1 of the periodic table.";
        } else if (doubt.contains("halogen")) {
            return "Halogens are highly reactive non-metals found in Group 17 of the periodic table.";
        } else if (doubt.contains("transition metal")) {
            return "Transition metals are elements found in Groups 3 to 12 of the periodic table.";
        } else if (doubt.contains("alkaline earth metal")) {
            return "Alkaline earth metals are reactive metals found in Group 2 of the periodic table.";
        } else if (doubt.contains("valence electron")) {
            return "Valence electrons are the electrons in the outermost energy level of an atom.";
        } else if (doubt.contains("Lewis structure")) {
            return "A Lewis structure is a representation of the arrangement of atoms and valence electrons in a molecule.";
        } else if (doubt.contains("chemical bond")) {
            return "A chemical bond is a force that holds atoms together in a molecule.";
        } else if (doubt.contains("activation energy")) {
            return "Activation energy is the minimum energy required for a reaction to occur.";
        } else if (doubt.contains("endothermic reaction")) {
            return "An endothermic reaction absorbs heat from the surroundings.";
        } else if (doubt.contains("concentration")) {
            return "Concentration is the amount of solute dissolved in a solvent.";
        } else if (doubt.contains("acid-base titration")) {
            return "An acid-base titration is a technique used to determine the concentration of an acid or base.";
        } else if (doubt.contains("stoichiometry")) {
            return "Stoichiometry involves calculating the quantities of reactants and products in a chemical reaction.";
        } else if (doubt.contains("chemical change")) {
            return "A chemical change involves the formation of new substances with different properties.";
        } else if (doubt.contains("physical change")) {
            return "A physical change only alters the state or appearance of a substance without changing its composition.";
        } else if (doubt.contains("density")) {
            return "Density is the ratio of mass to volume and indicates how tightly packed a substance is.";
        } else if (doubt.contains("solubility")) {
            return "Solubility is the ability of a substance to dissolve in a solvent at a given temperature.";
        } else if (doubt.contains("law of conservation of mass")) {
            return "The law of conservation of mass states that mass is neither created nor destroyed in a chemical reaction.";
        } else if (doubt.contains("thank you")) {
            return "Your Welcome ";
        }else {
            return "Sorry, I don't have information on that topic.";
        }
    }
}
