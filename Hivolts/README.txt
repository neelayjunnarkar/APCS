Hivolts
=======
by Neelay Junnarkar

This is a game of Hivolts, coded entirely by Neelay Junnarkar.

Thus far, I have completed most of the game, although there is still some functionality
left to be implemented. Functionality complete includes the Mho AI, the game board, 
player controls, and drawing. Functionality not yet complete includes gameover screens
and main menu screens (I may not implement this, however), and a restart button, which
will most likely be R. Although some functionalities may be complete, many of them do 
need fine-tuning. For example, one major issue is the way the board updates entities.
The entities are in a 2-dimensional array, and are updated in a sequence, rather than 
simultaneously as they should be. Because each entity is updated sequentially and modifies 
the board, all entities updating after that entity do not update correctly, as they update
in reference to a different board layout.

