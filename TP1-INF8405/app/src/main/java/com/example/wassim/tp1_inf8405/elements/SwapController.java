package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public class SwapController {
    private Board board;

    public SwapController(Board newBoard){
        board = newBoard;
    }

    /***
     * Swap the items of two adjacent cells
     * @param cell1
     * @param cell2
     */
    public boolean swap(Cell cell1, Cell cell2){
        boolean isSucces = false;
        if(cell1.isEmpty() || cell2.isEmpty()){
            isSucces = false;
        }
        else if (!isSwapAllowed(cell1,cell2)){
            isSucces = false;
        } else{
            //TODO::swap items (not cells)
            isSucces = true;
        }
        return isSucces;
    }

    /***
     * A swap is allowed only between horisontaly and verticaly adjacent cells
     * @return
     */
    private boolean isSwapAllowed(Cell cell1, Cell cell2){
        //TODO::calculate swapability
        return false;
    }

}
