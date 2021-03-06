package tetris.game.tetronimos.norotationstetronimo;

import org.junit.jupiter.api.Test;
import tetris.game.grid.DefaultGrid;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class OTetronimoTest {

    GameRenderer mockGameRenderer = mock(GameRenderer.class);

    @Test
    void shouldPassToConfirmCreatedCorrectly() {
        OTetronimo tetronimo = createOTetronimo();
        assertEquals(Colour.YELLOW, tetronimo.firstBlock.getColour());
        assertEquals(Colour.YELLOW, tetronimo.secondBlock.getColour());
        assertEquals(Colour.YELLOW, tetronimo.thirdBlock.getColour());
        assertEquals(Colour.YELLOW, tetronimo.fourthBlock.getColour());
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmBlockPositionsDoNotChangeWhenClockwiseRotationInvoked() {
        OTetronimo tetronimo = createOTetronimo();
        tetronimo.tryToMove(0, 2);
        tetronimo.rotateClockwise();
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmBlockPositionsDoNotChangeWhenAntiClockwiseRotationInvoked() {
        OTetronimo tetronimo = createOTetronimo();
        tetronimo.tryToMove(0, 2);
        tetronimo.rotateAntiClockwise();
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    private OTetronimo createOTetronimo() {
        return new OTetronimo(new DefaultGrid(mockGameRenderer,6,6), mockGameRenderer);
    }

}