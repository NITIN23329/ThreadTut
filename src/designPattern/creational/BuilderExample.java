package designPattern.creational;

class Pizza{
    // base and size is mandatory
    private final int size;
    private final String baseTye;
    // rest are optional
   private String sauceType;
    private boolean cheese;
    private boolean olive;

    // Private constructor - only Builder can create
    private Pizza(Builder builder) {
        this.baseTye = builder.baseType;
        this.size = builder.size;
        this.sauceType = builder.sauceType;
        this.cheese = builder.cheese;
        this.olive = builder.olive;
    }

    static class Builder{

        // base and size is mandatory
        private final int size;
        private final String baseType;
        // rest are optional
        private String sauceType;
        private boolean cheese;
        private boolean olive;

        public Builder(String baseType, int size) {
            this.baseType = baseType;
            this.size = size;
        }
        public Builder sauceType(String sauceType) {
            this.sauceType = sauceType;
            return this;
        }
        public Builder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }
        public Builder olive(boolean olive) {
            this.olive = olive;
            return this;
        }
        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", baseTye='" + baseTye + '\'' +
                ", sauceType='" + sauceType + '\'' +
                ", cheese=" + cheese +
                ", olive=" + olive +
                '}';
    }
}


public class BuilderExample {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder( "wheat", 8)
                .sauceType("pizzaSauce")
                .cheese(true)
                .olive(false)
                .build();
        System.out.println(pizza);

    }

}
