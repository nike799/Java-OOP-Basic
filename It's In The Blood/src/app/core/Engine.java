package app.core;

import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.Constants;
import app.utilities.InputParser;

public class Engine {
    private HealthManager healthManager;
    private ConsoleOutputWriter outputWriter;
    private ConsoleInputReader inputReader;
    private InputParser inputParser;

    public Engine(HealthManager healthManager, ConsoleOutputWriter outputWriter,
                  ConsoleInputReader inputReader, InputParser inputParser) {
        this.healthManager = healthManager;
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        this.inputParser = inputParser;
    }

    public void run() {
        String inputLine = inputLine = this.inputReader.readLine();

        while (!inputLine.equals(Constants.INPUT_TERMINATING_COMMAND)) {
            String[] commandArgs = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandArgs);

            inputLine = this.inputReader.readLine();
        }
    }

    private void dispatchCommand(String[] commandArgs) {
        String command = commandArgs[0];
        String organismName = commandArgs[1];
        String clusterId;
        switch (command){
            case Constants.CHECK_CONDITION:
                outputWriter.writeLine(healthManager.checkCondition(organismName));
                break;
            case Constants.CREATE_ORGANISM:
                outputWriter.writeLine(healthManager.createOrganism(organismName));
                break;
            case Constants.ADD_CLUSTER:
                clusterId = commandArgs[2];
                int rows = Integer.parseInt(commandArgs[3]);
                int cols = Integer.parseInt(commandArgs[4]);
                outputWriter.writeLine(healthManager.addCluster(organismName,clusterId,rows,cols));
                break;
            case Constants.ADD_CELL:
                clusterId = commandArgs[2];
                String cellType = commandArgs[3];
                String cellId = commandArgs[4];
                int health = Integer.parseInt(commandArgs[5]);
                int positionRow = Integer.parseInt(commandArgs[6]);
                int positionCol = Integer.parseInt(commandArgs[7]);
                int additionalProperty = Integer.parseInt(commandArgs[8]);

                outputWriter.writeLine(healthManager.addCell(organismName,clusterId,
                        cellType,cellId,health,positionRow,positionCol,additionalProperty));
                break;
            case Constants.ACTIVATE_CLUSTER:
                break;

        }
    }
}
