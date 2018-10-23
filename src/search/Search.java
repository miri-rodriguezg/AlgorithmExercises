package search;

/**
 * Class of operations on ordered lists of strings. You should fill in the
 * bodies of these methods.
 */
public class Search {

    /**
     * Returns the index of the longest string in the list. If there are several
     * string of this length, the indexed returned is the that of the first.
     *
     * @param a list of strings, in ascending order
     * @return position of an entry with the longest string in the list
     */
    public int longestWord(StringList a) {
        // replace the following line with your implementation        
        int i = 0;
        int length = 0;
        int longestWord = 0;

        // invariant: 0 ≤ i ≤ a.size() and longestWord ≡ a.get(0)... a.get(i-1) longest word
        while (i < a.size()) {
            if (a.get(i).length() > length) {
                length = a.get(i).length();
                longestWord = i;
            }
            i++;
        }
        return longestWord;
    }

    /**
     * Returns the number of unique elements in the list
     *
     * @param a list of strings, in ascending order
     * @return number of unique elements in the list.
     */
    public int countUnique(StringList a) {
        // replace the following line with your implementation
        int i = 1;
        int countUnique = 1;

        // invariant: 1 ≤ i ≤ a.size() and countUnique ≡ a.get(0)... a.get(i-1) counts unique words
        while (i < a.size()) {
            if (a.get(i).equals(a.get(i - 1))) {
            } else {
                countUnique++;
            }
            i++;
        }
        return countUnique;
    }

    /**
     * Returns the most commonly occurring string in the list. If two or more
     * are equally common, return the one that comes earliest.
     *
     * @param a collection of strings, in ascending order
     * @return most frequently occurring string
     */
    public String mostFrequent(StringList a) {
        // replace the following line with your implementation
        int i = 1;
        int frequency = 0;
        int max = 0;
        int mostFrequent = 0;

        // invariant: 1 ≤ i ≤ a.size() and mostFrequent is most frequent of a.get(0)... a.get(i-1)  
        while (i < a.size()) {
            if (a.get(i).equals(a.get(i - 1))) {
                frequency++;
            } else {
                if (frequency > max) {
                    max = frequency;
                    mostFrequent = i - 1;
                }
                frequency = 0;
            }
            i++;
        }
        return a.get(mostFrequent);
    }

    /**
     * Search for a string in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return position of an element equal to k, if any, otherwise -1
     */
    public int findElement(StringList a, String k) {
        // replace the following line with your implementation
        int lo = 0;
        int hi = a.size() - 1;

        // invariant: 0 ≤ lo ≤ hi+1 ≤ a.size() and a.get(0...lo-1) < k < a.get(hi+1...a.size()-1)    
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (a.get(mid).equals(k)) {
                return mid;
            }
            if (a.get(mid).compareTo(k) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Position of a string in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return number of strings in the collection a greater than or equal to k
     */
    public int countGreaterOrEqual(StringList a, String k) {
        // replace the following line with your implementation
        int lo = 0;
        int hi = a.size() - 1;
        int countGreaterOrEqual = 0;

        // invariant: 0 ≤ lo ≤ hi+1 ≤ a.size() and a.get(0..lo-1) < k ≤ a.get(hi+1..a.size()-1)
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a.get(mid).compareTo(k) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            if (a.get(lo).equals(k)) {
                countGreaterOrEqual = a.size() - lo;
            } else {
                countGreaterOrEqual = a.size() - hi - 1;
            }
        }
        return countGreaterOrEqual;
    }

    /**
     * Position after a string in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return number of strings in the collection strictly greater than k
     */
    public int countGreater(StringList a, String k) {
        // replace the following line with your implementation
        int lo = 0;
        int hi = a.size() - 1;
        int countGreater = 0;

        // invariant: 0 ≤ lo ≤ hi+1 ≤ a.size() and a.get(hi+1..a.size()-1) < k ≤ a.get(0..lo-1)
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a.get(mid).compareTo(k) > 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            if (a.get(lo).equals(k)) {
                countGreater = a.size() - lo - 1;
            } else {
                countGreater = a.size() - hi - 1;
            }
        }
        return countGreater;
    }

    /**
     * Determine the size of a range in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param k1 first string to search for
     * @param k2 second string to search for (greater than or equal to k1)
     * @return number of strings between k1 and k2 (inclusive)
     */
    public int countBetween(StringList a, String k1, String k2) {
        // replace the following line with your implementation
        int lo = 0;
        int hi = a.size() - 1;
        int low = 0;
        int high = a.size() - 1;
        int count1 = 0;
        int count2 = 0;

        // invariant: 0 ≤ lo ≤ hi+1 ≤ a.size() and a.get(0..lo-1) < k ≤ a.get(hi+1..a.size()-1)     
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a.get(mid).compareTo(k1) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            if (a.get(lo).equals(k1)) {
                count1 = a.size() - lo;
            } else {
                count1 = a.size() - hi - 1;

                // invariant: 0 ≤ lo ≤ hi+1 ≤ a.size() and a.get(hi+1..a.size()-1) < k ≤ a.get(0..lo-1)             
                while (low <= high) {
                    int middle = (low + high) / 2;
                    if (a.get(middle).compareTo(k2) < 0) {
                        low = middle + 1;
                    } else {
                        high = middle - 1;
                    }
                    if (a.get(low).equals(k2)) {
                        count2 = a.size() - low - 1;
                    } else {
                        count2 = a.size() - high - 1;
                    }
                }

            }
        }
        return count1 - count2;
    }

    /**
     * Count partial matches in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param prefix first string to search for
     * @param substring second string to search for
     * @return number of strings with both the prefix and the substring
     */
    public int countMatches(StringList a, String prefix, String substring) {
        // replace the following line with your implementation
        int lo = 0;
        int hi = a.size() - 1;
        int countMatches = 0;

        // invariant: 0 ≤ lo ≤ hi+1 ≤ a.size() and a.get(0..lo-1) < k ≤ a.get(hi+1..a.size()-1)     
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (a.get(mid).compareTo(prefix) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        // invariant: 0 ≤ lo ≤ a.size() and countMatches ≡ a.get(0)... a.get(i-1) counts matches    
        while (lo < a.size()) {
            if (a.get(lo).startsWith(prefix) && a.get(lo).contains(substring)) {
                countMatches++;
            }
            lo++;
        }
        return countMatches;
    }
}
