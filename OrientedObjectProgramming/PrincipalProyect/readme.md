This code is written in Java and consists of three classes: ArrTeam, Principal, and Team.

Team: This class represents a team with a name (Nombre) and points (Puntos). It has a constructor to initialize these properties and getter methods to retrieve them.

ArrTeam: This class manages a list of Team objects. It has methods to add a team to the list (Agregar), update a team's points (Actualizar), and sort the teams based on their points (Ordenar). The sorting algorithm used is bubble sort, but there's a bug in the swapping part of the code.

Principal: This class represents a GUI application with a JFrame. It has text fields for entering team names and points, labels for displaying the top 10 teams and their points, and a button for updating the teams' points and sorting the list. The actionPerformed method is triggered when the button is clicked. It updates the teams' points, sorts the list, and updates the labels. The ActualizarText method updates the labels with the top 10 teams and their points.

The main method creates an instance of Principal, adds some teams to the list, and updates the labels.
