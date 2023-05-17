package assets.view;

import assets.controller.EstudanteController;
import assets.model.Estudante;
import assets.sharing.Connectionfactory;
import java.sql.Connection;
import java.util.zip.CheckedOutputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
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

  TabPane tabPane;

  Connectionfactory conexao;

    public static void main(String[] args) throws Exception {
    // Connectionfactory con = new Connectionfactory();
    // con.SendQuery("SELECT * FROM aluno");
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
      window.setTitle("Estudantes");

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
      choiceuf.getItems().add(0, "SP");
      choiceuf.getItems().add(1, "BA");
      choiceuf.getItems().add(2, "MG");

      choiceuf.setValue("SP");

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
      // choicecurse.setPrefWidth(600);
      choicecurse
        .getItems()
        .addAll("Desenvolvimento", "Análise de dessenvolvimento", "Ciência");
      choicecurse.setValue("Ciência");
      choicecurse.setPrefWidth(300);

      HBox curseField = new HBox(choicecurse);
      GridPane.setConstraints(curseField, 1, 0);
      //   Curso

      //   Campus
      Label campusLabel = new Label("Campus :");
      GridPane.setConstraints(campusLabel, 0, 1);

      ChoiceBox choicecampus = new ChoiceBox<>();
      choicecampus.setPrefWidth(300);
      // choicecampus.setMaxWidth(400);
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
      // radioMat.setPadding(new Insets(0, 20, 0, 0));
      GridPane.setHgrow(radioMat, null);

      RadioButton radioVes = new RadioButton("Vespertino");
      radioVes.setToggleGroup(toggleGroup);
      // radioVes.setPadding(new Insets(0, 20, 0, 0));

      RadioButton radioNot = new RadioButton("Noturno");
      radioNot.setToggleGroup(toggleGroup);
      // radioNot.setPadding(new Insets(0, 20, 0, 0));
      radioNot.setSelected(true);
      //   Período

      HBox boxradiobt = new HBox(radioMat, radioVes, radioNot);
      boxradiobt.setSpacing(10);
      GridPane.setConstraints(boxradiobt, 1, 2);

      //   Lista de Botões com icones
      //? BTN1
      Image imgbt1 = new Image("./assets/image.png");

      ImageView btnimgview = new ImageView(imgbt1);
      btnimgview.setFitWidth(60);
      btnimgview.setFitHeight(55);

      Button btn1 = new Button("btn1");
      btn1.setGraphic(btnimgview);
      btn1.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn1.setTooltip(new Tooltip("Desliga a operação"));
      btn1.setOnAction(e -> System.out.println("btn1"));
      // GridPane.setConstraints(btn1, 0, 3);
      //? BTN1
      //? BTN2
      Image imgbt2 = new Image("./assets/image.png");

      ImageView btn2imgview = new ImageView(imgbt2);
      btn2imgview.setFitWidth(60);
      btn2imgview.setFitHeight(55);

      Button btn2 = new Button("btn2");
      btn2.setGraphic(btn2imgview);
      btn2.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn2.setTooltip(new Tooltip("Desliga a operação"));
      btn2.setOnAction(e -> System.out.println("btn2"));
      // GridPane.setConstraints(btn2, 1, 3);
      //? BTN2
      //? BTN3
      Image imgbt3 = new Image("./assets/image.png");
      ImageView btn3imgview = new ImageView(imgbt3);
      btn3imgview.setFitWidth(60);
      btn3imgview.setFitHeight(55);
      Button btn3 = new Button("btn3");
      btn3.setGraphic(btn3imgview);
      btn3.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn3.setTooltip(new Tooltip("Desliga a operação"));
      btn3.setOnAction(e -> System.out.println("btn3"));
      // GridPane.setConstraints(btn3, 2, 3);
      //? BTN3
      //? BTN4
      Image imgbt4 = new Image("./assets/image.png");

      ImageView btn4imgview = new ImageView(imgbt4);
      btn4imgview.setFitWidth(60);
      btn4imgview.setFitHeight(55);

      Button btn4 = new Button("btn4");
      btn4.setGraphic(btn4imgview);
      btn4.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn4.setTooltip(new Tooltip("Desliga a operação"));
      btn4.setOnAction(e -> System.out.println("btn4"));
      // GridPane.setConstraints(btn4, 3, 3);
      //? BTN4
      //? BTN5
      Image imgbt5 = new Image("./assets/image.png");

      ImageView btn5imgview = new ImageView(imgbt5);
      btn5imgview.setFitWidth(60);
      btn5imgview.setFitHeight(55);

      Button btn5 = new Button("btn5");
      btn5.setGraphic(btn5imgview);
      btn5.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn5.setTooltip(new Tooltip("Desliga a operação"));
      btn5.setOnAction(e -> System.out.println("btn5"));
      // GridPane.setConstraints(btn4, 3, 3);
      //? BTN5
      //   Lista de Botões com icones

      HBox boxbtn = new HBox(btn1, btn2, btn3, btn4, btn5);
      boxbtn.setSpacing(10);
      GridPane.setConstraints(boxbtn, 0, 3, 2, 1);

      gridPane2
        .getChildren()
        .addAll(
          cursoLabel,
          curseField,
          campusLabel,
          campusField,
          periodLabel,
          // radioMat,
          // radioVes,
          // radioNot,
          boxradiobt,
          // btn1,
          // btn2,
          // btn3,
          // btn4,
          boxbtn
        );
      tab2.setContent(gridPane2);

      Tab tab3 = new Tab("Notas e Faltas");
      tab3.setClosable(false);

      GridPane gridPane3 = new GridPane();
      gridPane3.setPadding(new Insets(16, 16, 16, 16));
      gridPane3.setVgap(4);
      gridPane3.setHgap(8);

      //   RGM
      Label rgmLabel2 = new Label("RGM: ");
      GridPane.setConstraints(rgmLabel2, 0, 0);

      TextField rgmField2 = new TextField("1234567");
      GridPane.setConstraints(rgmField2, 1, 0);
      //   RGM

      //   Nome
      TextField nameField2 = new TextField("Vinicius Silva de Jesus");
      GridPane.setConstraints(nameField2, 2, 0, 4, 1);
      //   Nome

      // Curso
      TextField courseField2 = new TextField("Ciência da Computação");
      GridPane.setConstraints(courseField2, 0, 1, 6, 1);
      // Curso

      // Disciplina
      Label labeldiscipline = new Label("Disciplina: ");
      GridPane.setConstraints(labeldiscipline, 0, 2);

      ChoiceBox choicediscipline = new ChoiceBox<>();
      // choicediscipline.setPrefWidth(315);
      // choicediscipline.setMaxWidth(400);
      choicediscipline
        .getItems()
        .addAll(
          "Estrutura de Dados",
          "Programação Orientada à Objetos",
          "Programação WEB"
        );
      choicediscipline.setValue("Estrutura de Dados");

      HBox disciplineField = new HBox(choicediscipline);
      GridPane.setConstraints(disciplineField, 1, 2, 5, 1);
      // Disciplina

      // Semestre Nota Faltas
      Label semesterlabel = new Label("Semestre: ");
      // GridPane.setConstraints(semestrelabel, 0, 3);

      ChoiceBox choicesem = new ChoiceBox<>();
      // choicediscipline.setPrefWidth(315);
      // choicesem.setMaxWidth(400);
      choicesem
        .getItems()
        .addAll("1º Sem", "2º Sem", "3º Sem", "4º Sem", "5º Sem", "6º Sem");
      choicesem.setValue("1º Sem");

      Label notelabel = new Label("Nota: ");
      TextField noteField = new TextField("10");

      Label faultlabel = new Label("Faltas: ");
      TextField faultField = new TextField("10");

      HBox semnotfaltbox = new HBox(
        semesterlabel,
        choicesem,
        notelabel,
        noteField,
        faultlabel,
        faultField
      );
      semnotfaltbox.setSpacing(10);
      GridPane.setConstraints(semnotfaltbox, 0, 3, 5, 1);

      // Semestre Nota Faltas

      //   Lista de Botões com icones
      //? BTN12
      Image imgbt12 = new Image("./assets/image.png");

      ImageView btnimgview2 = new ImageView(imgbt12);
      btnimgview2.setFitWidth(60);
      btnimgview2.setFitHeight(55);

      Button btn12 = new Button("btn12");
      btn12.setGraphic(btnimgview2);
      btn12.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn12.setTooltip(new Tooltip("Desliga a operação"));
      btn12.setOnAction(e -> System.out.println("btn12"));
      // GridPane.setConstraints(btn12, 0, 3);
      //? BTN12
      //? BTN22
      Image imgbt22 = new Image("./assets/image.png");

      ImageView btn2imgview2 = new ImageView(imgbt22);
      btn2imgview2.setFitWidth(60);
      btn2imgview2.setFitHeight(55);

      Button btn22 = new Button("btn22");
      btn22.setGraphic(btn2imgview2);
      btn22.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn22.setTooltip(new Tooltip("Desliga a operação"));
      btn22.setOnAction(e -> System.out.println("btn22"));
      // GridPane.setConstraints(btn22, 1, 3);
      //? BTN22
      //? BTN32
      Image imgbt32 = new Image("./assets/image.png");
      ImageView btn3imgview2 = new ImageView(imgbt32);
      btn3imgview2.setFitWidth(60);
      btn3imgview2.setFitHeight(55);
      Button btn32 = new Button("btn32");
      btn32.setGraphic(btn3imgview2);
      btn32.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn32.setTooltip(new Tooltip("Desliga a operação"));
      btn32.setOnAction(e -> System.out.println("btn32"));
      // GridPane.setConstraints(btn32, 2, 3);
      //? BTN32
      //? BTN42
      Image imgbt42 = new Image("./assets/image.png");

      ImageView btn4imgview2 = new ImageView(imgbt42);
      btn4imgview2.setFitWidth(60);
      btn4imgview2.setFitHeight(55);

      Button btn42 = new Button("btn42");
      btn42.setGraphic(btn4imgview2);
      btn42.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn42.setTooltip(new Tooltip("Desliga a operação"));
      btn42.setOnAction(e -> System.out.println("btn42"));
      // GridPane.setConstraints(btn42, 3, 3);
      //? BTN42
      //? BTN52
      Image imgbt52 = new Image("./assets/image.png");

      ImageView btn5imgview2 = new ImageView(imgbt52);
      btn5imgview2.setFitWidth(60);
      btn5imgview2.setFitHeight(55);

      Button btn52 = new Button("btn52");
      btn52.setGraphic(btn5imgview2);
      btn52.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      btn52.setTooltip(new Tooltip("Desliga a operação"));
      btn52.setOnAction(e -> System.out.println("btn52"));
      // GridPane.setConstraints(btn4, 3, 3);
      //? BTN52
      //   Lista de Botões com icones

      HBox boxbtn2 = new HBox(btn12, btn22, btn32, btn42, btn52);
      boxbtn2.setSpacing(20);
      GridPane.setConstraints(boxbtn2, 0, 4, 4, 1);

      gridPane3
        .getChildren()
        .addAll(
          rgmLabel2,
          rgmField2,
          nameField2,
          courseField2,
          labeldiscipline,
          disciplineField,
          semnotfaltbox,
          boxbtn2
        );

      tab3.setContent(gridPane3);

      Tab tab4 = new Tab("Boletim");
      tab4.setClosable(false);

      tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

      borderPane.setCenter(tabPane);
      borderPane.setLayoutY(25);

      Group group = new Group();
      // group.getChildren().addAll(menuBar,borderPane);
      // Scene root = new Scene(borderPane, 750, 250);
      Scene root = new Scene(group, 750, 255);

      Menu menu1 = new Menu("Aluno");
      MenuItem menuItem1 = new MenuItem("Salvar");
      menuItem1.setOnAction(e -> {
        // EstudanteController estCtlr = new EstudanteController();
        // Estudante est = new Estudante(
        //   rgmField.getText().toString(),
        //   nameField.getText().toString(),
        //   dtnascField.getText().toString(),
        //   cpfField.getText().toString(),
        //   emailField.getText().toString(),
        //   endField.getText().toString(),
        //   munField.getText().toString(),
        //   ufLabel.getText().toString(),
        //   phoneField.getText().toString()
        // );

        EstudanteController estctrl = new EstudanteController();

        // estctrl.CreateEstudante(est);

        estctrl.CreateEstudante(
          rgmField.getText().toString(),
          nameField.getText().toString(),
          dtnascField.getText().toString(),
          cpfField.getText().toString(),
          emailField.getText().toString(),
          endField.getText().toString(),
          munField.getText().toString(),
          choiceuf.getValue().toString(),
          phoneField.getText().toString()
        );
      });
      KeyCombination shortsave = new KeyCodeCombination(
        KeyCode.S,
        KeyCombination.CONTROL_DOWN
      );
      menuItem1.setAccelerator(shortsave);

      MenuItem menuItem2 = new MenuItem("Alterar");
      menuItem2.setOnAction(e -> {

        EstudanteController estctrl = new EstudanteController();

        Estudante est = estctrl.UpdateEstudante(
          rgmField.getText().toString(),
          nameField.getText().toString(),
          dtnascField.getText().toString(),
          cpfField.getText().toString(),
          emailField.getText().toString(),
          endField.getText().toString(),
          munField.getText().toString(),
          choiceuf.getValue().toString() ,
          phoneField.getText().toString()
        );

        if(est != null){

          nameField.setText(est.getNome());
          dtnascField.setText(est.getNasc());
          cpfField.setText(est.getCpf());
          emailField.setText(est.getEmail());
          endField.setText(est.getEnd());
          munField.setText(est.getMun());
          choiceuf.setValue(est.getUf());
          phoneField.setText(est.getCelular());

        }
      });

      MenuItem menuItem3 = new MenuItem("Consultar");
      menuItem3.setOnAction(e -> {
        EstudanteController estctrl = new EstudanteController();

        Estudante estbuscado = estctrl.ListOneEstudante(
          rgmField.getText().toString()
        );

        if (estbuscado != null) {
          nameField.setText(estbuscado.getNome());
          dtnascField.setText(estbuscado.getNasc());
          cpfField.setText(estbuscado.getCpf());
          emailField.setText(estbuscado.getEmail());
          endField.setText(estbuscado.getEnd());
          munField.setText(estbuscado.getMun());
          choiceuf.setValue(estbuscado.getUf());
          phoneField.setText(estbuscado.getCelular());
        }
      });

      MenuItem menuItem4 = new MenuItem("Excluir");

      menuItem4.setOnAction(e -> {
        EstudanteController estctrl = new EstudanteController();

        int returnestctrl = estctrl.DeleteOneEstudante(
          rgmField.getText().toString()
        );

        if (returnestctrl > 0) {
          rgmField.setText("");
          nameField.setText("");
          dtnascField.setText("");
          cpfField.setText("");
          emailField.setText("");
          endField.setText("");
          munField.setText("");
          choiceuf.setValue("");
          phoneField.setText("");
        }
      });

      //? ----------------------------------------------
      MenuItem menuItem5 = new MenuItem("Sair");
      menuItem5.setOnAction(e -> {
        System.exit(0);
      });
      KeyCombination shortexit = new KeyCodeCombination(
        KeyCode.R,
        KeyCombination.SHIFT_DOWN
      );
      menuItem5.setAccelerator(shortexit);

      // MenuItem menuItem2 = new MenuItem("Notas e Faltas");
      // MenuItem menuItem3 = new MenuItem("Ajuda");

      menu1
        .getItems()
        .addAll(menuItem1, menuItem2, menuItem3, menuItem4, menuItem5);

      Menu menu2 = new Menu("Notas e Faltas");
      MenuItem menu2Item1 = new MenuItem("Salvar");
      MenuItem menu2Item2 = new MenuItem("Alterar");
      KeyCombination shortalt = new KeyCodeCombination(
        KeyCode.A,
        KeyCombination.CONTROL_DOWN
      );
      menu2Item2.setAccelerator(shortalt);
      MenuItem menu2Item3 = new MenuItem("Excluir");
      MenuItem menu2Item4 = new MenuItem("Consultar");

      menu2.getItems().addAll(menu2Item1, menu2Item2, menu2Item3, menu2Item4);

      Menu menu3 = new Menu("Ajuda");
      MenuItem menu3Item1 = new MenuItem("Sobre");
      KeyCombination shorthelp = new KeyCodeCombination(
        KeyCode.F9,
        KeyCombination.ALT_ANY
      );
      menu3Item1.setAccelerator(shorthelp);

      menu3.getItems().addAll(menu3Item1);

      MenuBar menuBar = new MenuBar();
      menuBar.getMenus().addAll(menu1, menu2, menu3);

      group.getChildren().add(menuBar);
      group.getChildren().add(borderPane);

      // root.setOnKeyPressed(
      //   new EventHandler<KeyEvent>() {
      //     @Override
      //     public void handle(KeyEvent evt) {
      //       if (evt.getCode() == KeyCode.S && evt.isControlDown()) {
      //         // System.out.println("Salvar");
      //         // System.out.println(rgmField.getText());

      //         // EstudanteController estCtlr = new EstudanteController();
      //         // Estudante est = new Estudante(
      //         //   rgmField.getText().toString(),
      //         //   nameField.getText().toString(),
      //         //   dtnascField.getText().toString(),
      //         //   cpfField.getText().toString(),
      //         //   emailField.getText().toString(),
      //         //   endField.getText().toString(),
      //         //   munField.getText().toString(),
      //         //   ufLabel.getText().toString(),
      //         //   phoneField.getText().toString()
      //         // );

      //         // EstudanteController estctrl = new EstudanteController();

      //         // // estctrl.CreateEstudante(est);

      //         // estctrl.CreateEstudante(
      //         //   rgmField.getText().toString(),
      //         //   nameField.getText().toString(),
      //         //   dtnascField.getText().toString(),
      //         //   cpfField.getText().toString(),
      //         //   emailField.getText().toString(),
      //         //   endField.getText().toString(),
      //         //   munField.getText().toString(),
      //         //   ufLabel.getText().toString(),
      //         //   phoneField.getText().toString()
      //         // );
      //       } else if (evt.getCode() == KeyCode.A && evt.isControlDown()) {
      //         System.out.println("Alterar");
      //       } else if (evt.getCode() == KeyCode.R && evt.isShiftDown()) {
      //         System.exit(0);
      //       } else if (evt.getCode() == KeyCode.F9) {
      //         System.out.println("Ajuda");
      //       }
      //     }
      //   }
      // );

      window.setScene(root);
      window.show();
    } catch (Error e) {
      System.out.println(e);
    }
  }
}
