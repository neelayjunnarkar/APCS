Hivolts
=======
by Neelay Junnarkar

This is a game of Hivolts, coded by Neelay Junnarkar.

Controls
========
Main-Menu:
	Enter: starts game
In-Game:
	Q: up-left
	W: up
	E: up-right
	A: left
	S: sit
	D: right
	Z: down-left
	X: down
	C: down-right
	J: jump
	R: restart
Game-Over:
	R: restart
Win-Game:
	R: restart
	
Game Design
===========
The Panel: The Panel uses a a 2-dimensional array of Cells to represent the game grid. This class updates all Cells and draws all Cells
Cells: Each Cell hosts an Entity, updates the Entity, and is called on to draw the Entity
Entity: An Entity can be a Fence, a Mho, a Player, or simply be an Entity (results in an empty square)
Fence: Extends Entity. The Fences are the red squares. The are sessile and result in death for the Player
LivingEntity: Extends Entity. LivingEntities have a life boolean that signifies whether the LivingEntity is dead or not
Mho: Extends LivingEntity. The Mhos are the orange circles. They are motile and try to kill the Player
Player: Extends LivingEntity. The Player is the user-controlled blue circle which attempts to survive until the Mhos kill themselves

Development Process
===================

Timeline:
	1) Initially worked on Cell and Entity framework, simply making sure all different Entities could be drawn
	2) Implemented Player controls and the ability of instances of Player and instances of Mho to move
	3) Implemented death for the player when it has contact with Mhos or Fences
	4) Implemented the Mho AI
	5) Implemented death for Mhos and adjusted death for the Player to work with the complications caused by other motile entities
	6) Created Game-Over, Win-Game, and Main-Menu Screens and added Restart keys.
	7) Debugged any remaining outstanding flaws
NOTE: Throughout this process there were numerous bugs that needed to be fixed or features that needed to be fine-tuned 
Examples include:
	1) The window flickering
	2) Not all Mhos updating
	3) Some Mhos updating multiple times
	4) Mhos reappearing after death
	5) The Player not being registered as dead
	6) Even after all Mhos died, the Player would have to be moved once more for the game to recognize that the Player had won
	
	
	
Acknowledgements
================
Tyler Packard: Suggested KeyBindings for key input
Julian Knodt: Miscellaneous help and moral support

