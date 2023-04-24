import java.util.zip.CheckedOutputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class App extends Application {

  Stage window;
  // Scene scene1, scene2;
  TabPane tabPane;

  public static void main(String[] args) throws Exception {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    try { // primaryStage.setTitle("Estudante");
      // Button bt = new Button("CLIQUE AQUI");
      // bt.setOnAction(
      // e -> {
      // System.out.println("CLICOU");
      // System.out.println("teste");
      // });

      // StackPane root = new StackPane();

      // root.getChildren().addAll(bt);

      // primaryStage.setScene(new Scene(root, 250, 300));
      // primaryStage.show();

      window = primaryStage;

      // Label label = new Label("Bem-vindo à primeira Scene");
      // Button button1 = new Button("Ir para a cena2");
      // button1.setOnAction(e -> {
      // window.setScene(scene2);
      // window.setTitle("Scene2");
      // });
      // // button1.setOnAction(e -> window.setTitle("scene2"));

      // // Layout 1
      // VBox layout1 = new VBox(20);
      // layout1.getChildren().addAll(label, button1);
      // scene1 = new Scene(layout1, 400, 200);

      // // Button 2
      // Button button2 = new Button("Ir para a cena1");
      // button2.setOnAction(e -> {
      // window.setScene(scene1);
      // window.setTitle("Scene1");
      // });

      // // Layout 2
      // StackPane layout2 = new StackPane();
      // layout2.getChildren().addAll(button2);
      // scene2 = new Scene(layout2, 600, 300);

      // window.setScene(scene1);
      window.setTitle("Scene1");
      // window.show();
      BorderPane borderPane = new BorderPane();

      tabPane = new TabPane();

      Tab tab1 = new Tab("Dados Pessoais");
      tab1.setClosable(false);

      GridPane gridPane = new GridPane();
      gridPane.setPadding(new Insets(16, 16, 16, 16));
      gridPane.setVgap(4);
      gridPane.setHgap(8);

      //   RGM
      Label rgmLabel = new Label("RGM: ");
      GridPane.setConstraints(rgmLabel, 0, 0);

      TextField rgmField = new TextField("1234567");
      GridPane.setConstraints(rgmField, 1, 0);
      //   RGM

      //   Nome
      Label nameLabel = new Label("Nome: ");
      GridPane.setConstraints(nameLabel, 2, 0, 1, 1);

      TextField nameField = new TextField("Vinicius Silva");
      GridPane.setConstraints(nameField, 3, 0, 2, 1);
      //   Nome

      //   Data de Nascimento
      Label dtnascLabel = new Label("Data de Nascimento: ");
      GridPane.setConstraints(dtnascLabel, 0, 1);

      TextField dtnascField = new TextField("06/10/2001");
      GridPane.setConstraints(dtnascField, 1, 1);
      //   Data de Nascimento

      //   CPF
      Label cpfLabel = new Label("CPF: ");
      GridPane.setConstraints(cpfLabel, 2, 1);

      TextField cpfField = new TextField("229.355.918-10");
      GridPane.setConstraints(cpfField, 3, 1);
      //   CPF

      //   Email
      Label emailLabel = new Label("Email: ");
      GridPane.setConstraints(emailLabel, 0, 2);

      TextField emailField = new TextField("sjf.vinicius@gmail.com");
      GridPane.setConstraints(emailField, 1, 2, 3, 1);
      //   Email

      //   Endereço
      Label endLabel = new Label("End: ");
      GridPane.setConstraints(endLabel, 0, 3);

      TextField endField = new TextField("Tv. Inezita Barroso, 34");
      GridPane.setConstraints(endField, 1, 3, 3, 1);
      //   Endereço

      //   municipio
      Label munLabel = new Label("Muncípio: ");
      GridPane.setConstraints(munLabel, 0, 4);

      TextField munField = new TextField("São Paulo");
      GridPane.setConstraints(munField, 1, 4);
      //   municipio

      //   UF
      Label ufLabel = new Label("UF: ");
      GridPane.setConstraints(ufLabel, 2, 4);

      ChoiceBox choiceuf = new ChoiceBox<>();
      choiceuf.getItems().addAll("SP", "MG", "BA");
      choiceuf.setValue("SP");
      //   choiceBox.getItems().add("MG");
      //   choiceBox.getItems().add("BA");

      HBox ufField = new HBox(choiceuf);

      //   TextField ufField = new TextField("SP");

      ufField.setMaxWidth(60);
      GridPane.setConstraints(ufField, 3, 4);
      //   UF

      //   Celular
      Label phoneLabel = new Label("Celular: ");
      GridPane.setConstraints(phoneLabel, 4, 4);

      TextField phoneField = new TextField("(11) 9-5980-5820");
      GridPane.setConstraints(phoneField, 5, 4);
      //   Celular

      gridPane
        .getChildren()
        .addAll(
          rgmLabel,
          rgmField,
          nameLabel,
          nameField,
          dtnascLabel,
          dtnascField,
          cpfLabel,
          cpfField,
          emailLabel,
          emailField,
          endLabel,
          endField,
          munLabel,
          munField,
          ufLabel,
          ufField,
          phoneLabel,
          phoneField
        );
      tab1.setContent(gridPane);

      Tab tab2 = new Tab("Curso");
      tab2.setClosable(false);

      GridPane gridPane2 = new GridPane();

      gridPane2.setPadding(new Insets(16, 16, 16, 16));
      gridPane2.setVgap(4);
      gridPane2.setHgap(8);

      //   Curso
      Label cursoLabel = new Label("Curso :");
      GridPane.setConstraints(cursoLabel, 0, 0);

      ChoiceBox choicecurse = new ChoiceBox<>();
      choicecurse.setMinWidth(600);
      choicecurse.getItems().addAll("Desenvolviment", "Análise", "Ciência");
      choicecurse.setValue("Ciência");

      HBox curseField = new HBox(choicecurse);
      GridPane.setConstraints(curseField, 1, 0);
      //   Curso

      //   Campus
      Label campusLabel = new Label("campus :");
      GridPane.setConstraints(campusLabel, 0, 1);

      ChoiceBox choicecampus = new ChoiceBox<>();
      choicecampus.setMinWidth(600);
      choicecampus.getItems().addAll("UNICID", "UNIP", "Anhanguera");
      choicecampus.setValue("UNICID");

      HBox campusField = new HBox(choicecampus);
      GridPane.setConstraints(campusField, 1, 1);
      //   Campus

      //   Período
      Label periodLabel = new Label("Período: ");
      periodLabel.autosize();
      GridPane.setConstraints(periodLabel, 0, 2);

      ToggleGroup toggleGroup = new ToggleGroup();

      RadioButton radioMat = new RadioButton("Matutino");
      radioMat.setToggleGroup(toggleGroup);
      GridPane.setConstraints(radioMat, 1, 2);

      RadioButton radioVes = new RadioButton("Vespertino");
      radioVes.setToggleGroup(toggleGroup);
      GridPane.setConstraints(radioVes, 2, 2);

      RadioButton radioNot = new RadioButton("Noturno");
      radioNot.setToggleGroup(toggleGroup);
      GridPane.setConstraints(radioNot, 3, 2);
      radioNot.setSelected(true);
      //   Período

      //   Lista de Botões com icones
      Image turnoffimg = new Image("./assets/image.png");
      ImageView turnoffImageView = new ImageView(turnoffimg);
      turnoffImageView.setFitWidth(60);
      turnoffImageView.setFitHeight(55);
      Button turnoff = new Button("turnoff");
      turnoff.setGraphic(turnoffImageView);
      turnoff.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      turnoff.setTooltip(new Tooltip("Desliga a operação"));
      turnoff.setOnAction(e -> System.out.println("Desligou"));
      GridPane.setConstraints(turnoff, 0, 3);
      //   Lista de Botões com icones

      gridPane2
        .getChildren()
        .addAll(
          cursoLabel,
          curseField,
          campusLabel,
          campusField,
          periodLabel,
          radioMat,
          radioVes,
          radioNot,
          turnoff
        );
      tab2.setContent(gridPane2);

      Tab tab3 = new Tab("Notas e Faltas");
      tab3.setClosable(false);

      Tab tab4 = new Tab("Boletim");
      tab4.setClosable(false);

      tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

      borderPane.setCenter(tabPane);

      Scene root = new Scene(borderPane, 750, 250);

      window.setScene(root);
      window.show();
    } catch (Error e) {
      System.out.println(e);
    }
  }
}
