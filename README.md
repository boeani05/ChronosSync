# ChronosSync: Simple Event Manager

ChronosSync is a command-line application built in Java that allows users to manage their events. It supports adding new events with custom names and dates, listing all existing events, and provides background notifications for upcoming events.

## Features

*   **Add Events:** Easily add new events by providing a name and a date.
*   **List Events:** View all currently stored events with their details.
*   **Robust Date Input:** Accepts event dates in `dd.MM.yyyy` format with built-in error handling for invalid inputs.
*   **Background Event Notifications:** A dedicated background thread (`EventNotifier`) periodically checks for events happening today or tomorrow and displays console reminders without interrupting user interaction.
*   **Thread-Safe Event Storage:** Uses `ConcurrentHashMap` in the `EventManager` to ensure safe and efficient access to event data from multiple threads.

## Technologies Used

*   **Java 17+** (or compatible version)
*   **`java.time` API:** For modern date and time handling.
*   **`Scanner`:** For console input.
*   **Multi-threading:** Utilizing `Runnable`, `Thread`, and `ConcurrentHashMap` for concurrent operations.

## How to Run

To run ChronosSync, follow these steps:

1.  **Prerequisites:**
    *   Ensure you have a Java Development Kit (JDK) (version 17 or higher recommended) installed on your system.

2.  **Clone the Repository:**
    ```bash
    git clone https://github.com/boeani05/chronosyncapp.git
    cd chronosyncapp
    ```

3.  **Compile the Application:**
    Navigate to the project root and compile the Java source files. You can compile all `.java` files from the `src` directory into an `out` directory:

    ```bash
    mkdir -p out
    javac -d out src/com/chronosync/*.java src/com/chronosync/manager/*.java src/com/chronosync/model/*.java src/com/chronosync/notifier/*.java
    ```

4.  **Run the Application:**
    After successful compilation, run the main application class:

    ```bash
    java -cp out com.chronosync.ChronosSyncApp
    ```

## Usage

Once the application is running, you will be presented with a menu:
