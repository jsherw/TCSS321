# TCSS321 HW#8

Extra Credit Assignment for TCSS#321 Discrete Structures

RuntimeTest.java : Driver program
ArrayMaker : Class used by RuntimeTest for creating and filling arrays.

Implements the three provided range algorithms, compares their runtime speeds in ms, and reports the results.

For implementation, a seperate class was created to create an array of elements at different sizes.
Each algorithm was implemented in its own method, and runtimes were tested on the same array for each algorithm at each data set size.
At the end of each iteration of testing the data set size was doubled, and testing was repeated until a data set of size N = 64,000 was tested.

The test results were collected into LinkedHashMaps at the end of each iteration, to store in an ordered set of Key/Value pairs, and those results are displayed to the user.

Code for the methods "range1", "range2", and "range3" was provided by Professor Teredesai, with only the method headers changed for implementation purposes.
