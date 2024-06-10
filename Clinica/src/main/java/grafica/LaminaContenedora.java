package grafica;

import javax.swing.*;
import java.awt.*;

public class LaminaContenedora extends JPanel {

    CardLayout card = new CardLayout();


    public LaminaContenedora() {

        setLayout(card);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    public CardLayout getCard() {
        return card;
    }

    public void setCard(CardLayout card) {
        this.card = card;
    }



}
