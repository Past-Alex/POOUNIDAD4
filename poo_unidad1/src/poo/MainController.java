package poo;

public class MainController {
    private final ContentService service;
    private final ConsoleView view;

    public MainController(ContentService service, ConsoleView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        int choice;
        do {
            view.displayMenu();
            choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    service.loadData();
                    view.showMessage("Datos cargados correctamente.");
                    break;
                case 2:
                    service.saveData();
                    view.showMessage("Datos guardados correctamente.");
                    break;
                case 3:
                    view.displayContents(service.getAllContents());
                    break;
                case 0:
                    view.showMessage("Saliendo del sistema...");
                    break;
                default:
                    view.showMessage("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 0);
    }
}
