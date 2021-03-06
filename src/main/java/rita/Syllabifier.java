package rita;

import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;



public class Syllabifier
{







	// Takes a syllabification and turns it into a string of phonemes,
	// delimited with dashes, with spaces between syllables
	String stringify(String[][] syllables) {

		ArrayList<String> ret = new ArrayList<String>();

		for (int i = 0; i < syllables.length; i++) {

			String[] syl = syllables[i];
			char stress = syl[0].charAt(0); //TODO
			String onset = syl[1];
			String nucleus = syl[2];
			String coda = syl[3];

			if (stress != ' ' && nucleus.length() > 0) // dch
				nucleus = stress + nucleus;

			ArrayList<String> data = new ArrayList<String>();

			for (int j = 0; j < onset.length(); j++)
				data.add(Character.toString(onset.charAt(j)));
			for (int j = 0; j < nucleus.length(); j++)
				data.add(Character.toString(nucleus.charAt(j)));
			for (int j = 0; j < coda.length(); j++)
				data.add(Character.toString(coda.charAt(j)));

			ret.add(String.join("-", data));
		}


		return String.join(" ", ret);
	}

	// fromWords(input) {
	//   if (!input || !input.length) return "";
	//   let wordArr = RiTa.tokenize(input);
	//   let raw = wordArr.map(w => RiTa.lexicon._getRawPhones(w).replace(/\s/g, "/"));
	//   // for (var i = 0; i < wordArr.length; i++)
	//   //   raw[i] = this._getRawPhones(wordArr[i]).replace(/\s/g, "/");
	//   // console.log("[RiTa] syllables" + " " + word + " " + raw);
	//   return RiTa.untokenize(raw).replace(/1/g, "").trim();
	// }

	String fromPhones(String[] ltsPhones) {
		/*
			boolean dbug; 
			int none;
		    String[] internuclei;
		    String[] syllables; // returned data structure
		    String[] sylls = ltsPhones.split("-");

		    for (int i = 0; i < sylls.length; i++) {

		      String phoneme = sylls[i].trim();
		      int stress = none;

		      if (phoneme.length() == 0) continue;

		      if (Util.isNum(Util.last(phoneme))) {
		        stress = parseInt(Util.last(phoneme));
		        phoneme = phoneme.substring(0, phoneme.length - 1);
		      }

		      if (dbug) log(i + ")" + phoneme + " stress=" + stress + " inter=" + internuclei.join(":"));

		      if (Syllabifier.Phones.vowels.includes(phoneme)) {

		        // Split the consonants seen since the last nucleus into coda and onset.
		        let coda = none,
		          onset = none;

		        // Make the largest onset we can. The "split" variable marks the break point.
		        for (int split = 0; split < internuclei.length + 1; split++) {

		          coda = internuclei.slice(0, split);
		          onset = internuclei.slice(split, internuclei.length);

		          if (dbug) log("  " + split + ") onset=" + onset.join(":") +
		            "  coda=" + coda.join(":") + "  inter=" + internuclei.join(":"));

		          // If we are looking at a valid onset, or if we"re at the start of the word
		          // (in which case an invalid onset is better than a coda that doesn"t follow
		          // a nucleus), or if we"ve gone through all of the onsets and we didn"t find
		          // any that are valid, then split the nonvowels we"ve seen at this location.
		          boolean bool = Syllabifier.Phones.onsets.includes(onset.join(" "));
		          if (bool || syllables.length === 0 || onset.length === 0) {
		            if (dbug) log("  break " + phoneme);
		            break;
		          }
		        }

		        // Tack the coda onto the coda of the last syllable.
		        // Can"t do it if this is the first syllable.
		        if (syllables.length > 0) {
		          Util.extend(syllables[syllables.length - 1][3], coda);
		          if (dbug) log("  tack: " + coda + " -> len=" +
		            syllables[syllables.length - 1][3].length + " [" +
		            syllables[syllables.length - 1][3] + "]");
		        }

		        // Make a new syllable out of the onset and nucleus.
		        let toPush = [[stress], onset, [phoneme], []];
		        syllables.push(toPush);

		        // At this point we"ve processed the internuclei list.
		        internuclei = [];
		      } else if (!(Syllabifier.Phones.consonants.includes(phoneme)) && phoneme != " ") {
		        throw Error("Invalid phoneme: " + phoneme);
		      } else { // a consonant
		        internuclei.push(phoneme);
		      }
		    }

		    // Done looping through phonemes. We may have consonants left at the end.
		    // We may have even not found a nucleus.
		    if (internuclei.length > 0) {
		      if (syllables.length === 0) {
		        syllables.push([[none], internuclei, [], []]);
		      } else {
		        Util.extend(syllables[syllables.length - 1][3], internuclei);
		      }
		    }

		    return this.stringify(syllables);

		 */
		return null;
	}


	private static HashMap<String, String[]> Phones;
	static {
		Phones.put("consonants", new String[] {"b", "ch", "d", "dh", "f", "g", "hh", "jh", "k", "l", "m",
				"n", "ng", "p", "r", "s", "sh", "t", "th", "v", "w", "y", "z", "zh"});
		Phones.put("vowels", new String[] {"aa", "ae", "ah", "ao", "aw", "ax", "ay", "eh", "er", "ey", "ih",
				"iy", "ow", "oy", "uh", "uw"});
		Phones.put("onsets", new String[] {"p", "t", "k", "b", "d", "g", "f", "v", "th", "dh", "s", "z",
				"sh", "ch", "jh", "m", "n", "r", "l", "hh", "w", "y", "p r", "t r",
				"k r", "b r", "d r", "g r", "f r", "th r", "sh r", "p l", "k l", "b l",
				"g l", "f l", "s l", "t w", "k w", "d w", "s w", "s p", "s t", "s k",
				"s f", "s m", "s n", "g w", "sh w", "s p r", "s p l", "s t r", "s k r",
				"s k w", "s k l", "th w", "zh", "p y", "k y", "b y", "f y", "hh y",
				"v y", "th y", "m y", "s p y", "s k y", "g y", "hh w", ""});
		Phones.put("digits", new String[] {"z-ih-r-ow", "w-ah-n", "t-uw", "th-r-iy", "f-ao-r", "f-ay-v",
				"s-ih-k-s", "s-eh1-v-ax-n", "ey-t", "n-ih-n"});

	}






}
