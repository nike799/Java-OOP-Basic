package app.factories;

import app.cells.Cell;
import app.cells.bloodCells.RedBloodCell;
import app.cells.bloodCells.WhiteBloodCell;
import app.cells.microbes.Bacteria;
import app.cells.microbes.Fungi;
import app.cells.microbes.Virus;
import app.utilities.Constants;

public class CellFactory {

    public Cell createCell(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        switch (cellType) {
            case Constants.WHITE_BLOOD_CELL:
                return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case Constants.RED_BLOOD_CELL:
                return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case Constants.BACTERIA:
                return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
            case Constants.FUNGI:
                return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
            case Constants.VIRUS:
                return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
            default:
                return null;
        }
    }
}
