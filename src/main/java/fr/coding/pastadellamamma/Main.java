package fr.coding.pastadellamamma;

import fr.coding.pastadellamamma.model.Employes;
import fr.coding.pastadellamamma.model.Restaurant;
import fr.coding.pastadellamamma.model.Table;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        instantiateEmploye();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("Pasta della Mama");
        stage.setScene(scene);
        stage.show();



    }

    public static Restaurant pastaDellaMamma;
public  void instantiateEmploye(){
    pastaDellaMamma = new Restaurant();
    Employes eployer1 = new Employes("louis", "edward", "serveur");
    Employes eployer2 = new Employes("pierre", "edward", "serveur");
    pastaDellaMamma.addEmployes(eployer1);
    pastaDellaMamma.addEmployes(eployer2);
    Table table1 = new Table("A01",4);
    Table table2 = new Table("A02",4);
    Table table3 = new Table("A03",6);
    Table table4 = new Table("A04",8);
    Table table5 = new Table("A05",2);
    pastaDellaMamma.addTables(table1);
    pastaDellaMamma.addTables(table2);
    pastaDellaMamma.addTables(table3);
    pastaDellaMamma.addTables(table4);
    pastaDellaMamma.addTables(table5);

}

    public static void main(String[] args) {
        launch();
    }
}
