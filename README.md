# Minesweeper (Java CLI)

A terminal-based Minesweeper game written in Java, playable entirely from the command line.

## Features

- 9×9 board with 10 mines
- Flood-fill reveal — clicking an empty cell automatically opens all connected empty cells
- Flag mode to mark suspected mines
- Color-coded output (numbers, flags, mines)
- Win / Lose detection

## How to Play

Run the program. Each turn you choose a mode and then enter a row and column (0-indexed).

```
FOR SELECTING A CELL TO REVEAL PRESS 1 OR PRESS 2 TO CHANGE TO FLAG MODE ⚑
```

| Input | Action |
|-------|--------|
| `1` | Reveal the cell at the given position |
| `2` | Toggle a flag on the cell at the given position |

### Board symbols

| Symbol | Meaning |
|--------|---------|
| `■` | Unrevealed cell |
| `⚑` (yellow) | Flagged cell |
| `X` | Revealed — 0 mines around |
| `1` (blue) | Revealed — 1 mine around |
| `2` (magenta) | Revealed — 2 mines around |
| `3` (cyan) | Revealed — 3 mines around |
| `*` (red) | Mine (shown on game over) |

### Win condition
Reveal all non-mine cells without hitting a mine.

### Lose condition
Click on a mine. The full mine map is shown afterward.

## Project Structure

```
src/
├── Main.java       — entry point, game loop, board rendering
├── Game.java       — game logic (reveal, flag, win/lose state)
├── Board.java      — board initialization, mine placement, flood fill
├── Cell.java       — single cell model (mine, revealed, flagged, count)
└── GameState.java  — enum: PLAYING / WON / LOST
```

## Running the Project

### With IntelliJ IDEA
Open the project and run `Main.java`.

### With javac from the terminal
```bash
javac src/*.java -d out
java -cp out Main
```

## Requirements

- Java 8 or higher
- A terminal that supports ANSI color codes (most modern terminals do)

---

*Enjoy some nostalgia in your terminal!*
