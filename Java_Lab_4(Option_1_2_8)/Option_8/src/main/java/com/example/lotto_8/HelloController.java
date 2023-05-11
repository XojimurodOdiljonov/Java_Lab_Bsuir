package com.example.lotto_8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField numberOfValuesTextField;
    @FXML
    private TextField maxNumberTextField;
    @FXML
    private Label resultLabel;
    @FXML
    private TextArea ticketTextArea;

    @Deprecated
    public void findWinnerButtonClick(ActionEvent actionEvent){
        int numberOfValues = Integer.parseInt(numberOfValuesTextField.getText());
        int maxNumber = Integer.parseInt(maxNumberTextField.getText());

        LottoTicket winningTicket = new LottoTicket(numberOfValues, maxNumber);
        ticketTextArea.appendText("Выиграшный билет: ");
        addTicketToArea(winningTicket);

        int numberOfTicketsUntilAWinner = 1;

        LottoTicket anotherTicket = new LottoTicket(numberOfValues, maxNumber);
        addTicketToArea(anotherTicket);

        while (!anotherTicket.isWinner(winningTicket)){
            anotherTicket = new LottoTicket(numberOfValues, maxNumber);
            addTicketToArea(anotherTicket);
            numberOfTicketsUntilAWinner++;
        }

        resultLabel.setText("Потребовалось: " + numberOfTicketsUntilAWinner + " билетов, чтобы определить победителя");
    }

    private void addTicketToArea(LottoTicket ticket){
        String numbers = "";
        for (int number : ticket.getNumbers()){
            numbers += number + " ";
        }
        ticketTextArea.appendText(numbers);
        ticketTextArea.appendText("\n");
    }
}