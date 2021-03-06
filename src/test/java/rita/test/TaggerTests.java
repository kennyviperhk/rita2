/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rita.test;


import org.junit.Test;

import rita.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;


public class TaggerTests {



	@Test 
	public void testPosTags() {

		String[] result, answer, resultArr, answerArr;
		String txt;

		assertArrayEquals(RiTa.posTags(""), new String[] {});
		assertArrayEquals(RiTa.posTags("freed"), new String[] {"jj"});

		assertArrayEquals(RiTa.posTags("the top seed"), new String[]{"dt", "jj", "nn"});

		assertArrayEquals(RiTa.posTags("by illegal means"), new String[]{"in", "jj", "nn"});

		assertArrayEquals(RiTa.posTags("biped"), new String[]{"nn"});
		assertArrayEquals(RiTa.posTags("greed"), new String[]{"nn"});
		assertArrayEquals(RiTa.posTags("creed"), new String[]{"nn"});
		assertArrayEquals(RiTa.posTags("weed"), new String[]{"nn"});

		result = RiTa.posTags("mammal");
		answer = new String[]{"nn"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("asfaasd");
		answer = new String[]{"nn"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("innings");
		answer = new String[]{"nns"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("clothes");
		answer = new String[]{"nns"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("clothes");
		answer = new String[]{"nns"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("teeth");
		answer = new String[]{"nns"};
		assertArrayEquals(result, answer);
		//return;

		result = RiTa.posTags("memories");
		answer = new String[]{"nns"};
		assertArrayEquals(result, answer);

		assertArrayEquals(RiTa.posTags("flunks"), new String[]{"vbz"});

		assertArrayEquals(RiTa.posTags("outnumbers"), new String[]{"vbz"});
		assertArrayEquals(RiTa.posTags("He outnumbers us"), new String[]{"prp", "vbz", "prp"});
		assertArrayEquals(RiTa.posTags("I outnumber you"), new String[]{"prp", "vbp", "prp"});

		resultArr = RiTa.posTags("Elephants dance");
		answerArr = new String[]{"nns", "vbp"};
		assertArrayEquals(answerArr, resultArr);

		result = RiTa.posTags("the boy dances");
		answer = new String[]{"dt", "nn", "vbz"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("he dances");
		answer = new String[]{"prp", "vbz"};
		assertArrayEquals(result, answer);

		resultArr = RiTa.posTags("Dave dances");
		answerArr = new String[]{"nnp", "vbz"};
		assertArrayEquals(answerArr, resultArr);

		result = RiTa.posTags("running");
		answer = new String[]{"vbg"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("asserting");
		answer = new String[]{"vbg"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("assenting");
		answer = new String[]{"nn"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("Dave");
		answer = new String[]{"nnp"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("They feed the cat");
		answer = new String[]{"prp", "vbp", "dt", "nn"};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("There is a cat.");
		answer = new String[]{"ex", "vbz", "dt", "nn", "."};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("The boy, dressed in red, ate an apple.");
		answer = new String[]{"dt", "nn", ",", "vbn", "in", "jj", ",", "vbd", "dt", "nn", "."};
		assertArrayEquals(result, answer);

		txt = "The dog ran faster than the other dog.  But the other dog was prettier.";
		result = RiTa.posTags(txt);
		answer = new String[]{"dt", "nn", "vbd", "rbr", "in", "dt", "jj", "nn", ".", "cc", "dt", "jj", "nn", "vbd", "jjr", "."};
		assertArrayEquals(result, answer);

		// Tests for verb conjugation
		assertArrayEquals(RiTa.posTags("is"), new String[]{"vbz"});
		assertArrayEquals(RiTa.posTags("am"), new String[]{"vbp"});
		assertArrayEquals(RiTa.posTags("be"), new String[]{"vb"});

		result = RiTa.posTags("There is a cat.");
		answer = new String[]{"ex", "vbz", "dt", "nn", "."};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("There was a cat.");
		answer = new String[]{"ex", "vbd", "dt", "nn", "."};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("I am a cat.");
		answer = new String[]{"prp", "vbp", "dt", "nn", "."};
		assertArrayEquals(result, answer);

		result = RiTa.posTags("I was a cat.");
		answer = new String[]{"prp", "vbd", "dt", "nn", "."};
		assertArrayEquals(result, answer);

		assertArrayEquals(RiTa.posTags("flunk"), new String[]{"vb"});
		assertArrayEquals(RiTa.posTags("He flunks the test"), new String[]{"prp", "vbz", "dt", "nn"});

		assertArrayEquals(RiTa.posTags("he"), new String[]{"prp"});
		assertArrayEquals(RiTa.posTags("outnumber"), new String[]{"vb"});
		assertArrayEquals(RiTa.posTags("I outnumbered you"), new String[]{"prp", "vbd", "prp"});
		assertArrayEquals(RiTa.posTags("She outnumbered us"), new String[]{"prp", "vbd", "prp"});

		assertArrayEquals(RiTa.posTags("I outnumbered them"), new String[]{"prp", "vbd", "prp"});

		String[] checks = new String[]{"emphasis", "stress", "discus", "colossus", "fibrosis", "digitalis", "pettiness", "mess", "cleanliness", "orderliness", "bronchitis", "preparedness", "highness"};
		for (int i = 0, j = checks.length; i < j; i++) {
			//if (RiTa.posTags(checks[i])[0] !== "nn")
			//console.log(checks[i] + ": " + RiTa.posTags(checks[i])[0]);
			assertArrayEquals(RiTa.posTags(checks[i]), new String[]{"nn"});
		}
	}

	@Test 
	public void testSimplePosTags() {
		Map<String, Object> hm = new HashMap<String, Object>(); 
		hm.put("simple", true);

		//assertArrayEquals(RiTa.posTags("", hm), new String[]{});
		assertArrayEquals(RiTa.posTags("biped", hm), new String[]{"n"});
		assertArrayEquals(RiTa.posTags("creed", hm), new String[]{"n"});
		assertArrayEquals(RiTa.posTags("weed", hm), new String[]{"n"});
		assertArrayEquals(RiTa.posTags("is", hm), new String[]{"v"});
		assertArrayEquals(RiTa.posTags("am", hm), new String[]{"v"});
		assertArrayEquals(RiTa.posTags("be", hm), new String[]{"v"});
		assertArrayEquals(RiTa.posTags("freed", hm), new String[]{"a"});
	}

	@Test 
	public void testInlinePosTags() {

		String result, answer;
		String txt;

		// with Map
		Map<String, Object> hm = new HashMap<String, Object>(); 
		hm.put("inline", true);

		assertEquals(RiTa.posTagsInline("", hm), "");
		assertEquals(RiTa.posTagsInline("asdfaasd", hm), "asdfaasd/nn");

		result = RiTa.posTagsInline("clothes", hm);
		answer = "clothes/nns";
		assertEquals(result, answer);

		result = RiTa.posTagsInline("teeth", hm);
		answer = "teeth/nns";
		assertEquals(result, answer);

		result = RiTa.posTagsInline("There is a cat.", hm);
		answer = "There/ex is/vbz a/dt cat/nn .";
		assertEquals(result, answer);

		result = RiTa.posTagsInline("The boy, dressed in red, ate an apple.", hm);
		answer = "The/dt boy/nn , dressed/vbn in/in red/jj , ate/vbd an/dt apple/nn .";
		assertEquals(result, answer);

		txt = "The dog ran faster than the other dog.  But the other dog was prettier.";
		result = RiTa.posTagsInline(txt, hm);
		answer = "The/dt dog/nn ran/vbd faster/rbr than/in the/dt other/jj dog/nn . But/cc the/dt other/jj dog/nn was/vbd prettier/jjr .";
		assertEquals(result, answer);



		// without Map argument
		assertEquals(RiTa.posTagsInline(""), "");
		assertEquals(RiTa.posTagsInline("asdfaasd"), "asdfaasd/nn");

		result = RiTa.posTagsInline("clothes");
		answer = "clothes/nns";
		assertEquals(result, answer);

		result = RiTa.posTagsInline("teeth");
		answer = "teeth/nns";
		assertEquals(result, answer);

		result = RiTa.posTagsInline("There is a cat.");
		answer = "There/ex is/vbz a/dt cat/nn .";
		assertEquals(result, answer);

		result = RiTa.posTagsInline("The boy, dressed in red, ate an apple.");
		answer = "The/dt boy/nn , dressed/vbn in/in red/jj , ate/vbd an/dt apple/nn .";
		assertEquals(result, answer);

		txt = "The dog ran faster than the other dog.  But the other dog was prettier.";
		result = RiTa.posTagsInline(txt);
		answer = "The/dt dog/nn ran/vbd faster/rbr than/in the/dt other/jj dog/nn . But/cc the/dt other/jj dog/nn was/vbd prettier/jjr .";
		assertEquals(result, answer);
	}

	@Test 
	public void testIsAdverb() {


		assertTrue(!RiTa.isAdverb(""));

		assertTrue(!RiTa.isAdverb("swim"));
		assertTrue(!RiTa.isAdverb("walk"));
		assertTrue(!RiTa.isAdverb("walker"));
		assertTrue(!RiTa.isAdverb("beautiful"));
		assertTrue(!RiTa.isAdverb("dance"));
		assertTrue(!RiTa.isAdverb("dancing"));
		assertTrue(!RiTa.isAdverb("dancer"));

		//verb
		assertTrue(!RiTa.isAdverb("wash"));
		assertTrue(!RiTa.isAdverb("walk"));
		assertTrue(!RiTa.isAdverb("play"));
		assertTrue(!RiTa.isAdverb("throw"));
		assertTrue(!RiTa.isAdverb("drink"));
		assertTrue(!RiTa.isAdverb("eat"));
		assertTrue(!RiTa.isAdverb("chew"));

		//adj
		assertTrue(!RiTa.isAdverb("wet"));
		assertTrue(!RiTa.isAdverb("dry"));
		assertTrue(!RiTa.isAdverb("furry"));
		assertTrue(!RiTa.isAdverb("sad"));
		assertTrue(!RiTa.isAdverb("happy"));

		//n
		assertTrue(!RiTa.isAdverb("dogs"));
		assertTrue(!RiTa.isAdverb("wind"));
		assertTrue(!RiTa.isAdverb("dolls"));
		assertTrue(!RiTa.isAdverb("frogs"));
		assertTrue(!RiTa.isAdverb("ducks"));
		assertTrue(!RiTa.isAdverb("flowers"));
		assertTrue(!RiTa.isAdverb("fish"));

		//adv
		assertTrue(RiTa.isAdverb("truthfully"));
		assertTrue(RiTa.isAdverb("kindly"));
		assertTrue(RiTa.isAdverb("bravely"));
		assertTrue(RiTa.isAdverb("doggedly"));
		assertTrue(RiTa.isAdverb("sleepily"));
		assertTrue(RiTa.isAdverb("excitedly"));
		assertTrue(RiTa.isAdverb("energetically"));
		assertTrue(RiTa.isAdverb("hard")); // +adj
	}

	@Test 
	public void testIsNoun() {



		assertTrue(!RiTa.isNoun(""));

		assertTrue(RiTa.isNoun("swim"));
		assertTrue(RiTa.isNoun("walk"));
		assertTrue(RiTa.isNoun("walker"));
		assertTrue(RiTa.isNoun("dance"));
		assertTrue(RiTa.isNoun("dancer"));
		assertTrue(RiTa.isNoun("cats"));
		assertTrue(RiTa.isNoun("boxes"));
		assertTrue(RiTa.isNoun("teeth"));
		assertTrue(RiTa.isNoun("apples"));
		assertTrue(RiTa.isNoun("buses"));
		assertTrue(RiTa.isNoun("prognoses"));
		assertTrue(RiTa.isNoun("oxen"));
		assertTrue(RiTa.isNoun("theses"));
		assertTrue(RiTa.isNoun("stimuli"));
		assertTrue(RiTa.isNoun("crises"));

		//verb
		assertTrue(RiTa.isNoun("wash")); //"TODO:also false in processing -> nn" shoulbe be both Verb and Noun  ??
		assertTrue(RiTa.isNoun("walk"));
		assertTrue(RiTa.isNoun("play"));
		assertTrue(RiTa.isNoun("throw"));
		assertTrue(RiTa.isNoun("drink")); //TODO:"also false in processing -> nn" shoulbe be both Verb and Noun ??

		assertTrue(!RiTa.isNoun("eat"));
		assertTrue(!RiTa.isNoun("chew"));
		assertTrue(!RiTa.isNoun("moved"));
		assertTrue(!RiTa.isNoun("went"));
		assertTrue(!RiTa.isNoun("spent"));
		assertTrue(!RiTa.isNoun("abates"));

		//adj
		assertTrue(!RiTa.isNoun("hard"));
		assertTrue(!RiTa.isNoun("dry"));
		assertTrue(!RiTa.isNoun("furry"));
		assertTrue(!RiTa.isNoun("sad"));
		assertTrue(!RiTa.isNoun("happy"));
		assertTrue(!RiTa.isNoun("beautiful"));

		//n
		assertTrue(RiTa.isNoun("dogs"));
		assertTrue(RiTa.isNoun("wind"));
		assertTrue(RiTa.isNoun("dolls"));
		assertTrue(RiTa.isNoun("frogs"));
		assertTrue(RiTa.isNoun("ducks"));
		assertTrue(RiTa.isNoun("flower"));
		assertTrue(RiTa.isNoun("fish"));
		assertTrue(RiTa.isNoun("wet")); //+v/adj

		//adv
		assertTrue(!RiTa.isNoun("truthfully"));
		assertTrue(!RiTa.isNoun("kindly"));
		assertTrue(!RiTa.isNoun("bravely"));
		assertTrue(!RiTa.isNoun("scarily"));
		assertTrue(!RiTa.isNoun("sleepily"));
		assertTrue(!RiTa.isNoun("excitedly"));
		assertTrue(!RiTa.isNoun("energetically"));


	}

	@Test 
	public void testIsVerb() {


		assertTrue(RiTa.isVerb("dance"));
		assertTrue(RiTa.isVerb("swim"));
		assertTrue(RiTa.isVerb("walk"));
		assertTrue(!RiTa.isVerb("walker"));
		assertTrue(!RiTa.isVerb("beautiful"));

		assertTrue(RiTa.isVerb("dancing"));
		assertTrue(!RiTa.isVerb("dancer"));

		//verb
		assertTrue(RiTa.isVerb("eat"));
		assertTrue(RiTa.isVerb("chew"));

		assertTrue(RiTa.isVerb("throw")); // +n
		assertTrue(RiTa.isVerb("walk")); // +n
		assertTrue(RiTa.isVerb("wash")); // +n
		assertTrue(RiTa.isVerb("drink")); // +n

		// assertTrue(RiTa.isVerb("ducks")); // +n -> Known Issues
		assertTrue(RiTa.isVerb("fish")); // +n
		// assertTrue(RiTa.isVerb("dogs")); // +n -> Known Issues

		assertTrue(RiTa.isVerb("wind")); // +n
		assertTrue(RiTa.isVerb("wet")); // +adj
		assertTrue(RiTa.isVerb("dry")); // +adj

		//adj
		assertTrue(!RiTa.isVerb("hard"));
		assertTrue(!RiTa.isVerb("furry"));
		assertTrue(!RiTa.isVerb("sad"));
		assertTrue(!RiTa.isVerb("happy"));

		//n
		assertTrue(!RiTa.isVerb("dolls"));
		assertTrue(!RiTa.isVerb("frogs"));
		assertTrue(!RiTa.isVerb("flowers"));

		//adv
		assertTrue(!RiTa.isVerb("truthfully"));
		assertTrue(!RiTa.isVerb("kindly"));
		assertTrue(!RiTa.isVerb("bravely"));
		assertTrue(!RiTa.isVerb("scarily"));
		assertTrue(!RiTa.isVerb("sleepily"));
		assertTrue(!RiTa.isVerb("excitedly"));
		assertTrue(!RiTa.isVerb("energetically"));

	}

	@Test 
	public void testIsAdjective() {


		assertTrue(!RiTa.isAdjective("swim"));
		assertTrue(!RiTa.isAdjective("walk"));
		assertTrue(!RiTa.isAdjective("walker"));
		assertTrue(RiTa.isAdjective("beautiful"));
		assertTrue(!RiTa.isAdjective("dance"));
		assertTrue(!RiTa.isAdjective("dancing"));
		assertTrue(!RiTa.isAdjective("dancer"));

		//verb
		assertTrue(!RiTa.isAdjective("wash"));
		assertTrue(!RiTa.isAdjective("walk"));
		assertTrue(!RiTa.isAdjective("play"));
		assertTrue(!RiTa.isAdjective("throw"));
		assertTrue(!RiTa.isAdjective("drink"));
		assertTrue(!RiTa.isAdjective("eat"));
		assertTrue(!RiTa.isAdjective("chew"));

		//adj
		assertTrue(RiTa.isAdjective("hard"));
		assertTrue(RiTa.isAdjective("wet"));
		assertTrue(RiTa.isAdjective("dry"));
		assertTrue(RiTa.isAdjective("furry"));
		assertTrue(RiTa.isAdjective("sad"));
		assertTrue(RiTa.isAdjective("happy"));
		assertTrue(RiTa.isAdjective("kindly")); //+adv

		//n
		assertTrue(!RiTa.isAdjective("dog"));
		assertTrue(!RiTa.isAdjective("dogs"));
		assertTrue(!RiTa.isAdjective("wind"));
		assertTrue(!RiTa.isAdjective("dolls"));
		assertTrue(!RiTa.isAdjective("frogs"));
		assertTrue(!RiTa.isAdjective("ducks"));
		assertTrue(!RiTa.isAdjective("flowers"));
		assertTrue(!RiTa.isAdjective("fish"));

		//adv
		assertTrue(!RiTa.isAdjective("truthfully"));
		assertTrue(!RiTa.isAdjective("bravely"));
		assertTrue(!RiTa.isAdjective("scarily"));
		assertTrue(!RiTa.isAdjective("sleepily"));
		assertTrue(!RiTa.isAdjective("excitedly"));
		assertTrue(!RiTa.isAdjective("energetically"));
	}

}
