package poo;

public class MainApplication {
    public static void main(String[] args) {
        // Inyección de dependencias en el punto de entrada
        IFileHandler fileHandler = new CsvFileHandler();
        ContentService service = new ContentService(fileHandler);
        ConsoleView view = new ConsoleView();

        MainController controller = new MainController(service, view);
        controller.run();
    }
}
