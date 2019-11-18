package rita;

import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Lexicon // KW: Wait on this class please
{
  private static String LEXICON_DELIM = ":";
  private static int MAP_SIZE = 30000;

  protected Map<String, String[]> dict; // data

  public Lexicon(String filePath) throws Exception
  {
    List<String> lines = loadJSON(filePath);

    if (lines == null || lines.size() < 2) {
      throw new Exception("Problem parsing RiLexicon data files");
    }

    dict = new LinkedHashMap<String, String[]>(MAP_SIZE);

    for (int i = 1; i < lines.size() - 1; i++) // ignore JS prefix/suffix
    {
      String line = lines.get(i);
      String[] parts = line.split(LEXICON_DELIM);
      if (parts == null || parts.length != 2) {
        throw new Exception("Illegal entry: " + line);
      }
      dict.put(parts[0], parts[1].split(","));
    }
  }

  public static List<String> loadJSON(String file) throws Exception
  {
    if (file == null) {
      throw new Exception("No dictionary path specified!");
    }

    URL resource = RiTa.class.getResource(file);
    if (resource == null) {
      throw new Exception("Unable to load lexicon from: " + file);
    }
      
    final Path path = Paths.get(resource.toURI());
    final List<String> lines = Files.readAllLines(path);

    // clean out the JSON formatting (TODO: optimize)
    // String clean = data.replaceAll("['\\[\\]]", E).replaceAll(",", "|");

    return lines;
  }


  
  public String[] alliterations(String word, int minWordLength)
  {

	    word = word.contains(" ") ? word.substring(0, word.indexOf(" ")) : word;

	    if (RiTa.VOWELS.contains(String.valueOf(word.charAt(0)))) return new String[]{};

	   //  int matchMinLength = minWordLength || 4;
	   //  boolean useLTS = opts && opts.useLTS || false;
	    
	    boolean useLTS = false;

	    String[] results = {};
	    Object[] words = dict.keySet().toArray();
	    let fss = this._firstStressedSyl(word, useLTS);
	    let c1 = this._firstPhone(fss);

	    if (!c1 || !c1.length) return [];

	    for (let i = 0; i < words.length; i++) {

	      if (words[i].length < matchMinLength) continue;

	      let c2 = this._firstPhone(this._firstStressedSyl(words[i], useLTS));

	      if (RiTa.VOWELS.includes(word.charAt(0))) return []; // ????

	      if (c1 == c2) results.push(words[i]);
	    }

	    return Util.shuffle(results, RiTa);
  }
  
  public String[] alliterations(String word)
  {
	     int matchMinLength = 4;
	     boolean useLTS = false;

	    return alliterations(word,matchMinLength);
  }

  public boolean hasWord(String word)
  {
    return false;
  }

  public boolean isAlliteration(String word1, String word2)
  {

    return false;
  }

  public boolean isRhyme(String word1, String word2)
  {

    return false;
  }

  public String randomWord(String pos, int numSyllabes)
  {
    return null;
  }

  public String[] rhymes(String word)
  {
    return null;
  }

  public String[] similarBy(String word, Map<String, Object> opts)
  {
    return null;
  }

  public String[] words(Pattern regex)
  {
    return regex != null ? this.dict.keySet().stream().filter
        (word -> regex.matcher(word).matches()).toArray(String[]::new) :
        this.dict.keySet().toArray(new String[0]);
  }
  
  public static void main(String[] args) throws Exception
  {
    System.out.println(new Lexicon(RiTa.DICT_PATH).words(null).length);
  }
  
  //////////////////////////////////////////////////////////////////////

  private boolean _isVowel(c) {

    return c && c.length && RiTa.VOWELS.includes(c);
  }

  private boolean _isConsonant(p) {

    return (typeof p === S && p.length === 1 && // precompile
      RiTa.VOWELS.indexOf(p) < 0 && /^[a-z\u00C0-\u00ff]+$/.test(p));
  }

  private String _firstPhone(rawPhones) {

    if (!rawPhones || !rawPhones.length) return '';
    let phones = rawPhones.split(RiTa.PHONEME_BOUNDARY);
    if (phones) return phones[0];
    return ""; // return null?
  }

  _intersect() { // https://gist.github.com/lovasoa/3361645
    let i, all, n, len, ret = [],
      obj = {},
      shortest = 0,
      nOthers = arguments.length - 1,
      nShortest = arguments[0].length;
    for (i = 0; i <= nOthers; i++) {
      n = arguments[i].length;
      if (n < nShortest) {
        shortest = i;
        nShortest = n;
      }
    }
    for (i = 0; i <= nOthers; i++) {
      n = (i === shortest) ? 0 : (i || shortest);
      len = arguments[n].length;
      for (let j = 0; j < len; j++) {
        let elem = arguments[n][j];
        if (obj[elem] === i - 1) {
          if (i === nOthers) {
            ret.push(elem);
            obj[elem] = 0;
          } else {
            obj[elem] = i;
          }
        } else if (i === 0) {
          obj[elem] = 0;
        }
      }
    }
    return ret;
  }

  private String _lastStressedPhoneToEnd(word, useLTS) {

    if (!word || !word.length) return ''; // return null?

    let idx, c, result;
    let raw = this._rawPhones(word, useLTS);

    if (!raw || !raw.length) return ''; // return null?

    idx = raw.lastIndexOf(RiTa.STRESSED);

    if (idx < 0) return E; // return null?

    c = raw.charAt(--idx);
    while (c != '-' && c != ' ') {
      if (--idx < 0) {
        return raw; // single-stressed syllable
      }
      c = raw.charAt(idx);
    }
    result = raw.substring(idx + 1);

    return result;
  }


  private String _lastStressedVowelPhonemeToEnd(word, useLTS) {

    if (!word || !word.length) return ''; // return null?

    let raw = this._lastStressedPhoneToEnd(word, useLTS);
    if (!raw || !raw.length) return ''; // return null?

    let syllables = raw.split(' ');
    let lastSyllable = syllables[syllables.length - 1];
    lastSyllable = lastSyllable.replace('[^a-z-1 ]', '');

    let idx = -1;
    for (let i = 0; i < lastSyllable.length; i++) {
      let c = lastSyllable.charAt(i);
      if (RiTa.VOWELS.includes(c)) {
        idx = i;
        break;
      }
    }

    return lastSyllable.substring(idx);
  }

  private String _firstStressedSyl(String word, boolean useLTS) {

	 String raw = this._rawPhones(word, useLTS);

    if (raw == ""|| raw == null) return ""; // return null?

    int idx = raw.indexOf(RiTa.STRESSED);

    if (idx < 0) return ""; // no stresses... return null?

    char c = raw.charAt(--idx);

    while (c != ' ') {
      if (--idx < 0) {
        // single-stressed syllable
        idx = 0;
        break;
      }
      c = raw.charAt(idx);
    }

    String firstToEnd = idx == 0 ? raw : raw.substring(idx).trim();
    idx = firstToEnd.indexOf(' ');

    return idx < 0 ? firstToEnd : firstToEnd.substring(0, idx);
  }

  private String _posData(String word) {

    String[] rdata = _lookupRaw(word);
    return (rdata != null && rdata.length == 2) ? rdata[1] : "";
  }

  private String[] _posArr(word) {

    let pl = this._posData(word);
    if (!pl || !pl.length) return [];
    return pl.split(' ');
  }

  private String _bestPos(word) {

    let pl = this._posArr(word);
    return (pl.length > 0) ? pl[0] : [];
  }


  
   private String[] _lookupRaw(String word) {
	   //word = word && word.toLowerCase();
	   String[] a = null;
	    word = word.toLowerCase();
	    
	    if (dict != null) {
	    	return dict.get(word);
	    }else {
	    	return a; //TODO is it correct to return null?
	    }
  }
  
   String _rawPhones(String word, boolean b) {//, forceLTS) {

	    // TODO: remove all useLTS vars ?

	    String[] phones = null; 
	    String result = ""; 
	    String[] rdata = _lookupRaw(word);
	    //useLTS = useLTS || false;

	    if (rdata != null) result = rdata.length == 2 ? rdata[0] : "";

	    if (rdata == null) { //|| forceLTS) { // ??
	    	if(RiTa.lts != null) {
	  	      phones = RiTa.lts.getPhones(word);
	    	}
	      if (phones != null && phones.length > 0) {
	        result = RiTa.syllabifier.fromPhones(phones);
	      }
	    }

	    return result;
  }



}
