package UI;
//import javafx.application.Platform;
//import javafx.scene.canvas.*;
//import javafx.scene.text.*;

import BattleField.*;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.*;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

import java.awt.*;
import java.io.*;
import java.lang.*;
import java.util.*;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.collections.*;
import javafx.scene.paint.*;
import javafx.fxml.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class Controller {
    //�ǿ��Ƶ���
    final static int row = 15;
    final static int col = 20;
    final static int EachWidth = 50;
    final static int EachHeight = 50;
    //private BattleField battleField;
    private MainCanvas board;
    @FXML
    private Text clock;
    @FXML
    private Canvas mainCanvas;
    @FXML
    private AnchorPane MapPane;
    @FXML
    private Button begin_btn;
    @FXML
    private Button read_btn;
    @FXML
    private Button save_btn;
    @FXML
    private TextArea textField;
    @FXML
    private ComboBox<String> selectedmap;
    //private File files;
    @FXML
    private ComboBox<String> selectedstrategy;

    @FXML
    public void initialize() {
        //MapPane.setGraphic
        //battleField = new BattleField();
        board = new MainCanvas(mainCanvas, textField, clock);
        selectedstrategy.getItems().clear();
        selectedstrategy.getItems().addAll("��Բ��", "��ʸ��", "������");
        selectedmap.getItems().clear();
        selectedmap.getItems().addAll("Ĭ��", "ɽ��", "����");
        //UpdateAllMap(battleField.GetMap());
    }

    @FXML
    public void OpenFile(ActionEvent event) {
        //read_btn.setText("Hello World, I am JavaFX!");
        FileChooser filechos = new FileChooser();
        File files = filechos.showOpenDialog(MapPane.getScene().getWindow());
        if (files != null) {
            //save_btn.setText(readFiles(files));
            //save_btn.setText("OK!");
            board.LoadBattle(files);

        }
    }

    @FXML
    public void SaveFile(ActionEvent event) {
        FileChooser filechos = new FileChooser();
        File file = filechos.showSaveDialog(MapPane.getScene().getWindow());
        board.SaveFile(file);
    }

    @FXML
    public void BeginBattle() {
        board.StartFight();
        //UpdateAllMap(battleField.GetMap());

    }

    public void UpdateAllMap(Holder[][] mp) {
        GraphicsContext gra = mainCanvas.getGraphicsContext2D();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //"resource/grass.png"
                gra.drawImage(new Image(mp[i][j].Getappearance()), j * EachWidth, i * EachHeight);
            }
        }
    }

    @FXML
    private void ResponseKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.L) {
            OpenFile(null);
        } else if (event.getCode() == KeyCode.P) {
            PauseBattle();
        } else if (event.getCode() == KeyCode.S) {
            SaveFile(null);
        } else if(event.getCode() == KeyCode.A){
            BeginBattle();
        }
    }

    private void PauseBattle() {

    }

    @FXML
    private void SetStrategy() {
        String t = selectedstrategy.getValue();
        board.SetStrategy(selectedstrategy.getValue());
        //String tmp = selectedstrategy.getSelectionModel().getSelectedItem();
        System.out.println(t);
    }

    @FXML
    private void SetMap() {
        board.SetMap(selectedmap.getValue());
    }
    /*@FXML
    private void onmenuSave(ActionEvent event) throws Exception{
        if(files==null){
            FileChooser filechos = new FileChooser();
            files = filechos.showSaveDialog(layoutpane.getScene().getWindow());
        }
        writeFiles(files, filecontent.getText());
    }
    @FXML
    private void onmenuclose(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private void onmenudelet(ActionEvent event){
        filecontent.setText("");
    }

    @FXML
    private void OonmenuAbout(ActionEvent event){
        JOptionPane.showMessageDialog(null, "JavaFX���±���һ��ʹ��JavaFX�����ļ��±���" ,"����",  JOptionPane.PLAIN_MESSAGE);
    }

    @FXML
    private void onContextSelectAll(ActionEvent event) {
        filecontent.selectAll();
    }*/
}
