import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import arekceg.StripComments;

public class StripCommentsTest {

	@Test
	public void stripComments() throws Exception {
		assertEquals(
				"apples, pears\ngrapes\nbananas",
				StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
		);

		assertEquals(
				"a\nc\nd",
				StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
		);

		assertEquals(
				"a\n c\nd",
				StripComments.stripComments( "a #b\n c\nd $e f g", new String[] { "#", "$" } )
		);

		assertEquals(
				"a\n c\nd\n",
				StripComments.stripComments( "a #b\n c\nd\n $e f g", new String[] { "#", "$" } )
		);

		assertEquals(
				"a\n c\n\n",
				StripComments.stripComments( "a #b\n c\n\n $e f g", new String[] { "#", "$" } )
		);

		assertEquals(
				"",
				StripComments.stripComments( "                ", new String[] { "#", "$" } )
		);
	}

}