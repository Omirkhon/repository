// Interface for clothing items
interface Clothing {
    void getDescription();
}

// Concrete implementations of clothing items
class Shirt implements Clothing {
    @Override
    public void getDescription() {
        System.out.println("This is a shirt.");
    }
}

class Pants implements Clothing {
    @Override
    public void getDescription() {
        System.out.println("These are pants.");
    }
}

// Factory to create clothing items
class ClothingFactory {
    public Clothing createClothing(String type) {
        if (type.equalsIgnoreCase("Shirt")) {
            return new Shirt();
        } else if (type.equalsIgnoreCase("Pants")) {
            return new Pants();
        } else {
            return null;
        }
    }
}

// Main class to test the factory
public class Main {
    public static void main(String[] args) {
        ClothingFactory factory = new ClothingFactory();

// Create a shirt
        Clothing shirt = factory.createClothing("Shirt");
        if (shirt != null) {
            shirt.getDescription();
        }

        // Create pants
        Clothing pants = factory.createClothing("Pants");
        if (pants != null) {
            pants.getDescription();
        }
    }
}