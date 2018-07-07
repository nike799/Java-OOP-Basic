package app;

import app.core.Engine;
import app.core.HealthManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        HealthManager healthManager = new HealthManager();
        ConsoleOutputWriter consoleOutputWriter = new ConsoleOutputWriter();
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        InputParser inputParser = new InputParser();
        Engine engine = new Engine(healthManager,consoleOutputWriter,consoleInputReader,inputParser);
        engine.run();

    }
}
