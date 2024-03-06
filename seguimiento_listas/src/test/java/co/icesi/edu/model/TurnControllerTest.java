package co.icesi.edu.model;

import org.junit.Assert;
import org.junit.Test;

public class TurnControllerTest {

    public TurnController setup1(){
        TurnController controller = new TurnController();
        for (int i = 0; i <6; i++) {
            controller.giveTurn();
        }
        return controller;
    }

    @Test
    public void test1(){
        TurnController controller = new TurnController();
        for (int i = 0; i <6; i++) {
            int t = controller.giveTurn();
            Assert.assertEquals( i+1,t);
        }
    }

    @Test
    public void test2(){
        TurnController controller = setup1();
        Assert.assertEquals(1,controller.showCurrentTurn());
        controller.deleteAndContinue();
        Assert.assertEquals(2,controller.showCurrentTurn());
        controller.skipTurn();
        Assert.assertEquals(3,controller.showCurrentTurn());
        Assert.assertEquals("2 3 4 5 6",controller.printTurnList());
        controller.skipTurn();
        controller.skipTurn();
        controller.skipTurn();
        Assert.assertEquals(6,controller.showCurrentTurn());
        controller.deleteAndContinue();
        Assert.assertEquals("2 3 4 5",controller.printTurnList());
        Assert.assertEquals(2,controller.showCurrentTurn());
        controller.skipTurn();
        controller.skipTurn();
        controller.skipTurn();
        controller.skipTurn();
        Assert.assertEquals(2,controller.showCurrentTurn());
        Assert.assertEquals("2 3 4 5",controller.printTurnList());
        controller.skipTurn();
        Assert.assertEquals(3,controller.showCurrentTurn());
        Assert.assertEquals("3 4 5",controller.printTurnList());
    }
}
