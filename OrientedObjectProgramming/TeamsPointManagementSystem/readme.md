This is a simple Java Swing application that manages a list of teams and their points.

The code is divided into three classes: ArrTeam, Principal, and Team.

ArrTeam: This class is a container for Team objects. It has methods to add a new team (Agregar), and to update the points of a team (Actualizar).

Principal: This is the main class that creates the GUI for the application. It has text fields for entering team names and their points, and a button to update the points. The actionPerformed method is triggered when the button is clicked, and it updates the points of the teams entered in the text fields.

Team: This class represents a team with a name (Nombre) and points (Puntos). It has a constructor to initialize these values, and getter methods to retrieve them.

The main method in the Principal class creates an instance of the GUI, adds some initial teams to the ArrTeam object, and displays a table with the team data. However, the table data (arr.data) is not updated anywhere in the code, so it will not reflect the changes made to the teams' points.
