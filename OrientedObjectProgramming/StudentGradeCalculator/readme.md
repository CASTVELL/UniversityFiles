GitHub Copilot
This Java file, NewJFrame.java, is a GUI application that calculates the average of four grades for a student and keeps track of the student with the highest average. Here's a breakdown of its functionality:

The GUI has five text fields (jTextField1, jTextField2, jTextField3, jTextField4, jTextField5) and two buttons (jButton1, jButton2).

The user is expected to enter four numeric grades into the first four text fields and a student's name into the fifth text field.

The "Ingresar" button (jButton1) takes the input from the text fields, calculates the average grade, and stores the student's name and average grade in a HashMap. If the input grades are not numeric or not within the range 0-50, it prints an error message.

The "Mostrar" button (jButton2) modifies the HashMap entry of the student with the highest average grade, appending an asterisk to the end of their entry, and then prints out all the entries in the HashMap.

The Promedio method calculates the average of the four grades and updates the highest average seen so far.

The isNumeric method checks if a given string can be parsed to an integer between 0 and 50.

The actionPerformed method handles the button click events, performing the actions described in points 3 and 4 above.
