package motor3R;

import java.util.Random;

public class TresEnRaya {
    private boolean turnj;
    private boolean empate;
    private char fichaj;
    private char ficham;
    private char[] board = new char[9];

    
    public TresEnRaya() {
        turnj = true;
        empate = false;
        ficham = 'x';
        fichaj = 'o';
        board[0] = ' ';
        board[1] = ' ';
        board[2] = '.';
        board[3] = '.';
        board[4] = '.';
        board[5] = ' ';
        board[6] = ' ';
        board[7] = ' ';
        board[8] = '.';
    }

    /** array que almacena el tablero de juego, se deben de inicializar las posiciones 2,3,4 y 8
     *  con un caracter distinto al resto para que funcione la lógica del juego */
    public void setBoard(char[] board) {
        this.board = board;
    }
    /** valor que toma la ficha correspondiente al jugador usuario*/
    public void setFichaj(char fichaj) {
        this.fichaj = fichaj;
    }
    /** valor que toma la ficha correspondiente al jugador CPU*/
    public void setficham(char ficham) {
        this.ficham = ficham;
    }
    /** determina a quien le toca jugar, al final del juego determina el ganador */
    public void setTurnj(boolean turnj) {
        this.turnj = turnj;
    }
    
    public char[] getBoard() {
        return board;
    }
    public boolean getTurnj() {
        return turnj;
    }
    /** determina si el juego acabo en empate */
    public boolean getEmpate(){
        return empate;
    }

    /** Metodo que indica si algun jugador ha ganado el juego */
    public boolean winCon(char[] board) {
        if ((board[0] != board[1] || board[0] != board[2]) && (board[3] != board[4] || board[3] != board[5])
                && (board[6] != board[7] || board[6] != board[8]) && (board[0] != board[3] || board[0] != board[6])
                && (board[1] != board[4] || board[1] != board[7]) && (board[2] != board[5] || board[2] != board[8])
                && (board[0] != board[4] || board[0] != board[8]) && (board[2] != board[4] || board[2] != board[6])) {
            return true;
        } else{
            return false;
        }
    }

    /** Metodo que indica si el juego acabo en empate (todas las casillas se han ocupado sin ganador) */
    public boolean tieCon(char[] board) {
        if (board[0] != ' ' && board[1] != ' ' && board[2] != '.' && board[3] != '.' && board[4] != '.'
        && board[5] != ' ' && board[6] != ' ' && board[7] != ' '
        && board[8] != '.'){
            empate=true;
            return false;
        }else{
            return true;
        }
    }

    /** logica del turno del jugador 1 */
    public void turnoJugador(int input) {
        board[input - 1] = fichaj;
        turnj = false;
    }

    /** logica del turno del jugador 2 */
    public void turnoCPU(char[] board) {
        Random rng = new Random();
        while (true) {
            int tirada = rng.nextInt(0, 9);
            if (board[tirada] != ficham && board[tirada] != fichaj) {
                board[tirada] = ficham;
                break;
            }
        }
    }
}
