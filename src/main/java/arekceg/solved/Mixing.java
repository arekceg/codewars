package arekceg.solved;
//https://www.codewars.com/kata/5629db57620258aa9d000014/train/java

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Mixing {

  private static Set<OccuranceData> occuranceSet;

  public static String mix(final String s1, final String s2) {
    occuranceSet = new HashSet<>();
    final char[] s1CharArray = s1.replace(" ", "").toCharArray();
    final char[] s2CharArray = s2.replace(" ", "").toCharArray();
    for (final char c : s1CharArray) {
      if (Character.isLowerCase(c))
      calculateOccurancesAndAddToSet(s1CharArray, s2CharArray, c);
    }
    for (final char c : s2CharArray) {
      if (Character.isLowerCase(c))
      calculateOccurancesAndAddToSet(s1CharArray, s2CharArray, c);
    }
    if (occuranceSet.isEmpty()) return "";
    return createFinalString();
  }

  private static void calculateOccurancesAndAddToSet(final char[] s1CharArray,
      final char[] s2CharArray, final char c) {
    int occurancesInS1;
    int occurancesInS2;
    occurancesInS1 = calculateOccurances(s1CharArray, c);
    occurancesInS2 = calculateOccurances(s2CharArray, c);
    if (occurancesInS1 <= 1 && occurancesInS2 <= 1) return;
    if (occurancesInS1 > occurancesInS2) {
      occuranceSet.add(OccuranceData.of(c, "1", occurancesInS1));
    } else if (occurancesInS1 == occurancesInS2) {
      occuranceSet.add(OccuranceData.of(c, "=", occurancesInS1));
    } else {
      occuranceSet.add(OccuranceData.of(c, "2", occurancesInS2));
    }
  }

  private static String createFinalString() {
    StringBuilder sb = new StringBuilder();
    Comparator<OccuranceData> occuranceCountComparator = Comparator.comparing(data -> data.getOccuranceArray().length);
    Comparator<OccuranceData> stringComparator = Comparator.comparing(data -> data.getString());
    Comparator<OccuranceData> lexicographicComparator = Comparator.comparing(OccuranceData::getLetter);
    occuranceSet.stream()
      .sorted(occuranceCountComparator.reversed()
        .thenComparing(stringComparator)
        .thenComparing(lexicographicComparator))
      .forEach(data -> {
          sb.append(data.getString())
          .append(":")
          .append(data.getOccuranceArray())
          .append("/");
        });
    return sb.deleteCharAt(sb.length() - 1).toString();
  }

  private static int calculateOccurances(final char[] charArray, final char c) {
    int counter = 0;
    for (final char d : charArray) {
      if (d == c)
        counter++;
    }
    return counter;
  }

  private static class OccuranceData {
    private final char letter;
    private final String string;
    private final int count;

    private OccuranceData(final char letter, final String s, final int count) {
      this.letter = letter;
      this.string = s;
      this.count = count;
    }

    public static OccuranceData of(final char letter, final String s, final int count) {
      return new OccuranceData(letter, s, count);
    }

    public char getLetter() {
      return letter;
    }

    public String getString() {
      return string;
    }

    public char[] getOccuranceArray() {
      final char[] occurances = new char[count];
      Arrays.fill(occurances, 0, count, letter);
      return occurances;
    }

    @Override
    public boolean equals(final Object obj) {
      final OccuranceData o = (OccuranceData) obj;
      return this.letter == o.getLetter();
    }

    @Override
    public int hashCode() {
      return Character.valueOf(letter).hashCode();
    }

  }
}
