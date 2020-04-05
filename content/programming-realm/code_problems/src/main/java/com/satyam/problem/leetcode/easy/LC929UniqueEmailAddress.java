package com.satyam.problem.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**

 LC #929
 Every email consists of a local name and a domain name, separated by the @ sign.

 For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

 Besides lowercase letters, these emails may contain '.'s or '+'s.

 If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be
 forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com"
 forward to the same email address.  (Note that this rule does not apply for domain names.)

 If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain
 emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
 (Again, this rule does not apply for domain names.)

 It is possible to use both of these rules at the same time.

 Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?


 Example 1:

 Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 Output: 2
 Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

 Idea:
    split by @
    split by +
    replace . by ""

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308213217/
    Runtime: 43 ms
    Memory: 43.4     MB

 */

public class LC929UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }

        Set<String> seen = new HashSet<>();
        for (String email : emails) {
            handleEmail(email, seen);
        }
        return seen.size();
    }

    private void handleEmail(String email, Set<String> seen) {
        String[] arr = email.split("@");
        String localName = arr[0];

        int plusIndex = localName.indexOf("+");
        if (plusIndex != -1) {
            localName = localName.substring(0, plusIndex);
        }

        localName = localName.replaceAll("\\.", "");
        seen.add(String.format("%s@%s", localName, arr[1]));
    }
}
