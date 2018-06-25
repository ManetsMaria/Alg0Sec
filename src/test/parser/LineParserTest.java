package test.parser;

import main.parser.LineParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LineParserTest {

    @Test
    public void emptyStringTest(){
        LineParser lineParser = new LineParser("");
        Assert.assertNull(lineParser.findWord(5));
    }

    @Test
    public void WhiteSpacesSurroundLine(){
        LineParser lineParser = new LineParser("   0 1  2   3  4 5   ");
        Assert.assertEquals(lineParser.findPlace("2"), 2);
    }

    @Test
    public void WhiteSpacesIntoFieldLine(){
        LineParser lineParser = new LineParser("   0 \"1  6 8   7\"  \"2\"   3  4 5   ");
        Assert.assertEquals(lineParser.findPlace("2"), 2);
    }

    @Test
    public void findWordTest(){
        LineParser lineParser = new LineParser("   0 \"8909   87 6 \"  7 ");
        Assert.assertEquals(lineParser.findWord(2), "7");
    }

    @Test
    public void findDoNotContainsFieldTest(){
        LineParser lineParser = new LineParser("1 2 3");
        Assert.assertEquals(lineParser.findPlace("8"), -1);
    }

    @Test
    public void findDoNotContainsHostTest(){
        LineParser lineParser = new LineParser("   0 \"8909   87 6 \"  7 ");
        Assert.assertNull(lineParser.findWord(-1));
    }
}
