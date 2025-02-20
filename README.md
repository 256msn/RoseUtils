# 🌹 RoseUtils 1.7.3
A utility anarchy plugin for Minecraft Beta 1.7.3

---

## ⚙️ Features

**This are the RoseUtils features**

1. **Join and left messages**  
   *Adds join and left messages to game*  

2. **Death Messages**  
   *Death Messages like 2b2t.org*  

3. **/kill command**  
   *You can use /kill in game*  

4. **RandomSpawn**  
   *You can respawn in the game*  

5. **AntiIllegals**
   *Prevents illegal items such as bedrock**
   
---

## 🎨 How to install:

1. Download the latest version of the RoseUtil plugin.
2. Place the plugin file into your server's `plugins` folder.
3. Restart your server to enable the plugin.
---

## 📝 Compilation Guide

To compile and build the project, follow these steps:

### Prerequisites

1. **Java Development Kit (JDK) 1.8:** Ensure you have JDK 1.8 installed on your machine.  Go to [Amazon Correto](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html)

2. **Maven:** Make sure Maven is installed. You can download it from the [Apache Maven website](https://maven.apache.org/download.cgi).

3. **IntelliJ IDEA:** Download and install IntelliJ IDEA from the [JetBrains website](https://www.jetbrains.com/idea/download/).

4. **Minecraft Dev Plugin:** Install the Minecraft Dev plugin for IntelliJ IDEA to help with Minecraft plugin development.

5. **Lombok:** Ensure Lombok is set up in your IntelliJ IDEA for better development experience.

### Building the Project

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/256msn/RoseUtils.git
   ```
2. **Import the Project:**

    - Open IntelliJ IDEA.
    - Go to **File** > **Open** and select the cloned repository folder.
    - IntelliJ IDEA will detect the Maven project and prompt to import it. Click **Import**.

3. **Setup Project:**

    - **Install Dependencies:** IntelliJ IDEA will automatically download the required dependencies defined in the `pom.xml` file. If not, you can manually trigger this by right-clicking on the `pom.xml` file and selecting **Maven** > **Reload Project**.
    - **Enable Lombok:** Ensure Lombok is enabled by going to **File** > **Settings** > **Plugins**, searching for Lombok, and making sure it is installed and enabled.

4. **Compile the Project:**

    - **Using IntelliJ IDEA:**
        - Right-click on the project folder in the **Project** view.
        - Select **Maven** > **Package** to build the project.

    - **Using Command Line:**
        - Open a terminal or command prompt.
        - Navigate to the project directory.
        - Run the following command to compile and package the project:

          ```bash
          mvn clean package
          ```

### Notes

- Ensure that the Java SDK and Maven versions match the project's requirements.
- If you encounter any issues, refer to the project’s existing code and follow the coding standards used.
- Consult the [Maven documentation](https://maven.apache.org/guides/index.html) for additional Maven-related commands and configurations.

Feel free to reach out if you have any questions or run into issues!
