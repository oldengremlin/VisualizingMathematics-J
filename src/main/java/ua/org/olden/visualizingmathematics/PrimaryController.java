package ua.org.olden.visualizingmathematics;

import java.io.IOException;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ua.org.olden.stringnumeric.StringNumeric;
import ua.org.olden.stringnumeric.StringNumericRecord;

public class PrimaryController {

    @FXML
    private VBox mainWindows;

    @FXML
    private TextField value_a;

    @FXML
    private TextField value_b;

    @FXML
    private TextArea operationResult;

    @FXML
    private Button btn_addAB;

    @FXML
    private Button btn_subAB;

    @FXML
    private Button btn_mulAB;

    @FXML
    private Button btn_divAB;

    @FXML
    private Button btn_sqrtA;

    @FXML
    private Button btn_sqrtB;

    @FXML
    private MenuItem mitem_addAB;

    @FXML
    private MenuItem mitem_subAB;

    @FXML
    private MenuItem mitem_mulAB;

    @FXML
    private MenuItem mitem_divAB;

    @FXML
    private MenuItem mitem_sqrtA;

    @FXML
    private MenuItem mitem_sqrtB;

    private boolean isValidA = false;
    private boolean isValidB = false;

    private Pattern IS_NUMBER = Pattern.compile("^-?\\d+(\\.\\d+)?$");

    @FXML
    private void quit() {
        App.quit();
    }

    @FXML
    private void about() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("about.fxml"));
        DialogPane dialogPane = loader.load();
        Dialog<Void> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);
        dialog.initOwner(mainWindows.getScene().getWindow());
        dialog.show();
    }

    @FXML
    private void addAB() {
        StringNumericRecord add = new StringNumeric(value_a.getText().strip())
                .add(new StringNumeric(value_b.getText().strip()),
                        true
                );
        Result(add);
    }

    @FXML
    private void subAB() {
        StringNumericRecord sub = new StringNumeric(value_a.getText().strip())
                .sub(new StringNumeric(value_b.getText().strip()),
                        true
                );
        Result(sub);
    }

    @FXML
    private void mulAB() {
        StringNumericRecord mul = new StringNumeric(value_a.getText().strip())
                .mul(new StringNumeric(value_b.getText().strip()),
                        true
                );
        Result(mul);
    }

    @FXML
    private void divAB() {
        StringNumericRecord div = new StringNumeric(value_a.getText().strip())
                .div(new StringNumeric(value_b.getText().strip()),
                        10,
                        true
                );
        Result(div);
    }

    @FXML
    private void sqrtA() {
        StringNumericRecord sqrtLongDivision = new StringNumeric(value_a.getText().strip())
                .sqrtLongDivision(10, true);
        Result(sqrtLongDivision);
    }

    @FXML
    private void sqrtB() {
        StringNumericRecord sqrtLongDivision = new StringNumeric(value_b.getText().strip())
                .sqrtLongDivision(10, true);
        Result(sqrtLongDivision);
    }

    @FXML
    private void validateA() {
        isValidA = isValidNumber(value_a.getText().strip());
        setButtonState();
    }

    @FXML
    private void validateB() {
        isValidB = isValidNumber(value_b.getText().strip());
        setButtonState();
    }

    private void Result(StringNumericRecord snr) {
        StringBuilder sb = new StringBuilder();
        sb.append("Результат обчислення: ");
        sb.append(snr.value().toString());
        sb.append("\n\n");
        sb.append(snr.visualize());
        operationResult.setText(sb.toString());
    }

    private boolean isValidNumber(String v) {
        if (v != null && !v.isEmpty()) {
            return IS_NUMBER.matcher(v).matches();
        }
        return false;
    }

    private void setButtonState() {
        boolean state = !(isValidA && isValidB);
        btn_addAB.setDisable(state);
        btn_subAB.setDisable(state);
        btn_mulAB.setDisable(state);
        btn_divAB.setDisable(state);
        btn_sqrtA.setDisable(!isValidA);
        btn_sqrtB.setDisable(!isValidB);

        mitem_addAB.setDisable(state);
        mitem_subAB.setDisable(state);
        mitem_mulAB.setDisable(state);
        mitem_divAB.setDisable(state);
        mitem_sqrtA.setDisable(!isValidA);
        mitem_sqrtB.setDisable(!isValidB);
    }
}
