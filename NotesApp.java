import java.io.*;
import java.util.Scanner;

public class NotesApp {

    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("📒 Welcome to Notes App");
        System.out.println("1. Add Note");
        System.out.println("2. Read Notes");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        if (choice == 1) {
            System.out.print("📝 Write your note: ");
            String note = scanner.nextLine();
            addNoteToFile(note);
        } else if (choice == 2) {
            readNotesFromFile();
        } else {
            System.out.println("❌ Invalid choice.");
        }

        scanner.close();
    }

    public static void addNoteToFile(String note) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true); // append mode
            writer.write(note + "\n");
            writer.close();
            System.out.println("✅ Note saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error writing note: " + e.getMessage());
        }
    }

    public static void readNotesFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            System.out.println("📂 Saved Notes:");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No notes found. Write a note first.");
        } catch (IOException e) {
            System.out.println("❌ Error reading notes: " + e.getMessage());
        }
    }
}
