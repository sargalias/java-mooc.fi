public class Main {
    public static void main(String[] args) {
        Bird bird1 = new Bird("Rose Starling", "Sturnus roseus", 2012);
        Bird bird2 = new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012);
        Bird bird3 = new Bird("Hooded Crow", "Corvus corone cornix", 2012);
        Bird bird4 = new Bird("Rose-Coloured Pastor", "Sturnus roseus", 2000);

        System.out.println( bird1.equals(bird2));   // same Latin name and same observation year: they are the same bird
        System.out.println( bird1.equals(bird3));   // different Latin name: they are not the same bird
        System.out.println( bird1.equals(bird4));   // different observation year: not the same bird
        System.out.println( bird1.hashCode()==bird2.hashCode() );
    }
}
