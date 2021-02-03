package arekceg.unsolved;

import arekceg.unsolved.BirdMountain;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BirdMountainTest {
  @Test
  public void height1() {
    char[][] mountain = {
            " ^        ".toCharArray(),
            " ^^       ".toCharArray(),
            "  ^^      ".toCharArray(),
            "  ^^      ".toCharArray(),
            "  ^^      ".toCharArray(),
            "  ^^      ".toCharArray(),
            "  ^       ".toCharArray()
    };
    assertEquals(1, BirdMountain.peakHeight(mountain));
  }
  @Test
  public void height2() {
    char[][] mountain = {
            "   ^^         ".toCharArray(),
            "  ^^^^        ".toCharArray(),
            " ^^^^         ".toCharArray(),
            "  ^^          ".toCharArray(),
            "  ^           ".toCharArray(),
    };
    assertEquals(2, BirdMountain.peakHeight(mountain));
  }

  @Test
  public void height3() {
    char[][] mountain = {
      "^^^^^^        ".toCharArray(),
      " ^^^^^^^^     ".toCharArray(),
      "  ^^^^^^^     ".toCharArray(),
      "  ^^^^^       ".toCharArray(),
      "  ^^^^^^^^^^^ ".toCharArray(),
      "  ^^^^^^      ".toCharArray(),
      "  ^^^^        ".toCharArray()
    };
//111111
// 12222111
//  12^^211
//  12^21
//  12^^2111111
//  122211
//  1111
    assertEquals(3, BirdMountain.peakHeight(mountain));
  }

  @Test
  public void heightTwoSquares(){
    char[][] mountain = {
            "^^^^^       ".toCharArray(),
            "^^^^^       ".toCharArray(),
            "^^^^^       ".toCharArray(),
            "^^^^^       ".toCharArray(),
            "            ".toCharArray(),
            "     ^^^^^^^".toCharArray(),
            "     ^^^^^^^".toCharArray(),
            "     ^^^^^^^".toCharArray(),
            "     ^^^^^^^".toCharArray(),
            "     ^^^^^^^".toCharArray(),
            "     ^^^^^^^".toCharArray(),
            "     ^^^^^^^".toCharArray()
      };
    assertEquals(4, BirdMountain.peakHeight(mountain));
  }

  @Test
  public void heightAtPoint() {
    char[][] mountain = {
            "^^^^^^        ".toCharArray(),
            " ^^^^^^^^     ".toCharArray(),
            "  ^^^^^^^     ".toCharArray(),
            "  ^^^^^       ".toCharArray(),
            "  ^^^^^^^^^^^ ".toCharArray(),
            "  ^^^^^^      ".toCharArray(),
            "  ^^^^        ".toCharArray()
    };
    assertEquals(1, BirdMountain.heightAtCoordinates(1, 1, mountain));
    assertEquals(1, BirdMountain.heightAtCoordinates(4, 12, mountain));
    assertEquals(2, BirdMountain.heightAtCoordinates(1, 2, mountain));
    assertEquals(3, BirdMountain.heightAtCoordinates(2, 5, mountain));
  }

    @Test
    public void heightAtPint2() {
      char[][] mountain = {
              " ^        ".toCharArray(),
              " ^^       ".toCharArray(),
              "  ^^      ".toCharArray(),
              "  ^^      ".toCharArray(),
              "  ^^      ".toCharArray(),
              "  ^^      ".toCharArray(),
              "  ^       ".toCharArray()
      };
      assertEquals(1, BirdMountain.heightAtCoordinates(1, 1, mountain));
      assertEquals(1, BirdMountain.heightAtCoordinates(2, 3, mountain));
      assertEquals(1, BirdMountain.heightAtCoordinates(3, 3, mountain));
    }
}