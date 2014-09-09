Neelay Junnarkar AP Computer Science US Flag
============================================

To create a resizeable to-scale US Flag, I split the program into 3 classes: Main, Flag, and Star. The program uses a slider to scale the flag. The bounds of the slider are determined by the size of the window, which is resizeable.

The Main class serves as the entry point for the program and uses a JFrame.

The Flag class extends JPanel and is where all the drawing, scaling, and resizing of the flag takes place. It draws the 13 stripes as well as the blue rectangle and the 50 stars. To draw the stars in the specific grid pattern, it interlaces 2 rectangles of stars. The larger rectangle is of dimensions 6x5 stars, while the smaller rectangle is of dimensions 5x4 stars. It uses the Star class to draw the stars. It also uses a JSlider to resize the flag. The Flag class has a value which scales the flag, and this value is set by the slider. The range of values of the slider is set by the size of the window, which is resizable.

The Star class, which extends Polygon, abstracts away the logic of finding the vertices of stars. This makes the code in Flag a lot cleaner and easier to understand. The Star class uses trigonometry to find the points of the star. It is flexible in what type of star it can be by allowing different angles of rotation, different numbers of points, and different sized stars. However, The Star must be regular and each point is evenly spaced from its too adjacent points.