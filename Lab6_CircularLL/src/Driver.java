public class Driver {
    public static void main(String[] args) throws Exception {
    Game gg=new Game();
    gg.insert("A");
    gg.insert("B");
    gg.insert("C");
    System.out.println("BEFORE GAME");
    gg.print();
    System.out.println("AFTER GAME");
   System.out.println(gg.playGame());

    }
}
