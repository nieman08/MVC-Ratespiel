package de.uni_passau.fim.infosun.se2.mvc_rng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** The controller keeps the communication between model and view */
class Controller implements ActionListener {

    private final Model model;
    private final View view;

    Controller(final View pView) {
        model = new Model();
        view = pView;
    }

    /**
     * {@inheritDoc}
     *
     * <p>Parses the user's input and hands it to the model.  Pushes the result to the view afterwards.
     */
    @Override
    public void actionPerformed(final ActionEvent pActionEvent) {
        JTextField variable = view.getTextField();  // TODO implement me
        String stringVariable = variable.getText();
        int pNumber = Integer.parseInt(stringVariable);



        try{
            String checkErgebnis = model.check(pNumber).name();

            int numberOfTries = model.getNumberOfTries();

            if (checkErgebnis.equals("SMALL")){
                view.update(pNumber + " is too small");

            }

            else if(checkErgebnis.equals("LARGE")) {
                view.update(pNumber + " is too big");
            }
                else {
                view.update("Congratulation, you won ! " + numberOfTries + " tries.");
                model.dice();

            }


            /* anderer Möglichkeit, diese kann ignoriert werden, war nur dazu da um zu schauen ob Fehler so behoben werden können
                switch (checkErgebnis){
                    case "SMALL":
                        view.update(pNumber + " is too small");
                        break;

                    case "CORRECT":
                        view.update("Congratulation, you won ! " + numberOfTries + " tries.");
                        model.dice();
                        break;

                    case "LARGE":
                        view.update(pNumber + " is too big");
                        break;
                }

            **/
        }
            catch(Model.InvalidArgumentException e){
            JOptionPane.showMessageDialog(null,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }




    }
}
        


