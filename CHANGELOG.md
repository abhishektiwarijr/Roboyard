CHANGELOG
=========

These are all relevant changes since Version 1.0:

### Version 7.0

- Adapted resolution to Android 4.1.1 with 480px width

### Version 6.1

- added Sound on/off in Game settings (icons from freeiconspng [1](https://www.freeiconspng.com/img/40963), [2](https://www.freeiconspng.com/img/40944))
- Add roboyard in the middle of the play field

### Version 6.0

- show solution as the 2nd to 5th hint
- persistently store Settings
- remove (slower) BFS Solver algorithm
- fix bug, that was extra autosaving when starting a new level

### Version 5.4

- added more tolerance to touch a robot

### Version 5.3

- Add ambient background sound
- green walls are now more like garden hedges
- walls on the right screen are now visible
- In beginner level generate a new map each time

### Version 5.2

- rename to Roboyard
- Walls are green and a bit thicker
- increase initial movement speed of robots with linear slow-down

### Version 5.1

- carré always in the middle again (fixes robot posistions due to keeping the initial playingfield)

### Version 5.0

- keep initial playingfield when starting the next game
- keep playingfield when loading a saved game

### Version 4.0

- added more complexity to Advanced and Insane Level

New in Advanced:

  - The square must not be in the middle
  - three lines allowed in the same row/column
  - no multi-color target

New in Insane:

  - solutions with 10 moves are enough
  - 50% chance that the target is set anywhere on the map instead of in a corner

### Version 3.2

- adapt to different screen resolutions

### Version 3.1

- Spheres are now Robots
- change next game button

### Version 3.0

- New design

### Version 2.5

- 35 savegames and levels per page
- Autosave the current game after 40s in save slot 0

### Version 2.4

- fix bug: no save button when playing a saved game (was crashing the game)

### Version 2.3

- Settings: set user level to show only puzzles with at least
  - Beginner: 4-6 moves
  - Advanced: 6-8 moves
  - Insane: 14 moves (10 moves since v4.0)
- Warning if set to slow BFS and insane level

### Version 2.2

- Show 3 to 5 Hints before showing the optimal solution

### Version 1.0

- last french version
