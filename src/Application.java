
public class Application {
    public static void main(String[] args) {
        //создаем окно
        MainFrame mainFrame = new MainFrame();

        //запускаем игрушку
        Thread thread = new Thread(new RunGame(mainFrame));
        thread.start();
    }
}
