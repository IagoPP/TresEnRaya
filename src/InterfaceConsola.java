import java.util.Scanner;

public class InterfaceConsola {
    //Imprime estado actual del tablero de juego
    public void printBoard(char[] board) {
        System.out.println();
        System.out.printf(" %c | %c | %c ", board[6], board[7], board[8]);
        System.out.println("\n---|---|---");
        System.out.printf(" %c | %c | %c ", board[3], board[4], board[5]);
        System.out.println("\n---|---|---");
        System.out.printf(" %c | %c | %c ", board[0], board[1], board[2]);
        System.out.println();
    }
    public static void main(String[] args) {
        motor3R.TresEnRaya ter = new motor3R.TresEnRaya();
        InterfaceConsola ic = new InterfaceConsola();

        //Normas y funcionamiento del juego
        System.out.println("Normas del juego:");
        System.out.println("Empazará siempre el jugador usuario (o), y le seguirá la máquina oponente (x).");
        System.out.println("Para escoger la casilla en la que quieras colocar tu ficha (o), introduce por teclado el dígito del teclado numérico que corresponda según el siguiente mapa de controles: ");
        System.out.println(" 7 | 8 | 9 ");
        System.out.println("---|---|---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---|---|---");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("Los turnos se alternarán hasta que alguno de los jugadores gane consiguiendo alinear 3 casillas de su ficha correspondiente, o el tablero sea completado sin haberse declarado ningún ganador.");
        System.out.println("A JUGAR!!");

        //Alternacion entre los turnos del juego hasta que este acabe
        while (ter.winCon(ter.getBoard())) {
            System.out.print("\nJugador, introduce un numero correspondiente a una casilla desocupada: ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            ter.turnoJugador(input);
            ic.printBoard(ter.getBoard());
            if (ter.winCon(ter.getBoard())==false){
                break;
            }
            if (ter.tieCon(ter.getBoard())==false){
                break;
            }
            System.out.print("\nTurno de la máquina: \n");
            ter.turnoCPU(ter.getBoard());
            ic.printBoard(ter.getBoard());
        }

        //Fin del juego y determinar ganador
        if (ter.getEmpate()==true){
            System.out.println("\nHas empatado... Estuvo reñido!");
        }else if (ter.getTurnj()==false){
            System.out.println("\nHas ganado! Victoria aplastante!");
        }else{
            System.out.println("\nHas perdido, al final va a ser cierto que las IAs van a dominar el mundo...");
        }
    }
}
