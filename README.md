# Rock-Paper-Scissors Game Project with Java

This project is to design a rock-paper-scissors game that a player can compete with another player. The game can be played as user-computer or computer-computer and the player must make a choice at the beginning of the game.

In the game, each player has a total of 5 objects of 3 different types: rock, paper, and scissors. In the user-computer game, the user makes the object choice at the beginning of the game, while the computer makes a random choice.

In the computer-computer game, all choices will be made automatically and the game will progress quickly.

During the game, the user should not see the contents of the computer's objects. However, the selected objects can be seen on the interface after each choice. The user can choose any remaining object from their hand at the beginning of each move.

In the user-computer game, the game will proceed as follows: First, the user makes a choice from their items, then the computer makes a random choice, and finally, the scores are calculated by comparing the items and the game continues with a new choice. In the computer-computer game, both players will progress with random choices. The game ends when one of the following two conditions is met:

When one of the sides runs out of objects,
When the total number of moves set at the beginning of the game is completed (total number of starting moves: 10).
All objects must not be selected twice before all 5 objects are selected. The same object can be selected again when all 5 objects are selected.
