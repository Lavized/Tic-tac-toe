package com.flex.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    private static int ROWS = 3;
    private static int COLS = 3;
    private static int SIZE = ROWS * COLS;
    private static String HUMAN = " X ";
    private static String PC = " O ";
    private static String EMPTY = " * ";
    private static String AI = "AI";
    private String[] cells = new String[SIZE];

    public TicTacToe() {
        for (int i = 0; i < SIZE; i++) {
            cells[i] = EMPTY;
        }
    }

    public void showBoard(){

        int tmp = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print("\t" + cells[tmp]);
                tmp++;
            }
            System.out.println();
            System.out.println("\t" + "-----------");
        }

        System.out.println("\n");

    }

    public boolean setFigureByRows(String player){
        if(player.equals(PC)) {
            for (int i = 0; i < cells.length; i += 3) {
                if (cells[i].equals(PC) && cells[i + 1].equals(PC) && cells[i + 2].equals(EMPTY)) {
                    cells[i + 2] = PC;
                    return true;
                } else if (cells[i].equals(PC) && cells[i + 2].equals(PC) && cells[i + 1].equals(EMPTY)) {
                    cells[i + 1] = PC;
                    return true;
                } else if (cells[i + 2].equals(PC) && cells[i + 1].equals(PC) && cells[i].equals(EMPTY)) {
                    cells[i] = PC;
                    return true;
                }
            }
        }

        if (player.equals(AI)) {
            for (int i = 0; i < cells.length; i += 3) {
                if (cells[i].equals(HUMAN) && cells[i + 1].equals(HUMAN) && cells[i + 2].equals(EMPTY)) {
                    cells[i + 2] = PC;
                    return true;
                } else if (cells[i].equals(HUMAN) && cells[i + 2].equals(HUMAN) && cells[i + 1].equals(EMPTY)) {
                    cells[i + 1] = PC;
                    return true;
                } else if (cells[i + 2].equals(HUMAN) && cells[i + 1].equals(HUMAN) && cells[i].equals(EMPTY)) {
                    cells[i] = PC;
                    return true;
                }
            }

        }

        if (player.equals(HUMAN)) {
            for (int i = 0; i < cells.length; i += 3) {
                if (cells[i].equals(HUMAN) && cells[i + 1].equals(HUMAN) && cells[i + 2].equals(HUMAN)) {
                    return true;
                } else if (cells[i].equals(HUMAN) && cells[i + 2].equals(HUMAN) && cells[i + 1].equals(HUMAN)) {
                    return true;
                } else if (cells[i + 2].equals(HUMAN) && cells[i + 1].equals(HUMAN) && cells[i].equals(HUMAN)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean setFigureByCols(String player){
        if(player.equals(PC)) {
            for (int i = 0; i < 3; i++) {
                if (cells[i].equals(PC) && cells[i + 3].equals(PC) && cells[i + 6].equals(EMPTY)) {
                    cells[i + 6] = PC;
                    return true;
                } else if (cells[i].equals(EMPTY) && cells[i + 3].equals(PC) && cells[i + 6].equals(PC)) {
                    cells[i] = PC;
                    return true;
                } else if (cells[i].equals(PC) && cells[i + 6].equals(PC) && cells[i + 3].equals(EMPTY)) {
                    cells[i + 3] = PC;
                    return true;
                }
            }
        }

        if (player.equals(AI)) {

            for (int i = 0; i < 3; i++) {
                if (cells[i].equals(HUMAN) && cells[i + 3].equals(HUMAN) && cells[i + 6].equals(EMPTY)) {
                    cells[i + 6] = PC;
                    return true;
                } else if (cells[i].equals(EMPTY) && cells[i + 3].equals(HUMAN) && cells[i + 6].equals(HUMAN)) {
                    cells[i] = PC;
                    return true;
                } else if (cells[i].equals(HUMAN) && cells[i + 6].equals(HUMAN) && cells[i + 3].equals(EMPTY)) {
                    cells[i + 3] = PC;
                    return true;
                }
            }


        }
        if (player.equals(HUMAN)) {
            for (int i = 0; i < 3; i++) {
                if (cells[i].equals(HUMAN) && cells[i + 3].equals(HUMAN) && cells[i + 6].equals(HUMAN)) {
                    return true;
                } else if (cells[i].equals(HUMAN) && cells[i + 3].equals(HUMAN) && cells[i + 6].equals(HUMAN)) {
                    return true;
                } else if (cells[i].equals(HUMAN) && cells[i + 6].equals(HUMAN) && cells[i + 3].equals(HUMAN)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean setFigureByDiagonal(String player){
        if (player.equals(PC)) {
            for (int i = 0; i < 3; i += 2) {
                if (i == 0) {
                    if (cells[i].equals(PC) && cells[i + 4].equals(PC) && cells[i + 8].equals(EMPTY)) {
                        cells[i + 8] = PC;
                        return true;
                    } else if (cells[i].equals(EMPTY) && cells[i + 4].equals(PC) && cells[i + 8].equals(PC)) {
                        cells[i] = PC;
                        return true;
                    } else if (cells[i].equals(PC) && cells[i + 4].equals(EMPTY) && cells[i + 8].equals(PC)) {
                        cells[i + 4] = PC;
                        return true;
                    }
                }
                if (i == 2) {
                    if (cells[i].equals(PC) && cells[i + 2].equals(PC) && cells[i + 4].equals(EMPTY)) {
                        cells[i + 4] = PC;
                        return true;
                    } else if (cells[i].equals(PC) && cells[i + 2].equals(EMPTY) && cells[i + 4].equals(PC)) {
                        cells[i + 2] = PC;
                        return true;
                    } else if (cells[i].equals(EMPTY) && cells[i + 2].equals(PC) && cells[i + 4].equals(PC)) {
                        cells[i] = PC;
                        return true;
                    }
                }
            }

        }


        if (player.equals(AI)) {

            for (int i = 0; i < 3; i += 2) {
                if (i == 0) {
                    if (cells[i].equals(HUMAN) && cells[i + 4].equals(HUMAN) && cells[i + 8].equals(EMPTY)) {
                        cells[i + 8] = PC;
                        return true;
                    } else if (cells[i].equals(EMPTY) && cells[i + 4].equals(HUMAN) && cells[i + 8].equals(HUMAN)) {
                        cells[i] = PC;
                        return true;
                    } else if (cells[i].equals(HUMAN) && cells[i + 4].equals(EMPTY) && cells[i + 8].equals(HUMAN)) {
                        cells[i + 4] = PC;
                        return true;
                    }
                }
                if (i == 2) {
                    if (cells[i].equals(HUMAN) && cells[i + 2].equals(HUMAN) && cells[i + 4].equals(EMPTY)) {
                        cells[i + 4] = PC;
                        return true;
                    } else if (cells[i].equals(HUMAN) && cells[i + 2].equals(EMPTY) && cells[i + 4].equals(HUMAN)) {
                        cells[i + 2] = PC;
                        return true;
                    } else if (cells[i].equals(EMPTY) && cells[i + 2].equals(HUMAN) && cells[i + 4].equals(HUMAN)) {
                        cells[i] = PC;
                        return true;
                    }
                }
            }


        }

        if (player.equals(HUMAN)) {
            for (int i = 0; i < 3; i += 2) {
                if (i == 0) {
                    if (cells[i].equals(HUMAN) && cells[i + 4].equals(HUMAN) && cells[i + 8].equals(HUMAN)) {
                        return true;
                    } else if (cells[i].equals(HUMAN) && cells[i + 4].equals(HUMAN) && cells[i + 8].equals(HUMAN)) {
                        return true;
                    } else if (cells[i].equals(HUMAN) && cells[i + 4].equals(HUMAN) && cells[i + 8].equals(HUMAN)) {
                        return true;
                    }
                }
                if (i == 2) {
                    if (cells[i].equals(HUMAN) && cells[i + 2].equals(HUMAN) && cells[i + 4].equals(HUMAN)) {
                        return true;
                    } else if (cells[i].equals(HUMAN) && cells[i + 2].equals(HUMAN) && cells[i + 4].equals(HUMAN)) {
                        return true;
                    } else if (cells[i].equals(HUMAN) && cells[i + 2].equals(HUMAN) && cells[i + 4].equals(HUMAN)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean winnerPCMove(){

        if (setFigureByRows(PC)) {
            showBoard();
            System.out.println("PC is WIN! ");

            return true;
        }

        else if (setFigureByCols(PC)) {
            showBoard();
            System.out.println("PC is WIN! ");
            return true;
        }

        else if (setFigureByDiagonal(PC)) {
            showBoard();
            System.out.println("PC is WIN! ");
            return true;
        }

        return false;

    }

    public boolean winnerHumanMove(){

        if (setFigureByRows(HUMAN)) {
            showBoard();
            System.out.println("Human is WIN! \n");

            return true;
        }

        else if (setFigureByCols(HUMAN)) {
            showBoard();
            System.out.println("Human is WIN! \n");
            return true;
        }

        else if (setFigureByDiagonal(HUMAN)) {
            showBoard();
            System.out.println("Human is WIN! \n");
            return true;
        }

        return false;

    }

    public boolean tryToWinPC(){

        if (setFigureByRows(AI)) {
            showBoard();
            return true;
        }

        else if (setFigureByCols(AI)) {
            showBoard();
            return true;
        }

        else if (setFigureByDiagonal(AI)) {
            showBoard();
            return true;
        }

        return false;

    }

    public boolean pcMove() {
        for (int i = 0; i < cells.length; i++) {
            int rand = (int) (Math.random() * 8);
            if (cells[rand].equals(EMPTY)) {
                cells[rand] = PC;
                return true;
            }
        }
        return false;

    }

    public void playerMove()  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Player write your move 1-9  : ");
        int move = 0;
        try {
            move = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            e.getMessage();


        }

        catch (IOException e) {
            e.printStackTrace();
        }
        if (move <= cells.length && cells[move-1].equals(EMPTY)) {
            switch (move) {
                case 1 :
                    cells[0] = HUMAN;
                    break;
                case 2 :
                    cells[1] = HUMAN;
                    break;
                case 3 :
                    cells[2] = HUMAN;
                    break;
                case 4 :
                    cells[3] = HUMAN;
                    break;
                case 5 :
                    cells[4] = HUMAN;
                    break;
                case 6 :
                    cells[5] = HUMAN;
                    break;
                case 7 :
                    cells[6] = HUMAN;
                    break;
                case 8 :
                    cells[7] = HUMAN;
                    break;
                case 9 :
                    cells[8] = HUMAN;
                    break;

                default:
                    System.out.println("Invalid Move! Please try again");
                    playerMove();
                    break;

            }

        }

        else {
            System.out.println("WRONG MOVE!");
            playerMove();
        }



    }

    public void startGame() throws IOException, InterruptedException {

        for (int i = 0; i < 5; i++) {



            showBoard();
            playerMove();

            if (winnerHumanMove()) {
                showBoard();
                break;
            }


            if (i == 4) {
                System.out.println();
                System.out.println("\t \t  Draw \n" );

                showBoard();
                break;
            }

            else {
                showBoard();
                Thread.sleep(500);
                System.out.println("PC is moving");
                System.out.println();

                if (winnerPCMove()) {

                    break;
                }

                else if (tryToWinPC()) {
                    showBoard();
                }

                else {
                    pcMove();
                }

            }

        }
    }

}
